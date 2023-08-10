package main;

import entidades.Libro;
import servicios.LibroService;

public class POOGuia10Ex03 {

    public static void main(String[] args) {
        
        LibroService ls = new LibroService();
        // Para no tener que cargarlos a mano todas las veces
        Libro l1 = new Libro("Ojos de Angel", "Teresa Medeiros", 100, 0);
        Libro l2 = new Libro("Angeles y Demonios", "Dan Brown", 100, 0);
        Libro l3 = new Libro("Impulso", "Candance Camp", 100, 0);
        Libro l4 = new Libro("La Brujula Dorada", "Philip Pullman", 100, 0);
        Libro l5 = new Libro("Te Esperare", "Jane Lynn", 100, 0);
        ls.crearLibre(l1);
        ls.crearLibre(l2);
        ls.crearLibre(l3);
        ls.crearLibre(l4);
        ls.crearLibre(l5);
        // Ingresar Otro: Esperame de Elizabeth Naughton
        ls.menuLibreria();
    }
}
