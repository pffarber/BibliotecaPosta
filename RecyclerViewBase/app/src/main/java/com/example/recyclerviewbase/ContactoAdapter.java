package com.example.recyclerviewbase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ma on 21/05/18.
 */

public class ContactoAdapter extends RecyclerView.Adapter {

    private List<Contacto> contactos;
    private NotificadorContactoCelda notificadorContactoCelda;

    //recibo en el constructor del adapter, un set de datos ya armado desde afuera
    //y me lo guardo como atributo
    public ContactoAdapter(List<Contacto> contactos, NotificadorContactoCelda notificadorContactoCelda) {
        this.contactos = contactos;
        this.notificadorContactoCelda = notificadorContactoCelda;
    }

    /*
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
        notifyDataSetChanged();
    }*/


    //en este metodo debemos inflar nuesta celda (el xml armado) y pasarsela al viewholder
    //quien sera el que pegara la informacion del contacto en la celda que le pasemos.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //me creo el inflador para inflar el xml de la celda hacia una View.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_recycler_contactos, parent, false);
        //me creo un viewholder y le paso la View, que es la celda xml que inflamos
        ViewHolderContacto viewHolderContacto = new ViewHolderContacto(view);
        return viewHolderContacto;
    }

    //en este metodo recibimos una posicion, que es la posicion del contacto que debemos
    //mostrar en el recycler. Por lo que iremos con un GET a nuestro atributo (el set de datos)
    //y le pedirimos contactos.get(position) lo que nos devuelve el contacto en la posicion
    //recibida por parametro. Al viewholder que recibimos por parametro le pasamos este
    //contacto que obtuvimos, y el viewholder se encarga de volcar la info a la celda.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        ViewHolderContacto viewHolderContacto = (ViewHolderContacto) holder;
        viewHolderContacto.cargarContacto(contacto);
    }


    //retorno el tamaño de mi atributo que es el set de datos
    @Override
    public int getItemCount() {
        if (contactos != null) {
            return contactos.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderContacto extends RecyclerView.ViewHolder {

        private TextView textViewNombre;
        private ImageView imagenContacto;

        //este itemview es la celda construida
        public ViewHolderContacto(View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.nombre_contacto_id);
            imagenContacto = itemView.findViewById(R.id.imagen_contacto_id);

            imagenContacto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicionContactoClickeado = getAdapterPosition();
                    Contacto contacto = contactos.get(posicionContactoClickeado);
                    notificadorContactoCelda.notificarContactoClickeado(contacto);
                }
            });
        }

        public void cargarContacto(Contacto contacto) {
            //el contacto que recibe deberia sacarle sus datos y pegarlos en la celda
            textViewNombre.setText(contacto.getNombre());
            imagenContacto.setImageResource(contacto.getImageRes());
        }

    }

    //INTERFAZ QUE COMUNICA ADAPTER CON FRAGMENT. EL FRAGMENT ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorContactoCelda {
        public void notificarContactoClickeado(Contacto contacto);
    }
}
