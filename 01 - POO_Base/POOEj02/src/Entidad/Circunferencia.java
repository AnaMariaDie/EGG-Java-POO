package Entidad;

import java.util.Scanner;

public class Circunferencia {
    private double radio;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Circunferencia() {
        
    }
    
    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circunferencia{" + "radio = " + radio + '}';
    }
        
    public void crearCircunferencia() {
        System.out.println("Ingrese un valor para el radio");
        this.radio = leer.nextDouble();
    }
    
    public double area() {
        double area = Math.PI * Math.pow(radio, 2);
        return area;
    }
    
    public double perimetro() {
        double perimetro = 2 * Math.PI * radio;
        return perimetro;
    }
}
