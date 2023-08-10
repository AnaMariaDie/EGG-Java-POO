package estancias.persistencia;

import estancias.entidades.Estancias;
import java.util.ArrayList;
import java.util.Collection;

public final class EstanciasDAO extends DAO {

    /**
     * Guarda una Estancia en la Tabla de la Base de Datos.
     *
     * @param estancia
     * @throws Exception
     */
    public void guardarEstancia(Estancias estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar una Estancia");
            }
            String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta)"
                    + " VALUES (" + estancia.getIdCliente() + ", " + estancia.getIdCasa() + ", '" + 
                    estancia.getNombreHuesped() + "', " + estancia.getFechaDesde() + ", " + 
                    estancia.getFechaHasta() + ");";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Elimina una Estancia de la base de datos segun el codigo recibido.
     *
     * @param idEstancia
     * @throws java.lang.Exception
     */
    public void eliminarEstancia(int idEstancia) throws Exception {
        try {
            String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Modifica una Estancia segun los parametros que recibe.
     *
     * @param estancia
     * @throws java.lang.Exception
     */
    public void modificarEstancia(Estancias estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar una Estancia que desea modificar");
            }
            String sql = "UPDATE estancias SET id_cliente = " + estancia.getIdCliente() + ", id_casa = "
                    + estancia.getIdCasa() + ", nombre_huesped = '" + estancia.getNombreHuesped() + 
                    "', fecha_desde = '" + estancia.getFechaDesde() + "', fecha_hasta = '" + estancia.getFechaHasta() 
                    + "' WHERE id_estancia = " + estancia.getIdEstancia() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Busca una Estancia segun el codigo que recibe y lo devuelve.
     *
     * @param id_estancia
     * @return
     * @throws Exception
     */
    public Estancias buscarEstanciaPorIdEstancia(int id_estancia) throws Exception {
        try {
            String sql = "SELECT * FROM estancias WHERE id_estancia  = " + id_estancia + ";";
            consultarBase(sql);
            Estancias estancia = null;
            while (resultado.next()) {
                estancia = new Estancias();
                estancia.setIdEstancia(resultado.getInt(1));
                estancia.setIdCliente(resultado.getInt(2));
                estancia.setIdCasa(resultado.getInt(3));
                estancia.setNombreHuesped(resultado.getNString(4));
                estancia.setFechaDesde(resultado.getDate(5));
                estancia.setFechaHasta(resultado.getDate(6));
            }
            desconectarBase();
            return estancia;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve una lista de los productos con todos los valores de la base de
     * datos.
     *
     * @return
     * @throws Exception
     */
    public Collection<Estancias> listarEstancias() throws Exception {
        try {
            String sql = "SELECT * FROM estancias;";
            consultarBase(sql);
            Estancias estancia = null;
            Collection<Estancias> estancias = new ArrayList();
            while (resultado.next()) {
                estancia = new Estancias();
                estancia.setIdEstancia(resultado.getInt(1));
                estancia.setIdCliente(resultado.getInt(2));
                estancia.setIdCasa(resultado.getInt(3));
                estancia.setNombreHuesped(resultado.getNString(4));
                estancia.setFechaDesde(resultado.getDate(5));
                estancia.setFechaHasta(resultado.getDate(6));
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
//    
//    /**
//     * Devuelve un listado de los productos en la base de datos pero solo nombre.
//     * @param nombre
//     * @throws Exception 
//     */
//    public void listarProductosConParametro(String nombre) throws Exception {
//        try {
//            String sql = "SELECT " + nombre + " FROM producto;";
//            consultarBase(sql);
//            while (resultado.next()) {
//                System.out.println("Nombre: " + resultado.getString(nombre));
//            }
//            desconectarBase();
//        } catch (Exception e) {
//            e.printStackTrace();
//            desconectarBase();
//            throw e;
//        }
//    }
//    
//    /**
//     * Devuelve un listado de los productos en la base de datos pero solo nombre y precio.
//     * @param nombre
//     * @param precio
//     * @throws Exception 
//     */
//    public void listarProductosConParametro(String nombre, String precio) throws Exception {
//        try {
//            String sql = "SELECT " + nombre + ", " + precio + " FROM producto;";
//            consultarBase(sql);
//            while (resultado.next()) {
//                System.out.println("Nombre: " + resultado.getString(nombre) + " , Precio: " + 
//                        resultado.getDouble(precio));   
//            }
//            desconectarBase();
//        } catch (Exception e) {
//            e.printStackTrace();
//            desconectarBase();
//            throw e;
//        }
//    }
//
//    /**
//     * Devuelve un listado de productos de la base de datos, solo aquellos cuyo precio esta entre 120 y 202.
//     * @param num1
//     * @param num2
//     * @throws Exception 
//     */
//    public void listarProductosPorPrecio(int num1, int num2) throws Exception {
//        try {
//            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + num1 + " AND " + num2 + ";";
//            consultarBase(sql);
//            while (resultado.next()) {
//               System.out.println("Codigo: " + resultado.getInt(1) + " Nombre: " + resultado.getString(2) + " , Precio: " + 
//                        resultado.getDouble(3) + " Codigo Fabricante: " + resultado.getInt(4)); 
//            }
//            desconectarBase();
//        } catch (Exception e) {
//            e.printStackTrace();
//            desconectarBase();
//            throw e;
//        }
//    }
//
//    /**
//     * Busca en la base de datos y devuelve un listado de los productos(con todos sus valores)
//     * con nombre Portatiles.
//     * @return 
//     * @throws java.lang.Exception 
//     */
//    public Collection<Producto> buscarPortatil() throws Exception {
//        try {
//            String sql = "SELECT * FROM producto WHERE nombre LIKE '%portatil%';";
//            consultarBase(sql);
//            Producto producto = null;
//            Collection<Producto> productos = new ArrayList();
//            while (resultado.next()) {
//                producto = new Producto();
//                producto.setCodigo(resultado.getInt(1));
//                producto.setNombre(resultado.getString(2));
//                producto.setPrecio(resultado.getDouble(3));
//                producto.setCodigoFabricante(resultado.getInt(4));
//                productos.add(producto);
//            }
//            desconectarBase();
//            return productos;
//        } catch (Exception e) {
//            e.printStackTrace();
//            desconectarBase();
//            throw e;
//        }
//    }
// 
//    /**
//     * Devuelve el producto con el precio mas barato.
//     * @return
//     * @throws Exception 
//     */
//    public Producto buscarProductoBarato() throws Exception {
//        try {
//            String sql = "SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1;";
//            consultarBase(sql);
//            Producto producto = null;
//            while (resultado.next()) {
//                producto = new Producto();
//                producto.setNombre(resultado.getString(1));
//                producto.setPrecio(resultado.getDouble(2));
//            }
//            desconectarBase();
//            return producto;
//        } catch (Exception e) {
//            e.printStackTrace();
//            desconectarBase();
//            throw e;
//        }
//    }
//    
}
