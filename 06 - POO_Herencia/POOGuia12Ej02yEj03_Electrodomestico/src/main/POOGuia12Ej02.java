package main;

import entidades.*;
import java.util.*;
import servicios.*;

public class POOGuia12Ej02 {

    public static void main(String[] args) {
        // Ejercicio N° 2
        /*
        LavadoraService ls = new LavadoraService();
        Lavadora lavadora = ls.crearLavadora();
        double precioLav= ls.precioFinal(lavadora);
        System.out.println(lavadora.toString());
        System.out.println("El precio final de la Lavadora es: " + precioLav);
        TelevisorService ts = new TelevisorService();
        Televisor televisor = ts.crearTelevisor();
        double precioTv= ts.precioFinal(televisor);
        System.out.println(televisor.toString());
        System.out.println("El precio final del Televisor es: " + precioTv);
        */ 
        // Ejercicio N° 3
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList();
        LavadoraService ls = new LavadoraService();
        TelevisorService ts = new TelevisorService();
        boolean bucle = true;
        int opcion = 0;
        do {
            System.out.println(" *** Bienvenido a la Tienda de Electrodomesticos *** ");
            System.out.println("\n * Seleccione el producto que desea adquirir");
            System.out.println(" * 1. Lavadora\n * 2. Televisor\n * 3. Calcular Costos\n * 4. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n * * * Sumando una Lavadora a su carrito * * * ");
                    electrodomesticos.add(ls.crearLavadora());
                    System.out.println("Producto Agregado");
                    break;
                case 2:
                    System.out.println(" * * * Sumando un Televisor a su carrito * * * ");
                    electrodomesticos.add(ts.crearTelevisor());
                    System.out.println("Producto Agregado");
                    break;
                case 3:
                    System.out.println(" . . . Calculando costos . . . ");
                    double totalTelevisores = 0;
                    double totalLavadoras = 0;
                    for (Electrodomestico electrodomestico : electrodomesticos) {
                        if (electrodomestico instanceof Lavadora) {
                            Lavadora lava = (Lavadora) electrodomestico;
                            double precioLavadora = ls.precioFinal(lava);
                            totalLavadoras += precioLavadora;
                            System.out.println("El precio de la Lavadora es " + precioLavadora);
                        } else {
                            if (electrodomestico instanceof Televisor) {
                                Televisor tele = (Televisor) electrodomestico;
                                double precioTelevisor = ts.precioFinal(tele);
                                totalTelevisores += precioTelevisor;
                                System.out.println("El precio del Televisor es " + precioTelevisor);
                            }
                        }
                    }
                    System.out.println("El valor total de las Lavadoras es " + totalLavadoras);
                    System.out.println("El valor total de los Televisores es " + totalTelevisores);
                    System.out.println("El total en electrodomesticos es " + (totalLavadoras 
                            + totalTelevisores));
                    break;
                case 4:
                    System.out.println("Desea salir? S/N");
                    if (leer.next().equalsIgnoreCase("S")) {
                        System.out.println("Saliendo . . . ");
                        bucle = false;
                    }
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (bucle);
    }
}
