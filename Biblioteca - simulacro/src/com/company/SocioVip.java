package com.company;

public class SocioVip extends Socio {
    private Integer valorCuotaMensual;

    public SocioVip(String nombre, String apellido, Integer nroDeIdentificacion, Integer valorCuotaMensual) {
        super(nombre, apellido, nroDeIdentificacion, 15);
        this.valorCuotaMensual = valorCuotaMensual;

    }

}

