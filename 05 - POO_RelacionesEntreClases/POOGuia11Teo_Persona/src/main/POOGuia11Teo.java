package main;

import entidades.*;
import servicios.*;

public class POOGuia11Teo {

    public static void main(String[] args) {
//        Dni dni = new Dni('A', 20578982);
//        Persona persona = new Persona("Juan", "Perez", dni);
//        System.out.println(persona);
//        System.out.println();

        JugadorService js = new JugadorService();
        Equipo equipo = new Equipo();
        equipo.setNombre("Team Gold");
        equipo.setJugadores(js.crearJugarores());   
        
        System.out.println(equipo);
    }
}
