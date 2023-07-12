package entidades;

import java.util.Random;

/**
 * Comprobacion de Estado de Partes de Armadura
 * @author Ana
 */
public class Estado {
    
    private Random r = new Random();
    protected boolean danio;

    public boolean isDanio() {
        return danio;
    }

    public void setDanio(boolean danio) {
        this.danio = danio;
    }
    
    public boolean comprobarEstado() {
        return danio ? true : false;
    }
    
       /**
     * Metodo de Provabilidad de Daño por uso. Si es menos a 30 se daña sino
     * esta sano.
     *
     * @return
     */
    public boolean sufrirDanio() {
        int daniar = r.nextInt(100);
        return daniar <= 30 ? true : false;
    }

    /**
     * Metodo de Provabilidad de Reparar daño. Si es menos a 40 sigue dañado
     * sino se reparo.
     *
     * @return
     */
    public boolean repararDanio() {
        int reparar = r.nextInt(100);
        return reparar <= 40 ? true : false;
    }
}
