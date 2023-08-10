package servicios;

import java.util.*;

public class PaisService {

    private Scanner leer;
    private TreeSet<String> paises;

    public PaisService() {
        leer = new Scanner(System.in).useDelimiter("\n");
        paises = new TreeSet();
    }
    
    public void guardarPaises() {
        String re;
        boolean bucle;
        do{
            System.out.println("Ingrese un Pais");
            paises.add(leer.next());
            System.out.println("Desea guardar otro pais? S/N");
            re = leer.next();
            if (re.equalsIgnoreCase("S")) {
                bucle = true;
            } else {
                bucle = false;
            }
        } while(bucle);
        mostrarPaises();
    }
    
    public void mostrarPaises() {
        System.out.println("Los paises son: ");
        for (String pais : paises) {
            System.out.println(pais);
        }
    }
    
    public void eliminarPais() {
        System.out.println("Ingrese un Pais a eliminar");
        String paisEliminar = leer.next();
        boolean noesta = true;
        Iterator<String> it = paises.iterator();
        while (it.hasNext()) {
            String aux = it.next();
            if(aux.equalsIgnoreCase(paisEliminar)) {
                it.remove();
                noesta = false;
                break;
            }
        }
        if (noesta) {
            System.out.println("No se encontro el pais solicitado");
        } else {
            System.out.println("El pais se elimino correctamente");
        }
        mostrarPaises();
    }
}
