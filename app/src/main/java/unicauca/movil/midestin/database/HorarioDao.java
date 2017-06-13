package unicauca.movil.midestin.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.midestin.models.Horario;
import unicauca.movil.midestin.models.Tiquete;

public class HorarioDao {
    static final String TABLE= "horario";
    static final String C_ID = "id";
    static final String C_EMP = "empresa";
    static final String C_FECHA="fecha";
    static final String C_HOR="hora";
    static final String C_IMG="imagen";
    static final String C_TRY="trayecto";
    static final String C_PRECIO="precio";

    SQLiteDatabase db;

    public HorarioDao(Context contex){
        DataBaseHelper helper= new DataBaseHelper(contex);
        db= helper.getWritableDatabase();
    }

    public void insert(Horario usuario){
        ContentValues values = new ContentValues();
        values.put(C_EMP,usuario.getEmpresa());
        values.put(C_FECHA,usuario.getFecha());
        values.put(C_HOR,usuario.getHora());
        values.put(C_IMG,usuario.getImagen());
        values.put(C_TRY,usuario.getTrayecto());
        values.put(C_PRECIO,usuario.getPrecio());


        db.insert(TABLE, null, values);
    }
    public void update(Horario usuario){
        ContentValues values = new ContentValues();
        values.put(C_EMP,usuario.getEmpresa());
        values.put(C_FECHA,usuario.getFecha());
        values.put(C_HOR,usuario.getHora());
        values.put(C_IMG,usuario.getImagen());
        values.put(C_TRY,usuario.getTrayecto());
        values.put(C_PRECIO,usuario.getPrecio());

        db.update(TABLE,values, "id =?",new String[]{""+ usuario.getId()});

    }
    public void delete(Long id){
        db.delete(TABLE,"id=?", new String[]{""+id});
    }

    public  Horario getById(Long id,String fecha){
        String sql = "SELECT * FROM "+ TABLE + "WHERE id ="+id;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToNext();
            return cursorToUsuario(cursor,fecha);
        }else
            return null;
    }



    public int Count(){
        String sql = "SELECT * FROM "+ TABLE;
        Cursor cursor = db.rawQuery(sql,null);
        int a= cursor.getCount();
        return a;
    }


    public List<Horario> list(int c, String fecha){
        Log.i("Destino","String trayecto "+c);
        String sql ="SELECT * FROM "+ TABLE + " WHERE trayecto="+c ;
        Log.i("Destino", sql);
        return cursorToList(sql, fecha);
    }

    public int Counter(String c,int ced){
        String sql = "SELECT * FROM "+ TABLE +" WHERE modo= '"+c+"'  AND cedula="+ced ;
        Cursor cursor = db.rawQuery(sql,null);
        int a= cursor.getCount();
        return a;
    }



    private Horario cursorToUsuario(Cursor cursor,String fecha){
        Horario p = new Horario();
        p.setId(cursor.getInt(0));
        p.setEmpresa(cursor.getString(1));
        p.setFecha(fecha);
        p.setHora(cursor.getString(3));
        p.setImagen(cursor.getString(4));
        p.setTrayecto(cursor.getInt(5));
        p.setPrecio(cursor.getInt(6));
       // Log.i("Dest",p.getModo()+" "+ p.getCedula());
        return p;
    }
    private List<Horario> cursorToList(String sql, String fecha){
        Cursor cursor = db.rawQuery(sql,null);
        List<Horario> data = new ArrayList<>();

        while(cursor.moveToNext()){
            Horario p = cursorToUsuario(cursor, fecha);
            fecha = fecha;
           // Log.i("Dest",p.getModo()+" "+ p.getCedula());
            data.add(p);
        }

        return data;
    }
}
