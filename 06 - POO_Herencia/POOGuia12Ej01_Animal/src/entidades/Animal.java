package entidades;

public class Animal {

    protected String nombre;
    protected String alimento;
    protected Integer edad;
    protected String razaDelAnimal;

    public Animal(String nombre, String alimento, Integer edad, String razaDelAnimal) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.razaDelAnimal = razaDelAnimal;
    }
    
    public void alimentarse() {
        System.out.println("Me alimento de: ");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getRazaDelAnimal() {
        return razaDelAnimal;
    }

    public void setRazaDelAnimal(String razaDelAnimal) {
        this.razaDelAnimal = razaDelAnimal;
    }
    
}
