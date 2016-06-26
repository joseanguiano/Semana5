package com.joseanguiano.animals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerviewFragment extends Fragment implements  IRecyclerViewFragmentView{

    ArrayList<Animal> mascotas;
    private RecyclerView listaMascotas;
    private  IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

       listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
       //presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }
    /*
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Animal>();


        mascotas.add(new Animal(R.drawable.pollohd,"Pollo",8, likes));
        mascotas.add(new Animal(R.drawable.corderohd,"Cordero",4, likes));
        mascotas.add(new Animal(R.drawable.conejouhd,"Conejo",7, likes));
        mascotas.add(new Animal(R.drawable.serpientehd,"Serpiente",4, likes));
        mascotas.add(new Animal(R.drawable.perrohd,"Perro",9, likes));
    }
*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public AnimalAdaptador crearAdaptador(ArrayList<Animal> animals) {

        AnimalAdaptador adaptador = new AnimalAdaptador(mascotas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(AnimalAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
