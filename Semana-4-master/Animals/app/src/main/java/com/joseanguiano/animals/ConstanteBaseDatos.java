package com.joseanguiano.animals;

/**
 * Created by JoseAnguiano on 24/06/2016.
 */
public final class ConstanteBaseDatos {

    public static final  String DATABASE_NAME = "animalbd";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_ANIMALES_C = "animales";
    public static final String TABLE_ANIMALES_C_ID = "id";
    public static final String TABLE_ANIMALES_C_NOMBRE = "nombre";
    public static final String TABLE_ANIMALES_C_TELEFONO = "telefono";
    public static final String TABLE_ANIMALES_C_EMAIL = "email";
    public static final String TABLE_ANIMALES_C_FOTO = "foto";


    public static final String TABLE_LIKES_ANIMALES = "animales_likes" ;
    public static final String TABLE_LIKES_ANIMALES_ID = "id" ;
    public static final String TABLE_LIKES_ANIMALES_ID_ANIMAL ="id_animales" ;
    public static final String TABLE_LIKES_ANIMALES_NUMERO_LIKES = "numero_likes";
}
