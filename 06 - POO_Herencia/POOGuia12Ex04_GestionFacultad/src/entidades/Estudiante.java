package entidades;

import java.util.*;

/**
 * Clase Hija Persona
 *
 * @author Ana
 */
public class Estudiante extends Persona {

    private List<String> materia;

    public Estudiante() {
        this.materia = new ArrayList();
    }

    public Estudiante(String nameCompl, Integer dni, String estadoCivil, List<String> materia) {
        super(nameCompl, dni, estadoCivil);
        this.materia = materia;
    }

    public Estudiante(Persona p1, List<String> materia) {
        this.nameCompl = p1.getNameCompl();
        this.dni = p1.getDni();
        this.estadoCivil = p1.getEstadoCivil();
        this.materia = materia;
    }
    
    public List<String> getMateria() {
        return materia;
    }

    public void setMateria(List<String> materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEstudiante: Materias: " + materia.toString();
    }

// CREADO EN PERSONA CREAR PERSONA POR OPCION
    @Override
    public Persona crearPersona(Scanner leer) {
        super.crearPersona(leer);
        System.out.println("MATERIA");
        List<String> mate = new ArrayList();
        mate.add(leer.next());
       Persona est = new Estudiante(nameCompl, dni, estadoCivil, mate);
       return est;
    }
}
