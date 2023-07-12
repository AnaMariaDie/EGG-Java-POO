package entidades;

import interfaces.Volar;

/**
 * Propulsor con metodos descritos e implementados segun la informacion que
 * recibe
 *
 * @author Ana
 */
public class Propulsor extends Estado implements Volar {

    public Propulsor() {
        this.danio = false;
    }

    /**
     * Calculo de gasto de energia por accion de caminar.
     * @param intensidad
     * @param tiempo
     * @return 
     */
    public float caminar(float intensidad, float tiempo) {
        return (intensidad * tiempo);
    }

    /**
     * Calculo de gasto de energia por accion de correr.
     * @param intensidad
     * @param tiempo
     * @return 
     */
    public float correr(float intensidad, float tiempo) {
        return (float) Math.pow((intensidad * tiempo), 2);
    }

    /**
     * Calculo de gasto de energia por accion de propulcion. ????
     * @param intensidad
     * @param tiempo
     * @return 
     */
    public float propulsar(float intensidad, float tiempo) {
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
        return (float) Math.pow((intensidad * tiempo), 3);
    }

    /**
     * Calculo de gasto de energia por accion de vuelo evasivo.
     * @param energia
     * @return 
     */
    @Override
    public float volarEvasivo(float energia) {
        return (float) Math.pow(energia, 3);
    }
}
