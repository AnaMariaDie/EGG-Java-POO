package servicios;

import entidades.Electrodomestico;
import entidades.Lavadora;
import java.util.Scanner;

/**
 * Clase hija de servicios
 *
 * @author Ana
 */
public class LavadoraService extends ElectrodomesticoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo que crea y devuelve un objeto de la clase hija llamando a la
     * creacion del objeto de la clase padre inicializando todos los atributos
     * (los de la clase padre y la clase hija)
     *
     * @return
     */
    public Lavadora crearLavadora() {
        Electrodomestico e = crearElectrodomestico();
        System.out.println("Ingrese la carga de la Lavadora");
        int carga = leer.nextInt();
        return new Lavadora(e.getPrecio(), e.getColor(), e.getConsumoEnergetico(), e.getPeso(), carga);
    }

    /**
     * Metodo que calcula y devuelve el precio final del objeto hijo llamando al
     * metodo de la clase padre para que calcule el precio del padre y sume el
     * precio por los atributos de la clase hija.
     *
     * @param lavadora
     * @return
     */
    public double precioFinal(Lavadora lavadora) {
        super.precioFinal(lavadora);
        if (lavadora.getCarga() > 30) {
            lavadora.setPrecio(lavadora.getPrecio() + 500);
        }
        return lavadora.getPrecio();
    }

}
