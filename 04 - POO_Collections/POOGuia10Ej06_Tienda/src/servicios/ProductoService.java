package servicios;

import java.util.HashMap;
import java.util.Scanner;

public class ProductoService {

    private HashMap<String, Double> productos;
    private Scanner leer;

    public ProductoService() {
        leer = new Scanner(System.in).useDelimiter("\n");
        productos = new HashMap();
    }

    public void menuTienda() {
        char respuesta = 'a';
        int opcion;
        do {
            System.out.println("***** Sistema de Tienda Ana *****");
            System.out.println("1. Ingresar Productos");
            System.out.println("2. Modificar Precio");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Mostrar Lista");
            System.out.println("5. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    incluirProducto();
                    break;
                case 2:
                    modificarPrecio();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    mostrarProducto();
                    break;
                case 5:
                    System.out.println("Desea Salir");
                    respuesta = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!(respuesta == 's'));
        System.out.println("Saliendo del sistema . . .");
    }
    
    private void incluirProducto() {
        String re;
        boolean bucle;
        do {
            System.out.println("Ingrese el producto");
            String nombre = leer.next();
            System.out.println("Ingrese el precio");
            Double precio = leer.nextDouble();
            productos.put(nombre, precio);
            System.out.println("Desea agregar otro producto? S/N");
            re = leer.next();
            if (re.equalsIgnoreCase("S")) {
                bucle = true;
            } else {
                bucle = false;
            }
        } while (bucle);
    }

    private void modificarPrecio() {
        System.out.println("Ingrese un Producto a modificar");
        String producto = leer.next();
        System.out.println("Ingrese el valor a modificar");
        Double precio = leer.nextDouble();
        productos.replace(producto, precio);
    }

    public void eliminarProducto() {
        System.out.println("Ingrese el Producto que desea eliminar");
        String producto = leer.next();
        productos.remove(producto);
    }

    public void mostrarProducto() {
        System.out.println("***** Lista de Productos *****");
        for (HashMap.Entry<String, Double> entry : productos.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
}
