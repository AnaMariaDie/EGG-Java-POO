package estancias.servicios;

import estancias.entidades.Casas;
import estancias.persistencia.CasasDAO;
import java.util.Collection;
import java.util.Date;

public class CasasService {

    private CasasDAO dao;

    public CasasService() {
        this.dao = new CasasDAO();
    }

    /**
     * Crear un Casa con todos los datos y guardarlo en la base de datos.
     * Sin id_casa porque es autoincremental.
     *
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param pais
     * @param ciudad
     * @param fechaDesde
     * @param fechaHasta
     * @param tiempoMinimo
     * @param tiempoMaximo
     * @param precioHabitacion
     * @param tipoVivienda
     * @throws Exception
     */
    public void crearCasa(String calle, int numero, String codigoPostal, String ciudad, String pais, 
            Date fechaDesde, Date fechaHasta, int tiempoMinimo, int tiempoMaximo, double precioHabitacion, 
            String tipoVivienda) throws Exception {
        try {
            if (calle == null || calle.trim().isEmpty()) {
                throw new Exception("Debe indicar una calle");
            }
            if (numero <= 0) {
                throw new Exception("Debe indicar un numero");
            }
            if (codigoPostal == null || codigoPostal.trim().isEmpty()) {
                throw new Exception("Debe indicar un codigo postal");
            }
            if (ciudad == null || ciudad.trim().isEmpty()) {
                throw new Exception("Debe indicar una ciudad");
            }
            if (pais == null || pais.trim().isEmpty()) {
                throw new Exception("Debe indicar un pais");
            }
            // Faltaria Validar las DATE
            if (tiempoMinimo <= 0) {
                throw new Exception("Debe indicar un tiempo minimo");
            }
            if (tiempoMaximo <= 0) {
                throw new Exception("Debe indicar un tiempo maximo");
            }
            if (precioHabitacion <= 0) {
                throw new Exception("Debe indicar un precio para la habitacion");
            }
            if (tipoVivienda == null || tipoVivienda.trim().isEmpty()) {
                throw new Exception("Debe indicar un tipo de vivienda");
            }
            Casas casa = new Casas();
            casa.setCalle(calle);
            casa.setNumero(numero);
            casa.setCodigoPostal(codigoPostal);
            casa.setCiudad(ciudad);
            casa.setPais(pais);
            casa.setFechaDesde(fechaDesde);
            casa.setFechaHasta(fechaHasta);
            casa.setTiempoMinimo(tiempoMinimo);
            casa.setTiempoMaximo(tiempoMaximo);
            casa.setPrecioHabitacion(precioHabitacion);
            casa.setTipoVivienda(tipoVivienda);
            dao.guardarCasa(casa);
            System.out.println("Casa creada");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un Casa de la Tabla de la Base de Datos.
     *
     * @param id_casa
     * @throws java.lang.Exception
     */
    public void eliminarCasa(int id_casa) throws Exception {
        try {
            if (id_casa < 0) {
                throw new Exception("Debe indicar una id_casa");
            }
            dao.eliminarCasa(id_casa);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un Casa con los valores que le ingresan.
     *
     * @param idCasa
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param pais
     * @param ciudad
     * @param fechaDesde
     * @param fechaHasta
     * @param tiempoMinimo
     * @param tiempoMaximo
     * @param precioHabitacion
     * @param tipoVivienda
     * @throws Exception
     */
    public void modificarCasa(int idCasa, String calle, int numero, String codigoPostal, String ciudad, String pais, 
            Date fechaDesde, Date fechaHasta, int tiempoMinimo, int tiempoMaximo, double precioHabitacion, 
            String tipoVivienda) throws Exception {
        try {
            if (calle == null || calle.trim().isEmpty()) {
                throw new Exception("Debe indicar una calle");
            }
            if (numero <= 0) {
                throw new Exception("Debe indicar un numero");
            }
            if (codigoPostal == null || codigoPostal.trim().isEmpty()) {
                throw new Exception("Debe indicar un codigo postal");
            }
            if (ciudad == null || ciudad.trim().isEmpty()) {
                throw new Exception("Debe indicar una ciudad");
            }
            if (pais == null || pais.trim().isEmpty()) {
                throw new Exception("Debe indicar un pais");
            }
            // Faltaria Validar las DATE
            if (tiempoMinimo <= 0) {
                throw new Exception("Debe indicar un tiempo minimo");
            }
            if (tiempoMaximo <= 0) {
                throw new Exception("Debe indicar un tiempo maximo");
            }
            if (precioHabitacion <= 0) {
                throw new Exception("Debe indicar un precio para la habitacion");
            }
            if (tipoVivienda == null || tipoVivienda.trim().isEmpty()) {
                throw new Exception("Debe indicar un tipo de vivienda");
            }
            Casas casa = buscarCasaPorIdCasa(idCasa);
            // Modifica el casa segun los parametros que recibe para pasarlo al dao y que lo 
            // modifique en la base de datos.
            casa.setCalle(calle);
            casa.setNumero(numero);
            casa.setCodigoPostal(codigoPostal);
            casa.setCiudad(ciudad);
            casa.setPais(pais);
            casa.setFechaDesde(fechaDesde);
            casa.setFechaHasta(fechaHasta);
            casa.setTiempoMinimo(tiempoMinimo);
            casa.setTiempoMaximo(tiempoMaximo);
            casa.setPrecioHabitacion(precioHabitacion);
            casa.setTipoVivienda(tipoVivienda);
            dao.modificarCasa(casa);
            System.out.println("Casa modificada");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Busca y devuelve un Casa a modificar.
     *
     * @param id_casa
     * @return
     * @throws java.lang.Exception
     */
    public Casas buscarCasaPorIdCasa(int id_casa) throws Exception {
        try {
            if (id_casa < 0) {
                throw new Exception("Debe indicar un Codigo");
            }
            Casas casa = dao.buscarCasaPorIdCasa(id_casa);
            if (casa == null) {
                throw new Exception("No se encontro Casas para el codigo indicado");
            }
            return casa;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Listar todos los Casas de la base de datos
     *
     * @return
     * @throws Exception
     */
    public Collection<Casas> listarCasas() throws Exception {
        try {
            Collection<Casas> casas = dao.listarCasas();
            return casas;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los casas que hay en la base de datos.
     *
     * @throws Exception
     */
    public void imprimirCasas() throws Exception {
        try {
            Collection<Casas> casas = listarCasas();
            if (casas.isEmpty()) {
                throw new Exception("No existen casas para imprimir");
            } else {
                for (Casas casa : casas) {
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla todos los casas que recibe por parametro.
     *
     * @param casas
     * @throws Exception
     */
    public void imprimirCasas(Collection<Casas> casas) throws Exception {
        try {
            if (casas.isEmpty()) {
                throw new Exception("No existen casas para imprimir");
            } else {
                for (Casas casa : casas) {
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
