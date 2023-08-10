package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoService {

    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    /**
     * Crear un producto con todos los datos y guardarlo en la base de datos.
     * Sin codigo porque es autoincremental.
     *
     * @param nombre
     * @param precio
     * @param codigoFabricante
     * @throws Exception
     */
    public void crearProducto(String nombre, Double precio, Integer codigoFabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (precio == null) {
                throw new Exception("Debe indicar un precio");
            }
            if (codigoFabricante == null) {
                throw new Exception("Debe indicar un codigo para el fabricante");
            }
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(producto);
            System.out.println("Producto creado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Crear un producto con todos los datos y guardarlo en la base de datos
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param codigoFabricante
     * @throws Exception
     */
    public void crearProducto(Integer codigo, String nombre, Double precio, Integer codigoFabricante) throws Exception {
        try {
            if (codigo == null) {
                throw new Exception("Debe indicar un codigo");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (precio == null) {
                throw new Exception("Debe indicar un precio");
            }
            if (codigoFabricante == null) {
                throw new Exception("Debe indicar un codigo para el fabricante");
            }
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(producto);
            System.out.println("Producto creado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un producto de la Tabla de la Base de Datos.
     *
     * @param codigo
     * @throws java.lang.Exception
     */
    public void eliminarProducto(Integer codigo) throws Exception {
        try {
            if (codigo < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un producto con los valores que le ingresan.
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param codigoFabricante
     * @throws Exception
     */
    public void modificarProducto(Integer codigo, String nombre, Double precio, Integer codigoFabricante) throws Exception {
        try {
            if (codigo == null || codigo < 0) {
                throw new Exception("Debe indicar un codigo");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (precio == null || precio < 0) {
                throw new Exception("Debe indicar un precio");
            }
            if (codigoFabricante == null || codigoFabricante < 0) {
                throw new Exception("Debe indicar un codigo para el fabricante");
            }
            Producto producto = buscarProductoPorCodigo(codigo);
            // Modifica el producto segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.modificarProducto(producto);
            System.out.println("Producto modificado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un producto a modificar.
     *
     * @param codigo
     * @return
     * @throws java.lang.Exception
     */
    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
        try {
            if (codigo < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            if (producto == null) {
                throw new Exception("No se encontro Producto para el codigo indicado");
            }
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los productos de la base de datos
     *
     * @return
     * @throws Exception
     */
    public Collection<Producto> listarProductos() throws Exception {
        try {
            Collection<Producto> productos = dao.listarProductos();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los productos solo con nombre.
     *
     * @param nombre
     * @throws Exception
     */
    public void listarProductosConParametro(String nombre) throws Exception {
        try {
            dao.listarProductosConParametro(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los productos solo mostrando nombre y precio.
     *
     * @param nombre
     * @param precio
     * @throws Exception
     */
    public void listarProductosConParametro(String nombre, String precio) throws Exception {
        try {
            dao.listarProductosConParametro(nombre, precio);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los datos de los productos cuyo precio esta entre 120 y 202
     *
     * @param num1
     * @param num2
     * @throws Exception
     */
    public void listarProductosPorPrecio(int num1, int num2) throws Exception {
        try {
            dao.listarProductosPorPrecio(num1, num2);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Lista los productos portatiles.
     *
     * @return
     * @throws Exception
     */
    public Collection<Producto> buscarPortatil() throws Exception {
        try {
            Collection<Producto> productos = dao.buscarPortatil();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Devuelve el producto con el precio mas barato.
     *
     * @return
     * @throws Exception
     */
    public Producto buscarProductoBarato() throws Exception {
        try {
            Producto producto = dao.buscarProductoBarato();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los productos que hay en la base de datos.
     *
     * @throws Exception
     */
    public void imprimirProducto() throws Exception {
        try {
            Collection<Producto> productos = listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los productos que recibe por parametro.
     *
     * @param productos
     * @throws Exception
     */
    public void imprimirProducto(Collection<Producto> productos) throws Exception {
        try {
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
