package entidades;

import interfaces.Volar;

/**
 * Repulsor con metodos descritos e implementados segun la informacion que
 * recibe
 *
 * @author Ana
 */
public class Repulsor extends Estado implements Volar {

    public Repulsor() {
        this.danio = false;
    }

    /**
     * Calculo de gasto de energia por accion de ataque.
     * @param intensidad
     * @param tiempo
     * @return 
     */
    public float atacar(float intensidad, float tiempo) {
        return (float) Math.pow((intensidad * tiempo), 3);
    }

    /**
     * Calculo de gasto de energia por accion de vuelo.
     * @param intensidad
     * @param tiempo
     * @return 
     */
    @Override
    public float volar(float intensidad, float tiempo) {
        return (float) Math.pow((intensidad * tiempo), 2);
    }

    /**
     * Calculo de gasto de energia por accion de vuelo evasivo.
     * @param energia
     * @return 
     */
    @Override
    public float volarEvasivo(float energia) {
        return (float) Math.pow(energia, 2);
    }
}
