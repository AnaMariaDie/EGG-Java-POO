package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public FabricanteDAO() {
    }

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un Fabricante");
            }
            String sql = "INSERT INTO fabricante(codigo, nombre) " + "VALUES (" + fabricante.getCodigo()
                    + ", '" + fabricante.getNombre() + "');";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Elimina un fabricante de la base de datos segun el codigo recibido.
     *
     * @param codigo
     * @throws Exception
     */
    public void eliminarFabricante(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Modifica un fabricante segun los parametros que recibe.
     *
     * @param fabricante
     * @throws java.lang.Exception
     */
    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE fabricante SET nombre = '" + fabricante.getNombre() + "' WHERE codigo = " + 
                    fabricante.getCodigo() + ";";
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Busca un fabricante segun el codigo que recibe y lo devuelve.
     *
     * @param codigo
     * @return
     * @throws java.lang.Exception
     */
    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = " + codigo + ";";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve una lista de los fabricantes con todos los valores de la base de datos.
     * @return 
     * @throws java.lang.Exception 
     */
    public Collection<Fabricante> listarfabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante;";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
