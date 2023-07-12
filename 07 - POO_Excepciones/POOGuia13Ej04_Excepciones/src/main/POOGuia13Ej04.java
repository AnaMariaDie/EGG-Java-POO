package main;

import java.util.InputMismatchException;
import java.util.Scanner;


public class POOGuia13Ej04 {
    /*
    Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede
    causar una excepción de tipo InputMismatchException, el método Integer.parseInt() si la cadena
    no puede convertirse a entero, arroja una NumberFormatException y además, al dividir un
    número por cero surge una ArithmeticException. Manipule todas las posibles excepciones
    utilizando bloques try/catch para las distintas excepciones
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        /**
         * Error InputMismatchException: cuando el elemento recibido no corresponde al tipo de dato esperado,
         * ejemplo: por Ingreso de letras esperando numeros o viceversa
         */
        System.out.println("Ingrese un numero");
        try {
            int num = leer.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Error InputMisMatch por: " + ime.getMessage());
            System.out.println(ime.getCause());
        } 
        leer.next();
        /**
         * Error NumberFormatExcetion: Se lanza para indicar que la aplicación ha intentado convertir una 
         * cadena a uno de los tipos numéricos, pero la cadena no tiene el formato apropiado, por ejemplo: 
         * intentar convertir letras a numeros (int, double, etc)
         */
        System.out.println("Ingrese una cadena");
        int numInput = 0;
        try{
           String input = leer.next(); 
            numInput = Integer.parseInt(input); 
        } catch (NumberFormatException nfe) {
            System.out.println("Error NumberFormat por: " + nfe.getMessage());
            System.out.println(nfe.getCause());
        }
        /**
         * Error por division por cero
         */
        try{
            int result = numInput / 0;
        } catch(ArithmeticException ae) {
            System.out.println("Error Division por Cero: " + ae.getMessage());
            System.out.println(ae.getCause());
        }
    }
}
