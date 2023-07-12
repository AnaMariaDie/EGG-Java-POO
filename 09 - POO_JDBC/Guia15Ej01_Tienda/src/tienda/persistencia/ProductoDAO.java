package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {

    /**
     * Guarda un producto en la Tabla de la Base de Datos.
     * @param producto
     * @throws Exception 
     */
    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un Producto");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) " + "VALUES ("
                    + "'" + producto.getNombre() + "', " + producto.getPrecio()
                    + ", " + producto.getCodigoFabricante() + ");";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Elimina un producto de la base de datos segun el codigo recibido. 
     * @param codigo 
     * @throws java.lang.Exception 
     */
    public void eliminarProducto(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    /**
     * Modifica un producto segun los parametros que recibe.
     * @param producto 
     * @throws java.lang.Exception 
     */
    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "', precio = " + 
                    producto.getPrecio() + ", codigo_fabricante = " + producto.getCodigoFabricante() + 
                    " WHERE codigo = " + producto.getCodigo() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Busca un producto segun el codigo que recibe y lo devuelve.
     * @param codigo
     * @return
     * @throws Exception 
     */
    public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo + ";";
            consultarBase(sql);
            Producto producto = null;
            while(resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
    /**
     * Devuelve una lista de los productos con todos los valores de la base de datos.
     * @return
     * @throws Exception 
     */
    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve un listado de los productos en la base de datos pero solo nombre.
     * @param nombre
     * @throws Exception 
     */
    public void listarProductosConParametro(String nombre) throws Exception {
        try {
            String sql = "SELECT " + nombre + " FROM producto;";
            consultarBase(sql);
            while (resultado.next()) {
                System.out.println("Nombre: " + resultado.getString(nombre));
            }
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
    /**
     * Devuelve un listado de los productos en la base de datos pero solo nombre y precio.
     * @param nombre
     * @param precio
     * @throws Exception 
     */
    public void listarProductosConParametro(String nombre, String precio) throws Exception {
        try {
            String sql = "SELECT " + nombre + ", " + precio + " FROM producto;";
            consultarBase(sql);
            while (resultado.next()) {
                System.out.println("Nombre: " + resultado.getString(nombre) + " , Precio: " + 
                        resultado.getDouble(precio));   
            }
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve un listado de productos de la base de datos, solo aquellos cuyo precio esta entre 120 y 202.
     * @param num1
     * @param num2
     * @throws Exception 
     */
    public void listarProductosPorPrecio(int num1, int num2) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + num1 + " AND " + num2 + ";";
            consultarBase(sql);
            while (resultado.next()) {
               System.out.println("Codigo: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " , Precio: " + 
                        resultado.getDouble(3) + " Codigo Fabricante: " + resultado.getInt(4)); 
            }
            desconectarBase();
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Busca en la base de datos y devuelve un listado de los productos(con todos sus valores)
     * con nombre Portatiles.
     * @return 
     * @throws java.lang.Exception 
     */
    public Collection<Producto> buscarPortatil() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%portatil%';";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
 
    /**
     * Devuelve el producto con el precio mas barato.
     * @return
     * @throws Exception 
     */
    public Producto buscarProductoBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1;";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
}
