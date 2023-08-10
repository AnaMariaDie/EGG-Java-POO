package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private AutorService autorService;
    private EditorialService editorialService;
    private final LibroDAO DAO;

    public LibroService() {
        this.DAO = new LibroDAO();
        this.autorService = new AutorService();
        this.editorialService = new EditorialService();
    }

    /**
     * Crea un Libro con valores solicitados y lo guarda en la base de datos.
     *
     */
    public void crearLibro() {
        Libro libro = new Libro();
        try {
            System.out.println("Ingrese el Titulo del Libro");
            String titulo = leer.next();
            Libro libroBase = buscarPorTitulo(titulo);
            if (libroBase == null) {
                libro.setTitulo(titulo);
            } else {
                System.out.println("El titulo ya se encuentra en existencia\nA continuacion se detallan los datos");
                System.out.println(libroBase.toString());
            }
            System.out.println("Ingrese el codigo ISBN del libro");
            Long isbn = leer.nextLong();
            libro.setIsbn(validarIsbn(isbn));
            System.out.println("Ingrese el año de Edicion");
            Integer anio = leer.nextInt();
            libro.setAnio(validarAnio(anio));
            System.out.println("Ingrese la cantidad de ejemplares");
            Integer ejemplares = leer.nextInt();
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(0);
            libro.setEjemplaresRestantes(ejemplares);
            System.out.println("Ingrese el nombre del Autor");
            String nombreAutor = leer.next();
            libro.setAutor(validarAutor(nombreAutor));
            System.out.println("Ingrese el nombre de la Editorial");
            String nombreEditorial = leer.next();
            libro.setEditorial(validarEditorial(nombreEditorial));
            libro.setAlta(true);
            DAO.guardar(libro);
            System.out.println("Libro ingresado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al ingresar el Libro");
        }
    }

    /**
     * Busca y muestra el Libro con los valores actuales por ID y luego modigica
     * su nombre.
     */
    public void editarTitulo() {
        try {
            System.out.println("Indique el Id de la Libro a modificar");
            Integer id = leer.nextInt();
            Libro libro = DAO.buscarId(id);
            System.out.println("Los valores actuales son: " + libro.toString());
            System.out.println("Ingrese el nuevo Titulo");
            libro.setTitulo(leer.next());
            DAO.editar(libro);
            System.out.println("Titulo Libro modificado");
        } catch (Exception e) {
            System.out.println("No se pudo modificar");
        }
    }

    /**
     * Elimina un Libro por titulo.
     *
     * @param id
     * @return
     */
    public boolean eliminarId(Integer id) {
        try {
            Libro libro = DAO.buscarId(id);
            DAO.baja(libro);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
            return false;
        }
    }

    /**
     * Busca Libro por Titulo.
     *
     * @param titulo
     * @return
     */
    public Libro buscarPorTitulo(String titulo) {
        Libro libro = null;
        try {
            libro = DAO.buscarPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
        }
        return libro;
    }

    /**
     * Busca Libro por Id.
     *
     * @param id
     * @return
     */
    public Libro buscarId(Integer id) {
        Libro libro = null;
        try {
            libro = DAO.buscarId(id);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
        }
        return libro;
    }

    /**
     * Busca Libro por ISBN.
     *
     * @param isbn
     * @return
     */
    public Libro buscarPorIsbn(Long isbn) {
        Libro libro = null;
        try {
            libro = DAO.buscarPorIsbn(isbn);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
        }
        return libro;
    }

    /**
     * Busca Libro por Nombre de Autor.
     *
     * @param entidad
     * @param nombre
     * @return
     */
    public List<Libro> buscarPorNombre(String entidad, String nombre) {
        List<Libro> libros = null;
        try {
            Autor autor = null;
            Editorial editorial = null;
            if (entidad.equalsIgnoreCase("Autor")) {
                autor = autorService.buscarPorNombre(nombre);
            }
            if (entidad.equalsIgnoreCase("Editorial")) {
                editorial = editorialService.buscarPorNombre(nombre);
            }
            libros = DAO.buscarPorNombre(autor, editorial);
            mostrarLibros(libros);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
            e.printStackTrace();
        }
        return libros;
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
     * Lista los Libros en la base de datos.
     *
     */
    public void listarLibros() {
        try {
            List<Libro> libros = DAO.listarTodos();
            mostrarLibros(libros);
        } catch (NullPointerException npe) {
            System.out.println("La base de datos esta vacia");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    /**
     * Mostrar los Libros que estan de Alta.
     *
     * @param libros
     */
    public void mostrarLibros(List<Libro> libros) {
        List<Libro> listado = libros;
        for (Libro libro : listado) {
            if (libro.getAlta()) {
                System.out.println("\n * Libro *\nId: " + libro.getId() + " - Titulo: " + libro.getTitulo() + " - Año: "
                        + libro.getAnio() + "\nEjemplares: " + libro.getEjemplares() + " - Ejemplares Prestados: "
                        + libro.getEjemplaresPrestados() + " - Ejemplares Restantes: " + libro.getEjemplaresRestantes()
                        + libro.getAutor() + libro.getEditorial());
            }
        }
        System.out.println("");
    }

    /**
     * Valida el Codigo ISBN.
     *
     * @param isbn
     * @return
     */
    public Long validarIsbn(Long isbn) {
        boolean salir = true;
        do {
            try {
                if (isbn == 0) {
                    System.out.println("Debe ingresar un Codigo Valido");
                    isbn = leer.nextLong();
                } else {
                    return isbn;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar el Codigo");
            }
        } while (salir);
        return isbn;
    }

    /**
     * Valida el año.
     *
     * @param anio
     * @return
     */
    public Integer validarAnio(Integer anio) {
        boolean salir = true;
        do {
            try {
                if (anio == 0 || anio > 2023) {
                    System.out.println("Debe ingresar un Año Valido");
                    anio = leer.nextInt();
                } else {
                    return anio;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar el Año");
            }
        } while (salir);
        return anio;
    }

    /**
     * Valida el Autor, si ya se encuentra ingresada.
     *
     * @param nombreAutor
     * @return
     */
    public Autor validarAutor(String nombreAutor) {
        Autor autor = autorService.validarAutor(nombreAutor);
        return autor;
    }

    /**
     * Valida la Editorial, si ya se encuentra ingreada.
     *
     * @param nombreEditorial
     * @return
     */
    public Editorial validarEditorial(String nombreEditorial) {
        Editorial editorial = editorialService.validarEditorial(nombreEditorial);
        return editorial;
    }

    /**
     * Prestamo de Libro. Si hay ejemplares restantes se permite el prestamo
     * agregando a prestados y restando de restantes.
     *
     * @param libro
     */
    public void prestarLibro(Libro libro) {
        try {
            if (libro.getEjemplaresRestantes() != 0) {
                libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
                libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
                DAO.editar(libro);
            } else {
                System.out.println("No quedan ejemplares para prestar.");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar el prestamo");
        }
    }

    /**
     * Devolucion de Libro. Si hay ejemplares prestados se permite la devolucion
     * restando de prestados y agregando a restantes.
     *
     * @param libro
     */
    public void devolverLibro(Libro libro) {
        try {
            if (libro.getEjemplaresPrestados() != 0) {
                libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
                libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
                DAO.editar(libro);
            } else {
                System.out.println("No se registran ejemplares prestados. Los sentimos no podemos tramitar su "
                        + "solicitud");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la devolucion");
        }
    }
}
