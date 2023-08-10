package servicios;

import entidades.Libro;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LibroService {

    private Scanner leer;
    private HashSet<Libro> libros;

    public LibroService() {
        leer = new Scanner(System.in).useDelimiter("\n");
        libros = new HashSet<Libro>();
    }

    public void menuLibreria() {
        char respuesta = 'a';
        int opcion;
        do {
            System.out.println("***** Sistema de Biblioteca Ana *****");
            System.out.println("1. Crear Libros");
            System.out.println("2. Ingresar Nuevos Libros");
            System.out.println("3. Solicitar Prestamo de Libro");
            System.out.println("4. Realizar Devolucion de Libro");
            System.out.println("5. Mostrar Libros en Existencia");
            System.out.println("6. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    crearLibreria();
                    break;
                case 2:
                    ingresarNuevoLibro();
                    break;
                case 3:
                    System.out.println("Ingrese el Libro que desea en Prestamo");
                    prestamo(leer.next());
                    break;
                case 4:
                    System.out.println("Ingrese el Libro que desea en Devolver");
                    devolucion(leer.next());
                    break;
                case 5:
                    mostrarLibros();
                    break;
                case 6:
                    System.out.println("Desea Salir");
                    respuesta = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!(respuesta == 's'));
        System.out.println("Saliendo del sistema . . .");
    }
    
    public void crearLibreria() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese 5 Libros");
            System.out.println("Escriba el Titulo");
            String titulo = leer.next();
            System.out.println("Escriba el nombre del Autor");
            String autor = leer.next();
            System.out.println("Cuantos ejemplares posee");
            int cantEjemplares = leer.nextInt();
            System.out.println("Alguno de ellos se encuentra en prestamo?\nSi la respuesta es afirmativa "
                    + "ingrese el numero de ejemplares prestados y sino ingrese 0");
            int ejemPrestados = leer.nextInt();
            Libro libro = new Libro(titulo, autor, cantEjemplares, ejemPrestados);
            libros.add(libro);
        }
    }

    public void crearLibre(Libro libro) {
        libros.add(libro);
    }

    public void ingresarNuevoLibro() {
        boolean salir = true;
        do {
            System.out.println("---- Ingreso de Nuevo Ejemplar ----");
            System.out.println("Escriba el Titulo");
            String titulo = leer.next();
            System.out.println("Escriba el nombre del Autor");
            String autor = leer.next();
            System.out.println("Cuantos ejemplares posee");
            int cantEjemplares = leer.nextInt();
            System.out.println("Alguno de ellos se encuentra en prestamo?\nSi la respuesta es afirmativa "
                    + "ingrese el numero de ejemplares prestados y sino ingrese 0");
            int ejemPrestados = leer.nextInt();
            Libro libro = new Libro(titulo, autor, cantEjemplares, ejemPrestados);
            libros.add(libro);
            System.out.println("Libro Ingresado Exitosamente");
            System.out.println("Desea agregar otro libro? S/N");
            String re = leer.next();
            if (re.equalsIgnoreCase("N")) {
                salir = false;
            }
        } while (salir);
    }

    public boolean prestamo(String titulo) {
        boolean prestar = false;
        Libro encontrado = buscarLibro(titulo);
        if (encontrado == null) {
            System.out.println("El libro no se encontro");
            System.out.println("");
        } else {
            encontrado.setCantEjemplares(encontrado.getCantEjemplares() - 1);
            encontrado.setEjemPrestados(encontrado.getEjemPrestados() + 1);
            System.out.println("Datos del Libro:\n* Titulo: " + encontrado.getTitulo() + "\n* Autor:  " 
                    + encontrado.getAutor());
            System.out.println("");
            System.out.println("¡Prestamo Registrado Exitosamente!\nTiempo de Prestamo 7 días");
            System.out.println("");
        }
        return prestar;
    }

    private Libro buscarLibro(String titulo) {
        Libro encontrado = null;
        Libro a = null;
        Iterator<Libro> it = this.libros.iterator();
        while (it.hasNext() && encontrado == null) {
            a = it.next();
        if (a.getTitulo().equalsIgnoreCase(titulo)) {
            encontrado = a;
        }
        }        
        return encontrado;
    }

    public boolean devolucion(String titulo) {
        boolean devolver = false;
        Libro encontrado = buscarLibro(titulo);
        if (encontrado == null) {
            System.out.println("El libro no se encontro");
        } else {
            if(encontrado.getEjemPrestados() > 0) {
                encontrado.setEjemPrestados(encontrado.getEjemPrestados() - 1);
                encontrado.setCantEjemplares(encontrado.getCantEjemplares() + 1);
                System.out.println("Datos del Libro:\n* Titulo: " + encontrado.getTitulo() + "\n* Autor:  " 
                    + encontrado.getAutor());
                System.out.println("");
                System.out.println("¡Devolucion Exitosa!\n¡Muchas gracias!");
                System.out.println("");
            } else {
                System.out.println("Lo sentimos pero no tenemos prestado el libro. Tal vez te equivocaste "
                        + "de libreria");
            }
        }
        return devolver;
    }

    public void mostrarLibros() {
        System.out.println("**** Libros en Existencia ****");
        for (Iterator<Libro> it = libros.iterator(); it.hasNext();) {
            Libro next = it.next();
            System.out.println(next);
        }
        System.out.println("");
    }

}
