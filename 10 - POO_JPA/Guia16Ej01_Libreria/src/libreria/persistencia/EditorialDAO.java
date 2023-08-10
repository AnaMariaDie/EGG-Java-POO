package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    public EditorialDAO() {
        super();
    }

    /**
     * Guarda una Editorial que recibe por parametro.
     *
     * @param editorial
     */
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }
    
    /**
     * Edita una Editorial que recibe por parametro(ya tiene los valores
     * nuevos).
     *
     * @param editorial
     */
    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial);
    }
    
    /**
     * Elimina una Editorial que recibe por parametro. 
     *
     * @param editorial
     */
    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial);
    }

        /**
     * Elimina un Editorial que recibe por parametro. Setea el atributo alta en false si esta en
     * true(ya que estaria cargado)
     *
     * @param editorial
     */
    public void baja(Editorial editorial) {   
        super.conectar();
        if (editorial.getAlta()) {
            editorial.setAlta(false);
            super.editar(editorial);
        } else {
            System.out.println("El Editorial no se encuentra en la base de datos");
        }
        super.desconectar();
    }
    
    /**
     * Vuelve el atributo alta de la Editorial a true(alta).
     *
     */
    public void alta() {
        super.conectar();
        List<Editorial> editoriales = listarTodos();
        for (Editorial editorial : editoriales) {
            if (editorial.getAlta() == false) {
                editorial.setAlta(true);
                super.editar(editorial);
            }
        }
        super.desconectar();
    }

    /**
     * Busca una Editorial por id.
     *
     * @param id
     * @return
     */
    public Editorial buscarId(Integer id) {
        super.conectar();
        Editorial editorial = em.find(Editorial.class, id);
        super.desconectar();
        return editorial;
    }
    
    /**
     * Busca Editorial por Nombre.
     *
     * @param variable
     * @return
     */
    public Editorial buscarPorNombre(String variable) {
        super.conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :variable")
                .setParameter("variable", variable).getSingleResult();
        super.desconectar();
        return editorial;
    }

    /**
     * Devuelve un listado con todos los editoriales en la base de datos.
     *
     * @return
     */
    public List<Editorial> listarTodos() {
        super.conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        super.desconectar();
        return editoriales;
    }
}
