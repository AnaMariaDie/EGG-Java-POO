package servicios;

import entidad.Producto;
import java.util.*;

public class TiendaService {

    private HashMap<Integer, Producto> nuevoMapa; // Creo el mapa
    private Scanner leer; // Creo el Scanner para utilizar en toda mi clase
    //Esta es una muy buena practica
    public TiendaService() {
        this.nuevoMapa = new HashMap<>(); // Creo el espacio en memoria del LISTAS
        this.leer = new Scanner(System.in).useDelimiter("\n");
        // Cuando se invoca la clase, habilita el flujo de datos
    }

    public void menu() {
        int selec;
        do {
            System.out.println("--------Menu--------");
            System.out.println("--------1: Agregar Producto--------");
            System.out.println("--------2: Modificar Precio--------");
            System.out.println("--------3: Eliminar Producto--------");
            System.out.println("--------4: Imprimir Stock--------");
            System.out.println("--------5: Salir--------");
            selec = leer.nextInt();
            switch (selec) {
                case 1:
                    String res;
                    do {
                        agregarProducto(nuevoMapa);
                        System.out.println("Desea agregar otro Producto: S/N");
                        res = leer.next().toUpperCase();
                    } while (res.equals("S"));
                    break;
                case 2:
                    String res1;
                    do {
                        modificarPrecio(nuevoMapa);
                        System.out.println("Desea modificar otro Precio: S/N");
                        res1 = leer.next().toUpperCase();
                    } while (res1.equals("S"));
                    break;
                case 3:
                    String res2;
                    do {
                        eliminar(nuevoMapa);
                        System.out.println("Desea eliminar otro Producto: S/N");
                        res2 = leer.next().toUpperCase();
                    } while (res2.equals("S"));
                    break;
                case 4:
                    System.out.println(nuevoMapa.toString());
                    break;
            }
        } while (selec != 5);
    }

    public void agregarProducto(HashMap<Integer, Producto> nuevoMapa) {
        System.out.println("Introduzca el id del producto");
        Integer id = leer.nextInt();
        System.out.println("Introduzca el nombre del producto");
        String nombreIngresado = leer.next();
        nombreIngresado = nombreIngresado.toUpperCase();
        System.out.println("Introduzca el precio del producto");
        Integer precio = leer.nextInt();
        nuevoMapa.put(id, new Producto(id, nombreIngresado, precio));
        System.out.println("Se cargo el producto" + id + "exitosamente");
    }

    public void modificarPrecio(HashMap<Integer, Producto> nuevoMapa) {
        System.out.println("Ingrese el ID del producto a modificar");
        Integer id = leer.nextInt();
        if (nuevoMapa.containsKey(id)) {
            // Iterator<Map.Entry<String, Double>> it = prod2.entrySet().iterator();
            for (Map.Entry<Integer, Producto> entry : nuevoMapa.entrySet()) {
                if (entry.getKey().equals(id)) {
                    System.out.println("El precio actual es :" + entry.getValue().getPrecio());
                    System.out.println("Ingrese el nuevo precio");
                    Integer nuevoPrecio = leer.nextInt();
                    entry.getValue().setPrecio(nuevoPrecio);
                }
            }
        } else {
            System.out.println("No se encuentra");
        }
    }

    public void eliminar(HashMap<Integer, Producto> nuevoMapa) {
        System.out.println("Ingrese el ID del producto a ¡Eliminar!");
        Integer id = leer.nextInt();
        if (nuevoMapa.containsKey(id)) {
            nuevoMapa.remove(id);
            System.out.println("Borrado Exitosamente");
        } else {
            System.out.println("No se encuentra");
        }
    }
//     String opcion;
//        do {
//            System.out.println("Ingrese el nombre del producto: ");
//            String nombre = leer.nextLine();
//            System.out.println("Ingrese el precio del producto: ");
//            double precio = leer.nextDouble();
//            leer.nextLine(); // Limpia el buffer de entrada
//            // Consume el salto de línea pendiente
//            // En este caso, se está insertando un nuevo producto con su precio
//            //asociado, donde la clave es el nombre del producto y el valor es el
//            //precio. La línea de código productos.put(nombre, precio); agrega este
//            //par clave-valor al mapa productos
//            productos.put(nombre, precio);
//            System.out.println("El producto " + nombre + " ha sido agregado con éxito.");
//            System.out.println("¿Desea agregar otro producto? (S/N)");
//            opcion = leer.nextLine();
//        } while (opcion.equalsIgnoreCase("S"));
}
