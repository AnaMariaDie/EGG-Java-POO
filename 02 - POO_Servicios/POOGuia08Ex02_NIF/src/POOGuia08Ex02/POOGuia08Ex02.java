package POOGuia08Ex02;

import entidades.NIF;
import java.util.Scanner;
import servicios.NIFServicio;

public class POOGuia08Ex02 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        NIFServicio nifs = new NIFServicio();
        NIF nif = new NIF();
        char respuesta = 'a';
        int opcion;
        do {
            System.out.println("------ MENU ------");
            System.out.println("1. Ingresar un DNI");
            System.out.println("2. Mostrar NIF");
            System.out.println("3. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("----------------------------");
                    System.out.println("Ingrese el numero de su DNI");
                    nif.setnDNI(leer.nextLong());
                    nifs.crearNIF(nif, nifs.calcularPosicion(nif));
                    break;
                case 2:
                    System.out.println("----------------------------");
                    nifs.mostrarNIF(nif);
                    break;
                case 3:
                    System.out.println("----------------------------");
                    System.out.println("Desea Salir");
                    respuesta = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("----------------------------");
                    System.out.println("Opcion Invalida");
            }
        } while (!(respuesta == 's'));
        System.out.println("----------------------------");
        System.out.println("Saliendo del sistema . . .");
    }
}
