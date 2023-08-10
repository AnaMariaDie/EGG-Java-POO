package estancias.servicios;

import estancias.entidades.Comentarios;
import estancias.persistencia.ComentariosDAO;
import java.util.Collection;

public class ComentariosService {

    private ComentariosDAO dao;

    public ComentariosService() {
        this.dao = new ComentariosDAO();
    }

    /**
     * Crear un Comentario con todos los datos y guardarlo en la base de datos.
     * Sin id_comentario porque es autoincremental.
     *
     * @param idCasa
     * @param comentario
     * @throws Exception
     */
    public void crearComentario(int idCasa, String comentario) throws Exception {
        try {
            if (idCasa <= 0) {
                throw new Exception("Debe indicar un id Casa");
            }
            if (comentario == null || comentario.trim().isEmpty()) {
                throw new Exception("Debe indicar un comentario");
            }
            Comentarios comentario1 = new Comentarios();
            comentario1.setIdCasa(idCasa);
            comentario1.setComentario(comentario);
            dao.guardarComentario(comentario1);
            System.out.println("Comentario creado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un Comentario de la Tabla de la Base de Datos.
     *
     * @param id_comentario
     * @throws java.lang.Exception
     */
    public void eliminarComentario(int id_comentario) throws Exception {
        try {
            if (id_comentario < 0) {
                throw new Exception("Debe indicar una id_comentario");
            }
            dao.eliminarComentario(id_comentario);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un Comentario con los valores que le ingresan.
     *
     * @param idComentario
     * @param idCasa
     * @param comentario
     * @throws Exception
     */
    public void modificarComentario(int idComentario, int idCasa, String comentario) throws Exception {
        try {
            if (idCasa <= 0) {
                throw new Exception("Debe indicar un id Casa");
            }
            if (comentario == null || comentario.trim().isEmpty()) {
                throw new Exception("Debe indicar un comentario");
            }
            Comentarios comentario1 = buscarComentarioPorIdComentario(idCasa);
            // Modifica el comentario segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            comentario1.setIdCasa(idCasa);
            comentario1.setComentario(comentario);
            dao.modificarComentario(comentario1);
            System.out.println("Comentario modificado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un Comentario a modificar.
     *
     * @param id_comentario
     * @return
     * @throws java.lang.Exception
     */
    public Comentarios buscarComentarioPorIdComentario(int id_comentario) throws Exception {
        try {
            if (id_comentario < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Comentarios comentario = dao.buscarComentarioPorIdComentario(id_comentario);
            if (comentario == null) {
                throw new Exception("No se encontro Comentarios para el codigo indicado");
            }
            return comentario;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los Comentarios de la base de datos
     *
     * @return
     * @throws Exception
     */
    public Collection<Comentarios> listarComentarios() throws Exception {
        try {
            Collection<Comentarios> comentarios = dao.listarComentarios();
            return comentarios;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Comentarios que hay en la base de datos.
     *
     * @throws Exception
     */
    public void imprimirComentarios() throws Exception {
        try {
            Collection<Comentarios> comentarios = listarComentarios();
            if (comentarios.isEmpty()) {
                throw new Exception("No existen comentarios para imprimir");
            } else {
                for (Comentarios comentario : comentarios) {
                    System.out.println(comentario.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Comentarios que recibe por parametro.
     *
     * @param comentarios
     * @throws Exception
     */
    public void imprimirComentarios(Collection<Comentarios> comentarios) throws Exception {
        try {
            if (comentarios.isEmpty()) {
                throw new Exception("No existen comentarios para imprimir");
            } else {
                for (Comentarios comentario : comentarios) {
                    System.out.println(comentario.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
