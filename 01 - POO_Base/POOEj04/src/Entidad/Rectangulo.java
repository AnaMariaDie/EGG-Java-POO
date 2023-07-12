package Entidad;

import java.util.Scanner;

public class Rectangulo {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private int base;
    private int altura;

    public Rectangulo() {
    }

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "leer = " + leer + ", base = " + base + ", altura = " + altura + '}';
    }

    public void crearRectangulo() {
        System.out.println("Ingrese el valor de la Base");
        this.base = leer.nextInt();
        System.out.println("Ingrese el valor de la Altura");
        this.altura = leer.nextInt();
    }

    public int calcularSuperficie() {
        int superficie = this.base * this.altura;
        return superficie;
    }

    public int calcularPerimetro() {
        int perimetro = (this.base * this.altura) * 2;
        return perimetro;
    }

    public void dibujarRectangulo() {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                System.out.print(" * ");
            }
            System.out.println("");
        }
    }

}
