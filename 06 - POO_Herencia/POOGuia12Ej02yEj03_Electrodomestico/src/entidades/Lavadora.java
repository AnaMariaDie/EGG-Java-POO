package entidades;

/**
 * Clase hija, hereda de Electrodomestico
 *
 * @author Ana
 */
public class Lavadora extends Electrodomestico {

    private int carga;

    public Lavadora() {
    }

    /**
     * Constructor con parametros, recibe un electrodomestico para inicialicar
     * los atributos a partir del Electrodomestico y el parametro del atributo
     * propio de la clase hija.
     *
     * @param e
     * @param carga
     */
    public Lavadora(Electrodomestico e, int carga) {
        this.precio = e.precio;
        this.color = e.color;
        this.consumoEnergetico = e.consumoEnergetico;
        this.peso = e.peso;
        this.carga = carga;
    }

    /**
     * Constructor con los parametros que recibe los datos de la clase padre
     * para inicializarlos y los parametros pripios de esta clase. OJO QUE SI SE
     * CREA CON NETBEANS PRIMERO PIDE LOS PARAMETROS PROPIOS Y LUEGO LOS DE LA
     * CLASE PADRE
     *
     * @param precio
     * @param color
     * @param consumoEnergetico
     * @param peso
     * @param carga
     */
    public Lavadora(double precio, String color, char consumoEnergetico, int peso, int carga) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }


    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return super.toString() + "Lavadora: " + "Carga: " + carga + "kgs.";
    }

}
