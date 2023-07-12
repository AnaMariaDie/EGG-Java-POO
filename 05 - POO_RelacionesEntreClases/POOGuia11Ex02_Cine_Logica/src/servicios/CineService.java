package servicios;

import entidades.*;
import java.util.*;

public class CineService {

    private Cartelera pelicula;

    /**
     * Simulacion de venta de entradas, asignacion de lugar y random de 1000 espectadores.
     * @param salaMatriz
     * @return 
     */
    public Cine simulacion(Asiento[][] salaMatriz) {
        Cine cine = new Cine();
        elegirPelicula(cine);
        ventaEntradasRandom(salaMatriz, cine);
        mostrarAsientos(salaMatriz);
        return cine;
    }

    /**
     * Venta de entradas con valores de cantidad de espectadores(edad y dinero) aleatorio
     * @param salaMatriz
     * @param cine 
     */
    public void ventaEntradasRandom(Asiento[][] salaMatriz, Cine cine) {
        Random r = new Random();
        boolean salaLlena = false;
        int contador = 0;
        do {
            for (int i = 0; i < r.nextInt(1000); i++) {
                Espectador e = new Espectador();
                e.setNombre(String.valueOf(i));
                e.setEdad(r.nextInt(100));
                cine.costoEntrada(e.getEdad());
                e.setDinero(r.nextInt(1000));
                if (e.getEdad() >= cine.getPeliculaReproduccion().getEdadMinima()
                        && e.getDinero() > cine.getPrecioEntrada()) {
                    asignarLugarRandom(salaMatriz);
                    contador++;
                }
                if (contador == 48) {
                    salaLlena = true;
                    System.out.println("Lo sentimos, la sala se ha llenado");
                }
            }
        } while (salaLlena);
    }

    /**
     * Asignacion de lugares de forma aleatoria
     * @param salaMatriz 
     */
    public void asignarLugarRandom(Asiento[][] salaMatriz) {
        Random r = new Random();
        int fila = r.nextInt(8);
        int columna = r.nextInt(6);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == fila && j == columna) {
                    if (salaMatriz[i][j].getLugar().equals(" ")) {
                        salaMatriz[i][j].setLugar("X");
                    } 
                }
            }
        }
    }

    /**
     * Ingreso de espectadores de un ArrayList creado, verificacion de atributos
     * @param salaMatriz
     * @param espectadores
     * @param cine 
     */
    public void ventaEntradas(Asiento[][] salaMatriz, ArrayList<Espectador> espectadores, Cine cine) {
        for (Espectador espectador : espectadores) {
            if (espectador.getEdad() < cine.getPeliculaReproduccion().getEdadMinima()) {
                System.out.println("Hola " + espectador.getNombre() + " Lo sentimos pero no tienes la "
                        + "edad suficiente para ver esta Pelicula\n");
            } else {
                int precio = cine.costoEntrada(espectador.getEdad());
                System.out.println("Hola " + espectador.getNombre() + " el costo de la entrada es de $ " + precio);
                if (espectador.getDinero() < precio) {
                    System.out.println("Lo sentimos pero no tienes dinero suficiente para comprar la entrada\n");
                } else {
                    asignarLugar(salaMatriz);
                    espectador.setDinero(espectador.getDinero() - precio);
                    System.out.println("Muchas gracias por su compra, disfrute la pelicula\n");
                }
            }
        }
    }

    /**
     * Asignacion de lugar aleatoria mostrando antes los lugares ya ocupados
     * @param salaMatriz 
     */
    public void asignarLugar(Asiento[][] salaMatriz) {
        mostrarAsientos(salaMatriz);
        Random r = new Random();
        int fila = r.nextInt(8);
        int columna = r.nextInt(6);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (salaMatriz[i][j].getLugar().equals(" ")) {
                        salaMatriz[i][j].setLugar("X");
                    } 
            }
        }
    }

    public void mostrarAsientos(Asiento[][] salaMatriz) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(salaMatriz[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * Eleccion de peliculas de un enum
     * @param cine 
     */
    public void elegirPelicula(Cine cine) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
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
        asignarPelicula(cine, opcion);
        System.out.println("");
    }

    /**
     * Asignacion de pelicula al cine (pensando en la modificacion segun estreno o multiples salas)
     * @param cine
     * @param opcion 
     */
    public void asignarPelicula(Cine cine, int opcion) {
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

}
