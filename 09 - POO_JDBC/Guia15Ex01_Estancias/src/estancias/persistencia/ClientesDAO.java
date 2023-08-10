package estancias.persistencia;

import estancias.entidades.Clientes;
import java.util.ArrayList;
import java.util.Collection;

public class ClientesDAO extends DAO {
    
    /**
     * Guarda una Cliente en la Tabla de la Base de Datos.
     *
     * @param cliente
     * @throws Exception
     */
    public void guardarCliente(Clientes cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar un Cliente");
            }
            String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email)" + 
                    " VALUES ('" + cliente.getNombre() + "', '" + cliente.getCalle() + "', " + cliente.getNumero() 
                    + ", '" + cliente.getCodigoPostal() + "', '" + cliente.getCiudad()+ "', '" + cliente.getPais() 
                    + "', '" + cliente.getEmail() + "');";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Elimina una Cliente de la base de datos segun el codigo recibido.
     *
     * @param id_cliente
     * @throws java.lang.Exception
     */
    public void eliminarCliente(int id_cliente) throws Exception {
        try {
            String sql = "DELETE FROM clientes WHERE id_cliente = " + id_cliente + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Modifica una Cliente segun los parametros que recibe.
     *
     * @param cliente
     * @throws java.lang.Exception
     */
    public void modificarCliente(Clientes cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar un Cliente que desea modificar");
            }
            String sql = "UPDATE clientes SET nombre = '" + cliente.getNombre() + "', calle = '" + cliente.getCalle()
                    + "', numero = " + cliente.getNumero() + ", codigo_postal = '" + cliente.getCodigoPostal() + 
                    "', ciudad = '" + cliente.getCiudad() + "', pais = '" + cliente.getPais() + "', email = '" 
                    + cliente.getEmail() + "' WHERE id_cliente = " + cliente.getIdCliente() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Busca una Cliente segun el codigo que recibe y lo devuelve.
     *
     * @param id_cliente
     * @return
     * @throws Exception
     */
    public Clientes buscarClientePorIdCliente(int id_cliente) throws Exception {
        try {
            String sql = "SELECT * FROM clientes WHERE id_cliente = " + id_cliente + ";";
            consultarBase(sql);
            Clientes cliente = null;
            while (resultado.next()) {
                cliente = new Clientes();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
            }
            desconectarBase();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve una lista de los Cliente con todos los valores de la base de
     * datos.
     *
     * @return
     * @throws Exception
     */
    public Collection<Clientes> listarClientes() throws Exception {
        try {
            String sql = "SELECT * FROM clientes;";
            consultarBase(sql);
            Clientes cliente = null;
            Collection<Clientes> clientes = new ArrayList();
            while (resultado.next()) {
                cliente = new Clientes();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
                clientes.add(cliente);
            }
            desconectarBase();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
