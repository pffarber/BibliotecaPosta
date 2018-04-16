package com.company;

import java.util.ArrayList;
import java.util.List;

public class Socio {

    protected String nombre;
    protected String apellido;
    protected Integer nroDeIdentificacion;
    protected List<Ejemplar>listaDeEjemplaresRetirados;
    protected Integer cantidadMaxima;


    public Socio(String nombre, String apellido, Integer nroDeIdentificacion,Integer cantidadMaxima) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDeIdentificacion = nroDeIdentificacion;
        listaDeEjemplaresRetirados = new ArrayList<>();
        this.cantidadMaxima = cantidadMaxima;


    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNroDeIdentificacion() {
        return nroDeIdentificacion;
    }

    public void setNroDeIdentificacion(Integer nroDeIdentificacion) {
        this.nroDeIdentificacion = nroDeIdentificacion;
    }

    public List<Ejemplar> getListaDeEjemplaresRetirados() {
        return listaDeEjemplaresRetirados;
    }

    public void setListaDeEjemplaresRetirados(List<Ejemplar> listaDeEjemplaresRetirados) {
        this.listaDeEjemplaresRetirados = listaDeEjemplaresRetirados;
    }

    public boolean tieneCupoDisponible(){
        if (listaDeEjemplaresRetirados.size()<cantidadMaxima) {
                System.out.println("Tiene cupo para retirar " +
                        (cantidadMaxima - listaDeEjemplaresRetirados.size())+ " libros");
                return true;
            } else {
                System.out.println("No tiene más cupo");
                return false;
            }


        }

    public void tomarPrestadoUnEjemplar(Ejemplar ejemplar){
        listaDeEjemplaresRetirados.add(ejemplar);
        System.out.println("Está retirando el " + ejemplar);
    }

    public void devolverUnEjemplar (Ejemplar ejemplar){
        if(listaDeEjemplaresRetirados.contains(ejemplar)) {
            listaDeEjemplaresRetirados.add(ejemplar);
            System.out.println("Está devolviendo el " + ejemplar);
        } else{



        }

    }




    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Socio)){
            return false;
        }
        Socio socioAcomparar = (Socio) obj;
        return (this.nroDeIdentificacion.equals(socioAcomparar.getNroDeIdentificacion()));

    }

    @Override
    public String toString() {
        return String.format("Socio" + nombre + apellido + " con Número de Identificación " + nroDeIdentificacion ) ;
    }
}
