package POOGuia08Ej02;

import entidades.Cafetera;
import java.util.Scanner;
import servicios.CafeteraServicio;

public class POOGuia08Ej02 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        CafeteraServicio servCafe = new CafeteraServicio();
        Cafetera cafetera = servCafe.crearCafetera();
        int opcion1 = 0;
        char resp = 'a';
        do {
            System.out.println("**************************************");
            System.out.println("Indique la accion que desea realizar: ");
            System.out.println("1. Llenar Cafetera");
            System.out.println("2. Servir Taza");
            System.out.println("3. Vaciar Cafetera");
            System.out.println("4. Agregar Cafe");
            System.out.println("5. Salir");
            System.out.println("**************************************");
            opcion1 = leer.nextInt();
            switch (opcion1) {
                case 1:
                    servCafe.llenarCafetera(cafetera);
                    break;
                case 2:
                    System.out.println("**************************************");
                    System.out.println("Indique el tamaño de la taza: ");
                    int size = leer.nextInt();
                    servCafe.servirTaza(cafetera, size);
                    break;
                case 3:
                    servCafe.vaciarCafetera(cafetera);
                    break;
                case 4:
                    servCafe.agregarCafe(cafetera);
                    break;
                case 5:
                    System.out.println("**************************************");
                    System.out.println("Desea Salir");
                    resp = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("**************************************");
                    System.out.println("La opcion ingresada es invalida");
            }
        } while (opcion1 != 5);
        System.out.println("**************************************");
        System.out.println("Saliendo del sistema . . .");
    }
}
