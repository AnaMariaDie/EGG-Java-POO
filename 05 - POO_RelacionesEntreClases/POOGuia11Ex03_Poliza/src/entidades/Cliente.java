package entidades;

public class Cliente {

    private String nombreApellido;
    private Integer dni;
    private String mail;
    private String domicilio;
    private Integer telefono;

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Cliente(String nombreApellido, Integer dni, String mail, String domicilio, Integer telefono) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.mail = mail;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nCliente: " + "\nNombre y Apellido: " + nombreApellido + ", DNI: " + dni + ", E-mail: " + mail 
                + ", Domicilio:" + domicilio + ", Telefono: " + telefono;
    }

}
