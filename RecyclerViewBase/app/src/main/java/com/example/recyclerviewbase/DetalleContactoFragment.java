package com.example.recyclerviewbase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleContactoFragment extends Fragment {

    public static final String CONTACTO_KEY = "Contacto_key";
    private ImageView imagenContacto;
    private TextView nombreContacto;
    private TextView descripcionContacto;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_contacto, container, false);
        imagenContacto = view.findViewById(R.id.imagen_contacto);
        nombreContacto = view.findViewById(R.id.nombre_contacto);
        descripcionContacto = view.findViewById(R.id.descripcion_contacto);

        Bundle bundle = getArguments();
        Contacto contacto = (Contacto) bundle.getSerializable(CONTACTO_KEY);
        nombreContacto.setText(contacto.getNombre());
        descripcionContacto.setText(contacto.getDescripcion());
        imagenContacto.setImageResource(contacto.getImageRes());


        return view;
    }

}
