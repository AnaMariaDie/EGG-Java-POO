package entidades;

import java.util.Scanner;

/**
 * Clase Hija Empleado
 *
 * @author Ana
 */
public class Profesor extends Empleado {

    private String departamento;

    public Profesor() {
    }

    public Profesor(String nameCompl, Integer dni, String estadoCivil, Integer anioIngreso, Integer numDespacho, String departamento) {
        super(nameCompl, dni, estadoCivil, anioIngreso, numDespacho);
        this.departamento = departamento;
    }

    public Profesor(Empleado e1, String departamento) {
        this.nameCompl = e1.getNameCompl();
        this.dni = e1.getDni();
        this.estadoCivil = e1.getEstadoCivil();
        this.anioIngreso = e1.getAnioIngreso();
        this.numDespacho = e1.getNumDespacho();
        this.departamento = departamento;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + " Profesor: Departamento: " + departamento;
    }

// CREADO EN PERSONA CREAR PERSONA POR OPCION
    @Override
    public Persona crearPersona(Scanner leer) {
        super.crearPersona(leer);
        System.out.println("DEPARTAMENTO");
        String departamento = leer.next();
        Persona profe = new Profesor(nameCompl, dni, estadoCivil, anioIngreso, numDespacho, departamento);
        return profe;
    }
}
