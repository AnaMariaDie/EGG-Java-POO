package servicios;

import entidades.*;
import java.util.*;

public class BarajaService {

    private ArrayList<Baraja> cartas;
    private ArrayList<Baraja> cartasMonton;
    private ArrayList<Baraja> cartasDar = new ArrayList<>();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public BarajaService() {
        cartas = new ArrayList<>();
        cartasMonton = new ArrayList<>();
        /*
        String[] palo = {"ESPADAS", "BASTOS", "OROS", "COPAS"};
        int[] numerador = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        for (int i = 0; i < 4; i++) {
            String auxPalo = palo[i];
            for (int j = 0; j < 10; j++) {
                int auxNum = numerador[j];
                cartas.add(new Baraja(auxPalo, auxNum));
            }
        }*/
        for (int i = 1; i <= 12; i++) {
            if (i != 8 && i != 9) {
                cartas.add(new Baraja(Palo.ESPADAS, i));
                cartas.add(new Baraja(Palo.BASTOS, i));
                cartas.add(new Baraja(Palo.OROS, i));
                cartas.add(new Baraja(Palo.COPAS, i));
            }
        }
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("***** Menu *****");
            System.out.println(" 1. Mezclar Cartas");
            System.out.println(" 2. Dar Cartas");
            System.out.println(" 3. Cartas Disponibles");
            System.out.println(" 4. Mostrar Cartas ya dadas");
            System.out.println(" 5. Mostrar Baraja");
            System.out.println(" 6. Salir");
            System.out.println("** Ingrese una opcion **");
            System.out.println("------------------------");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("La Baraja ha sido mezclada");
                    barajar();
                    break;
                case 2:
                    darCarta();
                    cartasDadas();
                    break;
                case 3:
                    System.out.println("Las cartas disponibles son: ");
                    cartasDisponibles();
                    break;
                case 4:
                    cartasMonton();
                    break;
                case 5:
                    mostrarBaraja();
                    break;
                case 6:
                    System.out.println("Usted esta saliendo . . . ");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 6);
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public void mostrarBaraja() {
        for (Baraja carta : cartas) {
            System.out.println(carta.toString());
        }
    }

    public Baraja siguienteCarta() {
        if (cartas.isEmpty()) {
            System.out.println("Ya no hay mas cartas");
            return null;
        }
        Baraja carta = cartas.remove(0);
        cartasMonton.add(carta);
        return carta;
    }

    public void cartasDisponibles() {
        System.out.println(cartas.size());
    }

    public ArrayList<Baraja> darCarta() {
        System.out.println("Ingrese la cantidad de cartas que desea");
        int cantidad = leer.nextInt();
        if (cantidad > cartas.size()) {
            System.out.println("No hay suficientes cartas");
            return cartasDar;
        }
        for (int i = 0; i < cantidad; i++) {
                Baraja carta = siguienteCarta();
                cartasDar.add(carta);
        }
        return cartasDar;
    }

    public void cartasDadas() {
        if (cartasDar.isEmpty()) {
            System.out.println("No hay cartas dadas");
        } else {
            System.out.println("Las cartas repartidas son: ");
            System.out.println(cartasDar.toString());
        }
    }

    public void cartasMonton() {
        if (cartasMonton.isEmpty()) {
            System.out.println("No hay cartas en el monton");
        } else {
            System.out.println("Las cartas que ya han salido son: ");
            System.out.println(cartasMonton.toString());
        }
    }

    @Override
    public String toString() {
        return cartas.toString();
    }

}
