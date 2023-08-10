package entidades;

public class Camping extends ExtraHotelero {

    private int capacidadMaxCarpas;
    private int cantBanios;
    private boolean resto;

    public Camping() {
        super();
        this.capacidadMaxCarpas = 0;
        this.cantBanios = 0;
        this.resto = false;
    }

    public Camping(int capacidadMaxCarpas, int cantBanios, boolean resto, boolean privado, int cantMts2,
            String nombre, String direccion, String localidad, String encargado) {
        super(privado, cantMts2, nombre, direccion, localidad, encargado);
        this.capacidadMaxCarpas = capacidadMaxCarpas;
        this.cantBanios = cantBanios;
        this.resto = resto;
    }

    public int getCapacidadMaxCarpas() {
        return capacidadMaxCarpas;
    }

    public void setCapacidadMaxCarpas(int capacidadMaxCarpas) {
        this.capacidadMaxCarpas = capacidadMaxCarpas;
    }

    public int getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(int cantBanios) {
        this.cantBanios = cantBanios;
    }

    public boolean isResto() {
        return resto;
    }

    public void setResto(boolean resto) {
        this.resto = resto;
    }

    /**
     * Le vamos a sumar a la Entrada el valor de los baños y si tiene resto.
     *
     * @return
     */
    @Override
    public int valorEntrada() {
        int plus = resto ? 250 : 0;
        return (super.valorEntrada() + plus + (50 * cantBanios));
    }

    @Override
    public String toString() {
        String rest = resto ? " - Tiene Restaurante" : " - No tiene Restaurante";
        return super.toString() + "\nCamping: Capacidad Max. Carpas: " + capacidadMaxCarpas + 
                " - Cant. Baños: " + cantBanios + rest;
    }

}
