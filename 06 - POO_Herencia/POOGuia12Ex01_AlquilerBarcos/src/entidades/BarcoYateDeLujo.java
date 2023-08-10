package entidades;

/**
 * @author Ana
 */
public class BarcoYateDeLujo extends BarcoConMotor {

    private int cantCamarotes;

    public BarcoYateDeLujo() {
    }

    public BarcoYateDeLujo(BarcoConMotor bcm, int cantCamarotes) {
        this.matricula = bcm.matricula;
        this.eslora = bcm.eslora;
        this.anioFabricacion = bcm.anioFabricacion;
        this.potenciaCV = bcm.potenciaCV;
        this.cantCamarotes = cantCamarotes;
    }

    public BarcoYateDeLujo(int cantCamarotes, String matricula, int eslora, int anioFabricacion,
            int potenciaCV) {
        super(matricula, eslora, anioFabricacion, potenciaCV);
        this.cantCamarotes = cantCamarotes;
    }

    /**
     * Sobreescribe metodo y suma los atributos propios
     *
     * @return
     */
    @Override
    public int valorModulo() {
        return super.valorModulo() + cantCamarotes;
    }

    public int getCantCamarotes() {
        return cantCamarotes;
    }

    public void setCantCamarotes(int cantCamarotes) {
        this.cantCamarotes = cantCamarotes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBarco Yate De Lujo: Cant. Camarotes: " + cantCamarotes;
    }

}
