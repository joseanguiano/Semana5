package com.joseanguiano.animals;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 24/06/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public AnimalAdaptador crearAdaptador(ArrayList<Animal>animals);

    public void inicializarAdaptador(AnimalAdaptador adaptador);
}
