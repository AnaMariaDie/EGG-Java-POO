package Entidad;

import java.util.Scanner;

public class Puntos {

    private int coordenadaX1;
    private int coordenadaY1;
    private int coordenadaX2;
    private int coordenadaY2;

    public Puntos() {
    }

    public Puntos(int coordenadaX1, int coordenadaY1, int coordenadaX2, int coordenadaY2) {
        this.coordenadaX1 = coordenadaX1;
        this.coordenadaY1 = coordenadaY1;
        this.coordenadaX2 = coordenadaX2;
        this.coordenadaY2 = coordenadaY2;
    }

    public int getCoordenadaX1() {
        return coordenadaX1;
    }

    public void setCoordenadaX1(int coordenadaX1) {
        this.coordenadaX1 = coordenadaX1;
    }

    public int getCoordenadaY1() {
        return coordenadaY1;
    }

    public void setCoordenadaY1(int coordenadaY1) {
        this.coordenadaY1 = coordenadaY1;
    }

    public int getCoordenadaX2() {
        return coordenadaX2;
    }

    public void setCoordenadaX2(int coordenadaX2) {
        this.coordenadaX2 = coordenadaX2;
    }

    public int getCoordenadaY2() {
        return coordenadaY2;
    }

    public void setCoordenadaY2(int coordenadaY2) {
        this.coordenadaY2 = coordenadaY2;
    }

    @Override
    public String toString() {
        return "Puntos{" + "coordenadaX1 = " + coordenadaX1 + ", coordenadaY1 = " + coordenadaY1 
                + ", coordenadaX2 = " + coordenadaX2 + ", coordenadaY2 = " + coordenadaY2 + '}';
    }
    
    public void crearPuntos() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese una coordenada para el primer punto");
        this.coordenadaX1 = leer.nextInt();
        System.out.println("Ingrese otra coordenada para el primer punto");
        this.coordenadaY1 = leer.nextInt();
        System.out.println("Ingrese una coordenada para el segundo punto");
        this.coordenadaX2 = leer.nextInt();
        System.out.println("Ingrese otra coordenada para el segundo punto");
        this.coordenadaY2 = leer.nextInt();
    }
    
    public double calcularDistancia() {
        double distancia = Math.sqrt(Math.pow((this.coordenadaX2 - this.coordenadaX1),2) + 
                Math.pow((this.coordenadaY2 - this.coordenadaY1),2));
        return distancia; 
    }
}
