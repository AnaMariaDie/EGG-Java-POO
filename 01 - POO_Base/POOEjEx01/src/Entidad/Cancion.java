package Entidad;

import java.util.Scanner;

public class Cancion {
    private String titulo;
    private String autor;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Cancion() {
        this.titulo = "";
        this.autor = "";
    }
    
    public Cancion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo = " + titulo + ", autor = " + autor + '}';
    }
    
    public void ingresarCancion() {
        System.out.println("Ingrese el titulo de una cancion");
        this.titulo = leer.next();
        System.out.println("Ingrese el autor de la cancion");
        this.autor = leer.next();
    }
}
