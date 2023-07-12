package servicios;

import entidades.Raices;
import java.util.Scanner;

public class RaicesServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    // Crear Raices
    public Raices crearRaices() {
        Raices raices = new Raices();
        System.out.println("Ingrese un valor para a");
        raices.setA(leer.nextDouble());
        System.out.println("Ingrese un valor para b");
        raices.setB(leer.nextDouble());
        System.out.println("Ingrese un valor para c");
        raices.setC(leer.nextDouble());
        return raices;
    }
    // Calcular el Discriminante
    public double getDiscriminante(Raices raices) {
        double discriminante = (Math.pow(raices.getB(), 2) - (4 * (raices.getA()) * raices.getC()));
        return discriminante;
    }
    // Metodo si tienen raices o raiz
    public boolean tieneRaices(Raices raices) {
        return getDiscriminante(raices) >= 0;
    }

    public boolean tieneRaiz(Raices raices) {
        return getDiscriminante(raices) == 0;
    }
    //Obtener las raices o la raiz
    public void obtenerRaices(Raices raices) {
        if (this.tieneRaices(raices)) {
            double raiz1 = (-raices.getB()) + Math.sqrt((Math.pow(raices.getB(), 2) - (4 * (raices.getA()) * raices.getC()))) / (2 * raices.getA());
            System.out.println("La raiz uno es = " + raiz1);
            double raiz2 = (-raices.getB()) - Math.sqrt((Math.pow(raices.getB(), 2) - (4 * (raices.getA()) * raices.getC()))) / (2 * raices.getA());
            System.out.println("La raiz dos es = " + raiz2);
        }
    }

    public void obtenerRaiz(Raices raices) {
        if (this.tieneRaiz(raices)) {
            double raizUnica = (-raices.getB()) / (2 * raices.getA());
            System.out.println("La raiz unica es = " + raizUnica);
        }
    }
    // Realizar los calculos y mostrarlos
    public void calcular(Raices raices) {
        if (this.tieneRaiz(raices)) {
            this.obtenerRaiz(raices);
        } else {
            if (this.tieneRaices(raices)) {
                this.obtenerRaices(raices);
            } else {
                System.out.println("No hay solucion real para esta ecuación");
            }
        }
    }
}
