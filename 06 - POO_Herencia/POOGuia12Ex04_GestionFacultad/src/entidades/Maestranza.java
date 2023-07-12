package entidades;

import java.util.Scanner;

/**
 * Clase Hija Empleado
 *
 * @author Ana
 */
public class Maestranza extends Empleado {

    private String section;

    public Maestranza() {
    }

    public Maestranza(String nameCompl, Integer dni, String estadoCivil, Integer anioIngreso,
            Integer numDespacho, String section) {
        super(nameCompl, dni, estadoCivil, anioIngreso, numDespacho);
        this.section = section;
    }

    public Maestranza(Empleado e1, String section) {
        this.nameCompl = e1.getNameCompl();
        this.dni = e1.getDni();
        this.estadoCivil = e1.getEstadoCivil();
        this.anioIngreso = e1.getAnioIngreso();
        this.numDespacho = e1.getNumDespacho();
        this.section = section;
    }
    
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return super.toString() + " Maestranza: Section: " + section;
    }

// CREADO EN PERSONA CREAR PERSONA POR OPCION
    @Override
    public Persona crearPersona(Scanner leer) {
        super.crearPersona(leer);
        System.out.println("SECCION");
        String section = leer.next();
        Persona maes = new Maestranza(nameCompl, dni, estadoCivil, anioIngreso, numDespacho, section);
        return maes;
    } 
}
