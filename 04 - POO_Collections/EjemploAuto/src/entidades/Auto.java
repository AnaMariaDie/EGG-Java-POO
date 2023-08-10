package entidades;

public class Auto extends Vehiculo {

    private int cantPuertas;

    public Auto() {
    }

    public Auto(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
    
    public void prenderAire() {
    }

    @Override
    public String toString() {
        return super.toString() + " Auto{" + "cantPuertas = " + cantPuertas + '}';
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
    
}
