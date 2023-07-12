package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteService {

    private FabricanteDAO dao;

    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }

    /**
     * Crea un fabricante nuevo con los parametros que recibe.
     * @param codigo
     * @param nombre
     * @throws Exception 
     */
    public void crearFabricante(Integer codigo, String nombre) throws Exception {
        try {
            if (codigo == null) {
                throw new Exception("Debe indicar un codigo");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
            System.out.println("Fabricante creado");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un fabricante de la Tabla de la Base de Datos.
     * @param codigo
     * @throws java.lang.Exception
     */
    public void eliminarFabricante(Integer codigo) throws Exception {
        try {
            if (codigo < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e; 
        }
    }
    
    /**
     * Modifica un fabricante con los valores que le ingresan.
     * @param codigo
     * @param nombre
     * @throws Exception 
     */
    public void modificarFabricante(Integer codigo, String nombre) throws Exception {
        try {
            if (codigo == null || codigo < 0) {
                throw new Exception("Debe indicar un codigo");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            Fabricante fabricante = buscarFabricantePorCodigo(codigo);
            // Modifica el producto que recibe segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            dao.modificarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un fabricante a modificar.
     * @param codigo
     * @return
     * @throws Exception 
     */
    private Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        try {
            if (codigo < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);
            if (fabricante == null) {
                throw new Exception("No se encontro Producto para el codigo indicado");
            }
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Imprime por pantalla todos los fabricantes que hay en la base de datos.
     * @throws Exception 
     */
    public void imprimirFabricante() throws Exception {
        try {
            Collection<Fabricante> fabricantes = listarFabricantes();
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Fabricante fabricante : fabricantes) {
                    System.out.println(fabricante.toString());
                }
            }
        } catch (Exception e) {
            throw e; 
        }
    }

    /**
     * Imprime por pantalla todos los fabricantes que recibe por parametro.
     * @param fabricantes
     * @throws Exception 
     */
    public void imprimirFabricante(Collection<Fabricante> fabricantes) throws Exception {
        try {
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Fabricante fabricante : fabricantes) {
                    System.out.println(fabricante.toString());
                }
            }
        } catch (Exception e) {
            throw e; 
        }
    }
    
    /**
     * Lista los fabricantes de la base de datos.
     * @return 
     */
    private Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            Collection<Fabricante> fabricantes = dao.listarfabricantes();
            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }
}
