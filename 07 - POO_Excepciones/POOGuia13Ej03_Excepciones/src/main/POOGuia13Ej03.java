package main;

import entidades.DivisionNumero;
import java.util.Scanner;

public class POOGuia13Ej03 {
    /**
     * Defina una clase llamada DivisionNumero. En el método main utilice un
     * Scanner para leer dos números en forma de cadena. A continuación, utilice
     * el método parseInt() de la clase Integer, para convertir las cadenas al
     * tipo int y guardarlas en dos variables de tipo int.
     * 
     * Por ultimo realizar una división con los dos numeros y mostrar el resultado.
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("INGRESE 1");
        String n1 = sc.next();
        System.out.println("INGRESE 2");
        String n2 = sc.next();
        
        DivisionNumero dn = new DivisionNumero();
        dn.test(n1, n2);
    }
}
 