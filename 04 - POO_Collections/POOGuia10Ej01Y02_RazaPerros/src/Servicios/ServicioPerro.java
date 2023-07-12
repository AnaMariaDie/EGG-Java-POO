package Servicios;

import java.util.*;
import static java.util.Collections.sort;

public class ServicioPerro {

    private Scanner leer;
    private ArrayList<String> listaDePerros;

    public ServicioPerro() {
        leer = new Scanner(System.in).useDelimiter("\n");
        listaDePerros = new ArrayList<>();
    }

    public void crearPerro() {
        System.out.println("Ingrese la raza de perro");
        String perro = leer.next();
        listaDePerros.add(perro);
        System.out.println("La raza ingresada es: " + perro);
    }

    public void agregarPerros() {
        String salir;
        do {
            crearPerro();
            System.out.println("¿Desea salir? (S/N)");
            salir = leer.next();
        } while (!salir.toUpperCase().equals("S"));
        mostrarPerros(listaDePerros);
        verificarIngreso(listaDePerros);
    }

    public void verificarIngreso(ArrayList<String> listaDePerros) {
        String out;
        int cont;
        int size;
        do {
            System.out.println("Ingrese la raza de perro a verificar");
            String aux = leer.next();
            Iterator<String> it = listaDePerros.iterator(); 
            while (it.hasNext()) {
                String aux1 = it.next();
                if (aux1.equals(aux)) {
                    it.remove();
                    System.out.println("El perro se removio correctamente");
                }    
            }
            System.out.println("¿Finalizo la Revision? (S/N)");
            out = leer.next();
        } while (!out.toUpperCase().equals("S"));
        sort(listaDePerros);
        mostrarPerros(listaDePerros);
    }
    
    public void mostrarPerros(ArrayList<String> listaDePerros) {
        System.out.println("La lista de perros es: ");
        for (String list : listaDePerros) {
            System.out.println(list);
        }
        System.out.println("-----------------------------");
    }
}
