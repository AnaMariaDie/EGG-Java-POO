package entidades;

public class Asiento {

    private String posicion;
    private String lugar;

    public Asiento() {
    }

    public Asiento(String posicion, String lugar) {
        this.posicion = posicion;
        this.lugar = lugar;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
        }

    @Override
    public String toString() {
        return " [" + posicion + " " + lugar + "] ";
    }

}
