package entidades;

public class RevolverAgua {
/**
 * Numeros generados aleatoriamente de 1 a 6
 */
    private Integer posicionActual;
    private Integer posicionAgua;

    public RevolverAgua() {
    }

    public RevolverAgua(Integer posicionActual, Integer posicionAgua) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
    }

    public Integer getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Integer posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Integer getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(Integer posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    @Override
    public String toString() {
        return "RevolverAgua{" + "Posicion Actual = " + posicionActual + ", Posicion Agua = " + posicionAgua + '}';
    }
 
}
