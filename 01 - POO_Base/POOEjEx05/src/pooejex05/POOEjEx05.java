package pooejex05;

import Entidad.Empleado;
import java.util.Scanner;

public class POOEjEx05 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        Empleado empleado1 = new Empleado("Pepe Grillo", 25, 35000);
        Empleado empleado2 = new Empleado("Rosa Garcia", 35, 45000);
        
        System.out.println(empleado1.toString());
        System.out.println(empleado2.toString());
        System.out.println("------------------------------------------------------------");
        // Calculando Aumentos
        empleado1.calcularAumento();
        empleado2.calcularAumento();
        System.out.println(empleado1.toString());
        System.out.println(empleado2.toString());
    }
}
