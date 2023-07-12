package main;

import entidades.Persona;
import java.util.*;
import servicios.Facultad;

public class POOGuia12Ex04 {

    public static void main(String[] args) {
        List<Persona> listPer = new ArrayList();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Facultad facu = new Facultad();
        Boolean flag = true;
        do {
            System.out.println("** ¿QUE QUIERE REALIZAR? **");
            System.out.println(" * 1 - ALTA");
            System.out.println(" * 2 - MODIFICACION");
            System.out.println(" * 3 - MOSTRAR LOS REGISTROS");
            System.out.println(" * 4 - SALIR");
            int option = leer.nextInt();
            switch (option) {
                case 1:
                    listPer = facu.crearPersonas(listPer, leer);
//                    listPer = facu.registrarDatos(listPer, leer);
                    break;
                case 2:
                    listPer = facu.modificar(listPer, leer);
                    break;
                case 3:
                    facu.mostarPersona(listPer);
                    break;
                case 4:
                    System.out.println("¿Desea abandonar el sistema? S/N");
                    if (leer.next().equalsIgnoreCase("S")) {
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
            }
        } while (flag);
    }

}
