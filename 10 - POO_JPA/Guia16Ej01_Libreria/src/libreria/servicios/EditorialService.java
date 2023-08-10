package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialService {

    private final EditorialDAO DAO;
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public EditorialService() {
        this.DAO = new EditorialDAO();
    }

    /**
     * Crea una Editorial con valores recibidos por parametro y lo guarda en la
     * base de datos.
     *
     * @param nombre
     * @param alta
     * @return
     */
    public Editorial crearEditorial(String nombre, Boolean alta) {
        Editorial editorial = new Editorial();
        try {
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            DAO.guardar(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println("Error al ingresar la Editorial");
            return null;
        }
    }

    /**
     * Crea una Editorial y lo guarda en la base de datos.
     *
     * @return
     */
    public Editorial crearEditorial() {
        Editorial editorial = null;
        try {
            System.out.println("Ingrese el nombre de la Editorial");
            String nombreEditorial = leer.next();
            editorial = validarEditorial(nombreEditorial);
            DAO.guardar(editorial);
            System.out.println("Editorial ingresada exitosamente");
        } catch (Exception e) {
            System.out.println("Error al ingresar la Editorial");
        }
        return editorial;
    }

    /**
     * Busca y muestra la Editorial con los valores actuales por ID y luego
     * modigica su nombre.
     */
    public void editarNombre() {
        try {
            System.out.println("Indique el Id de la Editorial a modificar");
            Integer id = leer.nextInt();
            Editorial editorial = DAO.buscarId(id);
            System.out.println("Los valores actuales son: " + editorial.toString());
            System.out.println("Ingrese el nuevo Nombre");
            editorial.setNombre(leer.next());
            DAO.editar(editorial);
            System.out.println("Nombre Editorial modificado");
        } catch (Exception e) {
            System.out.println("No se pudo modificar");
        }
    }
    
    /**
     * Elimina una Editorial por titulo.
     *
     * @param id
     * @return
     */
    public boolean eliminarId(Integer id) {
        try {
            Editorial editorial = DAO.buscarId(id);
            DAO.baja(editorial);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
            return false;
        }
    }
    
    /**
     * Busca Editorial por Nombre.
     *
     * @param nombre
     * @return
     */
    public Editorial buscarPorNombre(String nombre) {
        try {
            Editorial editorial = DAO.buscarPorNombre(nombre);
            return editorial;
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
     * Lista las Editoriales en la base de datos.
     *
     */
    public void listarEditoriales() {
        try {
            List<Editorial> editoriales = DAO.listarTodos();
            mostrarEditoriales(editoriales);
        } catch (NullPointerException npe) {
            System.out.println("La base de datos esta vacia");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    /**
     * Mostrar las Editoriales que estan de Alta.
     * @param editoriales 
     */
    public void mostrarEditoriales(List<Editorial> editoriales) {
        List<Editorial> listado = editoriales;
        for (Editorial editorial : listado) {
            if(editorial.getAlta()) {
                System.out.println("\n * Editorial *\nId: " + editorial.getId() + " - Nombre: " + editorial.getNombre());
            }
        }
        System.out.println("");
    }
    
    /**
     * Valida la Editorial, si ya se encuentra ingreada.
     *
     * @param nombreEditorial
     * @return
     */
    public Editorial validarEditorial(String nombreEditorial) {
        // Carga de la Editorial
        int i = 0;
        boolean ingresarEditorial = true; // se solicitan datos hasta ingresar editorial.
        Editorial editorialNueva = null;
        do {
            try {
                Editorial editorial = buscarPorNombre(nombreEditorial);
                if (editorial == null) {
                    editorialNueva = crearEditorial(nombreEditorial, true);
                    return editorialNueva;
                } else {
                    return editorial;
                }
            } catch (Exception e) {
                System.out.println("No se ingreso la Editorial");
            }
        } while (ingresarEditorial);
        return editorialNueva;
    }
}
