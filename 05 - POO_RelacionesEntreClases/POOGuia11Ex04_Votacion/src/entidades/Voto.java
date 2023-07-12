package entidades;

import java.util.*;

public class Voto {
 
    private Alumno alumno; // alumno que vota
    private ArrayList<Alumno> alumnos; // alumnos a los que voto

    public Voto() {
    }

    public Voto(Alumno alumno, ArrayList<Alumno> alumnos) {
        this.alumno = alumno;
        this.alumnos = alumnos;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Voto{" + "Alumno: " + alumno + " Alumnos: a los que voto: " + alumnos + '}';
    }

}
