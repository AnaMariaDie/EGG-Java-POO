package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorService {

    private final AutorDAO DAO;
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public AutorService() {
        this.DAO = new AutorDAO();
    }

    /**
     * Crea un Autor con valores recibidos por parametro y lo guarda en la base
     * de datos.
     *
     * @param nombre
     * @param alta
     * @return
     */
    public Autor crearAutor(String nombre, Boolean alta) {
        Autor autor = new Autor();
        try {
            autor.setNombre(nombre);
            autor.setAlta(alta);
            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println("Error al ingresar el Autor");
            return null;
        }
    }

    /**
     * Crea un Autor y lo guarda en la base de datos.
     *
     * @return
     */
    public Autor crearAutor() {
        Autor autor = null;
        try {
            System.out.println("Ingrese el nombre del Autor");
            String nombreAutor = leer.next();
            autor = validarAutor(nombreAutor);
            DAO.guardar(autor);
            System.out.println("Autor ingresado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al ingresar el Autor");
        }
        return autor;
    }

    /**
     * Busca y muestra el Autor con los valores actuales por ID y luego modifica
     * su nombre.
     */
    public void editarNombre() {
        try {
            System.out.println("Indique el Id de la Autor a modificar");
            Integer id = leer.nextInt();
            Autor autor = DAO.buscarId(id);
            System.out.println("Los valores actuales son: " + autor.toString());
            System.out.println("Ingrese el nuevo Nombre");
            autor.setNombre(leer.next());
            DAO.editar(autor);
            System.out.println("Nombre Autor modificado");
        } catch (Exception e) {
            System.out.println("No se pudo modificar");
        }
    }
    
    /**
     * Elimina un Autor por titulo.
     *
     * @param id
     * @return
     */
    public boolean eliminarId(Integer id) {
        try {
            Autor autor = DAO.buscarId(id);
            DAO.baja(autor);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
            return false;
        }
    }
    
    /**
     * Busca Autor por Nombre.
     *
     * @param nombre
     * @return
     */
    public Autor buscarPorNombre(String nombre) {
        try {
            Autor autor = DAO.buscarPorNombre(nombre);
            return autor;
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
            return null;
        }
    }

    /**
     * Retorna el atrubuto Alta a true.
     */
    public void alta() {
        try {
            DAO.alta();
        } catch (Exception e) {
            System.out.println("No se pudo modifical el Alta");
        }
    }
    
    /**
     * Lista los Autores en la base de datos.
     *
     */
    public void listarAutores() {
        try {
            List<Autor> autores = DAO.listarTodos();
            mostrarAutores(autores);
        } catch (NullPointerException npe) {
            System.out.println("La base de datos esta vacia");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    /**
     * Mostrar los Autores que estan de Alta.
     * @param autores 
     */
    public void mostrarAutores(List<Autor> autores) {
        List<Autor> listado = autores;
        for (Autor autor : listado) {
            if(autor.getAlta()) {
                System.out.println("\n * Autor *\nId: " + autor.getId() + " - Nombre: " + autor.getNombre());
            }
        }
        System.out.println("");
    }

    /**
     * Valida el Autor, si ya se encuentra ingresada.
     *
     * @param nombreAutor
     * @return
     */
    public Autor validarAutor(String nombreAutor) {
        // Carga del Autor
        boolean ingresarAutor = true; // se solicitan datos hasta ingresar autor.
        Autor autorNuevo = null;
        do {
            try {
                Autor autor = buscarPorNombre(nombreAutor);
                if (autor == null) {
                    autorNuevo = crearAutor(nombreAutor, true);
                    return autorNuevo;
                } else {
                    return autor;
                }
            } catch (Exception e) {
                System.out.println("No se ingreso el Autor");
            }
        } while (ingresarAutor);
        return autorNuevo;
    }
}