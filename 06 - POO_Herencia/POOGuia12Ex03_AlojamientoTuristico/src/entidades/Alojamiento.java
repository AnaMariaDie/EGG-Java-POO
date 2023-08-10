package entidades;

public class Alojamiento {

    private String nombre;
    private String direccion;
    private String localidad;
    private String encargado;

    public Alojamiento() {
        this.nombre = "";
        this.direccion = "";
        this.localidad = "";
        this.encargado = "";
    }
    
    public Alojamiento(String nombre, String direccion, String localidad, String encargado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.encargado = encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "Alojamiento: Nombre: " + nombre + " - Direccion: " + direccion + " - Localidad:" + localidad 
                + " - Encargado: " + encargado;
    }
     
}
