package entidades;

public class ExtraHotelero extends Alojamiento {

    private boolean privado;
    private int cantMts2;
    private int precioEntrada = 100;

    public ExtraHotelero() {
        super();
        this.privado = false;
        this.cantMts2 = 0;
    }

    public ExtraHotelero(boolean privado, int cantMts2, String nombre, String direccion, String localidad, String encargado) {
        super(nombre, direccion, localidad, encargado);
        this.privado = privado;
        this.cantMts2 = cantMts2;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public int getCantMts2() {
        return cantMts2;
    }

    public void setCantMts2(int cantMts2) {
        this.cantMts2 = cantMts2;
    }

    /**
     * Metodo para la creacion de un valor de entrada por metro cuadrado y si es privado o no
     *
     * @return
     */
    public int valorEntrada() {
        int plus = privado ? 500 : 0;
        return (precioEntrada * cantMts2) + plus;
    }

    @Override
    public String toString() {
        String aux = privado ? "Es Privado" : "No es Privado";
        return "\nExtraHotelero: " + aux + " - Cant. Mts2: " + cantMts2;
    }
}
