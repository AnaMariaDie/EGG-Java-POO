package servicios;

import entidades.Electrodomestico;
import java.util.Scanner;

/**
 * Clase padre servicios
 *
 * @author Ana
 */
public class ElectrodomesticoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo que solo se usa en esta clase y es interno, por lo que puede ser
     * privado
     *
     * @param letra
     * @return
     */
    private char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        if (letra == 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E') {
            return letra;
        } else {
            return 'F';
        }
    }

    /**
     * Metodo que solo se usa en esta clase y es interno, por lo que puede ser
     * privado
     *
     * @param color
     * @return
     */
    private String comprobarColor(String color) {
        color = color.toUpperCase();
        if (color.equals("NEGRO") || color.equals("ROJO") || color.equals("AZUL") || color.equals("GRIS")) {
            return color;
        } else {
            return "BLANCO";
        }
    }

    /**
     * Metodo que Crea un Objeto de la clase padre solicitando los atributos
     * para inicializar y lo devuelve.
     *
     * @return
     */
    public Electrodomestico crearElectrodomestico() {
        double precio = 1000;
        System.out.println("Ingrese el Color (Debe ser Blanco / Negro / Rojo / Azul / Gris)");
        String color = comprobarColor(leer.next());
        System.out.println("Ingrese el tipo de consumo (A, B, C, D, E, F)");
        char consumoEnergetico = comprobarConsumoEnergetico(leer.next().charAt(0));
        System.out.println("Ingrese el peso");
        int peso = leer.nextInt();
        return new Electrodomestico(precio + 1000, color, consumoEnergetico, peso);
    }

    /**
     * Metodo que calcula y devuelve el precio final del producto en base a los
     * atributos y sus valores.
     *
     * @param e
     * @return
     */
    public double precioFinal(Electrodomestico e) {
        switch (e.getConsumoEnergetico()) {
            case 'A':
                e.setPrecio(e.getPrecio() + 1000);
                break;
            case 'B':
                e.setPrecio(e.getPrecio() + 800);
                break;
            case 'C':
                e.setPrecio(e.getPrecio() + 600);
                break;
            case 'D':
                e.setPrecio(e.getPrecio() + 500);
                break;
            case 'E':
                e.setPrecio(e.getPrecio() + 300);
                break;
            case 'F':
                e.setPrecio(e.getPrecio() + 100);
                break;
        }
        if (e.getPeso() >= 1 && e.getPeso() <= 19) {
            e.setPrecio(e.getPrecio() + 100);
        } else {
            if (e.getPeso() >= 20 && e.getPeso() <= 49) {
                e.setPrecio(e.getPrecio() + 500);
            } else {
                if (e.getPeso() >= 50 && e.getPeso() <= 79) {
                    e.setPrecio(e.getPrecio() + 800);
                } else {
                    if (e.getPeso() >= 80) {
                        e.setPrecio(e.getPrecio() + 1000);
                    }
                }
            }
        }
        return e.getPrecio();
    }
}
