package com.example.recyclerviewbase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements PeliculasFragment.NotificadorPelicula{

    private PeliculasFragment peliculasFragment;
    private String nombreCategoria;
    private int idCategoria,idCategoria2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //EUGENIO: CARGO 6 CATEGORÍAS GENERICAS
        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Populares");
        idCategoria=R.id.container_fragment1;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat2");
        idCategoria2=R.id.container_fragment2;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria2);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat3");
        idCategoria=R.id.container_fragment3;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat4");
        idCategoria=R.id.container_fragment4;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat5");
        idCategoria=R.id.container_fragment5;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria);

        peliculasFragment = new PeliculasFragment();
        nombreCategoria = new String("Cat6");
        idCategoria=R.id.container_fragment6;
        cargarFragment(peliculasFragment,nombreCategoria,idCategoria);
    }


    //EUGENIO: AGREGUE A LA FUNCIÓN DE CARGAR FRAGMENT LOS PARAMETROS ID DEL CONTAINER DE CADA
    // FRAGMENT Y EL TITULO DE CADA CATEGORÍA
    private void cargarFragment(Fragment fragment,String Categoria,int IdCategoria) {


        //EUGENIO: CARGO EL BUNDLE PARA ENVIAR EL TITULO DE LA CATEGORIA AL Fragment
        Bundle unBundle = new Bundle();
        unBundle.putString(PeliculasFragment.CLAVE_TITULO_CATEGORIA, Categoria);
        peliculasFragment.setArguments(unBundle);
        ////////////////////////////////////////////////////////////////////////

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(IdCategoria, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void notificar(Pelicula pelicula) {
        Intent intent = new Intent(this,DetallePeliculaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetallePeliculaFragment.PELICULA_KEY, pelicula);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void abrirGrilla(String categoria){
        //IR A LA Activity de detalle de categoría en grilla
        Intent unIntent = new Intent(this, GrillaCategoria.class);
        //CARGO EL BUNDLE PARA ENVIAR AL ACTIVITY
        Bundle unBundle = new Bundle();
        unBundle.putString(PeliculasFragment.CLAVE_TITULO_CATEGORIA, categoria);
        //ASOCIO EL BUNDLE AL INTENT
        unIntent.putExtras(unBundle);

        //COMIENZO LA ACTIVIDAD
        startActivity(unIntent);
    }

}


