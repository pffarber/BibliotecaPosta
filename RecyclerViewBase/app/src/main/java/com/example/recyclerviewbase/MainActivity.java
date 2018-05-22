package com.example.recyclerviewbase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ContactosFragment.NotificadorContacto{

    private ContactosFragment contactosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactosFragment = new ContactosFragment();
        cargarFragment(contactosFragment);

    }

    private void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void notificar(Contacto contacto) {
        Intent intent = new Intent(this,DetalleContactoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetalleContactoFragment.CONTACTO_KEY,contacto);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
