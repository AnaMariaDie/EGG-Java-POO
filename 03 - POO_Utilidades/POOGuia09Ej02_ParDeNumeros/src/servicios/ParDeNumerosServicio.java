package servicios;

import entidades.ParDeNumeros;

public class ParDeNumerosServicio {

    ParDeNumeros pdn = new ParDeNumeros();

    public void mostrarValores() {
        System.out.println("El valor del numero 1 es: " + pdn.getNumero1());
        System.out.println("El valor del numero 2 es: " + pdn.getNumero2());
    }

    public double devolverMayor() {
        double mayor = Math.max(pdn.getNumero1(), pdn.getNumero2());
        return mayor;
    }

    public double devolverMenor() {
        double menor = Math.min(pdn.getNumero1(), pdn.getNumero2());
        return menor;
    }

    public double calcularPotencia(double mayorL, double menorL) {
        double potencia = Math.pow(mayorL, menorL);
        return potencia;
    }

    public double calcularRaiz(double menorL) {
        double absoluto = Math.abs(menorL);
        double raiz = Math.sqrt(absoluto);
        return raiz;
    }
}
