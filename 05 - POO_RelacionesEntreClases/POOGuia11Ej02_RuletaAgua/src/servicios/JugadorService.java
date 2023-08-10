package servicios;

import entidades.*;
import java.util.*;

public class JugadorService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Jugador> crearJugadores(ArrayList<Jugador> jugadores) {
        ArrayList<Jugador> aux = new ArrayList<>();
        System.out.println("Ingrese la cantidad de jugadores (La cantidad debe ser de 1 a 6)");
        int cant = leer.nextInt();
        do {
            if (cant < 1 || cant > 6) {
                System.out.println("Valor invalido! Intenta nuevamente");
                cant = leer.nextInt();
            }
        } while (cant < 1 || cant > 6);
        // Usando cant creamos los Jugadores.
        for (int i = 0; i < cant; i++) {
            System.out.println("Ingrese su nombre");
            String nombre = leer.next();
            Jugador j = new Jugador((i + 1), nombre, false);
            aux.add(j);
        }
        return aux;
    }

    /**
     * Recibe un Revolver y llama a los metodos mojar() y siguienteChorro().
     * Jugador se apunta y dispara, si el revolver tira el agua el jugador se
     * moja. (Mojado se vuelve true y disparo() devuelve false en lugar de true.
     *
     * @param r
     * @return
     */
    public boolean disparo(RevolverAgua r) {
        RevolverService rs = new RevolverService();
        RevolverAgua aux = r;
        rs.siguienteChorro(aux);
        return rs.mojar(aux);
    }
}
