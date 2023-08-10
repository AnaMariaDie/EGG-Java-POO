package libreria.persistencia;

import java.util.List;
import libreria.entidades.Cliente;

public class ClienteDAO extends DAO<Cliente> {

    /**
     * Guarda un Cliente que recibe por parametro.
     *
     * @param cliente
     */
    @Override
    public void guardar(Cliente cliente) {
        super.guardar(cliente);
    }

    /**
     * Edita un Cliente que recibe por parametro(ya tiene los valores nuevos).
     *
     * @param cliente
     */
    @Override
    public void editar(Cliente cliente) {
        super.editar(cliente);
    }
    
    /**
     * Elimina un Cliente que recibe por parametro.
     *
     * @param cliente
     */
    @Override
    public void eliminar(Cliente cliente) {
        super.eliminar(cliente);
    }
    
    /**
     * Busca y devuelve un Cliente por id.
     *
     * @param id_cliente
     * @return
     */
    public Cliente buscarId(Integer id_cliente) {
        super.conectar();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.id = :id_cliente")
                .setParameter("id_cliente", id_cliente).getSingleResult();
        super.desconectar();
        return cliente;
    }

    /**
     * Busca y devuelve un Cliente por DNI.
     *
     * @param dni
     * @return
     */
    public Cliente buscarPorDni(Long dni) {
        super.conectar();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.dni = :dni")
                .setParameter("dni", dni).getSingleResult();
        super.desconectar();
        return cliente;
    }
    
    /**
     * Devuelve un listado con todos los clientes en la base de datos.
     *
     * @return
     */
    public List<Cliente> listarTodos() {
        super.conectar();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c").getResultList();
        super.desconectar();
        return clientes;
    }
}
