package servicios;

import entidades.NIF;
import java.util.Scanner;

public class NIFServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearNIF(NIF nif, int posicion) {
        nif.setLetra(nif.getLetras()[posicion]);
    }

    public int calcularPosicion(NIF nif) {
        int posicion = (int) (nif.getnDNI() % 23);
        return posicion;
    }

    public void mostrarNIF(NIF nif) {
        String guion = "-";
        System.out.println("El NIF es: " + nif.getnDNI() + guion + nif.getLetra());
    }
}
