package com.joseanguiano.animals;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 18/06/2016.
 */


public class AnimalAdaptador extends RecyclerView.Adapter<AnimalAdaptador.MascotaViewHolder> {

    ArrayList<Animal> mascotas;

    public AnimalAdaptador(ArrayList<Animal> mascotas){
        this.mascotas = mascotas;
    }


    @Override
    public AnimalAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalAdaptador.MascotaViewHolder holder, int position) {
        final Animal mascota = mascotas.get(position);
        holder.ivPerro.setImageResource(mascota.getPerro());
        holder.tvNombrePerro.setText(mascota.getNombrePerro());
        holder.tvConteoLikes.setText(String.valueOf(mascota.getConteoLikes()));
        holder.tvlikes.setText(String.valueOf(mascota.getLikes())+ "likes");



        holder.ivHuesoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Diste Like a " + mascota.getNombrePerro(),Toast.LENGTH_SHORT).show();

                ContructorContactos contructorContactos = new ContructorContactos(null);
                contructorContactos.darLikeAnimal(mascota);
                holder.tvlikes.setText(contructorContactos.obtenerLikesAnimal(mascota));



            }
        });
    }

    @Override
    public int getItemCount() {return mascotas.size(); }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPerro;
        private TextView tvNombrePerro;
        private TextView tvConteoLikes;
        private ImageView ivHuesoLike;
        private TextView tvlikes;

        public MascotaViewHolder(View itemView){
            super(itemView);

            ivPerro         = (ImageView) itemView.findViewById(R.id.ivPerro);
            tvNombrePerro   = (TextView) itemView.findViewById(R.id.tvNombrePerro);
            tvConteoLikes   = (TextView) itemView.findViewById(R.id.tvConteoLikes);
            ivHuesoLike     = (ImageView) itemView.findViewById(R.id.ivHuesoLike);
            tvlikes = (TextView)itemView.findViewById(R.id.tvlikes);
        }
    }
}
