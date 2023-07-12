package servicio;

import java.util.Scanner;
import service.Producto;

public class ProductoService {

    private Producto producto;

    public void softManager() {
        ProductoService menu = new ProductoService();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            menu.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    modificarPrecio(scanner);
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 5:
                    mostrarNombresProductos();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
        scanner.close();
    }

    private void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer de entrada
        producto = new Producto(nombre, descripcion, precio);
        producto.addProducto(producto);
        System.out.println("Producto agregado con éxito.");
    }

    private void modificarPrecio(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();
        if (Producto.getProductos().containsKey(nombre)) {
            System.out.print("Ingrese el nuevo precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer de entrada
            Producto producto = Producto.getProductos().get(nombre);
            producto.setPrecio(precio);
            System.out.println("Precio del producto actualizado.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    private void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        if (Producto.getProductos().containsKey(nombre)) {
            Producto producto = Producto.getProductos().get(nombre);
            producto.removeProducto(nombre);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    private void mostrarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : Producto.getProductos().values()) {
            System.out.println(producto.getNombre() + " - " + producto.getDescripcion() + " - " 
                    + producto.getPrecio());
        }
    }

    private void mostrarNombresProductos() {
        System.out.println("Lista de productos:");
        for (String nombre : Producto.getProductos().keySet()) {
            System.out.println(nombre);
        }
    }

    private void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar precio de un producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Mostrar todos los productos");
        System.out.println("5. Mostrar nombres de productos");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }
}