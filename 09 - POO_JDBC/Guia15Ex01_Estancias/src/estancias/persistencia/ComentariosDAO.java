package estancias.persistencia;

import estancias.entidades.Comentarios;
import java.util.ArrayList;
import java.util.Collection;

public class ComentariosDAO extends DAO {
    
     /**
     * Guarda una Familia en la Tabla de la Base de Datos.
     *
     * @param comentario
     * @throws Exception
     */
    public void guardarComentario(Comentarios comentario) throws Exception {
        try {
            if (comentario == null) {
                throw new Exception("Debe indicar un Comentarioa");
            }
            String sql = "INSERT INTO comentarios (id_casa, comentario)"
                    + " VALUES (" + comentario.getIdCasa() + ", '" + comentario.getComentario() + "');";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Elimina una Familia de la base de datos segun el codigo recibido.
     *
     * @param id_comentario
     * @throws java.lang.Exception
     */
    public void eliminarComentario(int id_comentario) throws Exception {
        try {
            String sql = "DELETE FROM comentarios WHERE id_comentario = " + id_comentario + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Modifica una Familia segun los parametros que recibe.
     *
     * @param comentario
     * @throws java.lang.Exception
     */
    public void modificarComentario(Comentarios comentario) throws Exception {
        try {
            if (comentario == null) {
                throw new Exception("Debe indicar un Comentario que desea modificar");
            }
            String sql = "UPDATE comentarios SET id_casa = " + comentario.getIdCasa() + ", comentario = '" 
                    + comentario.getComentario() + "' WHERE id_comentario = " + comentario.getIdComentario() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Busca una Familia segun el codigo que recibe y lo devuelve.
     *
     * @param id_comentario
     * @return
     * @throws Exception
     */
    public Comentarios buscarComentarioPorIdComentario(int id_comentario) throws Exception {
        try {
            String sql = "SELECT * FROM comentarios WHERE id_comentario = " + id_comentario + ";";
            consultarBase(sql);
            Comentarios comentario = null;
            while (resultado.next()) {
                comentario = new Comentarios();
                comentario.setIdComentario(resultado.getInt(1));
                comentario.setIdCasa(resultado.getInt(2));
                comentario.setComentario(resultado.getNString(3));
            }
            desconectarBase();
            return comentario;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve una lista de los Familia con todos los valores de la base de
     * datos.
     *
     * @return
     * @throws Exception
     */
    public Collection<Comentarios> listarComentarios() throws Exception {
        try {
            String sql = "SELECT * FROM comentarios;";
            consultarBase(sql);
            Comentarios comentario = null;
            Collection<Comentarios> comentarios = new ArrayList();
            while (resultado.next()) {
                comentario = new Comentarios();
                comentario.setIdComentario(resultado.getInt(1));
                comentario.setIdCasa(resultado.getInt(2));
                comentario.setComentario(resultado.getNString(3));
                comentarios.add(comentario);
            }
            desconectarBase();
            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
