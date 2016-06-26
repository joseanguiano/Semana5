package com.joseanguiano.animals;

import android.content.Context;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 24/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorContactos contructorContactos;
private ArrayList<Animal>animals;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
    this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactisBaseDatos();
    }

    @Override
    public void obtenerContactisBaseDatos() {

          contructorContactos = new ContructorContactos(context);
        animals = contructorContactos.obtenerDatos();
         mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {

        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(animals));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
