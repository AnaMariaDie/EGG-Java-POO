package tienda;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;

public class MainTienda {

    public static void main(String[] args) throws Exception {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductoService ps = new ProductoService();
        FabricanteService fs = new FabricanteService();
        boolean bucle = true;
        do {
            System.out.println("********** Menu Productos **********");
            System.out.println(" 1. Listar todos los Productos de la Tabla Producto");
            System.out.println(" 2. Listar los nombres de los Productos de la Tabla Producto");
            System.out.println(" 3. Listar los nombres y precios de los Productos de la Tabla Producto");
            System.out.println(" 4. Listar todos los Productos con precios entre 120 y 202");
            System.out.println(" 5. Listar todos los Productos portátiles");
            System.out.println(" 6. Listar el nombre y precio del Producto mas barato");
            System.out.println(" 7. Ingresar un Productos a la Base de Datos");
            System.out.println(" 8. Ingresar un Fabricante a la Base de Datos");
            System.out.println(" 9. Editar un Producto con datos a eleccion");
            System.out.println("10. Salir");
            System.out.println(" Seleccione una opcion");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    ps.imprimirProducto();
                    break;
                case 2: 
                    ps.listarProductosConParametro("nombre");
                    break;
                case 3: 
                    ps.listarProductosConParametro("nombre", "precio");
                    break;
                case 4:
                    ps.listarProductosPorPrecio(120, 202);
                    break;
                case 5:
                    Collection<Producto> productos5 = ps.buscarPortatil();
                    ps.imprimirProducto(productos5);
                    break;
                case 6:
                    Producto producto6 = ps.buscarProductoBarato();
                    System.out.println(producto6.toString());
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del Producto a ingresar");
                    String nombre = leer.next();
                    System.out.println("Ingrese el precio");
                    Double precio = leer.nextDouble();
                    System.out.println("Ingrese el codigo del fabricante");
                    Integer codFab = leer.nextInt();
                    ps.crearProducto(nombre, precio, codFab);
                    break;
                case 8:
                    System.out.println("Ingrese el nombre del Fabricante a ingresar");
                    String nombreF = leer.next();
                    System.out.println("Ingrese el codigo del fabricante");
                    Integer codigo = leer.nextInt();
                    fs.crearFabricante(codigo, nombreF);
                    break;
                case 9:
                    System.out.println("Ingrese el código del Producto que desea modificar");
                    Integer codigoP = leer.nextInt();
                    System.out.println("Ingrese el nombre del pruducto");
                    String nombre2 = leer.next();
                    System.out.println("Ingrese el precio del producto");
                    Double precio2 = leer.nextDouble();
                    System.out.println("Ingrese el código del fabricante");
                    Integer fabricante2 = leer.nextInt();
                    ps.modificarProducto(codigoP, nombre2, precio2, fabricante2); 
                    break;
                case 10:
                    System.out.println("Usted esta saliendo del sistema . . .");
                    bucle = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (bucle);
    }
}
