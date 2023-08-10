package entidades;

public class Generador {

    private float cargaMaxima = Float.MAX_VALUE;
    private float cargaRestante;

    /**
     * El constructor inicializa la carga restante al valor de la carga maxima.
     */
    public Generador() {
        this.cargaRestante = cargaMaxima;
    }

    public float getCargaRestante() {
        return cargaRestante;
    }

    /**
     * Metodo que actualiza la carga de energia segun los consumos realizados
     * por los dispositivos.
     *
     * @param consumo
     */
    public void consumoEnergia(float consumo) {
        this.cargaRestante = cargaRestante - consumo;
    }

    /**
     * Metodo devuelve la energia restante en porcentaje.
     * @return 
     */
    public float estadoBateria() {
        return (this.cargaRestante * 100) / this.cargaMaxima;
    }
}
