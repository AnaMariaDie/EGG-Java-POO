package libreria.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;

public class PrestamoService {

    private final PrestamoDAO DAO;
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    /*
    Para convertir la clase Date, necesitamos definir el formato esperado usando la clase SimpleDateFormat:
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Esta definición está especificando que esperamos una fecha que contenga día/mes/año.
    La conversión de String a Date la haremos a traves del método parse() del objeto formato:   
    Date dateFormateada = formato.parse(fechaDate);
     */
    public PrestamoService() {
        this.DAO = new PrestamoDAO();
    }

    /**
     * Crea un Prestamo y lo guarda en la base de datos.
     *
     * @param libroP
     * @param cliente
     */
    public void crearPrestamo(Libro libroP, Cliente cliente) {
        Prestamo prestamo = new Prestamo();
        try {
            System.out.println("Ingrese la fecha de Prestamo");
            String strFechaP = leer.next();
            Date fPrestamo = formato.parse(strFechaP);
            prestamo.setFechaPrestamo(validarFecha(fPrestamo));
            prestamo.setLibro(libroP);
            prestamo.setCliente(cliente);
            DAO.guardar(prestamo);
            System.out.println("Prestamo registrado exitosamente");
        } catch (ParseException pe) {
            System.out.println("Error al ingresar el Prestamo");
        } catch (Exception e) {
            System.out.println("Error al ingresar el Prestamo");
        }
    }

    /**
     * Edita un Prestamo que recibe por parametro.
     *
     * @param prestamo
     */
    public void editarPrestamo(Prestamo prestamo) {
        try {
            System.out.println("Ingrese la fecha de devolucion del Prestamo");
            String strFechaD = leer.next();
            Date fDevolucion = formato.parse(strFechaD);
            prestamo.setFechaDevolucion(validarFecha(fDevolucion));
            DAO.editar(prestamo);
        } catch (ParseException pe) {
            System.out.println("Error al ingresar el Prestamo");
        } catch (Exception e) {
            System.out.println("Error al ingresar el Prestamo");
        }
    }

    /**
     * Elimina un Prestamo por titulo.
     *
     * @param id
     * @return
     */
    public boolean eliminarId(Integer id) {
        try {
            Prestamo prestamo = DAO.buscarId(id);
            DAO.eliminar(prestamo);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
            return false;
        }
    }

    /**
     * Lista los Prestamos en la base de datos.
     *
     */
    public void listarPrestamos() {
        try {
            List<Prestamo> prestamos = DAO.listarTodos();
            mostrarPrestamos(prestamos);
        } catch (NullPointerException npe) {
            System.out.println("La base de datos esta vacia");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    /**
     * Mostrar los Prestamos que estan de Alta.
     *
     * @param prestamos
     */
    public void mostrarPrestamos(List<Prestamo> prestamos) {
        List<Prestamo> listado = prestamos;
        for (Prestamo prestamo : listado) {
            if (prestamo != null) {
                String fPres = formato.format(prestamo.getFechaPrestamo());
                String fDev = formato.format(prestamo.getFechaDevolucion());
                System.out.println("\n * Prestamo *\nId: " + prestamo.getId() + " Fecha Prestamo: " + fPres 
                        + " Fecha Devolucion: " + fDev + "\n" + prestamo.getLibro() + "\n" + prestamo.getCliente());
            }
        }
        System.out.println("");
    }

    /**
     * Busca el Prestamo, si ya se encuentra ingresado.
     *
     * @param id
     * @return
     */
    public Prestamo buscarId(Integer id) {
        Prestamo prestamo = null;
        try {
            prestamo = DAO.buscarId(id);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
        }
        return prestamo;
    }

    /**
     * Busca Libro por Nombre de Autor.
     *
     * @param cliente
     * @return
     */
    public List<Prestamo> buscarPorCliente(Cliente cliente) {
        List<Prestamo> prestamos = null;
        try {
            if (cliente == null) {
                System.out.println("No se encontro el Cliente");
            }
            prestamos = DAO.buscarPorCliente(cliente);
            mostrarPrestamos(prestamos);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
            e.printStackTrace();
        }
        return prestamos;
    }

    /**
     * Valida el Date de la fecha que recibe por parametro.
     *
     * @param date
     * @return
     */
    public Date validarFecha(Date date) {
        boolean salir = true;
        Date actual = new Date();
        Date fPrestamo = null;
        do {
            try {
                if (actual.before(date)) {
                    System.out.println("Debe ingresar una Fecha Valida, la misma no puede ser anterior a la fecha"
                            + " actual");
                    String strFechaP = leer.next();
                    fPrestamo = formato.parse(strFechaP);
                } else {
                    return date;
                }
            } catch (NullPointerException npe) {
                System.out.println("Error al ingresar comprobar fecha");
            } catch (Exception e) {
                System.out.println("Error al ingresar la fecha");
            }
        } while (salir);
        return fPrestamo;
    }

}
