package com.example.recyclerviewbase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PeliculasFragment.NotificadorPelicula{

    private PeliculasFragment peliculasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peliculasFragment = new PeliculasFragment();
        cargarFragment(peliculasFragment);

    }

    private void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void notificar(Pelicula pelicula) {
        Intent intent = new Intent(this,DetallePeliculaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetallePeliculaFragment.CONTACTO_KEY, pelicula);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
