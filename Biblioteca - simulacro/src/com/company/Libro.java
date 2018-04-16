package com.company;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private String titulo;
    private Integer codigoISBN;
    private String autor;
    private List<Ejemplar> listaDeEjemplares;

    public Libro(String titulo, Integer codigoISBN, String autor) {
        this.titulo = titulo;
        this.codigoISBN = codigoISBN;
        this.autor = autor;
        listaDeEjemplares = new ArrayList<>();
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(Integer codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Ejemplar> getListaDeEjemplares() {
        return listaDeEjemplares;
    }

    public void setListaDeEjemplares(List<Ejemplar> listaDeEjemplares) {
        this.listaDeEjemplares = listaDeEjemplares;
    }

    public void agregarNuevoEjemplar(Ejemplar ejemplar) {
        if (ejemplar != null) {
            listaDeEjemplares.add(ejemplar);
        }
    }

    public boolean tieneEjemplaresDisponibles() {
        if (listaDeEjemplares.size()>0) {
            System.out.println("Hay " + listaDeEjemplares.size() + " ejemplares");
            return true;
        } else {
            System.out.println("No hay ejemplares");
            return false;
        }


    }

    public Ejemplar prestarEjemplar() {
        if (tieneEjemplaresDisponibles()) {

            System.out.println("Se está prestando el ejemplar nro de edición " + +listaDeEjemplares.get(0).getNroDeEdicion() +
                    " del libro " + listaDeEjemplares.get(0).getLibro() + ", ubicado en sector " + listaDeEjemplares.get(0).getUbicacion());

            return listaDeEjemplares.remove(0);
        }
        System.out.println("No hay ejemplares");
        return null;
    }

    public void reingresarEjemplar(Ejemplar ejemplar){
        if(listaDeEjemplares.contains(ejemplar)){
            System.out.println("Ese ejemplar no se puede reingresar ya está que está en la lista");
        }
        else {


            listaDeEjemplares.add(ejemplar);
            System.out.println("Se está ingresando el " + ejemplar);

        }
    }


        @Override
        public boolean equals (Object obj){
            if (!(obj instanceof Libro)) {
                return false;
            }
            Libro libroAcomparar = (Libro) obj;
            return (this.codigoISBN.equals(libroAcomparar.getCodigoISBN()));

        }

        @Override
        public String toString () {
            return String.format(titulo);
        }
    }


