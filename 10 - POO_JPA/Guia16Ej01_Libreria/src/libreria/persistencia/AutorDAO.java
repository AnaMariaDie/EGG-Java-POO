package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    public AutorDAO() {
        super();
    }
    
    /**
     * Guarda un Autor que recibe por parametro.
     *
     * @param autor
     */
    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    /**
     * Edita un Autor que recibe por parametro(ya tiene los valores nuevos).
     *
     * @param autor
     */
    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }
    
    /**
     * Elimina un Autor que recibe por parametro. 
     *
     * @param autor
     */
    @Override
    public void eliminar(Autor autor) {
        super.eliminar(autor);    
    }

        /**
     * Elimina un Autor que recibe por parametro. Setea el atributo alta en false si esta en
     * true(ya que estaria cargado)
     *
     * @param Autor
     */
    public void baja(Autor Autor) { 
        super.conectar();
        if (Autor.getAlta()) {
            Autor.setAlta(false);
            super.editar(Autor);
        } else {
            System.out.println("El Autor no se encuentra en la base de datos");
        }
        super.desconectar();
    }
    
    /**
     * Vuelve el atributo alta del Autor a true(alta).
     *
     */
    public void alta() {
        super.conectar();
        List<Autor> autores = listarTodos();
        for (Autor autor : autores) {
            if (autor.getAlta() == false) {
                autor.setAlta(true);
                super.editar(autor);
            }
        }
        super.desconectar();
    }

    /**
     * Busca un Autor por id.
     *
     * @param id
     * @return
     */
    public Autor buscarId(Integer id) {
        super.conectar();
        Autor autor = em.find(Autor.class, id);;
        super.desconectar();
        return autor;
    }

    /**
     * Busca Autor por Nombre.
     *
     * @param variable
     * @return
     */
    public Autor buscarPorNombre(String variable) {
        super.conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :variable")
                .setParameter("variable", variable).getSingleResult();
        super.desconectar();
        return autor;
    }

    /**
     * Devuelve un listado con todos los Autores en la base de datos.
     *
     * @return
     */
    public List<Autor> listarTodos() {
        super.conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        super.desconectar();
        return autores;
    }
}
