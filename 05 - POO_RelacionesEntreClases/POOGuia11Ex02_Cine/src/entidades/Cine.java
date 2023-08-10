package entidades;

public class Cine {

    private Cartelera peliculaReproduccion;
    private int precioEntrada;
    private Asiento[][] salaMatriz = new Asiento[8][6];
    private Sala sala;
    
    public Cine() {
    }
    
    public Asiento[][] crearSala() {
       sala = new Sala();
       salaMatriz = sala.crearSalaMatriz();
       return salaMatriz;
    }
    
    public int costoEntrada(int edad) {
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

    public int getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
    
   
}
