package com.example.recyclerviewbase;

import java.io.Serializable;

/**
 * Created by ma on 21/05/18.
 */

//PARA PASAR UN OBJETO POR BUNDLE, TENGO QUE PONERLE IMPLEMENTS SERIALIZABLE EN SU CLASE
public class Pelicula implements Serializable {
    private String nombre;
    private int imageRes;
    private String descripcion;


    public Pelicula(String nombre, int imageRes) {
        this.nombre = nombre;
        this.imageRes = imageRes;
    }


    public Pelicula(String nombre) {
        this.nombre = nombre;
        this.imageRes = R.drawable.santa;
    }

    public Pelicula(String nombre, String descripcion) {
        this.nombre = nombre;
        this.imageRes = R.drawable.santa;
        this.descripcion = descripcion;
    }
    public Pelicula(String nombre, String descripcion, int imageRes) {
        this.nombre = nombre;
        this.imageRes = imageRes;
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
