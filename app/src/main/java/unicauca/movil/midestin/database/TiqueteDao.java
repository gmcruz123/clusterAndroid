package unicauca.movil.midestin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.models.Usuario;



public class TiqueteDao {
    static final String TABLE= "tiquete";
    static final String C_ID="id";
    static final String C_NOMBRE="nombre";
    static final String C_EMP = "empresa";
    static final String C_OR="origen";
    static final String C_DES = "destino";
    static final String C_FECHA="fecha";
    static final String C_HOR="hora";
    static final String C_MODO = "modo";
    static final String C_IMG="imagen";
    static final String C_FECHAV="fechav";
    static final String C_CED = "cedula";
    static final String C_PRECIO="precio";
    static final String C_SIL="silla";

    SQLiteDatabase db;

    public TiqueteDao(Context contex){
        DataBaseHelper helper= new DataBaseHelper(contex);
        db= helper.getWritableDatabase();
    }

    public void insert(Tiquete usuario){
        ContentValues values = new ContentValues();

        values.put(C_NOMBRE,usuario.getNombre());
        values.put(C_EMP,usuario.getEmpresa());
        values.put(C_OR,usuario.getOrigen());
        values.put(C_DES,usuario.getDestino());
        values.put(C_FECHA,usuario.getFecha());
        values.put(C_HOR,usuario.getHora());
        values.put(C_MODO,usuario.getModo());
        values.put(C_IMG,usuario.getImagen());
        values.put(C_FECHAV,usuario.getFechav());
        values.put(C_CED,usuario.getCedula());
        values.put(C_PRECIO,usuario.getPrecio());
        values.put(C_SIL,usuario.getSilla());


        db.insert(TABLE, null, values);

    }
    public void update(Tiquete usuario){
        ContentValues values = new ContentValues();
        values.put(C_ID,usuario.getIdTiquete());
        values.put(C_NOMBRE,usuario.getNombre());
        values.put(C_EMP,usuario.getEmpresa());
        values.put(C_OR,usuario.getOrigen());
        values.put(C_DES,usuario.getDestino());
        values.put(C_FECHA,usuario.getFecha());
        values.put(C_HOR,usuario.getHora());
        values.put(C_MODO,usuario.getModo());
        values.put(C_IMG,usuario.getImagen());
        values.put(C_FECHAV,usuario.getFechav());
        values.put(C_CED,usuario.getCedula());
        values.put(C_PRECIO,usuario.getPrecio());
        values.put(C_SIL,usuario.getSilla());

        db.update(TABLE,values, "id =?",new String[]{""+ usuario.getIdTiquete()});

    }
    public void delete(Long id){
        db.delete(TABLE,"id=?", new String[]{""+id});
    }

    public  Tiquete getById(Long id){
        String sql = "SELECT * FROM "+ TABLE + "WHERE id ="+id;
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


    public List<Tiquete> list(String c,int ced){
        Log.i("Destino","String "+c+"   cedula "+ ced);
        String sql ="SELECT * FROM "+ TABLE+ " WHERE modo= '"+c+"'  AND cedula="+ced ;
        Log.i("Destino", sql);
        return cursorToList(sql);
    }
    public List<Tiquete> listByName(String name){
        String sql = "SELECT * FROM "+ TABLE + "WHERE " +C_NOMBRE + "LIKE '%"+name+"%'";
        return cursorToList(sql);
    }
    public int Counter(String c,int ced){
        String sql = "SELECT * FROM "+ TABLE +" WHERE modo= '"+c+"'  AND cedula="+ced ;
        Cursor cursor = db.rawQuery(sql,null);
        int a= cursor.getCount();
        return a;
    }



    private Tiquete cursorToUsuario(Cursor cursor){
        Tiquete p = new Tiquete();
        p.setIdTiquete(cursor.getInt(0));
        p.setNombre(cursor.getString(1));
        p.setEmpresa(cursor.getString(2));
        p.setOrigen(cursor.getString(3));
        p.setDestino(cursor.getString(4));
        p.setFecha(cursor.getString(5));
        p.setHora(cursor.getString(6));
        p.setModo(cursor.getString(7));
        p.setImagen(cursor.getString(8));
        p.setFechav(cursor.getString(9));
        p.setCedula(cursor.getInt(10));
        p.setPrecio(cursor.getInt(11));
        p.setSilla(cursor.getInt(12));
        Log.i("Dest",p.getModo()+" "+ p.getCedula());
        return p;
    }
    private List<Tiquete> cursorToList(String sql){
        Cursor cursor = db.rawQuery(sql,null);
        List<Tiquete> data = new ArrayList<>();

        while(cursor.moveToNext()){
            Tiquete p = cursorToUsuario(cursor);
            Log.i("Dest",p.getModo()+" "+ p.getCedula());
            data.add(p);
        }
        return data;
    }

}


