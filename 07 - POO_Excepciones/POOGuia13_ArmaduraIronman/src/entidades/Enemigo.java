package entidades;

public class Enemigo {

    private int distancia;
    private int resistencia;
    private boolean hostil;

    public Enemigo(int distancia, int resistencia, boolean hostil) {
        this.distancia = distancia;
        this.resistencia = resistencia;
        this.hostil = hostil;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }
 
}
