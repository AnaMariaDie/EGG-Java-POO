package Entidad;

import java.util.Scanner;

public class Operacion {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private int num1;
    private int num2;

    public Operacion() {

    }

    public Operacion(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Operacion{" + "num1 = " + num1 + ", num2 = " + num2 + '}';
    }

    public void crearOperacion() {
        System.out.println("Ingrese el primer numero");
        this.num1 = leer.nextInt();
        System.out.println("Ingrese el segundo numero");
        this.num2 = leer.nextInt();
    }

    public int sumar() {
        int sumar = this.num1 + this.num2;
        return sumar;
    }

    public int restar() {
        int restar = this.num1 - this.num2;
        return restar;
    }

    public int multiplicar() {
        int multiplicar;
        if (num1 == 0 || num2 == 0) {
            System.out.println("El retorno es 0 ya que uno o ambos numeros son 0");
            return 0;
        } else {
            multiplicar = this.num1 * this.num2;
        }
        return multiplicar;
    }

    public int dividir() {
        int dividir;
        if (num1 == 0 || num2 == 0) {
            // Si realizamos la operacion tira error. Asignamos 0.   this.num1 / this.num2;
            System.out.println("El retorno es 0 ya que uno o ambos numeros son 0");
            return 0;
        } else {
            dividir = this.num1 / this.num2;
        }
        return dividir;
    }
}
