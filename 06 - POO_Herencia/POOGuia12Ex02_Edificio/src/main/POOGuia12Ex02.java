package main;

import entidades.*;
import java.util.*;

public class POOGuia12Ex02 {

    public static void main(String[] args) {
        ArrayList<Edificio> edificios = edificiosCreados();
        for (Edificio edificio : edificios) {
            if (edificio instanceof EdificioDeOficinas) {
                EdificioDeOficinas edo = (EdificioDeOficinas) edificio;
                System.out.println(edo.toString());
                System.out.println("La superficie es: " + edo.calcularSuperficie());
                System.out.println("El volumen es: " + edo.calcularVolumen());
                System.out.println("Cantidad de personas por piso: " + edo.cantidadPersonasPiso());
                System.out.println("Cantidad de personas Total en el Edificio: " + edo.cantidadPersonasEdificio()
                        + "\n");
            } else {
                if (edificio instanceof Polideportivo) {
                    Polideportivo poli = (Polideportivo) edificio;
                    System.out.println(poli.toString());
                    System.out.println("La superficie es: " + poli.calcularSuperficie());
                    System.out.println("El volumen es: " + poli.calcularVolumen() + "\n");
                } else {
                    System.out.println("Edificio mal instanciado");
                }
            }
        }
    }

    public static ArrayList<Edificio> edificiosCreados() {
        ArrayList<Edificio> aux = new ArrayList();
        Edificio e1 = new EdificioDeOficinas(15, 10, 5, 50, 80, 60);
        Edificio e2 = new EdificioDeOficinas(10, 5, 2, 40, 70, 50);
        Edificio e3 = new Polideportivo("Maria Teresa", true, 200, 80, 100);
        Edificio e4 = new Polideportivo("Pulmon Verde", false, 300, 0, 200);
        aux.add(e1);
        aux.add(e2);
        aux.add(e3);
        aux.add(e4);
        return aux;
    }
}
