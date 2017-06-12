package unicauca.movil.midestin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kathe on 15/12/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "destino.db";
    static int VERSION =1;
    public DataBaseHelper(Context context){
        super(context, DB_NAME, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlUsuario = "CREATE TABLE usuario (cedula INTEGER PRIMARY KEY UNIQUE "
                +", nombre VARCHAR NOT NULL"
                +",correo VARCHAR"
                +",user VARCHAR NOT NULL UNIQUE"
                +",password VARCHAR NOT NULL"
                +",cuenta INTEGER DEFAULT 12345"
                +")";
        sqLiteDatabase.execSQL(sqlUsuario);

        ContentValues contentValues =new ContentValues();
        contentValues.put("cedula", 3);
        contentValues.put("nombre", "tasha");
        contentValues.put("user", "tasha");
        contentValues.put("correo", "ts");
        contentValues.put("password", "123");
        contentValues.put("cuenta", 12345);

        sqLiteDatabase.insert("usuario",null, contentValues);


        String sqlTiquete = "CREATE TABLE tiquete (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL "
                +", nombre VARCHAR NOT NULL"
                +",empresa VARCHAR NOT NULL"
                +",origen VARCHAR NOT NULL "
                +",destino VARCHAR NOT NULL"
                +",fecha VARCHAR NOT NULL"
                +",hora VARCHAR NOT NULL"
                +",modo VARCHAR NOT NULL"
                +",imagen VARCHAR "
                +",fechav VARCHAR NOT NULL"
                +",cedula INTEGER NOT NULL "
                +",precio INTEGER NOT NULL"
                +",silla INTEGER DEFAULT 3"
                +")";
        sqLiteDatabase.execSQL(sqlTiquete);

        ContentValues contentValuesT =new ContentValues();
        contentValuesT.put("nombre", "Tasha");
        contentValuesT.put("empresa", "Bolivariano");
        contentValuesT.put("origen", "Cali");
        contentValuesT.put("destino", "Bogota");
        contentValuesT.put("fecha", "16/12/1016");
        contentValuesT.put("hora", "9:00");
        contentValuesT.put("modo", "compra");
        contentValuesT.put("imagen", "http://www.terminalarmenia.com/userfiles/images/empresas/expresobolivariano.jpg");
        contentValuesT.put("fechav", "16/12/2016");
        contentValuesT.put("cedula", 3);
        contentValuesT.put("precio", 90000);
        contentValuesT.put("silla", 3);

        ContentValues contentValuesT1 =new ContentValues();
        contentValuesT1.put("nombre", "Tasha");
        contentValuesT1.put("empresa", "Velotax");
        contentValuesT1.put("origen", "Cali");
        contentValuesT1.put("destino", "Popayán");
        contentValuesT1.put("fecha", "17/12/1016");
        contentValuesT1.put("hora", "9:00");
        contentValuesT1.put("modo", "reserva");
        contentValuesT1.put("imagen", "http://terminalhonda.com/images/empresas/Velotax_opt.jpg");
        contentValuesT1.put("fechav", "16/12/2016");
        contentValuesT1.put("cedula", 3);
        contentValuesT1.put("precio", 90000);
        contentValuesT1.put("silla", 3);

        ContentValues contentValuesT2 =new ContentValues();
        contentValuesT2.put("nombre", "Tasha");
        contentValuesT2.put("empresa", "Velotax");
        contentValuesT2.put("origen", "Bogotá");
        contentValuesT2.put("destino", "Popayán");
        contentValuesT2.put("fecha", "17/12/1016");
        contentValuesT2.put("hora", "9:00");
        contentValuesT2.put("modo", "reserva");
        contentValuesT2.put("imagen", "http://terminalhonda.com/images/empresas/Velotax_opt.jpg");
        contentValuesT2.put("fechav", "16/12/2016");
        contentValuesT2.put("cedula", 3);
        contentValuesT2.put("precio", 90000);
        contentValuesT2.put("silla", 3);


        sqLiteDatabase.insert("tiquete",null, contentValuesT);
        sqLiteDatabase.insert("tiquete",null, contentValuesT2);
        sqLiteDatabase.insert("tiquete",null, contentValuesT1);

        String sqlHorario = "CREATE TABLE horario (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL "

                +",empresa VARCHAR NOT NULL"
                +",fecha VARCHAR NOT NULL"
                +",hora VARCHAR NOT NULL"
                +",imagen VARCHAR "
                +",trayecto INTEGER NOT NULL "
                +",precio INTEGER NOT NULL"
                +")";
        sqLiteDatabase.execSQL(sqlHorario);

        ContentValues contentValuesH =new ContentValues();

        contentValuesH.put("empresa", "Bolivariano");
        contentValuesH.put("fecha", "16/12/1016");
        contentValuesH.put("hora", "9:00");
        contentValuesH.put("imagen","http://www.terminalarmenia.com/userfiles/images/empresas/expresobolivariano.jpg" );
        contentValuesH.put("trayecto", 1);
        contentValuesH.put("precio", 90000);


        sqLiteDatabase.insert("horario",null, contentValuesH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE usuario");
        sqLiteDatabase.execSQL("DROP TABLE tiquete");
        sqLiteDatabase.execSQL("DROP TABLE horario");
        onCreate(sqLiteDatabase);
    }


}
