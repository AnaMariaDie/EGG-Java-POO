package entidades;

public class Cine {

    private Cartelera peliculaReproduccion;
    private Integer precioEntrada;
    
    public Cine() {
        Asiento[][] salaMatriz = new Asiento[8][6];
    }
    
    public Asiento[][] crearSala() {
       Sala sala = new Sala();
       Asiento[][] salaMatriz = sala.crearSalaMatriz();
       return salaMatriz;
    }
    
    /**
     * Posibilidad de setear un costo de entrada segun la edad del espectador
     * @param edad
     * @return 
     */
    public Integer costoEntrada(Integer edad) {
        if(edad < 12) {
            precioEntrada = 100;
        } else {
            precioEntrada = 150;
        }
        return precioEntrada;
    }
    
    public Cartelera getPeliculaReproduccion() {
        return peliculaReproduccion;
    }

    public void setPeliculaReproduccion(Cartelera peliculaReproduccion) {
        this.peliculaReproduccion = peliculaReproduccion;
    }

    public Integer getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Integer precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
    
}
