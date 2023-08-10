package servicios;

import entidades.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Clase que realiza los servicios de alquiler
 *
 * @author Ana
 */
public class Puerto {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Puerto() {
    }
    /**
     * Metodo para crear Alquiler con un Barco
     * @param a1
     * @return 
     */
    public Alquiler crearAlquiler(Alquiler a1) {
        System.out.println("\nIngrese el nombre del Cliente");
        a1.setNombre(leer.next());
        System.out.println("Ingrese el numero de documento");
        a1.setDocumento(leer.nextLong());
        System.out.println("Ingrese la fecha de Alquiler (dd/mm/yyyy)");
        String fechaA = leer.next();
        a1.setFechaAlquiler(LocalDate.of(Integer.parseInt(fechaA.substring(7, 10)),
                Integer.parseInt(fechaA.substring(4, 5)), Integer.parseInt(fechaA.substring(1, 2))));
        System.out.println("Ingrese la fecha de Devolucion (dd/mm/yyyy)");
        String fechaD = leer.next();
        a1.setFechaDevolucion(LocalDate.of(Integer.parseInt(fechaD.substring(7, 10)),
                Integer.parseInt(fechaD.substring(4, 5)), Integer.parseInt(fechaD.substring(1, 2))));
        System.out.println("Ingrese la Posicion del Amarre (1 a 20)");
        a1.setPosicionAmarre(leer.nextInt());
        System.out.println("Ingrese la opcion de Barco que desea Alquilar:\n1. Velero\n2. Barco Con Motor\n3. "
                + "Yate de Lujo");
        int opcion = 0;
        boolean sale = true;
        do {
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Barco barv = crearBarco();
                    System.out.println("Indique la Cantidad de Mastiles");
                    int cMastiles = leer.nextInt();
                    a1.setBarco(new BarcoVelero(barv, cMastiles));
                    sale = false;
                    break;
                case 2:
                    Barco barm = crearBarcoConMotor();
                    a1.setBarco(barm);
                    sale = false;
                    break;
                case 3:
                    Barco bary = crearBarcoConMotor();
                    System.out.println("Indique Cantidad de Camarotes");
                    int cantCama = leer.nextInt();
                    a1.setBarco(new BarcoYateDeLujo((BarcoConMotor) bary, cantCama));
                    sale = false;
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (sale);
        System.out.println("El Barco a Alquilar es: " + a1.getBarco().toString() + "\nEl valor del Alquiler"
                + " por " + a1.calcularDiasOcupacion() + " dias es de " + calcularAlquiler(a1));
        return a1;
    }

    private int calcularAlquiler(Alquiler alquiler) {
        int diasOcupacion = alquiler.calcularDiasOcupacion();
        int costo = 0;
        if (alquiler.getBarco() instanceof BarcoYateDeLujo) {
            BarcoYateDeLujo bydl = (BarcoYateDeLujo) alquiler.getBarco();
            costo = alquiler.getBarco().valorModulo() * diasOcupacion;
        } else {
            if (alquiler.getBarco() instanceof BarcoConMotor) {
                BarcoConMotor bcm = (BarcoConMotor) alquiler.getBarco();
                costo = alquiler.getBarco().valorModulo() * diasOcupacion;
            } else {
                if (alquiler.getBarco() instanceof BarcoVelero) {
                    BarcoVelero bv = (BarcoVelero) alquiler.getBarco();
                    costo = alquiler.getBarco().valorModulo() * diasOcupacion;
                } else {
                    System.out.println("El Barco esta mal configurado");
                    costo = 0;
                }
            }
        }
        return costo;
    }

    private Barco crearBarco() {
        Barco bar = new Barco();
        System.out.println("Ingrese la Matricula del Barco");
        bar.setMatricula(leer.next());
        System.out.println("Ingrese la Eslora del Barco (en metros)");
        bar.setEslora(leer.nextInt());
        System.out.println("Ingrese el año de Fabricacion");
        bar.setAnioFabricacion(leer.nextInt());
        return bar;
    }

    private BarcoConMotor crearBarcoConMotor() {
        Barco aux = crearBarco();
        System.out.println("Indique la Potencia en CV (Caballos de Vapor)");
        int potCV = leer.nextInt();
        BarcoConMotor bcoCM = new BarcoConMotor(aux, potCV);
        return bcoCM;
    }
}
