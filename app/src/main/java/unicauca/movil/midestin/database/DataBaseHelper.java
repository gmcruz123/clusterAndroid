package unicauca.movil.midestin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kathe on 15/12/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "midestino.db";
    static int VERSION =1;
    public DataBaseHelper(Context context){
        super(context, DB_NAME, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlUsuario = "CREATE TABLE usuario (cedula INTEGER PRIMARY KEY UNIQUE NOT NULL"
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE usuario");
        onCreate(sqLiteDatabase);
    }


}
