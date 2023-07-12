package servicios;

import java.util.Scanner;
import entidades.Estudiante;
import java.util.Arrays;

public class EstudiantesService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Estudiante[] estudiantes = new Estudiante[8];
    
    public Estudiante[] crearEstudiantes() {
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Ingrese el nombre del Estudiante: " + (i + 1));
            String nombre = leer.next();
            System.out.println("Ingrese la nota final");
            double nota = leer.nextDouble();
            estudiantes[i] = new Estudiante(nombre, nota);
        }
        return estudiantes;
    }
    
    public String[] mayorPromedio() {
        double promedio = 0;
        double suma = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            suma += estudiantes[i].getNota();
        }
        promedio = suma / estudiantes.length;
        System.out.println("El promedio de notas de los Estudiantes es: " + promedio);
        String[] estMayorProm = new String[8];
        Arrays.fill(estMayorProm, "");
        for (int i = 0; i < estMayorProm.length; i++) {
            if (estudiantes[i].getNota() > promedio) {
                estMayorProm[i] = estudiantes[i].getNombre();
            } else {
                estMayorProm[i] = "";
            }
        }
        return estMayorProm;
    }
    public void mostrar(String[] estMayorProm) {
        System.out.println("Los estudiantes con nota mayor al promedio son:\n");
        for (int i = 0; i < estMayorProm.length; i++) {
            if (estMayorProm[i].equals("")) {
            } else {
                System.out.println(estMayorProm[i]);
            }
        }
    }
}
