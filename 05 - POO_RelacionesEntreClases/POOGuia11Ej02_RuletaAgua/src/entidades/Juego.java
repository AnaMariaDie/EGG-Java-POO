package entidades;

import java.util.ArrayList;
import servicios.*;

public class Juego {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private RevolverAgua rAgua = new RevolverAgua();
    private RevolverService rs = new RevolverService();
    private JugadorService js = new JugadorService();

    public Juego() {
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public RevolverAgua getrAgua() {
        return rAgua;
    }

    public void setrAgua(RevolverAgua rAgua) {
        this.rAgua = rAgua;
    }

    public void mostrarJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    public void llenarJuego() {
        rs.llenarRevolver(rAgua);
        this.jugadores = js.crearJugadores(jugadores);
    }

    public void ronda() {
        boolean turno = true;
        boolean shoot = false;
        System.out.println("Se inicia el Juego");
        do {
            for (Jugador jugador : jugadores) {
                System.out.println("Turno del Jugador " + jugador.getId() + " " + jugador.getNombre());
                shoot = js.disparo(rAgua);
                if (shoot == false) {
                    System.out.println("Jugador a Salvo, siguiente ronda");
                } else {
                    if (shoot == true) {
                        jugador.setMojado(shoot);
                    System.out.println("Fin del Juego");
                    System.out.println(toString() + " Jugador que perdio: " + jugador.toString());
                    turno = false;
                    break;
                }
                }
            }
        } while (turno);
    }

    @Override
    public String toString() {
        return "Juego {" + "Revolver: Posicion Actual " + rAgua.getPosicionActual() + " Posicion Agua " 
                + rAgua.getPosicionAgua() + '}';
    }
    
}
