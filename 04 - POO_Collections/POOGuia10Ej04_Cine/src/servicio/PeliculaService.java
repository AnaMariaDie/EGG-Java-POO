package servicio;

import entidades.Pelicula;
import java.util.*;
import utilidades.Comparadores;

public class PeliculaService {

    private Scanner leer;
    private ArrayList<Pelicula> pelis;

    public PeliculaService() {
        this.pelis = new ArrayList();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void menuPeliculas() {
        char respuesta = 'a';
        int opcion;
        do {
            System.out.println("***** Sistema de Filmoteca Ana *****");
            System.out.println("1. Ingresar Pelicula");
            System.out.println("2. Ver Peliculas");
            System.out.println("3. Ver Peliculas con Duración Mayor a 1 hora");
            System.out.println("4. Organizar Peliculas segun Duracion (Ascendente)");
            System.out.println("5. Organizar Peliculas segun Duracion (Descendente)");
            System.out.println("6. Organizar Peliculas segun Titulo (Alfabeticamente)");
            System.out.println("7. Organizar Peliculas segun Director (Alfabeticamente)");
            System.out.println("8. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    crearPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    mostrarPeliculasDuracion();
                    break;
                case 4:
                    mostrarPeliculasDuracionAscendente();
                    break;
                case 5:
                    mostrarPeliculasDuracionDescendente();
                    break;    
                case 6:
                    mostrarPeliculasTituloAscendente();
                    break;         
                case 7:
                    mostrarPeliculasDirectorAscendente();
                    break;             
                case 8:
                    System.out.println("Desea Salir");
                    respuesta = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!(respuesta == 's'));
        System.out.println("Saliendo del sistema . . .");
    }
    public void crearPelicula() {
        String continuar;
        boolean re = false;
        do {
            Pelicula peli = new Pelicula();
            System.out.println("Ingrese el Tilulo de la Pelicula");
            peli.setTitulo(leer.next());
            System.out.println("Ingrese el Nombre del Director");
            peli.setDirector(leer.next());
            System.out.println("Ingrese la duracion de la Pelicula (en minutos)");
            Double horas = duracion(leer.nextDouble());
            peli.setDuracion(horas);
            pelis.add(peli);
            System.out.println("Desea ingresar otra pelicula? S/N");
            continuar = leer.next();
            if (continuar.equalsIgnoreCase("S")) {
                re = true;
            } else {
                re = false;
            }
        } while (re);
    }
    
    private Double duracion(Double minutos) {
        Double hora = (double) Math.round(minutos / 60);
        Double minres = (minutos - (hora * 60)) * 0.01;
        Double duracion = hora + minres;
        return duracion;
    }
    
    public void mostrarPeliculas() {
        for (Pelicula peli : pelis) {
            System.out.println(peli.toString());
        }
        System.out.println("---------------------------------------------------");
    }
    
    public void mostrarPeliculasDuracion() {
        System.out.println("***** Peliculas con Duracion Mayor a Una Hora *****");
        for (Pelicula peli : pelis) {
            if (peli.getDuracion() > 1.0 ) {
                System.out.println(peli.toString());
            }
        }
        System.out.println("---------------------------------------------------");
    }
    
    public void mostrarPeliculasDuracionAscendente() {
        System.out.println("***** Peliculas Orden por Duracion Ascendente*****");
        pelis.sort(Comparadores.ordenarDuracionAscendente);
        mostrarPeliculas();
    }
    
    public void mostrarPeliculasDuracionDescendente() {
        System.out.println("***** Peliculas Orden por Duracion Descendente*****");
        pelis.sort(Comparadores.ordenarDuracionDescendente);
        mostrarPeliculas();
    }
    
     public void mostrarPeliculasTituloAscendente() {
        System.out.println("***** Peliculas Orden por Titulo Ascendente*****");
        pelis.sort(Comparadores.ordenarTituloAscendente);
        mostrarPeliculas();
    }
    
    public void mostrarPeliculasDirectorAscendente() {
        System.out.println("***** Peliculas Orden por Director Ascendente*****");
        pelis.sort(Comparadores.ordenarDirectorAscendente);
        mostrarPeliculas();
    }

}
