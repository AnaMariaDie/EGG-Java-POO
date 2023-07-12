package servicios;

import entidades.Jugador;
import java.util.ArrayList;

public class JugadorService {

    public ArrayList<Jugador> crearJugarores() {
        Jugador jugador1 = new Jugador("Luis", "Angel", "Delantero", 15);
        Jugador jugador2 = new Jugador("Pedro", "Garcia", "Defensa", 25);
        Jugador jugador3 = new Jugador("Luis", "Gonzalez", "Arquero", 12);
        Jugador jugador4 = new Jugador("Gaston", "Fulano", "Delantero", 5);
        Jugador jugador5 = new Jugador("Jose", "Mengano", "Defensa", 9);
        Jugador jugador6 = new Jugador("Juan", "Sultano", "Armador", 10);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        jugadores.add(jugador6);
        return jugadores;
    }
}
