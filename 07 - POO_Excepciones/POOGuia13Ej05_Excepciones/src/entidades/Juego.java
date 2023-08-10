package entidades;

import java.util.*;

public class Juego {

    private Scanner leer;
    private Random r;
    private int nAdivinar;
    private int intentos;

    /**
     * La computadora debe generar un número aleatorio entre 1 y 500, el usuario
     * tiene que intentar adivinarlo.
     */
    public Juego() {
        r = new Random();
        leer = new Scanner(System.in).useDelimiter("\n");
        this.nAdivinar = r.nextInt(500);
        System.out.println("Numero a Adivinar " + this.nAdivinar);
    }

    /**
     * Cada vez que el usuario introduce un valor, la computadora debe decirle
     * al usuario si el número que tiene que adivinar es mayor o menor que el
     * que ha introducido el usuario.
     *
     * @param num
     */
    public void mayorMenor(int num) {
        if (num < nAdivinar) {
            System.out.println("El numero " + num + " es menor!!\nIntenta otra vez!!");
        } else {
            if (num > nAdivinar) {
                System.out.println("El numero " + num + " es mayor!!\nIntenta otra vez!!");
            }
        }
    }

    /**
     * Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el
     * número de veces que el usuario ha intentado adivinar el número. Si el
     * usuario introduce algo que no es un número, se debe controlar esa
     * excepción e indicarlo por pantalla. En este último caso también se debe
     * contar el carácter fallido como un intento.
     */
    public void iniciarJuego() {
        System.out.println("Arranca el Juego . . .\nYa hemos ocultado un numero, intenta adivinarlo");
        System.out.println("Te doy una pista, esta entre 1 y 500");
        int num = 0;
        do {
            try {
                num = leer.nextInt();
                mayorMenor(num);
                this.intentos++;
            } catch (InputMismatchException ime) {
                this.intentos++;
                System.out.println("Error! Tienes que ingresar un numero entero");
                leer.next(); // sin este next() queda en un bucle infinito imprimiendo el mensaje de error
            }
        } while (num != nAdivinar);
        System.out.println("Felicidades adivinaste el numero que era: " + nAdivinar + "\nLo conseguiste en "
                + this.intentos + " intentos");
    }
}
