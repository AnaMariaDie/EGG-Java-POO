package entidades;

public class Alumno {

    private String nombreCompleto;
    private Integer dni;
    private Integer cantidadVotos; // recibidos

    public Alumno() {
    }

    public Alumno(String nombreCompleto, Integer dni, Integer cantidadVotos) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.cantidadVotos = cantidadVotos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(Integer cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "Nombre Completo: " + nombreCompleto + " DNI:" + dni + " Cantidad Votos: "
                + cantidadVotos + "}\n";
    }
    
}
