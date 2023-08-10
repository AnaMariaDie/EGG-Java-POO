package estancias.persistencia;

import estancias.entidades.Casas;
import java.util.ArrayList;
import java.util.Collection;

public class CasasDAO extends DAO {

    /**
     * Guarda una Casa en la Tabla de la Base de Datos.
     *
     * @param casa
     * @throws Exception
     */
    public void guardarCasa(Casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar una Casa");
            }
            String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, "
                    + "tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda)" + " VALUES ('" 
                    + casa.getCalle() + "', " + casa.getNumero() + ", '" + casa.getCodigoPostal() + "', '" + 
                    casa.getCiudad()+ "', '" + casa.getPais() + "', '" + casa.getFechaDesde() + "', '" + 
                    casa.getFechaHasta() + "', " + casa.getTiempoMinimo() + ", " + casa.getTiempoMaximo() + 
                    ", " + casa.getPrecioHabitacion() + ", '" + casa.getTipoVivienda() + "');";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Elimina una Casa de la base de datos segun el codigo recibido.
     *
     * @param id_casa
     * @throws java.lang.Exception
     */
    public void eliminarCasa(int id_casa) throws Exception {
        try {
            String sql = "DELETE FROM casas WHERE id_casa = " + id_casa + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Modifica una Casa segun los parametros que recibe.
     *
     * @param casa
     * @throws java.lang.Exception
     */
    public void modificarCasa(Casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar una Casa que desea modificar");
            }
            String sql = "UPDATE casas SET calle = '" + casa.getCalle()+ "', numero = " + casa.getNumero() + 
                    ", codigo_postal = '" + casa.getCodigoPostal() + "', ciudad = '" + casa.getCiudad() + 
                    "', pais = '" + casa.getPais() + "', fecha_desde = '" + casa.getFechaDesde() + 
                    "', fecha_hasta = '" + casa.getFechaHasta() + "', tiempo_minimo = " + casa.getTiempoMinimo() +
                    ", tiempo_maximo = " + casa.getTiempoMaximo() + ", precio_habitacion = " + 
                    casa.getPrecioHabitacion() + ", tipo_vivienda = '" + casa.getTipoVivienda() + 
                    "' WHERE id_casa = " + casa.getIdCasa() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    /**
     * Busca una Casa segun el codigo que recibe y lo devuelve.
     *
     * @param id_casa
     * @return
     * @throws Exception
     */
    public Casas buscarCasaPorIdCasa(int id_casa) throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE id_casa = " + id_casa + ";";
            consultarBase(sql);
            Casas casa = null;
            while (resultado.next()) {
                casa = new Casas();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
            }
            desconectarBase();
            return casa;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    /**
     * Devuelve una lista de los Casa con todos los valores de la base de
     * datos.
     *
     * @return
     * @throws Exception
     */
    public Collection<Casas> listarCasas() throws Exception {
        try {
            String sql = "SELECT * FROM casas;";
            consultarBase(sql);
            Casas casa = null;
            Collection<Casas> casas = new ArrayList();
            while (resultado.next()) {
                casa = new Casas();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
     
}
