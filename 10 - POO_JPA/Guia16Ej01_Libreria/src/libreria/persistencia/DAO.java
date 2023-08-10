package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    protected final EntityManagerFactory EMF;
    protected EntityManager em;

    /**
     * El constructor vacio inicializa las Entidades.
     */
    public DAO() {
        EMF = Persistence.createEntityManagerFactory("LibreriaPU");
        em = EMF.createEntityManager();
    }

    /**
     * Realiza la conexion con la base de datos si no esta conectada.
     */
    protected void conectar() {
        try {
            if (!em.isOpen()) {
                em = EMF.createEntityManager();
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Desconecta la base de datos, verificando previamente si esta conectada.
     * Cierra la conexion y desconecta.
     */
    protected void desconectar() {
        try {
            if (em.isOpen()) {
                em.close();
            }
        } catch (Exception e) {
            System.out.println("No se pudo desconectar");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que guarda un objeto que recibe por parametro en la base de datos.
     * El rollback es para indicarle que si la transaccion quedo abierta se
     * ejecuta un rollback indicando que lo que se llego a hacer se ignore.
     *
     * @param obj
     */
    protected void guardar(T obj) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo guardar");
            System.out.println(e.getMessage());
        } finally {
            desconectar();
        }
    }

    /**
     * Metodo que modifica un objeto de la base de datos, recibido por parametro
     * .
     *
     * @param obj
     */
    protected void editar(T obj) {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo editar");
            System.out.println(e.getMessage());
        } finally {
            desconectar();
        }
    }

    /**
     * Metodo que elimina un objeto de la base de datos, recibido por parametro.
     * Realizamos un merge en un nuevo objeto para que el entity manager lo este
     * manejando y nos permita eliminarlo.
     *
     * @param obj
     */
    protected void eliminar(T obj) {
        try {
            conectar();
            em.getTransaction().begin();
            Object o = em.merge(obj);
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("No se pudo eliminar");
            System.out.println(e.getMessage());
        } finally {
            desconectar();
        }
    }

}
