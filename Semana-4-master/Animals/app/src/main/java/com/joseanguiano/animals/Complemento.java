/*package com.joseanguiano.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class Complemento extends AppCompatActivity {

    ArrayList<Animal> mascotas;
    private RecyclerView listaMascotas;
    private ImageView cincoEstrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complemento);


        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cincoEstrellas = (ImageView) findViewById(R.id.ivCincoEstrellas);
        cincoEstrellas.setVisibility(View.INVISIBLE);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Animal>();


        mascotas.add(new Animal(R.drawable.pollohd, "Pollo", 8, 7));
        mascotas.add(new Animal(R.drawable.corderohd, "Cordero", 4, 7));
        mascotas.add(new Animal(R.drawable.conejouhd, "Conejo", 7, 7));
        mascotas.add(new Animal(R.drawable.serpientehd, "Serpiente", 4, 7));
        mascotas.add(new Animal(R.drawable.perrohd, "Perro", 9, 7));


    }

    public void inicializarAdaptador() {
        AnimalAdaptador adaptador = new AnimalAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void btnCincoEstrellas(View v) {
        Intent intent = new Intent(this, Complemento.class);
        startActivity(intent);
    }
}
*/