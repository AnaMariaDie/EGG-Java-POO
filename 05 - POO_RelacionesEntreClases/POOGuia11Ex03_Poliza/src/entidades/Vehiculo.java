package entidades;

import enumeraciones.Tipo;

public class Vehiculo {

    private String marca;
    private String modelo;
    private Integer anio;
    private String numMotor;
    private String chasis;
    private String color;
    private Tipo tipo;
    private Cliente cliente;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo(String marca, String modelo, Integer anio, String numMotor, String chasis, String color, Tipo tipo, Cliente cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.numMotor = numMotor;
        this.chasis = chasis;
        this.color = color;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "\nVehiculo: " + "\nMarca: " + marca + ", Modelo: " + modelo + ", Año: " + anio + ", N° Motor: " 
                + numMotor + ", Chasis: " + chasis + ", Color: " + color + ", Tipo: " + tipo + ", " + cliente;
    }

}
