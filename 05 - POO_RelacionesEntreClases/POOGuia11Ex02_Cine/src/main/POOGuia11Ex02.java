package main;

import servicios.CineService;

public class POOGuia11Ex02 {

    public static void main(String[] args) {
        // Funciona usando todo en servicio. Ahora hay que hacer la logica en Servicio y la informacion/objetos
        // guardarlos en el main asi como el menu
        CineService cs = new CineService();
        cs.menuCine();

    }
}
