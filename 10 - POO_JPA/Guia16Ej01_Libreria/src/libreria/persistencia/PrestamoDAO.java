package libreria.persistencia;

import java.util.List;
import libreria.entidades.Cliente;
import libreria.entidades.Prestamo;

public class PrestamoDAO extends DAO<Prestamo> {

    /**
     * Guarda un Prestamo que recibe por parametro.
     *
     * @param prestamo
     */
    @Override
    public void guardar(Prestamo prestamo) {
        super.guardar(prestamo);
    }

    /**
     * Edita un Prestamo que recibe por parametro(ya tiene los valores nuevos).
     *
     * @param prestamo
     */
    @Override
    public void editar(Prestamo prestamo) {
        super.editar(prestamo);
    }

    /**
     * Elimina un Prestamo que recibe por parametro.
     *
     * @param prestamo
     */
    @Override
    public void eliminar(Prestamo prestamo) {
        super.eliminar(prestamo);
    }

    /**
     * Busca y devuelve un Prestamo por id.
     *
     * @param id
     * @return
     */
    public Prestamo buscarId(Integer id) {
        super.conectar();
        Prestamo prestamo = em.find(Prestamo.class, id);
        super.desconectar();
        return prestamo;
    }

    /**
     * Devuelve un listado con todos los prestamos en la base de datos.
     *
     * @return
     */
    public List<Prestamo> listarTodos() {
        super.conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p").getResultList();
        super.desconectar();
        return prestamos;
    }
        /**
         * Busca y devuelve un Listado de Libros por Nombre de Autor o
         * Editorial.
         *
         * @param cliente
         * @return
         */
    public List<Prestamo> buscarPorCliente(Cliente cliente) {
        super.conectar();
        List<Prestamo> prestamos = null;
        String sql = "";
        if (cliente != null) {
            sql = "SELECT p FROM Prestamo p WHERE p.cliente = :cliente";
            prestamos = em.createQuery(sql).setParameter("cliente", cliente).getResultList();
        }
        super.desconectar();
        return prestamos;
    }

}
