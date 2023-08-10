package entidades;

public class Baraja {

    private Palo palo;
    private int numero;

    public Baraja() {
    }

    public Baraja(Palo palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return palo + " " + numero;
    }
    
}
