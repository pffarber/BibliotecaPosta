package com.example.recyclerviewbase;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactosFragment extends Fragment implements ContactoAdapter.NotificadorContactoCelda {

    private RecyclerView recyclerView;
    private List<Contacto> contactos;
    private NotificadorContacto notificadorContacto;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contactos, container, false);

        recyclerView = view.findViewById(R.id.recycler_id);
        armarListadoContactos();
        //necesito pasarle al adapter el set de datos armado
        ContactoAdapter adapter = new ContactoAdapter(contactos, this);
        //el layout manager es la disposicion visual del recycler (lineal o grilla, con orientacion vertical u horizontal)
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        //si le puse match parent al alto y ancho del recycler, el setHasFixedSize mejora la performance
        recyclerView.setHasFixedSize(true);
        //le seteo el adapter creado al recycler view
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificadorContacto = (NotificadorContacto) context;
    }

    private void armarListadoContactos() {
        contactos = new ArrayList<>();
        contactos.add(new Contacto("Nicolas", "Vive en caballito, juega al futbol"));
        contactos.add(new Contacto("Juan", "Vive en flores, juega al basket"));
        contactos.add(new Contacto("Roberto", "Vive en almagro, juega al tenis"));
        contactos.add(new Contacto("Claudio", "Vive en puerto madero, juega al golf"));
        contactos.add(new Contacto("Juana", "Vive en hurlingam, juega al paddle"));
        contactos.add(new Contacto("Sebastian", "Labura en youtube"));
        contactos.add(new Contacto("Nicolas", "Vive en caballito, juega al futbol"));
        contactos.add(new Contacto("Juan", "Vive en flores, juega al basket"));
        contactos.add(new Contacto("Roberto", "Vive en almagro, juega al tenis"));
        contactos.add(new Contacto("Claudio", "Vive en puerto madero, juega al golf"));
        contactos.add(new Contacto("Juana", "Vive en hurlingam, juega al paddle"));
        contactos.add(new Contacto("Sebastian", "Labura en youtube"));
    }

    @Override
    public void notificarContactoClickeado(Contacto contacto) {
        //esto se va a llamar cuando se clickee una celda en el adapter
        //Esto hace de pasa mano, y tiene que notificarle al activity el contacto que llegó.
        //aca estoy en el metodo que me obligo a implementar LA INTERFAZ DEL ADAPTER!
        notificadorContacto.notificar(contacto);
    }

    //INTERFAZ QUE COMUNICA FRAGMENT CON ACTIVITY. EL ACTIVITY ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorContacto {
        public void notificar(Contacto contacto);
    }
}
