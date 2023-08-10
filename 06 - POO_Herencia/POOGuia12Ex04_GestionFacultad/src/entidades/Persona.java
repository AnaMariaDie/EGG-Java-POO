package entidades;

import java.util.Scanner;

/**
 * Clase Padre (Empleado y Estudiante)
 *
 * @author Ana
 */
public class Persona {

    protected String nameCompl;
    protected Integer dni;
    protected String estadoCivil;

    public Persona() {
    }

    public Persona(String nameCompl, Integer dni, String estadoCivil) {
        this.nameCompl = nameCompl;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
    }

    public String getNameCompl() {
        return nameCompl;
    }

    public Integer getDni() {
        return dni;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Persona: Nom. Completo:" + nameCompl + " DNI: " + dni + " Estado Civil: " + estadoCivil;
    }

    /**
     * Metodo Sobreescrito para ingresar Personas. Arranca por RegistrarDatos()
     *
     * @param leer
     * @return 
     */
    public Persona crearPersona(Scanner leer) {
        System.out.println("NOMBRE COMPLETO");
        String nomComp = leer.next();
        System.out.println("DNI");
        Integer dniI = leer.nextInt();
        System.out.println("ESTADO CIVIL");
        String estCivil = leer.next();
        Persona p1 = new Persona(nomComp, dniI, estCivil);
        return p1;
    }
}
