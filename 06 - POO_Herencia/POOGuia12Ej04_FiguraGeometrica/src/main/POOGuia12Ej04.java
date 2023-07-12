package main;

import entidades.*;

public class POOGuia12Ej04 {

    public static void main(String[] args) {
        
        Circulo circ = new Circulo(5);
        Rectangulo rec = new Rectangulo(4,6);
        
        double areacirc = circ.calcularArea();
        double perimetrocirc = circ.calcularPerimetro();
        System.out.println(circ.toString());
        System.out.println("El Area es: " + areacirc + "\nEl Perimetro es: " 
                + perimetrocirc);
        double arearec = rec.calcularArea();
        double perimetrorec = rec.calcularPerimetro();
        System.out.println(rec.toString());
        System.out.println("El Area es: " + arearec + "\nEl Perimetro es: " 
                + perimetrorec);
    }
}
