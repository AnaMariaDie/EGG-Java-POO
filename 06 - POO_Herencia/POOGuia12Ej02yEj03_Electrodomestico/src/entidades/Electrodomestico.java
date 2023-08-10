package entidades;

/**
 * Clase padre
 *
 * @author Ana
 */
public class Electrodomestico {

    protected double precio;
    protected String color;
    protected char consumoEnergetico;
    protected int peso;

    /**
     * Constructor vacio que debe inicializar los atributos
     */
    public Electrodomestico() {
        this.precio = 0;
        this.color = "";
        this.consumoEnergetico = 'x';
        this.peso = 0;
    }

    /**
     * Constructor con parametros
     *
     * @param precio
     * @param color
     * @param consumoEnergetico
     * @param peso
     */
    public Electrodomestico(double precio, String color, char consumoEnergetico, int peso) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Electrodomestico:" + "Precio: $ " + precio + " Color: " + color + " Consumo Energetico: "
                + consumoEnergetico + " Peso: " + peso + " kgs.";
    }

}
