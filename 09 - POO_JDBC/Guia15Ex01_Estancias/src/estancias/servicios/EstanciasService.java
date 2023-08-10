package estancias.servicios;

import estancias.entidades.Estancias;
import estancias.persistencia.EstanciasDAO;
import java.util.Collection;
import java.util.Date;

public class EstanciasService {

    private EstanciasDAO dao;

    public EstanciasService() {
        this.dao = new EstanciasDAO();
    }

    /**
     * Crear un Estancia con todos los datos y guardarlo en la base de datos.
     * Sin id_estancia porque es autoincremental.
     *
     * @param idCliente
     * @param idCasa
     * @param nombreHuesped
     * @param fechaDesde
     * @param fechaHasta
     * @throws Exception
     */
    public void crearEstancia(int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, 
            Date fechaHasta) throws Exception {
        try {
            if (idCliente <= 0) {
                throw new Exception("Debe indicar un id Cliente");
            }
            if (idCasa <= 0) {
                throw new Exception("Debe indicar un id Casa");
            }
            if (nombreHuesped == null || nombreHuesped.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre Huesped");
            }
            // Faltaria Validar las DATE
            Estancias estancia = new Estancias();
            estancia.setIdCliente(idCliente);
            estancia.setIdCasa(idCasa);
            estancia.setNombreHuesped(nombreHuesped);
            estancia.setFechaDesde(fechaDesde);
            estancia.setFechaHasta(fechaHasta);
            dao.guardarEstancia(estancia);
            System.out.println("Estancia creada");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un Estancia de la Tabla de la Base de Datos.
     *
     * @param id_estancia
     * @throws java.lang.Exception
     */
    public void eliminarEstancia(int id_estancia) throws Exception {
        try {
            if (id_estancia < 0) {
                throw new Exception("Debe indicar una id_estancia");
            }
            dao.eliminarEstancia(id_estancia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un Estancia con los valores que le ingresan.
     *
     * @param idEstancia
     * @param idCliente
     * @param idCasa
     * @param nombreHuesped
     * @param fechaDesde
     * @param fechaHasta
     * @throws Exception
     */
    public void modificarEstancia(int idEstancia, int idCliente, int idCasa, String nombreHuesped, Date fechaDesde, 
            Date fechaHasta) throws Exception {
        try {
            if (idCliente <= 0) {
                throw new Exception("Debe indicar un id Cliente");
            }
            if (idCasa <= 0) {
                throw new Exception("Debe indicar un id Casa");
            }
            if (nombreHuesped == null || nombreHuesped.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre Huesped");
            }
            // Faltaria Validar las DATE
            Estancias estancia = buscarEstanciaPorIdEstancia(idCasa);
            // Modifica el estancia segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            estancia.setIdCliente(idCliente);
            estancia.setIdCasa(idCasa);
            estancia.setNombreHuesped(nombreHuesped);
            estancia.setFechaDesde(fechaDesde);
            estancia.setFechaHasta(fechaHasta);
            dao.modificarEstancia(estancia);
            System.out.println("Estancia modificada");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un Estancia a modificar.
     *
     * @param id_estancia
     * @return
     * @throws java.lang.Exception
     */
    public Estancias buscarEstanciaPorIdEstancia(int id_estancia) throws Exception {
        try {
            if (id_estancia < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Estancias estancia = dao.buscarEstanciaPorIdEstancia(id_estancia);
            if (estancia == null) {
                throw new Exception("No se encontro Estancias para el codigo indicado");
            }
            return estancia;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los Estancias de la base de datos
     *
     * @return
     * @throws Exception
     */
    public Collection<Estancias> listarEstancias() throws Exception {
        try {
            Collection<Estancias> estancias = dao.listarEstancias();
            return estancias;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Estancias que hay en la base de datos.
     *
     * @throws Exception
     */
    public void imprimirEstancias() throws Exception {
        try {
            Collection<Estancias> estancias = listarEstancias();
            if (estancias.isEmpty()) {
                throw new Exception("No existen estancias para imprimir");
            } else {
                for (Estancias estancia : estancias) {
                    System.out.println(estancia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los Estancias que recibe por parametro.
     *
     * @param estancias
     * @throws Exception
     */
    public void imprimirEstancias(Collection<Estancias> estancias) throws Exception {
        try {
            if (estancias.isEmpty()) {
                throw new Exception("No existen estancias para imprimir");
            } else {
                for (Estancias estancia : estancias) {
                    System.out.println(estancia.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
