package estancias.persistencia;

import estancias.entidades.Familias;
import java.util.ArrayList;
import java.util.Collection;

public class FamiliasDAO extends DAO {

    /**
     * Guarda una Familia en la Tabla de la Base de Datos.
     *
     * @param familia
     * @throws Exception
     */
    public void guardarFamilia(Familias familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar una Familia");
            }
            String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia)"
                    + " VALUES ('" + familia.getNombre() + "', " + familia.getEdadMinima() + ", " + 
                    familia.getEdadMaxima() + ", " + familia.getNumHijos() + ", '" + 
                    familia.getEmail() + "', " + familia.getIdCasaFamilia() + ");";
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
     * @param id_familia
     * @throws java.lang.Exception
     */
    public void eliminarFamilia(int id_familia) throws Exception {
        try {
            String sql = "DELETE FROM familias WHERE id_familia = " + id_familia + ";";
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
     * @param familia
     * @throws java.lang.Exception
     */
    public void modificarFamilia(Familias familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar una Familia que desea modificar");
            }
            String sql = "UPDATE familias SET nombre = '" + familia.getNombre() + "', edad_minima = "
                    + familia.getEdadMinima() + ", edad_maxima = " + familia.getEdadMaxima() + 
                    ", num_hijos = " + familia.getNumHijos() + ", email = '" + familia.getEmail()
                    + "', id_casa_familia = " + familia.getIdCasaFamilia() + " WHERE id_familia = " 
                    + familia.getIdFamilia() + ";";
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
     * @param id_familia
     * @return
     * @throws Exception
     */
    public Familias buscarFamiliaPorIdFamilia(int id_familia) throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE id_familia = " + id_familia + ";";
            consultarBase(sql);
            Familias familia = null;
            while (resultado.next()) {
                familia = new Familias();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getNString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
            }
            desconectarBase();
            return familia;
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
    public Collection<Familias> listarFamilias() throws Exception {
        try {
            String sql = "SELECT * FROM familias;";
            consultarBase(sql);
            Familias familia = null;
            Collection<Familias> familias = new ArrayList();
            while (resultado.next()) {
                familia = new Familias();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getNString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Familias> listaFamHijosEdad() throws Exception {
        try {
            String query = "Select * FROM familias WHERE num_hijos >=3 AND edad_maxima < 10";
            consultarBase(query);
            Collection<Familias> arrayFam = new ArrayList();
            while (resultado.next()) {
                Familias familia = new Familias();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getNString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
                arrayFam.add(familia);
            }
            desconectarBase();
            return arrayFam;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    /**
     * Retorna un Listado de Familias que contengan "HOTMAIL" en su email.
     * @return
     * @throws Exception 
     */
    public Collection<Familias> buscarFamiliaPorEmail() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE email LIKE '%hotmail%';";
            consultarBase(sql);
            Collection<Familias> arrayFam = new ArrayList();
            while (resultado.next()) {
                Familias familia = new Familias();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getNString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
                arrayFam.add(familia);
            }
            desconectarBase();
            return arrayFam;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
