package servicios;

import entidades.Alumno;
import java.text.DecimalFormat;
import java.util.*;

public class AlumnoService {

    private Scanner leer;
    private ArrayList<Alumno> alumnos;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public AlumnoService() {
        leer = new Scanner(System.in).useDelimiter("\n");
        alumnos = new ArrayList();
    }
    
    public void menuAlumnos() {
        char respuesta = 'a';
        int opcion;
        do {
            System.out.println("***** Sistema de Control Alumnos *****");
            System.out.println("1. Ingresar Alumnos");
            System.out.println("2. Calcular Nota Final");
            System.out.println("3. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    notaFinal();
                    break;
                case 3:
                    System.out.println("Desea Salir");
                    respuesta = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!(respuesta == 's'));
        System.out.println("Saliendo del sistema . . .");
    }
    
    private void crearAlumno() {
        String re;
        do {
            Alumno alum1 = new Alumno();
            ArrayList<Double> aux = new ArrayList();
            System.out.println("Ingrese los datos de un Alumno");
            System.out.println("Ingrese el nombre");
            alum1.setNombre(leer.next());
            System.out.println("Ingrese nota 1");
            aux.add(leer.nextDouble());
            System.out.println("Ingrese nota 2");
            aux.add(leer.nextDouble());
            System.out.println("Ingrese nota 3");
            aux.add(leer.nextDouble());
            alum1.setNotas(aux);
            alumnos.add(alum1);
            System.out.println("Quiere ingresar otro alumno? S/N");
            re = leer.next();
        } while (!re.toUpperCase().equals("N"));
        System.out.println(alumnos.toString());
    }

    private double notaFinal() {
        double promedio = 0;
        double suma = 0;
        int size;
        int cont = 0;
        System.out.println("Ingrese el nombre del alumno a buscar");
        String nuevo = leer.next();
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nuevo)) {
                ArrayList<Double> auxNotas = alumno.getNotas();
                size = auxNotas.size();
                for (Double notas : auxNotas) {
                    suma += notas;
                }
                promedio = suma / size;
                System.out.println("El promedio del alumno ingresado es: " + df.format(promedio));
            } else {
                cont += 1;
            }
        }
        if (alumnos.size() == cont) {
            System.out.println("Alumno no encontrado ");
            promedio = 0;
        }
        return promedio;
    } 
}
