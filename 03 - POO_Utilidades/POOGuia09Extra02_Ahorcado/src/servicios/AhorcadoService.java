package servicios;

import entidades.Ahorcado;
import java.util.Scanner;

public class AhorcadoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Ahorcado juegoA = new Ahorcado();

    // Metodo crearJuego() crea el juego y completa atributos
    public Ahorcado crearJuego() {
        System.out.println("Ingrese una palabra");
        String palabra = leer.next();
        System.out.println("Indique la cantidad de jugadas máxima");
        juegoA.setJugadasMax(leer.nextInt());
        juegoA.setCantidadIntentos(juegoA.getJugadasMax());
        char[] palabraVectorChar = new char[palabra.length()];
        //vector aux=
        char[] auxVector = palabra.toCharArray();//automatico
        //cargo el vector de CHAR q estoy x enviar
        for (int i = 0; i < palabra.length(); i++) {
            palabraVectorChar[i] = auxVector[i];
        }
        juegoA.setPalabra(palabraVectorChar);
        return juegoA;
    }

    //Método longitud(): muestra la longitud de la palabra que se debe encontrar.
    private void longitud() {
        System.out.println("Longitud de la palabra: " + juegoA.getPalabra().length);
    }

    //Método buscar(letra): este método recibe una letra dada por el usuario
    //y busca si la letra ingresada es parte de la palabra o no.
    //También informará si la letra estaba o no.
    public void buscar(char letra) {
        char[] auxVector = juegoA.getPalabra();
        int contador = 0;
        int acierto = 0;
        for (int i = 0; i < juegoA.getPalabra().length; i++) {
            if (letra == auxVector[i]) {
                acierto += 1;
            } else {
                contador += 1;
            }
        }
        if (contador == juegoA.getPalabra().length) {
            System.out.println("Mensaje: La letra NO pertenece a la palabra!!");
        } else {
            if (acierto != 0) {
                System.out.println("Mensaje: La letra pertenece a la palabra!!");
            }
        }
    }
    // Metodo encontradas(letra): recibe una letra y muestra cuantas fueron encontradas y cuantas faltan
    // devuelve true si la letra estaba y false si no. Cada vez que no este se resta uno a las oportunidades
    public boolean encontradas(char letra) {
        boolean esta = false;
        int contador = 0;
        int acierto = 0;
        char[] auxVector = juegoA.getPalabra();
        for (int i = 0; i < juegoA.getPalabra().length; i++) {
            if (letra == auxVector[i]) {
                acierto += 1;
            } else {
                contador += 1;
            }
        }
        if (acierto != 0) {
            juegoA.setLetrasEncontradas(juegoA.getLetrasEncontradas() + acierto);
            esta = true;
            System.out.println("Numero de letras (entontradas, faltantes): ("
                    + juegoA.getLetrasEncontradas() + "," + (juegoA.getPalabra().length
                    - juegoA.getLetrasEncontradas()) + ")");
        } else {
            if (contador == juegoA.getPalabra().length) {
                esta = false;
                System.out.println("Numero de letras (entontradas, faltantes): ("
                        + juegoA.getLetrasEncontradas() + "," + (juegoA.getPalabra().length
                        - juegoA.getLetrasEncontradas()) + ")");
            }
        }
        return esta;
    }

    // Metodo intentos(): muestra cuantas oportunidades le quedan al jugador.
    public void intentos(boolean esta) {
        if (esta == false) {
            juegoA.setCantidadIntentos(juegoA.getCantidadIntentos() - 1);
            System.out.println("Numero de oportunidades restantes: " + juegoA.getCantidadIntentos());
        } else {
            if (esta == true) {
                System.out.println("Numero de oportunidades restantes: " + juegoA.getCantidadIntentos());
            }
        }
        if (juegoA.getCantidadIntentos() == 0) {
            System.out.println("Lo sentimos no hay mas oportunidades");
        }
    }

    // Metodo juego(): juego se encarga de llamar a todos los metodos e informa al usuario cuando descubra toda 
    // la palabra o se quede sin intentos. Este se llamara desde el main.
    public void juego() {
        boolean perdio = true;
        do {
            System.out.println("Ingrese una letra:");
            char letra = leer.next().charAt(0);
            longitud();
            buscar(letra);
            boolean esta = encontradas(letra);
            intentos(esta);
            if (juegoA.getCantidadIntentos() == 0) {
                perdio = false;
            }
            if (juegoA.getLetrasEncontradas() == juegoA.getPalabra().length) {
                System.out.println("Felicidades has descubierto la palabra");
                System.out.println(juegoA.getPalabra());
                perdio = false;
            } 
        } while (perdio != false);
    }
}
