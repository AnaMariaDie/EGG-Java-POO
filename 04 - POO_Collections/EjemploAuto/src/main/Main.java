package main;

import entidades.*;

public class Main {

    public static void main(String[] args) {
    
    Vehiculo m1 = new Moto(2150);
    Auto a1 = new Auto(2);
    m1.setMarca("Kawasaki");
    m1.setModelo("Ninja");
    System.out.println(m1);
    a1.setMarca("Ferrari");
    a1.setModelo("SF90 Stradale");
    System.out.println(a1);
    
    }
    
}
