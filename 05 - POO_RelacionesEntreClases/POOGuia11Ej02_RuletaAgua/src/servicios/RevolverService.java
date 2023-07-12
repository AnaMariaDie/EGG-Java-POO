package servicios;

import entidades.RevolverAgua;

public class RevolverService {

    public RevolverAgua r = new RevolverAgua();

    public void llenarRevolver(RevolverAgua rAgua) {
        r = rAgua;
        r.setPosicionActual((int) Math.random() * 6 + 1);
        r.setPosicionAgua((int) Math.random() * 6 + 1);
    }

    public boolean mojar(RevolverAgua aux) {
        boolean mojado = false;
        r = aux;
        if (r.getPosicionActual() == r.getPosicionAgua()) {
            mojado = true;
        }
        return mojado;
    }

    public void siguienteChorro(RevolverAgua aux) {
        r = aux;
        if (r.getPosicionActual() == 6) {
            r.setPosicionActual(1);
        } else {
            r.setPosicionActual(r.getPosicionActual() + 1);
        }
    }
    
}
