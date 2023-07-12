package entidades;

public class Cafetera {

    private int capacidadMaxima = 50;
    private int cantidadActual;

    // Constructores
    public Cafetera() {
    }

    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = cantidadActual;
    }

    // Getters y Setters
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    // Como tiene una capacidad maxima no vamos a poder utilizar esta opcion
//    public void setCapacidadMaxima(int capacidadMaxima) {
//        this.capacidadMaxima = capacidadMaxima;
//    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
}
