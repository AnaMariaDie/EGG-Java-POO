package servicios;

import entidades.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CineService {

    private ArrayList<Espectador> espectadores = new ArrayList();
    private Asiento[][] salaMatriz = new Asiento[8][6];
    private Cartelera pelicula;
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private Cine cine = new Cine();

    public void menuCine() {
        crearEspectadores();
        asignarSala();
        int opcion = 0;
        do {
            System.out.println("***** Bienvenido a CinemaAnna *****");
            mostrarPeliculas();
            ventaEntradas();
            opcion++;
        } while (opcion >= espectadores.size());
        mostrarAsientos();
    }

    public void ventaEntradas() {
        for (Espectador espectador : espectadores) {
            if (espectador.getEdad() < pelicula.getEdadMinima()) {
                System.out.println("Hola " + espectador.getNombre() + " Lo sentimos pero no tienes la "
                        + "edad suficiente para ver esta Pelicula\n");
            } else {
                int precio = cine.costoEntrada(espectador.getEdad());
                System.out.println("Hola " + espectador.getNombre() + " el costo de la entrada es de $ " + precio);
                if (espectador.getDinero() < precio) {
                    System.out.println("Lo sentimos pero no tienes dinero suficiente para comprar la entrada\n");
                } else {
                    asignarLugar();
                    espectador.setDinero(espectador.getDinero() - precio);
                    System.out.println("Muchas gracias por su compra, disfrute la pelicula\n");
                }
            }
        }
    }

    public void asignarLugar() {
        mostrarAsientos();
        int fila = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        int columna = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == fila && j == columna) {
                    salaMatriz[i][j].setLugar("X");
                }
            }
        }
    }
    
    public void asignarSala() {
        this.salaMatriz = cine.crearSala();
    }

    public void mostrarAsientos() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(salaMatriz[i][j]);
            }
            System.out.println("");
        }

    }

    public void mostrarPeliculas() {
        int opcion = 0;
        do {
            System.out.println(" * Elija una Pelicula: ");
            System.out.println(" * Titulos Disponibles * ");
            System.out.println("1. " + pelicula.PELICULA1.toString());
            System.out.println("2. " + pelicula.PELICULA2.toString());
            System.out.println("3. " + pelicula.PELICULA3.toString());
            System.out.println("4. " + pelicula.PELICULA4.toString());
            System.out.println("5. " + pelicula.PELICULA5.toString());
            System.out.println("6. " + pelicula.PELICULA6.toString());
            opcion = leer.nextInt();
            if (opcion < 0 || opcion > 6) {
                System.out.println("La opcion ingresada es invalida vuelva a intentarlo");
                opcion = leer.nextInt();
            }
        } while (opcion < 0 || opcion > 6);
        asignarPelicula(opcion);
        System.out.println("");
    }

    public void asignarPelicula(int opcion) {
        switch (opcion) {
            case 1:
                pelicula = pelicula.PELICULA1;
                System.out.println("La Pelicula Elegida fue:\n" + pelicula.PELICULA1.toString());
                cine.setPeliculaReproduccion(pelicula.PELICULA1);
                break;
            case 2:
                pelicula = pelicula.PELICULA2;
                System.out.println("La Pelicula Elegida fue:\n" + pelicula.PELICULA2.toString());
                cine.setPeliculaReproduccion(pelicula.PELICULA2);
                break;
            case 3:
                pelicula = pelicula.PELICULA3;
                System.out.println("La Pelicula Elegida fue:\n" + pelicula.PELICULA3.toString());
                cine.setPeliculaReproduccion(pelicula.PELICULA3);
                break;
            case 4:
                pelicula = pelicula.PELICULA4;
                System.out.println("La Pelicula Elegida fue:\n" + pelicula.PELICULA4.toString());
                cine.setPeliculaReproduccion(pelicula.PELICULA4);
                break;
            case 5:
                pelicula = pelicula.PELICULA5;
                System.out.println("La Pelicula Elegida fue: " + pelicula.PELICULA5.toString());
                cine.setPeliculaReproduccion(pelicula.PELICULA5);
                break;
            case 6:
                pelicula = pelicula.PELICULA6;
                System.out.println("La Pelicula Elegida fue:\n" + pelicula.PELICULA6.toString());
                cine.setPeliculaReproduccion(pelicula.PELICULA6);
        }
    }

    public void crearEspectadores() {
        Espectador e1 = new Espectador("Marta", 35, 1000);
        Espectador e2 = new Espectador("Pedro", 51, 2000);
        Espectador e3 = new Espectador("Luis", 28, 1210);
        Espectador e4 = new Espectador("Sandra", 15, 100);
        Espectador e5 = new Espectador("Jose", 25, 2100);
        Espectador e6 = new Espectador("Gabriela", 42, 4500);
        espectadores.add(e1);
        espectadores.add(e2);
        espectadores.add(e3);
        espectadores.add(e4);
        espectadores.add(e5);
        espectadores.add(e6);
    }

}
