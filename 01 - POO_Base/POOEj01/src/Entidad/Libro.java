package Entidad;

import java.util.Scanner;

public class Libro {
    Scanner leer = new Scanner(System.in).useDelimiter("\n"); 
    private int isbm;
    private String titulo;
    private String autor;
    private int cantidadPaginas;

   public Libro() {
        
   }
    
    public Libro(int isbm, String titulo, String autor, int cantidadPaginas) {
        this.isbm = isbm;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getISBN() {
        return isbm;
    }

    public void setISBN(int isbm) {
        this.isbm = isbm;
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
        return "Libro{" + "leer = " + leer + ", isbm = " + isbm + ", titulo = " + titulo + ", autor = " 
                + autor + ", cantidadPaginas = " + cantidadPaginas + '}';
    }
    
    public void llenarLibro() {
        System.out.println("Ingrese el Codigo ISBM del Libro");
        this.isbm = leer.nextInt();
        System.out.println("Ingrese el Titulo del Libro");
        this.titulo = leer.next();
        System.out.println("Ingrese el nombre del Autor del Libro");
        this.autor = leer.next();
        System.out.println("Ingrese la cantidad de paginas del Libro");
        this.cantidadPaginas = leer.nextInt();
    }
    
    public void mostrarLibro() {
        System.out.println("Codigo ISBM: " + this.isbm);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Cantidad de Paginas: " + this.cantidadPaginas);
    }
}
