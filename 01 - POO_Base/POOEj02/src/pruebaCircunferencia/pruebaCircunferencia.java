package pruebaCircunferencia;

import Entidad.Circunferencia;

public class pruebaCircunferencia {

    public static void main(String[] args) {
        
        Circunferencia circ1 = new Circunferencia();
        
        circ1.crearCircunferencia();
        System.out.println("El radio ingresado es: " + circ1.getRadio());
        System.out.println("El Area del circulo es: "+ circ1.area());
        System.out.println("El Perimetro del circulo es: " + circ1.perimetro());
    }

}
