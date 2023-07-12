package tienda.entidades;

public class Producto {

    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer codigoFabricante;

    public Producto() {
    }

    public Producto(String nombre, Double precio, Integer codigoFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigoFabricante = codigoFabricante;
    }

    public Producto(Integer codigo, String nombre, Double precio, Integer codigoFabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigoFabricante = codigoFabricante;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(Integer codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    @Override
    public String toString() {
        return "Producto: Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Codigo Fabricante: " 
                + codigoFabricante;
    }
    
}
