package entidades;

import java.util.Scanner;

/**
 * Clase Hija Persona y Padre de Maestranza y Profesor
 *
 * @author Ana
 */
public class Empleado extends Persona {

    protected Integer anioIngreso;
    protected Integer numDespacho;

    public Empleado() {
    }

    public Empleado(String nameCompl, Integer dni, String estadoCivil, Integer anioIngreso,
            Integer numDespacho) {
        super(nameCompl, dni, estadoCivil);
        this.anioIngreso = anioIngreso;
        this.numDespacho = numDespacho;
    }

    public Empleado(Persona p1, Integer anioIngreso, Integer numDespacho) {
        this.nameCompl = p1.getNameCompl();
        this.dni = p1.getDni();
        this.estadoCivil = p1.getEstadoCivil();
        this.anioIngreso = anioIngreso;
        this.numDespacho = numDespacho;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }
    
    public Integer getNumDespacho() {
        return numDespacho;
    }

    public void setNumDespacho(Integer numDespacho) {
        this.numDespacho = numDespacho;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmpleado: Año Ingreso: " + anioIngreso + " N° Despacho: " + numDespacho;
    }

// CREADO EN PERSONA CREAR PERSONA POR OPCION
    @Override
    public Persona crearPersona(Scanner leer) {
        super.crearPersona(leer);
        System.out.println("AÑO DE INGRESO");
        Integer anioIngreso = leer.nextInt();
        System.out.println("NUMERO DE DESPACHO");
        Integer numDespacho = leer.nextInt();
        Persona empl = new Empleado(nameCompl, dni, estadoCivil, anioIngreso, numDespacho);
        return empl;
    }
}
