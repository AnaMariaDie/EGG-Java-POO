package entidades;

public class Perro {

    private String nombre;
    private Raza raza;
    private int edad;
    private Tamano tamano;

    public Perro() {
    }

    public Perro(String nombre, Raza raza, int edad, Tamano tamano) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Perro{" + "Nombre = " + nombre + ", Raza = " + raza + ", Edad = " + edad + ", Tamano = " 
                + tamano + '}';
    }
 
}
