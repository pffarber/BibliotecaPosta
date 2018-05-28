package com.example.recyclerviewbase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DetallePeliculaActivity extends AppCompatActivity  implements PeliculasFragment.NotificadorPelicula{

    private DetallePeliculaFragment detallePeliculaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
        Bundle bundle = getIntent().getExtras();
        detallePeliculaFragment = new DetallePeliculaFragment();
        detallePeliculaFragment.setArguments(bundle);
        cargarFragment(detallePeliculaFragment);

    }


    private void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment1, fragment);
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
    public void abrirGrilla(String categoria, ArrayList<Pelicula> peliculas){

    }
}
