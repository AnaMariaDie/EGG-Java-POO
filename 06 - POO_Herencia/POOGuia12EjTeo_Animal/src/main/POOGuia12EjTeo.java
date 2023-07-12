package main;

import entidades.*;
import java.util.ArrayList;

public class POOGuia12EjTeo {

    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList();
        Animal a = new Animal();
        Animal b = new Perro();
        Animal c = new Gato();
        
        animales.add(a);
        animales.add(b);
        animales.add(c);
        
        for (Animal animal : animales) {
            System.out.println(animal.getClass()); 
                    animal.hacerRuido();
        }
        
//        FiguraGeometrica fg = new FiguraGeometrica();
        
    }
}
