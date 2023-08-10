package servicios;

import entidades.Cadena;
import java.util.Scanner;

public class CadenaServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Cadena cadena = new Cadena();
        
    public CadenaServicio(String frase) {
        cadena.setFrase(frase);
    }
    // Metodo contador de vocales
    public void mostrarVocales() {
        int contador = 0;
        for (int i = 0; i < cadena.getLongitud(); i++) {
            String contarVocales = cadena.getFrase().substring(i, (i + 1));
            if (contarVocales.toLowerCase().equals("a") || contarVocales.toLowerCase().equals("e") || 
                    contarVocales.toLowerCase().equals("i") || contarVocales.toLowerCase().equals("o") || 
                    contarVocales.toLowerCase().equals("u")) {
                contador++;
            }
        }
        System.out.println("La cantidad de vocales en la frase ingresada fue de: " + contador);
    }

    // Metodo para invertir la frase
    public void invertirFrase() {
        String fraseInvertida = "";
        // Recorre de la longitud de la frase a 0 (inicio) y va restando (--)
        for (int i = (cadena.getLongitud() - 1); i >= 0; i--) {
            // Concatena en la fraseInvertida cada caracter de la frase original segun la iteracion de i
            fraseInvertida += cadena.getFrase().charAt(i);
        }
        System.out.println("La frase ingresada es: " + cadena.getFrase());
        System.out.println("La frase invertida es: " + fraseInvertida);
    }

    public void vecesRepetido(String letra) {
        int contador = 0;
        for (int i = 0; i < cadena.getLongitud(); i++) {
            if (cadena.getFrase().substring(i, (i + 1)).equals(letra)) {
                contador += 1;
            }
        }
        System.out.println("El caracter " + letra + " se ha repetido: " + contador + " veces");
    }

    public void compararLongitud(String frase) {
        if (cadena.getLongitud() == frase.length()) {
            System.out.println("La longitud de ambas frases es igual");
        } else {
            System.out.println("La longitud de las frases es diferente");
        }
    }

    public void unirFrases(String frase) {
        String union = cadena.getFrase().concat(" ").concat(frase);
        System.out.println("Union de Ambas frases " + union);
    }

    public void reemplazar(char letra) {
        String vacio = cadena.getFrase().replace('a', letra);
        System.out.println("La frase modificada es: " + vacio);
    }

    public boolean contiene(String letra) {
        int contador = 0;
        boolean contiene = true;
        for (int i = 0; i < cadena.getLongitud(); i++) {
            if (cadena.getFrase().substring(i, (i + 1)).equals(letra)) {
                contador += 1;
            }
        }
        if(contador == 0) {
            contiene = false;
        }
        return contiene;
    }

}
