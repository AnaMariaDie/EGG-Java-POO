package Entidad;

import java.awt.geom.Area;

public class Rectangulo {
    private int lado1;
    private int lado2;

    public Rectangulo() {
    }

    public Rectangulo(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "lado1 = " + lado1 + ", lado2 = " + lado2 + '}';
    }
    
    public int calcularArea() {
        int area = this.lado1 * this.lado2;
        System.out.println(" Dibujemos este reactangulo con * para representar el áera");
        for (int i = 0; i < this.lado1; i++) {
            for (int j = 0; j < this.lado2; j++) {
              System.out.print(" * ");  
            }
            System.out.println("");
        }
        return area;
    }
    
}
