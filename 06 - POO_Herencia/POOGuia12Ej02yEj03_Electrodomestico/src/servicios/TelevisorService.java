package servicios;

import entidades.*;
import java.util.Scanner;

/**
 * Clase hija de servicios
 *
 * @author Ana
 */
public class TelevisorService extends ElectrodomesticoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo que crea y devuelve un objeto de la clase hija llamando a la
     * creacion del objeto de la clase padre inicializando todos los atributos
     * (los de la clase padre y la clase hija)
     *
     * @return
     */
    public Televisor crearTelevisor() {
        Electrodomestico el = crearElectrodomestico();
        System.out.println("Indique la resolucion (en pulgadas) del Televisor");
        int resolucion = leer.nextInt();
        System.out.println("Tiene sintonizador? S/N");
        boolean sintonizador = false;
        if (leer.next().equalsIgnoreCase("S")) {
            sintonizador = true;
        }
        return new Televisor(el.getPrecio(), el.getColor(), el.getConsumoEnergetico(), el.getPeso(), resolucion, sintonizador);
    }

    /**
     * Metodo que calcula y devuelve el precio final del objeto hijo llamando al
     * metodo de la clase padre para que calcule el precio del padre y sume el
     * precio por los atributos de la clase hija.
     *
     * @param tele
     * @return
     */
    public double precioFinal(Televisor tele) {
        super.precioFinal(tele);
        if (tele.getResolucion() > 40) {
            tele.setPrecio(tele.getPrecio() * 1.30);
        }
        if (tele.isSintonizadorTDT()) {
            tele.setPrecio(tele.getPrecio() + 500);
        }
        return tele.getPrecio();
    }
}
