package com.joseanguiano.animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Animal> mascotas;
    private RecyclerView listaMascotas;
    private ImageView cincoEstrellas;
    private Toolbar tolbar;
    private TabLayout tablaLayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tolbar = (Toolbar)findViewById(R.id.toba);
        tablaLayout = (TabLayout)findViewById(R.id.tablayout);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionbar);

        cincoEstrellas = (ImageView) findViewById(R.id.ivCincoEstrellas);
            setUpViewPager();

/*
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
*/
        agregarFAB();

    }

    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment>fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
private void setUpViewPager(){
viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
    tablaLayout.setupWithViewPager(viewpager);
    tablaLayout.getTabAt(0).setIcon(R.drawable.ic_action_houses);
    tablaLayout.getTabAt(1).setIcon(R.drawable.ic_action_perro);
}


    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabCamara);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Tomaste un Fotografia", Toast.LENGTH_SHORT).show();
            }
        });
    }
/*
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Animal>();


        mascotas.add(new Animal(R.drawable.pollohd,"Pollo",8));
        mascotas.add(new Animal(R.drawable.corderohd,"Cordero",4));
        mascotas.add(new Animal(R.drawable.conejouhd,"Conejo",7));
        mascotas.add(new Animal(R.drawable.serpientehd,"Serpiente",4));
        mascotas.add(new Animal(R.drawable.perrohd,"Perro",9));
    }

    public void inicializarAdaptador(){
        AnimalAdaptador adaptador = new AnimalAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void btnCincoEstrellas(View v){
        Intent intent = new Intent(this, Complemento.class);
        startActivity(intent);
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_contacto:
                Toast.makeText(this,getResources().getString(R.string.action_contacto),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Contacto.class);
                startActivity(intent);

                break;
            case R.id.action_acercade:
                Toast.makeText(this,getResources().getString(R.string.action_acercade),Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this,Acerca.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
