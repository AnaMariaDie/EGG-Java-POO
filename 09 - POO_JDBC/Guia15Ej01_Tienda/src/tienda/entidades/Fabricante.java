package tienda.entidades;

public class Fabricante {

    private Integer codigo;
    private String nombre;

    public Fabricante() {
    }

    public Fabricante(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Fabricante: Codigo: " + codigo + ", Nombre: " + nombre;
    }

}
