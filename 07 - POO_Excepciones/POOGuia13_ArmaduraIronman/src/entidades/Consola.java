package entidades;

/**
 * Consola informa por si misma o por Sintetizador(hablar al oido) informacion.
 *
 * @author Ana
 */
public class Consola {

    public boolean danio;

    public Consola() {
        this.danio = false;
    }
///// ???????
    public float informar(float intensidad, float tiempo) {
        return (intensidad * tiempo);
    }

}
