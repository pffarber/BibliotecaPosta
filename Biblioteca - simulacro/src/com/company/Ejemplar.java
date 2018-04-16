package com.company;

public class Ejemplar {

    private Libro libro;
    private Integer nroDeEdicion;
    private String ubicacion;

    public Ejemplar(Libro libro, Integer nroDeEdicion, String ubicacion) {
        this.libro = libro;
        this.nroDeEdicion = nroDeEdicion;
        this.ubicacion = ubicacion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getNroDeEdicion() {
        return nroDeEdicion;
    }

    public void setNroDeEdicion(Integer nroDeEdicion) {
        this.nroDeEdicion = nroDeEdicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Ejemplar)){
            return false;
        }
        Ejemplar ejemplarAcomparar = (Ejemplar) obj;
        return (this.ubicacion.equals(ejemplarAcomparar.getUbicacion())&&
                this.libro.equals(ejemplarAcomparar.getLibro()))&&
                this.nroDeEdicion.equals(ejemplarAcomparar.getNroDeEdicion());

    }

    @Override
    public String toString() {
        return String.format("Ejemplar del Libro " + libro + " edición número " + nroDeEdicion + " ubicado en " + ubicacion) ;
    }
}
