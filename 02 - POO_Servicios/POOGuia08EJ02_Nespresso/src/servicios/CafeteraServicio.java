package servicios;

import entidades.Cafetera;
import java.util.Scanner;

public class CafeteraServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    // Metdo para crear cafeteras
    public Cafetera crearCafetera() {
        Cafetera cafetera = new Cafetera();
        return cafetera;
    }

    // Metodo llenar la cafetera
    public void llenarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(cafetera.getCapacidadMaxima());
        System.out.println("**************************************");
        System.out.println("La Cafetera ha sido llenada a su capacidad maxima " + cafetera.getCantidadActual());
    }

    // Metodo para servir tazas
    public void servirTaza(Cafetera cafetera, int size) {
        if (cafetera.getCantidadActual() > size) {
            cafetera.setCantidadActual(cafetera.getCantidadActual() - size);
            System.out.println("**************************************");
            System.out.println("Retire su cafe . . . Cuidado esta caliente");
        } else {
            if (cafetera.getCantidadActual() < size) {
                System.out.println("**************************************");
                System.out.println("Su taza no ha podido llenarse. La misma se encuentra al " 
                        + ((cafetera.getCantidadActual() * 100) / size) + " %");
                cafetera.setCantidadActual(0);
            } else {
                System.out.println("**************************************");
                System.out.println("Retire su cafe . . . Cuidado esta caliente");
                System.out.println("La cafetera se encuentra vacia");
                cafetera.setCantidadActual(0);
            }
        }
    }

    // Metodo agregar cafe
    public void agregarCafe(Cafetera cafetera) {
        System.out.println("**************************************");
        System.out.println("Indique la cantidad de cafe a adicionar");
        int cafe = leer.nextInt();
        int sobra = 0;
        if (cafetera.getCantidadActual() < cafetera.getCapacidadMaxima()) {
            if ((cafetera.getCantidadActual() + cafe) <= cafetera.getCapacidadMaxima()) {
                cafetera.setCantidadActual(cafetera.getCantidadActual() + cafe);
                System.out.println("**************************************");
                System.out.println("El cafe ha sido adicionado y la cafetera tienen " 
                        + cafetera.getCantidadActual());
            } else {
                if (cafetera.getCantidadActual() + cafe > cafetera.getCapacidadMaxima()) {
                    sobra = (cafetera.getCantidadActual() + cafe) - cafetera.getCapacidadMaxima();
                    System.out.println("**************************************");
                    System.out.println("La cafetera ha sido llenada pero sobro " + sobra + " del cafe a adicionar");
                    cafetera.setCantidadActual(cafetera.getCapacidadMaxima());
                }
            }
        } else {
            if (cafetera.getCantidadActual() == cafetera.getCapacidadMaxima()) {
                System.out.println("**************************************");
                System.out.println("La cafetera se encuentra llena por lo que no puede adicionarse nada más");
            }
        }
    }

    // Metodo para vaciar la cafetera
    public void vaciarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(0);
        System.out.println("**************************************");
        System.out.println("La cafetera ha sido vaciada");
    }
}
