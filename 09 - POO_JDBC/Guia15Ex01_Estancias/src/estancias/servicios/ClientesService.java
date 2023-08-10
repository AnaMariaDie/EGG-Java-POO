package estancias.servicios;

import estancias.entidades.Clientes;
import estancias.persistencia.ClientesDAO;
import java.util.Collection;

public class ClientesService {

    private ClientesDAO dao;

    public ClientesService() {
        this.dao = new ClientesDAO();
    }

    /**
     * Crear un Cliente con todos los datos y guardarlo en la base de datos.
     * Sin id_cliente porque es autoincremental.
     *
     * @param nombre
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param ciudad
     * @param pais
     * @param email
     * @throws Exception
     */
    public void crearCliente(String nombre, String calle, int numero, String codigoPostal, String ciudad, 
            String pais, String email) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (calle == null || calle.trim().isEmpty()) {
                throw new Exception("Debe indicar una calle");
            }
            if (numero <= 0) {
                throw new Exception("Debe indicar un numero");
            }
            if (codigoPostal == null || codigoPostal.trim().isEmpty()) {
                throw new Exception("Debe indicar un codigo postal");
            }
            if (ciudad == null || ciudad.trim().isEmpty()) {
                throw new Exception("Debe indicar una ciudad");
            }
            if (pais == null || pais.trim().isEmpty()) {
                throw new Exception("Debe indicar un pais");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un email");
            }
            Clientes cliente = new Clientes();
            cliente.setNombre(nombre);
            cliente.setCalle(calle);
            cliente.setNumero(numero);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setCiudad(ciudad);
            cliente.setPais(pais);
            cliente.setEmail(email);
            dao.guardarCliente(cliente);
            System.out.println("Cliente creado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un Cliente de la Tabla de la Base de Datos.
     *
     * @param id_cliente
     * @throws java.lang.Exception
     */
    public void eliminarCliente(int id_cliente) throws Exception {
        try {
            if (id_cliente < 0) {
                throw new Exception("Debe indicar una id_cliente");
            }
            dao.eliminarCliente(id_cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un Cliente con los valores que le ingresan.
     *
     * @param idCliente
     * @param nombre
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param ciudad
     * @param pais
     * @param email
     * @throws Exception
     */
    public void modificarCliente(int idCliente, String nombre, String calle, int numero, String codigoPostal, 
            String ciudad, String pais, String email) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (calle == null || calle.trim().isEmpty()) {
                throw new Exception("Debe indicar una calle");
            }
            if (numero <= 0) {
                throw new Exception("Debe indicar un numero");
            }
            if (codigoPostal == null || codigoPostal.trim().isEmpty()) {
                throw new Exception("Debe indicar un codigo postal");
            }
            if (ciudad == null || ciudad.trim().isEmpty()) {
                throw new Exception("Debe indicar una ciudad");
            }
            if (pais == null || pais.trim().isEmpty()) {
                throw new Exception("Debe indicar un pais");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un email");
            }
            Clientes cliente = buscarClientePorIdCliente(idCliente);
            // Modifica el cliente segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            cliente.setNombre(nombre);
            cliente.setCalle(calle);
            cliente.setNumero(numero);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setCiudad(ciudad);
            cliente.setPais(pais);
            cliente.setEmail(email);
            dao.modificarCliente(cliente);
            System.out.println("Cliente modificado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un Cliente a modificar.
     *
     * @param idCliente
     * @return
     * @throws java.lang.Exception
     */
    public Clientes buscarClientePorIdCliente(int idCliente) throws Exception {
        try {
            if (idCliente < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Clientes cliente = dao.buscarClientePorIdCliente(idCliente);
            if (cliente == null) {
                throw new Exception("No se encontro Clientes para el codigo indicado");
            }
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los Clientes de la base de datos
     *
     * @return
     * @throws Exception
     */
    public Collection<Clientes> listarClientes() throws Exception {
        try {
            Collection<Clientes> clientes = dao.listarClientes();
            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Clientes que hay en la base de datos.
     *
     * @throws Exception
     */
    public void imprimirClientes() throws Exception {
        try {
            Collection<Clientes> clientes = listarClientes();
            if (clientes.isEmpty()) {
                throw new Exception("No existen clientes para imprimir");
            } else {
                for (Clientes cliente : clientes) {
                    System.out.println(cliente.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Clientes que recibe por parametro.
     *
     * @param clientes
     * @throws Exception
     */
    public void imprimirClientes(Collection<Clientes> clientes) throws Exception {
        try {
            if (clientes.isEmpty()) {
                throw new Exception("No existen clientes para imprimir");
            } else {
                for (Clientes cliente : clientes) {
                    System.out.println(cliente.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
