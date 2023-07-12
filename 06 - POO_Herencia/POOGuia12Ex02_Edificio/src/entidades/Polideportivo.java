package entidades;

public class Polideportivo extends Edificio {

    private String nombre;
    private boolean tipoInstalacion; //abierto o techado

    public Polideportivo(String nombre, boolean tipoInstalacion, float ancho, float alto, float largo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }
    
    /**
     * Implementacion de Metodo Abstracto para calculo de Superficie
     * @return 
     */
    @Override
    public float calcularSuperficie() {
        return this.largo * this.ancho;
    }

    /**
     * Implementacion de Metodo Abstracto para calculo de Volumen.
     * Si no esta techado no calcula por el alto.
     * @return 
     */
    @Override
    public float calcularVolumen() {
        if (tipoInstalacion) {
            return (this.alto * this.largo * this.ancho);
        } else {
            return (this.largo * this.ancho);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(boolean tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    @Override
    public String toString() {
        String aux = tipoInstalacion ? " Techado" : " Abierto";
        return "Polideportivo: " + " Nombre: " + nombre + " Tipo Instalacion: " + aux;
    }
   
}
