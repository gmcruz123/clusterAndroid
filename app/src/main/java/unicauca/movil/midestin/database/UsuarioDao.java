package unicauca.movil.midestin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.midestin.models.Usuario;

/**
 * Created by Kathe on 15/12/2016.
 */

public class UsuarioDao {
    static final String TABLE= "usuario";
    static final String C_ID="cedula";
    static final String C_NOMBRE="nombre";
    static final String C_CORREO = "correo";
    static final String C_USR="user";
    static final String C_PASS = "password";
    static final String C_CUENTA="cuenta";

    SQLiteDatabase db;

    public UsuarioDao(Context contex){
        DataBaseHelper helper= new DataBaseHelper(contex);
        db= helper.getWritableDatabase();
    }

    public void insert(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put(C_ID,usuario.getCedula());
        values.put(C_NOMBRE,usuario.getNombre());
        values.put(C_CORREO,usuario.getCorreo());
        values.put(C_USR,usuario.getUser());
        values.put(C_PASS,usuario.getPassword());
        values.put(C_CUENTA,usuario.getCuenta());

        db.insert(TABLE, null, values);
    }
    public void update(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put(C_NOMBRE,usuario.getNombre());
        values.put(C_CORREO,usuario.getCorreo());
        values.put(C_USR,usuario.getUser());
        values.put(C_PASS,usuario.getPassword());
        values.put(C_CUENTA,usuario.getCuenta());

        db.update(TABLE,values, "cedula =?",new String[]{""+ usuario.getCedula()});

    }
    public void delete(Long id){
        db.delete(TABLE,"cedula=?", new String[]{""+id});
    }

    public  Usuario getById(Long id){
        String sql = "SELECT * FROM "+ TABLE + "WHERE cedula ="+id;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToNext();
            return cursorToUsuario(cursor);
        }else
            return null;
    }

    public  Usuario getByLogin(String name,String pass){
        String sql = "SELECT * FROM "+ TABLE + " WHERE " +C_USR + " LIKE '%"+name+"%' AND "+C_PASS+" LIKE '%"+pass+"%'";
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToNext();
            return cursorToUsuario(cursor);
        }else
            return null;
    }

    public int Count(){
        String sql = "SELECT * FROM "+ TABLE;
        Cursor cursor = db.rawQuery(sql,null);
        int a= cursor.getCount();
        return a;
    }


    public List<Usuario> list(){

        String sql ="SELECT * FROM "+ TABLE;
        return cursorToList(sql);
    }
    public List<Usuario> listByName(String name){
        String sql = "SELECT * FROM "+ TABLE + "WHERE " +C_NOMBRE + "LIKE '%"+name+"%'";
        return cursorToList(sql);
    }



    private Usuario cursorToUsuario(Cursor cursor){
        Usuario p = new Usuario();
        p.setCedula(cursor.getInt(0));
        p.setNombre(cursor.getString(1));
        p.setCorreo(cursor.getString(2));
        p.setUser(cursor.getString(3));
        p.setPassword(cursor.getString(4));
        p.setCuenta(cursor.getInt(5));

        return p;
    }
    private List<Usuario> cursorToList(String sql){
        Cursor cursor = db.rawQuery(sql,null);
        List<Usuario> data = new ArrayList<>();

        while(cursor.moveToNext()){
            Usuario p = cursorToUsuario(cursor);
            data.add(p);
        }
        return data;
    }

}
