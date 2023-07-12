package entidades;

import java.util.Arrays;
import java.util.Scanner;

public class Curso {

    private String nombreCurso;
    private int cantidadHorasPorDia;
    private int cantidadDiasPorSemana;
    private String turno; // mañana o tarde
    private double precioPorHora;
    private String Alumnos[] = new String[5];
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Curso() {
    }

    public Curso(String nombreCurso, int cantidadHorasPorDia, int cantidadDiasPorSemana, String turno, double precioPorHora) {
        this.nombreCurso = nombreCurso;
        this.cantidadHorasPorDia = cantidadHorasPorDia;
        this.cantidadDiasPorSemana = cantidadDiasPorSemana;
        this.turno = turno;
        this.precioPorHora = precioPorHora;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCantidadHorasPorDia() {
        return cantidadHorasPorDia;
    }

    public void setCantidadHorasPorDia(int cantidadHorasPorDia) {
        this.cantidadHorasPorDia = cantidadHorasPorDia;
    }

    public int getCantidadDiasPorSemana() {
        return cantidadDiasPorSemana;
    }

    public void setCantidadDiasPorSemana(int cantidadDiasPorSemana) {
        this.cantidadDiasPorSemana = cantidadDiasPorSemana;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String[] getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(String[] Alumnos) {
        this.Alumnos = Alumnos;
    }

    public void setAlumnos() {
        cargarAlumnos();
    }

    private void cargarAlumnos() {
        for (int i = 0; i < getAlumnos().length; i++) {
            System.out.println("Ingrese el nombre del alumno");
            Alumnos[i] = leer.next();
        }
    }

    public void crearCurso(Curso curso) {
        System.out.println("Ingrese el nombre del Curso");
        this.nombreCurso = leer.next();
        System.out.println("Ingrese la cantidad de horas por dia");
        this.cantidadHorasPorDia = leer.nextInt();
        System.out.println("Ingrese la cantidad de dias por semana");
        this.cantidadDiasPorSemana = leer.nextInt();
        boolean error = true;
        String rta;
        do {
            System.out.println("Ingrese el turno: M (mañana) o T (tarde)");
            rta = leer.next();
            if (rta.equals("M")) {
                this.turno = "Mañana";
                error = false;
            } else {
                if (rta.equals("T")) {
                    this.turno = "Tarde";
                    error = false;
                } else {
                    System.out.println("Error M/T");
                }
            }
        } while (error);
        System.out.println("Ingrese el precio por hora");
        this.precioPorHora = leer.nextDouble();
        cargarAlumnos();
    }

    public void calcularGananciaSemana(Curso curso) {
        System.out.println("La ganancia por semana es de " + (curso.getCantidadDiasPorSemana()
           * curso.getCantidadHorasPorDia() * curso.getPrecioPorHora() * curso.getAlumnos().length));
    }

    @Override
    public String toString() {
        return "Curso{" + "nombreCurso=" + nombreCurso + ", cantidadHorasPorDia=" + cantidadHorasPorDia + 
                ", cantidadDiasPorSemana=" + cantidadDiasPorSemana + ", turno=" + turno + ", precioPorHora=" 
                + precioPorHora + ", Alumnos=" + Arrays.toString(Alumnos) + '}';
    }
}
