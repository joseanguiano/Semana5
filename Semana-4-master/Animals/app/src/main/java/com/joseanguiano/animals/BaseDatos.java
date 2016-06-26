package com.joseanguiano.animals;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 24/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaAnimalC = "CREATE TABLE" + ConstanteBaseDatos.TABLE_ANIMALES_C + "(" +
                ConstanteBaseDatos.TABLE_ANIMALES_C_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstanteBaseDatos.TABLE_ANIMALES_C_NOMBRE + "TEXT,"+
                ConstanteBaseDatos.TABLE_ANIMALES_C_TELEFONO + "TEXT,"+
                ConstanteBaseDatos.TABLE_ANIMALES_C_EMAIL + "TEXT,"+
                ConstanteBaseDatos.TABLE_ANIMALES_C_FOTO+ "INTEGER"+
                ")";
        String queryCrearTablaLikesAnimales = "CREATE TABLE"+ ConstanteBaseDatos.TABLE_LIKES_ANIMALES + "(" +
                ConstanteBaseDatos.TABLE_LIKES_ANIMALES_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstanteBaseDatos.TABLE_LIKES_ANIMALES_ID_ANIMAL + "INTEGER,"+
                ConstanteBaseDatos.TABLE_LIKES_ANIMALES_NUMERO_LIKES + "INTEGER"+
                "FOREIGN KEY ("+ConstanteBaseDatos.TABLE_LIKES_ANIMALES_ID_ANIMAL +")"+
                "REFERENCES"+ConstanteBaseDatos.TABLE_ANIMALES_C+"("+ConstanteBaseDatos.TABLE_ANIMALES_C_ID+")"+
                ")";
        db.execSQL(queryCrearTablaAnimalC);
        db.execSQL(queryCrearTablaLikesAnimales);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ConstanteBaseDatos.TABLE_ANIMALES_C);

        db.execSQL("DROP TABLE IF EXIST"+ConstanteBaseDatos.TABLE_LIKES_ANIMALES);
        onCreate(db);
    }

    public ArrayList<Animal>obtenerTodosLosAnimales()
    {
        ArrayList<Animal>animals = new ArrayList<>();

        String query = "SELECT * FROM" + ConstanteBaseDatos.TABLE_ANIMALES_C;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){

            Animal animalActual = new Animal();
            animalActual.setId(registros.getInt(0));
            animalActual.setNombrePerro(registros.getString(1));
            animalActual.setConteoLikes(registros.getInt(2));
            animalActual.setLikes(registros.getInt(3));

            String queryLikes = "SELECT COUNT ("+ConstanteBaseDatos.TABLE_LIKES_ANIMALES_NUMERO_LIKES+")as likes"+
                                "FROM"+ ConstanteBaseDatos.TABLE_LIKES_ANIMALES+
                    "WHERE" + ConstanteBaseDatos.TABLE_LIKES_ANIMALES_ID_ANIMAL + "="+ animalActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes,null);
            if (registrosLikes.moveToNext()){
                animalActual.setLikes(registrosLikes.getInt(0));
            }

            else{
                animalActual.setLikes(0);

            }

            animals.add(animalActual);


        }

        db.close();

        return  animals;
    }

    public void insertarAnimal(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_ANIMALES_C, null, contentValues);

        db.close();
    }

    public void insertarLikeAnimal(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKES_ANIMALES,null, contentValues);
        db.close();
    }

    public int obtenerLikesAnimal(Animal animal){
        int likes = 0;

        String query = "SELECT COUNT("+ConstanteBaseDatos.TABLE_LIKES_ANIMALES_NUMERO_LIKES+")"+
                "FROM"+ConstanteBaseDatos.TABLE_LIKES_ANIMALES+
                "WHERE"+ConstanteBaseDatos.TABLE_LIKES_ANIMALES_ID_ANIMAL + "="+animal.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return  likes;

    }
}
