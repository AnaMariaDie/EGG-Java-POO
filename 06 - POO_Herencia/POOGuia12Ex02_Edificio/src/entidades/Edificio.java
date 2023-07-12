package entidades;
/**
 * Clase Abstracta ya que posee metodos abstractos. 
 * No la hacemos interface ya que necesitamos que sus atributos puedan ser modificables. 
 * Las Interfaces tienen atributos constantes(final)
 * @author Ana
 */
public abstract class Edificio {

    protected float ancho;
    protected float alto;
    protected float largo;

    public Edificio() {
        this.ancho = 0;
        this.alto = 0;
        this.largo = 0;
    }

    public Edificio(float ancho, float alto, float largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    /**
     * Metodo Abstracto que debe implementar las clases hijas
     * @return 
     */
    public abstract float calcularSuperficie();

    /**
     * Metodo Abstracto que debe implementar las clases hijas
     * @return 
     */
    public abstract float calcularVolumen();
    
    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Edificio:" + " Ancho: " + ancho + " Alto: " + alto + " Largo: " + largo;
    }
    
}
