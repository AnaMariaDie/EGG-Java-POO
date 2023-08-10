package entidad;

public class Producto {

    private Integer idProducto;
    private String nombreP;
    private Integer precio;

    public Producto(Integer idProducto, String nombreP, Integer precio) {
        this.idProducto = idProducto;
        this.nombreP = nombreP;
        this.precio = precio;
    }

    public Producto() {
    }

    public Integer getProducto() {
        return idProducto;
    }

    public void setProducto(Integer producto) {
        this.idProducto = producto;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "ID = " + idProducto + ", nombre del Producto = " + nombreP + ", precio = " + precio + '}';
    }
}
