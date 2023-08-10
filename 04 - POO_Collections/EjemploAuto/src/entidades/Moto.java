package entidades;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto() {
    }
    
    public Moto(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void ponerseCasco() {
    }

    @Override
    public String toString() {
        return super.toString() + " Moto{" + "cilindrada = " + cilindrada + '}';
    }
}
