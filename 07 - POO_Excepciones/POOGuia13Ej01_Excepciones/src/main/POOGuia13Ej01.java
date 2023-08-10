package main;

import entidades.Persona;
//import java.util.Scanner;
import servicios.PersonaServicio;

public class POOGuia13Ej01 {

    public static void main(String[] args) {
        PersonaServicio ps = new PersonaServicio();
        Persona p1 = null;
        ps.esMayorDeEdad(p1);
        
        /*
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaServicio ps = new PersonaServicio();
        System.out.println("Ingrese la cantidad de Personas a ingresar");
        int N = leer.nextInt();
        Persona[] personas = new Persona[N];
        int[] valoresIMC = new int[N];
        boolean[] esMayores = new boolean[N];
        double sobrepeso = 0;
        double pesoIdeal = 0;
        double pesoBajo = 0;
        double mayores = 0;
        double menores = 0;
        for (int i = 0; i < N; i++) {
            personas[i] = ps.crearPersona();
            valoresIMC[i] = ps.calcularIMC(personas[i]);
            switch (valoresIMC[i]) {
                case 1:
                    System.out.println("La persona tiene sobrepeso");
                    sobrepeso+=1;
                    break;
                case 0:
                    System.out.println("La persona tiene peso ideal");
                    pesoIdeal+=1;
                    break;
                default:
                    System.out.println("La persona tiene peso bajo");
                    pesoBajo+=1;
            }
            esMayores[i] = ps.esMayorDeEdad(personas[i]);
            if (esMayores[i]) {
                mayores+=1;
            } else {
                menores+=1;
            }
        }
        System.out.println("El promedio de personas con sobrepeso es: " + ((sobrepeso / N) * 100));
        System.out.println("El promedio de personas con peso ideal es: " + ((pesoIdeal / N) * 100));
        System.out.println("El promedio de personas con peso bajo es: " + ((pesoBajo / N) * 100));
        System.out.println("El promedio de personas mayores de edad es: " + (mayores / N));
        System.out.println("El promedio de personas menores de edad es: " + (menores / N));
        */
    }
}
