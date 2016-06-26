package com.joseanguiano.animals;

/**
 * Created by JoseAnguiano on 18/06/2016.
 */
public class Animal {


    private int id;
    private int Perro;
    private String NombrePerro;
    private int ConteoLikes;
    private int likes;

    public Animal(int perro, String nombrePerro, int conteoLikes, int likes) {
        Perro = perro;
        NombrePerro = nombrePerro;
        ConteoLikes = conteoLikes;
        this.likes = likes;
    }

    public Animal() {

    }

    public int getConteoLikes() {
        return ConteoLikes;
    }

    public void setConteoLikes(int conteoLikes) {
        ConteoLikes = conteoLikes;
    }

    public String getNombrePerro() {
        return NombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        NombrePerro = nombrePerro;
    }

    public int getPerro() {
        return Perro;
    }

    public void setPerro(int perro) {
        Perro = perro;
    }


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
