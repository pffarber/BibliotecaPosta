package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Libro laBellaDurmiente = new Libro("La bella durmiente", 11111,"Grimm");
        Ejemplar ejLaBellaDurmiente1 = new Ejemplar(laBellaDurmiente, 1, "Infantil");
        Ejemplar ejLaBellaDurmiente2 = new Ejemplar(laBellaDurmiente, 2, "Infantil");
        Ejemplar ejLaBellaDurmiente3 = new Ejemplar(laBellaDurmiente, 3, "Infantil");
        Ejemplar ejLaBellaDurmiente4 = new Ejemplar(laBellaDurmiente, 4, "Infantil");
        List <Ejemplar> listaDeEjemplaresLaBellaDurmiente = new ArrayList<>();
        listaDeEjemplaresLaBellaDurmiente.add(ejLaBellaDurmiente1);
        listaDeEjemplaresLaBellaDurmiente.add(ejLaBellaDurmiente2);
        listaDeEjemplaresLaBellaDurmiente.add(ejLaBellaDurmiente3);
        listaDeEjemplaresLaBellaDurmiente.add(ejLaBellaDurmiente4);

        laBellaDurmiente.setListaDeEjemplares(listaDeEjemplaresLaBellaDurmiente);



        laBellaDurmiente.prestarEjemplar();
        laBellaDurmiente.tieneEjemplaresDisponibles();
        laBellaDurmiente.reingresarEjemplar(ejLaBellaDurmiente1);
        laBellaDurmiente.reingresarEjemplar(ejLaBellaDurmiente1);
        laBellaDurmiente.reingresarEjemplar(ejLaBellaDurmiente2);

        SocioComun socioComun = new SocioComun("Anna", "Frozen", 101);
        List<Ejemplar> listaDeEjemplaresRetiradosSocio1 = new ArrayList<>();
        //listaDeEjemplaresRetiradosSocio1.add(ejLaBellaDurmiente1);
        //listaDeEjemplaresRetiradosSocio1.add(ejLaBellaDurmiente2);
        //listaDeEjemplaresRetiradosSocio1.add(ejLaBellaDurmiente3);

        SocioVip socioVip1 = new SocioVip("Elsa", "Frozen",102, 100);
        List<Ejemplar> listaDeEjemplaresRetiradosSocioVip1 = new ArrayList<>();


        socioComun.setListaDeEjemplaresRetirados(listaDeEjemplaresRetiradosSocio1);
        socioComun.tieneCupoDisponible();

        socioVip1.setListaDeEjemplaresRetirados(listaDeEjemplaresRetiradosSocioVip1);

        socioVip1.tieneCupoDisponible();
        socioComun.tomarPrestadoUnEjemplar(ejLaBellaDurmiente4);





        // write your code here
    }
}
