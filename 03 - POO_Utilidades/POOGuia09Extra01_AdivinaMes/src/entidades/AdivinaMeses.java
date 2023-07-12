package entidades;

import java.util.Random;
import java.util.Scanner;

public class AdivinaMeses {

    private String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
        "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    private String mesSecreto = meses[9];
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public AdivinaMeses() {
        int puntero = new Random().nextInt(11 - 0 + 1) + 0;
        mesSecreto = meses[puntero];
        System.out.println("puntero = " + puntero);
        //  System.out.println("mes"+ Arrays.toString(mes));
        System.out.println("mesSecreto = " + mesSecreto);
    }

    public void adivineMesSecreto() {
        System.out.println("Adivine el mes secreto. Introduzca el nombre del mes en minusculas");
        String mesAdividar;
        boolean error = false;
        int intentos = 0;
        do {
            mesAdividar = leer.next().toLowerCase();
            if (mesAdividar.equals(mesSecreto)) {
                intentos += 1;
                System.out.println("Adivinaste!! en " + intentos + " intentos");
                
                break;
            } else {
                intentos += 1;
                if (intentos == 3) {
                    System.out.println("Supero la cantidad de intentos");
                    break;
                }
                System.out.println("No ha acertado. Intente adivinando intruduciendo otro mes.\n" 
                        + intentos + " intentos");
            }
        } while (!error);
    }
}
