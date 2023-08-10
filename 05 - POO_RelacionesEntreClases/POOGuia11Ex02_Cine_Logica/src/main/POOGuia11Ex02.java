package main;

import entidades.*;
import java.util.*;
import servicios.CineService;

public class POOGuia11Ex02 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Espectador> espectadores = crearEspectadores();
        CineService cs = new CineService(); 
        Cine cine = new Cine();
        Asiento[][] salaMatriz = cine.crearSala();
        // SIMULACION Generacion de Espectadores con edad random y dinero random
//        cine = cs.simulacion(salaMatriz);
        
        //MENU INGRESO ENTRADAS
        boolean bucle = true;
        int opcion = 0;
        do {
            System.out.println("***** Bienvenido a CinemaAnna *****");
            System.out.println(" 1. Elegir Pelicula");
            System.out.println(" 2. Comprar Entrada");
            System.out.println(" 3. Mostrar Asientos");
            System.out.println(" 4. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    cs.elegirPelicula(cine);
                    break;
                case 2:
                    cs.ventaEntradas(salaMatriz, espectadores, cine);
                    break;
                case 3:
                    cs.mostrarAsientos(salaMatriz);
                    break;
                case 4:
                    System.out.println("Desea salir? S/N");
                    if (leer.next().equalsIgnoreCase("N")) {
                        System.out.println("Saliendo . . . ");
                        bucle = false;
                    }
                default:
                    System.out.println("Opcion invalida");
            }
        } while (bucle);
    }

    /**
     * Array de espectadores ya cargados
     * @return 
     */
    public static ArrayList<Espectador> crearEspectadores() {
        ArrayList<Espectador> espectadores = new ArrayList();
        Espectador e1 = new Espectador("Marta", 35, 1000);
        Espectador e2 = new Espectador("Pedro", 51, 2000);
        Espectador e3 = new Espectador("Luis", 28, 1210);
        Espectador e4 = new Espectador("Sandra", 15, 100);
        Espectador e5 = new Espectador("Jose", 25, 2100);
        Espectador e6 = new Espectador("Gabriela", 42, 4500);
        espectadores.add(e1);
        espectadores.add(e2);
        espectadores.add(e3);
        espectadores.add(e4);
        espectadores.add(e5);
        espectadores.add(e6);
        return espectadores;
    }
}
