package entidades;

public enum Cartelera {

    PELICULA1("Avatar - Director: James Cameron - Duracion: 2 horas 42 minutos", 8),
    PELICULA2("Avatar: El Sentido del Agua - Director: James Cameron - Duracion: 3 horas 12 minutos.", 12),
    PELICULA3("Avengers: EndGame - Directores: Joe Russo y Anthony Russo - Duracion: 3 horas 01 minuto.", 12),
    PELICULA4("Avengers: Infinity War - Directores: Joe Russo y Anthony Russo - Duracion: 2 horas 36 minutos.", 12),
    PELICULA5("John Wick: Un Buen dia para Matar - Directores: David Leitch y Chad Stahelski - Duracion: 1 hora 41 minutos.", 18),
    PELICULA6("John Wick: Pacto de Sangre - Director: Chad Stahelski - Duracion: 2 horas 03 minutos.", 18);
    
    private String datos;
    private int edadMinima;
 
    Cartelera(String datos, int edadMinima) {
        this.datos = datos;
        this.edadMinima = edadMinima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    @Override
    public String toString() {
        return "Cartelera{ " + datos + ", Edad Minima: " + edadMinima + '}';
    }
}
