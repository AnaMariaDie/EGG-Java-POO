package estancias.servicios;

import estancias.entidades.Familias;
import estancias.persistencia.FamiliasDAO;
import java.util.Collection;

public class FamiliasService {

    private FamiliasDAO dao;

    public FamiliasService() {
        this.dao = new FamiliasDAO();
    }

    /**
     * Crear un Familia con todos los datos y guardarlo en la base de datos.
     * Sin id_familia porque es autoincremental.
     *
     * @param nombre
     * @param edadMinima
     * @param edadMaxima
     * @param numHijos
     * @param email
     * @param idCasaFamilia
     * @throws Exception
     */
    public void crearFamilia(String nombre, int edadMinima, int edadMaxima, int numHijos, String email, 
            int idCasaFamilia) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (edadMinima <= 0) {
                throw new Exception("Debe indicar una edad Minima");
            }
            if (edadMaxima <= 0) {
                throw new Exception("Debe indicar una edad Maxima");
            }
            if (numHijos <= 0) {
                throw new Exception("Debe indicar un numero de Hijos");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un email");
            }
            if (idCasaFamilia <= 0) {
                throw new Exception("Debe indicar un id Casa Familia");
            }
            Familias familia = new Familias();
            familia.setNombre(nombre);
            familia.setEdadMinima(edadMinima);
            familia.setEdadMaxima(edadMaxima);
            familia.setNumHijos(numHijos);
            familia.setEmail(email);
            familia.setIdCasaFamilia(idCasaFamilia);
            dao.guardarFamilia(familia);
            System.out.println("Familia creada");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un Familia de la Tabla de la Base de Datos.
     *
     * @param id_familia
     * @throws java.lang.Exception
     */
    public void eliminarFamilia(int id_familia) throws Exception {
        try {
            if (id_familia < 0) {
                throw new Exception("Debe indicar una id_familia");
            }
            dao.eliminarFamilia(id_familia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un Familia con los valores que le ingresan.
     *
     * @param idFamilia
     * @param nombre
     * @param edadMinima
     * @param edadMaxima
     * @param numHijos
     * @param email
     * @param idCasaFamilia
     * @throws Exception
     */
    public void modificarFamilia(int idFamilia, String nombre, int edadMinima, int edadMaxima, int numHijos, 
            String email, int idCasaFamilia) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (edadMinima <= 0) {
                throw new Exception("Debe indicar una edad Minima");
            }
            if (edadMaxima <= 0) {
                throw new Exception("Debe indicar una edad Maxima");
            }
            if (numHijos <= 0) {
                throw new Exception("Debe indicar un numero de Hijos");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe indicar un email");
            }
            if (idCasaFamilia <= 0) {
                throw new Exception("Debe indicar un id Casa Familia");
            }
            Familias familia = buscarFamiliaPorIdFamilia(idFamilia);
            // Modifica el familia segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            familia.setNombre(nombre);
            familia.setEdadMinima(edadMinima);
            familia.setEdadMaxima(edadMaxima);
            familia.setNumHijos(numHijos);
            familia.setEmail(email);
            familia.setIdCasaFamilia(idCasaFamilia);
            dao.modificarFamilia(familia);
            System.out.println("Familia modificada");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un Familia a modificar.
     *
     * @param idFamilia
     * @return
     * @throws java.lang.Exception
     */
    public Familias buscarFamiliaPorIdFamilia(int idFamilia) throws Exception {
        try {
            if (idFamilia < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Familias familia = dao.buscarFamiliaPorIdFamilia(idFamilia);
            if (familia == null) {
                throw new Exception("No se encontro Familias para el codigo indicado");
            }
            return familia;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los Familias de la base de datos
     *
     * @return
     * @throws Exception
     */
    public Collection<Familias> listarFamilias() throws Exception {
        try {
            Collection<Familias> familias = dao.listarFamilias();
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Familias que hay en la base de datos.
     *
     * @throws Exception
     */
    public void imprimirFamilias() throws Exception {
        try {
            Collection<Familias> familias = listarFamilias();
            if (familias.isEmpty()) {
                throw new Exception("No existen familias para imprimir");
            } else {
                for (Familias familia : familias) {
                    System.out.println(familia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Familias que recibe por parametro.
     *
     * @param familias
     * @throws Exception
     */
    public void imprimirFamilias(Collection<Familias> familias) throws Exception {
        try {
            if (familias.isEmpty()) {
                throw new Exception("No existen familias para imprimir");
            } else {
                for (Familias familia : familias) {
                    System.out.println(familia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
        /**
     * Listar todos los Familias de la base de datos
     *
     * @throws Exception
     */
    public void listarFamHijosEdadMax() throws Exception {
        try {
            Collection<Familias> familias = dao.listarFamilias();
            for (Familias familia : familias) {
            System.out.println(familia.toString());
        }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Retorna un Listado de Familias que contengan "HOTMAIL" em su email.
     * @return
     * @throws Exception 
     */
    public Collection<Familias> buscarFamiliaPorEmail() throws Exception {
        try {
            Collection<Familias> familias = dao.buscarFamiliaPorEmail();
            return familias;
        } catch (Exception e) {
            throw e;
        }
    }
}
