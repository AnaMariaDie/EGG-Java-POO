package entidades;

/**
 * Clase padre Barco
 *
 * @author Ana
 */
public class Barco {

    protected String matricula;
    /* Eslora: La distancia medida paralelamente a la línea de flotación de referencia, entre dos planos 
    perpendiculares al plano central de la embarcación situados uno en la parte más a proa de la misma y el 
    otro en la parte más a popa.
     */
    protected int eslora; // en metros
    protected int anioFabricacion;

    public Barco() {
        this.matricula = "";
        this.eslora = 0;
        this.anioFabricacion = 0;
    }

    public Barco(String matricula, int eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * Metodo para calcular el modulo (metros de eslora * 10)
     *
     * @return
     */
    public int valorModulo() {
        return eslora * 10;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return "\nMatricula: " + matricula + " - Eslora: " + eslora + " - Año de Fabricacion: "
                + anioFabricacion;
    }

}
