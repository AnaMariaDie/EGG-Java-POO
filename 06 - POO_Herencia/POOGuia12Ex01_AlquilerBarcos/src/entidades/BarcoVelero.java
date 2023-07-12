package entidades;

/**
 * @author Ana
 */
public class BarcoVelero extends Barco {

    private int cantMastiles;

    public BarcoVelero() {
    }

    public BarcoVelero(String matricula, int eslora, int anioFabricacion, int cantMastiles) {
        super(matricula, eslora, anioFabricacion);
        this.cantMastiles = cantMastiles;
    }

    public BarcoVelero(Barco barco, int cantMastiles) {
        this.matricula = barco.matricula;
        this.eslora = barco.eslora;
        this.anioFabricacion = barco.anioFabricacion;
        this.cantMastiles = cantMastiles;
    }

    /**
     * Sobreescribe metodo y suma los atributos propios
     *
     * @return
     */
    @Override
    public int valorModulo() {
        return (super.valorModulo() + cantMastiles);
    }

    public int getCantMastiles() {
        return cantMastiles;
    }

    public void setCantMastiles(int cantMastiles) {
        this.cantMastiles = cantMastiles;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBarco Velero: Cant. Mastiles: " + cantMastiles;
    }

}
