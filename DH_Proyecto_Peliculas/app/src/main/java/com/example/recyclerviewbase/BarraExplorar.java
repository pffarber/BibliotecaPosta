package com.example.recyclerviewbase;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BarraExplorar extends Fragment {


private NotificadorBarraExplorar notificadorBarraExplorar;
private ImageView iconoFavorito;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_barra_explorar, container, false);

        iconoFavorito = (ImageView) view.findViewById(R.id.boton_barra_favorito_id);

        iconoFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GUARDO EN UNA VARIABLE Drawable la imagen
                //ENVIARLE EL MENSAJE AL ACTIVITY
                notificadorBarraExplorar.abrirFavoritos();
            }
        });



        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificadorBarraExplorar = (BarraExplorar.NotificadorBarraExplorar) context;

    }


    //INTERFAZ QUE COMUNICA FRAGMENT CON ACTIVITY. EL ACTIVITY ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorBarraExplorar {

        public void abrirFavoritos();
    }
}
