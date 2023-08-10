package main;
   
import entidades.*;
import java.util.*;

public class POOGuia11Ex04 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Simulador sim = new Simulador();
        System.out.println("Indique cuantos alumnos quiere crear");
        int cantidad = leer.nextInt();      
        ArrayList<Alumno> alumnos = sim.creadorAlumnos(cantidad);
        sim.mostrarAlumnos(alumnos); // Mostramos los alumnos creados
        ArrayList<Voto> votacion = sim.votacion(alumnos); // realizamos la votacion
        System.out.println(" *** Imprimimos las votaciones *** ");
        sim.imprimirVotaciones(votacion);
        sim.nombrarFacilitadores(votacion);
    }
}
