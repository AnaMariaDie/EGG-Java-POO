package TestLibro;

import Entidad.Libro;
import java.util.Scanner;

public class TestLibro {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Libro con Constructor");
        Libro libro1 = new Libro(943785, "El Princitipo", "Antoine De Saint Exupery", 120);
        libro1.mostrarLibro();
        System.out.println("");

        System.out.println("Libro con Constructor vacio");
        Libro libro2 = new Libro();
        libro2.setISBN(458123);
        libro2.setTitulo("Mujercitas");
        libro2.setAutor("Louisa May Alcott");
        libro2.setCantidadPaginas(688);
        libro2.mostrarLibro();
        System.out.println("");

        Libro libro3 = new Libro();
        libro3.llenarLibro();
        libro3.mostrarLibro();
    }
}
