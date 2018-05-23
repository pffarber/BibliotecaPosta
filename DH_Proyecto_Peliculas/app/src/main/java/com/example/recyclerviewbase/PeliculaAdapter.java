package com.example.recyclerviewbase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ma on 21/05/18.
 */

public class PeliculaAdapter extends RecyclerView.Adapter {

    private List<Pelicula> peliculas;
    private NotificadorPeliculaCelda notificadorPeliculaCelda;

    //recibo en el constructor del adapter, un set de datos ya armado desde afuera
    //y me lo guardo como atributo
    public PeliculaAdapter(List<Pelicula> peliculas, NotificadorPeliculaCelda notificadorPeliculaCelda) {
        this.peliculas = peliculas;
        this.notificadorPeliculaCelda = notificadorPeliculaCelda;
    }

    /*
    public void agregarPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
        notifyDataSetChanged();
    }*/


    //en este metodo debemos inflar nuesta celda (el xml armado) y pasarsela al viewholder
    //quien sera el que pegara la informacion dea pelicula en la celda que le pasemos.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //me creo el inflador para inflar el xml de la celda hacia una View.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_recycler_peliculas, parent, false);
        //me creo un viewholder y le paso la View, que es la celda xml que inflamos
        ViewHolderPelicula viewHolderPelicula = new ViewHolderPelicula(view);
        return viewHolderPelicula;
    }

    //en este metodo recibimos una posicion, que es la posicion de la pelicula que debemos
    //mostrar en el recycler. Por lo que iremos con un GET a nuestro atributo (el set de datos)
    //y le pedirimos peliculas.get(position) lo que nos devuelvela pelicula en la posicion
    //recibida por parametro. Al viewholder que recibimos por parametro le pasamos esta
    //pelicula que obtuvimos, y el viewholder se encarga de volcar la info a la celda.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        ViewHolderPelicula viewHolderPelicula = (ViewHolderPelicula) holder;
        viewHolderPelicula.cargarPelicula(pelicula);
    }


    //retorno el tamaño de mi atributo que es el set de datos
    @Override
    public int getItemCount() {
        if (peliculas != null) {
            return peliculas.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderPelicula extends RecyclerView.ViewHolder {


        private ImageView imagenPelicula;

        //este itemview es la celda construida
        public ViewHolderPelicula(View itemView) {
            super(itemView);

            imagenPelicula = itemView.findViewById(R.id.imagen_pelicula_id);

            imagenPelicula.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicionPeliculaClickeado = getAdapterPosition();
                    Pelicula pelicula = peliculas.get(posicionPeliculaClickeado);
                    notificadorPeliculaCelda.notificarPeliculaClickeado(pelicula);
                }
            });
        }

        public void cargarPelicula(Pelicula pelicula) {
            //el pelicula que recibe deberia sacarle sus datos y pegarlos en la celda

            imagenPelicula.setImageResource(pelicula.getImageRes());
        }

    }

    //INTERFAZ QUE COMUNICA ADAPTER CON FRAGMENT. EL FRAGMENT ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorPeliculaCelda {
        public void notificarPeliculaClickeado(Pelicula pelicula);
    }
}
