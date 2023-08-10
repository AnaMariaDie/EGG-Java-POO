package main;

import servicios.ServicioPoliza;

public class POOGuia11Ex03 {

    public static void main(String[] args) {
        ServicioPoliza serv = new ServicioPoliza();
        // Metodos para llenado Random
//        serv.llenador();
//        serv.mostrarPoliza();
        
        // Metodos para ingreso Manual
        serv.ingresoPoliza();
        serv.mostrarPoliza();
    }

}
