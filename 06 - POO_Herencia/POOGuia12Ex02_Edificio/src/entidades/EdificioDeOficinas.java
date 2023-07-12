package entidades;

public class EdificioDeOficinas extends Edificio {

    private int numeroOficinas;
    private int cantPersonasOficina;
    private int numeroPisos;

    public EdificioDeOficinas(int numeroOficinas, int cantPersonasOficina, int numeroPisos, 
            float ancho, float alto, float largo) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.cantPersonasOficina = cantPersonasOficina;
        this.numeroPisos = numeroPisos;
    }

    /**
     * Implementacion de Metodo Abstracto para calculo de Superficie
     * @return 
     */
    @Override
    public float calcularSuperficie() {
        return (this.largo * this.ancho * numeroPisos);     
    }

    /**
     * Implementacion de Metodo Abstracto para calculo de Volumen
     * @return 
     */
    @Override
    public float calcularVolumen() {
        return (this.alto * this.largo * this.ancho * numeroPisos);
    }

    public int cantidadPersonasPiso() {
        return cantPersonasOficina * numeroOficinas;
    }
    
    public int cantidadPersonasEdificio() {
        return cantidadPersonasPiso() * numeroPisos;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }

    public int getCantPersonasOficina() {
        return cantPersonasOficina;
    }

    public void setCantPersonasOficina(int cantPersonasOficina) {
        this.cantPersonasOficina = cantPersonasOficina;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEdificio De Oficinas:" + " Cant. Oficinas: " + numeroOficinas + 
                " - Cant. Personas por Oficina: " + cantPersonasOficina + " - Cant. Pisos: " + numeroPisos;
    }
    
}
