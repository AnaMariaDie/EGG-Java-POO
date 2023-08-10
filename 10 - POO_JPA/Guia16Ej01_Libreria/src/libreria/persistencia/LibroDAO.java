package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroDAO extends DAO<Libro> {

    /**
     * El constructor vacio llama al constructor de la clase padre.
     */
    public LibroDAO() {
        super();
    }

    /**
     * Guarda un Libro que recibe por parametro.
     *
     * @param libro
     */
    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    /**
     * Edita un Libro que recibe por parametro(ya tiene los valores nuevos).
     *
     * @param libro
     */
    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }
    
    /**
     * Elimina un Libro que recibe por parametro.
     *
     * @param libro
     */
    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }

    /**
     * Elimina un Libro recibido por parametro. Setea el atributo alta en false si esta en true(ya que
     * estaria cargado)
     *
     * @param libro
     */
    public void baja(Libro libro) {
        super.conectar();
        if (libro.getAlta()) {
            libro.setAlta(false);
            super.editar(libro);
        } else {
            System.out.println("El Libro no se encuentra en la base de datos");
        }
        super.desconectar();
    }

    /**
     * Vuelve el atributo alta del Libro a true(alta). Se recorre todo el listado.
     *
     */
    public void alta() {
        super.conectar();
        List<Libro> libros = listarTodos();
        for (Libro libro : libros) {
            if (libro.getAlta() == false) {
                libro.setAlta(true);
                super.editar(libro);
            }
        }
        super.desconectar();
    }

    /**
     * Busca y devuelve un Libro por id.
     *
     * @param id_libro
     * @return
     */
    public Libro buscarId(Integer id_libro) {
        super.conectar();
        Libro libro = em.find(Libro.class, id_libro);
        super.desconectar();
        return libro;
    }

    /**
     * Busca y devuelve un Libro por titulo.
     *
     * @param variable
     * @return
     */
    public Libro buscarPorTitulo(String variable) {
        super.conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :variable")
                .setParameter("variable", variable).getSingleResult();
        super.desconectar();
        return libro;
    }

    /**
     * Busca y devuelve un Libro por ISBN.
     *
     * @param var
     * @return
     */
    public Libro buscarPorIsbn(Long var) {
        super.conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :var")
                .setParameter("var", var).getSingleResult();
        super.desconectar();
        return libro;
    }

    /**
     * Devuelve un listado con todos los libros en la base de datos.
     *
     * @return
     */
    public List<Libro> listarTodos() {
        super.conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        super.desconectar();
        return libros;
    }

    /**
     * Busca y devuelve un Listado de Libros por Nombre de Autor o Editorial.
     *
     * @param autor
     * @param editorial
     * @return
     */
    public List<Libro> buscarPorNombre(Autor autor, Editorial editorial) {
        super.conectar();
        List<Libro> libros = null;
        String sql = "";
        if (autor != null) {
            sql = "SELECT l FROM Libro l WHERE l.autor = :autor";
            libros = em.createQuery(sql).setParameter("autor", autor).getResultList();
        }
        if (editorial != null) {
            sql = "SELECT l FROM Libro l WHERE l.editorial = :editorial";
            libros = em.createQuery(sql).setParameter("editorial", editorial).getResultList();
        }
        super.desconectar();
        return libros;
    }

}
