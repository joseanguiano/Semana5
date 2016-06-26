package com.joseanguiano.animals;

import android.content.ContentValues;
import android.content.Context;

import com.joseanguiano.animals.Animal;
import com.joseanguiano.animals.R;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 24/06/2016.
 */
public class ContructorContactos {

    private static final int LIKE = 1 ;
    private Context context;
    public ContructorContactos(Context context) {
        this.context = this.context;
    }

    public ArrayList<Animal>obtenerDatos(){
/*
        ArrayList<Animal> mascotas = new ArrayList<Animal>();


        mascotas.add(new Animal(R.drawable.pollohd,"Pollo",7,7));
        mascotas.add(new Animal(R.drawable.corderohd,"Cordero",4, 4));
        mascotas.add(new Animal(R.drawable.conejouhd,"Conejo",7, 7));
        mascotas.add(new Animal(R.drawable.serpientehd,"Serpiente",4, 4));
        mascotas.add(new Animal(R.drawable.perrohd,"Perro",9, 5));

        return  mascotas;
  */
        BaseDatos db = new BaseDatos(context);
    insertarTresAnimales(db);
        return  db.obtenerTodosLosAnimales();
    }

    public void insertarTresAnimales(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_ANIMALES_C_NOMBRE, "Jose Anguiano");
        contentValues.put(ConstanteBaseDatos.TABLE_ANIMALES_C_TELEFONO, "11");
        contentValues.put(ConstanteBaseDatos.TABLE_ANIMALES_C_EMAIL, "2");
        contentValues.put(ConstanteBaseDatos.TABLE_ANIMALES_C_FOTO, R.drawable.pollohd);


        db.insertarAnimal(contentValues);
    }
    public void darLikeAnimal(Animal animal){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_ANIMALES_ID_ANIMAL,animal.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_ANIMALES_NUMERO_LIKES, LIKE);
        db.insertarLikeAnimal(contentValues);
    }

    public int obtenerLikesAnimal(Animal animal){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerLikesAnimal(animal);

    }
}
