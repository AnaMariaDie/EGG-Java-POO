package main;

import entidades.Alquiler;
import java.util.*;
import servicios.Puerto;

public class POOGuia12Ex01 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Alquiler> alquileres = new ArrayList();
        Puerto puerto = new Puerto();
        String resp;
        System.out.println(" *** Sistmea de Alquiler de Barcos *** ");
        do {
            System.out.println(" * Ingreso de Alquiler");
            Alquiler a1 = new Alquiler();
            alquileres.add(puerto.crearAlquiler(a1));
            System.out.println("Desea Alquilar otro Barco S/N");
            resp = leer.next();
        } while (resp.equalsIgnoreCase("S"));
        System.out.println("Saliendo del sistema . . . ");
        System.out.println("Barcos alquilados:");
        for (Alquiler alquiler : alquileres) {
            System.out.println(alquiler.toString());
        }
    }
}
