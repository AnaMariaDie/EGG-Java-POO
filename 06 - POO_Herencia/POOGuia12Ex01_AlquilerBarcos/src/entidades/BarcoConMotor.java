package entidades;

/**
 * @author Ana
 */
public class BarcoConMotor extends Barco {

    protected int potenciaCV; // Caballos de Vapor

    public BarcoConMotor() {
    }

    public BarcoConMotor(String matricula, int eslora, int anioFabricacion, int potenciaCV) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaCV = potenciaCV;
    }

    public BarcoConMotor(Barco barco, int potenciaCV) {
        this.matricula = barco.matricula;
        this.eslora = barco.eslora;
        this.anioFabricacion = barco.anioFabricacion;
        this.potenciaCV = potenciaCV;
    }

    public BarcoConMotor(BarcoConMotor barcoCM) {
        this.matricula = barcoCM.matricula;
        this.eslora = barcoCM.eslora;
        this.anioFabricacion = barcoCM.anioFabricacion;
        this.potenciaCV = barcoCM.potenciaCV;
    }

    /**
     * Sobreescribe metodo y suma los atributos propios
     *
     * @return
     */
    @Override
    public int valorModulo() {
        return (super.valorModulo() + potenciaCV);
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBarco Con Motor: Potencia CV: " + potenciaCV;
    }

}
