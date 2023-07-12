package Entidad;

import java.util.Scanner;

public class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Empleado() {
    }

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre = " + nombre + ", edad = " + edad + ", salario = " + salario + '}';
    }
    
    public void ingresarEmpleado() {
        System.out.println("Ingrese el nombre del Empleado");
        this.nombre = leer.next();
        System.out.println("Ingrese la edad del Empleado");
        this.edad = leer.nextInt();
        System.out.println("Ingrese el salario del Empleado");
        this.salario = leer.nextDouble();
        
    }
    
    public double calcularAumento() {
        if (this.edad > 30) {
            this.salario = (this.salario * 0.10) + this.salario;
        }
        if (this.edad < 30) {
                this.salario = (this.salario * 0.05) + this.salario;
            }
        return salario;
    }
}
