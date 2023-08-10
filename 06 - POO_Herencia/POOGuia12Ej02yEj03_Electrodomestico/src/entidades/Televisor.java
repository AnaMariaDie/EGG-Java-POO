package entidades;

/**
 * Clase hija, hereda de Electrodomestico
 *
 * @author Ana
 */
public class Televisor extends Electrodomestico {

    private int resolucion; // en pulgadas
    private boolean sintonizadorTDT;

    public Televisor() {
    }

    /**
     * Constructor con parametros, recibe un electrodomestico para inicialicar
     * los atributos a partir del Electrodomestico y el parametro del atributo
     * propio de la clase hija.
     *
     * @param e
     * @param resolucion
     * @param sintonizadorTDT
     */
    public Televisor(Electrodomestico e, int resolucion, boolean sintonizadorTDT) {
        this.precio = e.precio;
        this.color = e.color;
        this.consumoEnergetico = e.consumoEnergetico;
        this.peso = e.peso;
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
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
     * @param resolucion
     * @param sintonizadorTDT
     */
    public Televisor(double precio, String color, char consumoEnergetico, int peso, int resolucion, boolean sintonizadorTDT) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public String toString() {
        // Segun el booleano elegimos un String para mostrar
        String aux = "no tiene";
        if (this.sintonizadorTDT) {
            aux = "tiene";
        }
        return super.toString() + "Televisor: " + "Resolucion: " + resolucion + " Pulgadas Sintonizador TDT: " + aux;
    }

}
