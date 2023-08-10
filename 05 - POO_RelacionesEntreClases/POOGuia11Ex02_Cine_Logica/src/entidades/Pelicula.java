package entidades;

import java.util.ArrayList;

public class Pelicula {
 
    /**
     * Clase no utilizada
     */
    private String titulo;
    private String duracion;
    private String edadMinima;
    private String director;
    private ArrayList<Pelicula> peliculas = new ArrayList();
    
    public Pelicula() {
        Pelicula p1 = new Pelicula("Avatar","2 horas 42 minutos", "8 años", "James Cameron");
        Pelicula p2 = new Pelicula("Avatar: El Sentido del Agua","3 horas 12 minutos", "12 años", "James Cameron");
        Pelicula p3 = new Pelicula("Avengers: EndGame","3 horas 01 minuto", "12 años", "Joe Russo y Anthony Russo");
        Pelicula p4 = new Pelicula("Avengers: Infinity War","2 horas 36 minutos", "12 años", "Joe Russo y Anthony Russo");
        Pelicula p6 = new Pelicula("John Wick: Un Buen dia para Matar","1 hora 41 minutos", "18 años", "David Leitch y Chad Stahelski");
        Pelicula p5 = new Pelicula("John Wick: Pacto de Sangre","2 horas 03 minutos", "18 años", "Chad Stahelski");
        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);
        peliculas.add(p5);
        peliculas.add(p6);
    }

    public Pelicula(String titulo, String duracion, String edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getEdadMinima() {
        return edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "Titulo: " + titulo + ", Duracion: " + duracion + ", Edad Minima: " + edadMinima 
                + ", Director: " + director + '}';
    }
 
}
