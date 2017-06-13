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

        ContentValues contentValuesH1 =new ContentValues();
        contentValuesH1.put("empresa", "Velotax");
        contentValuesH1.put("fecha", "16/12/1016");
        contentValuesH1.put("hora", "9:00");
        contentValuesH1.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH1.put("trayecto", 0);
        contentValuesH1.put("precio", 90000);



        ContentValues contentValuesH2 =new ContentValues();

        contentValuesH2.put("empresa", "Bolivariano");
        contentValuesH2.put("fecha", "16/12/1016");
        contentValuesH2.put("hora", "9:00");
        contentValuesH2.put("imagen","http://www.terminalarmenia.com/userfiles/images/empresas/expresobolivariano.jpg" );
        contentValuesH2.put("trayecto", 2);
        contentValuesH2.put("precio", 90000);

        ContentValues contentValuesH3 =new ContentValues();
        contentValuesH3.put("empresa", "Velotax");
        contentValuesH3.put("fecha", "16/12/1016");
        contentValuesH3.put("hora", "9:00");
        contentValuesH3.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH3.put("trayecto", 3);
        contentValuesH3.put("precio", 90000);




        ContentValues contentValuesH4 =new ContentValues();

        contentValuesH4.put("empresa", "Bolivariano");
        contentValuesH4.put("fecha", "16/12/1016");
        contentValuesH4.put("hora", "9:00");
        contentValuesH4.put("imagen","http://www.terminalarmenia.com/userfiles/images/empresas/expresobolivariano.jpg" );
        contentValuesH4.put("trayecto", 4);
        contentValuesH4.put("precio", 90000);

        ContentValues contentValuesH5 =new ContentValues();
        contentValuesH5.put("empresa", "Velotax");
        contentValuesH5.put("fecha", "16/12/1016");
        contentValuesH5.put("hora", "9:00");
        contentValuesH5.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH5.put("trayecto", 5);
        contentValuesH5.put("precio", 90000);


        ContentValues contentValuesH6 =new ContentValues();
        contentValuesH6.put("empresa", "Velotax");
        contentValuesH6.put("fecha", "16/12/1016");
        contentValuesH6.put("hora", "9:00");
        contentValuesH6.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH6.put("trayecto", 1);
        contentValuesH6.put("precio", 95000);

        ContentValues contentValuesH14 =new ContentValues();
        contentValuesH.put("empresa", "Bolivariano");
        contentValuesH.put("fecha", "16/12/1016");
        contentValuesH.put("hora", "18:00");
        contentValuesH.put("imagen","http://www.terminalarmenia.com/userfiles/images/empresas/expresobolivariano.jpg" );
        contentValuesH.put("trayecto", 1);
        contentValuesH.put("precio", 90000);

        ContentValues contentValuesH15 =new ContentValues();
        contentValuesH6.put("empresa", "Velotax");
        contentValuesH6.put("fecha", "16/12/1016");
        contentValuesH6.put("hora", "20:00");
        contentValuesH6.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH6.put("trayecto", 1);
        contentValuesH6.put("precio", 95000);

        ContentValues contentValuesH7 =new ContentValues();
        contentValuesH7.put("empresa", "Velotax");
        contentValuesH7.put("fecha", "16/12/1016");
        contentValuesH7.put("hora", "9:00");
        contentValuesH7.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH7.put("trayecto", 2);
        contentValuesH7.put("precio", 95000);


        ContentValues contentValuesH8 =new ContentValues();
        contentValuesH8.put("empresa", "Velotax");
        contentValuesH8.put("fecha", "16/12/1016");
        contentValuesH8.put("hora", "9:00");
        contentValuesH8.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH8.put("trayecto", 3);
        contentValuesH8.put("precio", 95000);


        ContentValues contentValuesH9 =new ContentValues();
        contentValuesH9.put("empresa", "Velotax");
        contentValuesH9.put("fecha", "16/12/1016");
        contentValuesH9.put("hora", "9:00");
        contentValuesH9.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH9.put("trayecto", 4);
        contentValuesH9.put("precio", 95000);


        ContentValues contentValuesH10 =new ContentValues();
        contentValuesH10.put("empresa", "Velotax");
        contentValuesH10.put("fecha", "16/12/1016");
        contentValuesH10.put("hora", "9:00");
        contentValuesH10.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH10.put("trayecto", 5);
        contentValuesH10.put("precio", 95000);


        ContentValues contentValuesH11 =new ContentValues();
        contentValuesH11.put("empresa", "Velotax");
        contentValuesH11.put("fecha", "16/12/1016");
        contentValuesH11.put("hora", "9:00");
        contentValuesH11.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH11.put("trayecto", 6);
        contentValuesH11.put("precio", 95000);


        ContentValues contentValuesH12 =new ContentValues();
        contentValuesH12.put("empresa", "Velotax");
        contentValuesH12.put("fecha", "16/12/1016");
        contentValuesH12.put("hora", "9:00");
        contentValuesH12.put("imagen","http://www.terminalarmenia.com/userfiles/images/empresas/expresobolivariano.jpg" );
        contentValuesH12.put("trayecto", 1);
        contentValuesH12.put("precio", 90000);


        ContentValues contentValuesH13 =new ContentValues();
        contentValuesH13.put("empresa", "Velotax");
        contentValuesH13.put("fecha", "16/12/1016");
        contentValuesH13.put("hora", "9:00");
        contentValuesH13.put("imagen","http://terminalhonda.com/images/empresas/Velotax_opt.jpg" );
        contentValuesH13.put("trayecto", 2);
        contentValuesH13.put("precio", 96000);





        sqLiteDatabase.insert("horario",null, contentValuesH);
        sqLiteDatabase.insert("horario",null, contentValuesH1);
        sqLiteDatabase.insert("horario",null, contentValuesH2);
        sqLiteDatabase.insert("horario",null, contentValuesH3);
        sqLiteDatabase.insert("horario",null, contentValuesH4);
        sqLiteDatabase.insert("horario",null, contentValuesH5);
        sqLiteDatabase.insert("horario",null, contentValuesH6);
        sqLiteDatabase.insert("horario",null, contentValuesH7);
        sqLiteDatabase.insert("horario",null, contentValuesH8);
        sqLiteDatabase.insert("horario",null, contentValuesH9);
        sqLiteDatabase.insert("horario",null, contentValuesH10);
        sqLiteDatabase.insert("horario",null, contentValuesH11);
        sqLiteDatabase.insert("horario",null, contentValuesH12);
        sqLiteDatabase.insert("horario",null, contentValuesH13);





    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE usuario");
        sqLiteDatabase.execSQL("DROP TABLE tiquete");
        sqLiteDatabase.execSQL("DROP TABLE horario");
        onCreate(sqLiteDatabase);
    }


}
