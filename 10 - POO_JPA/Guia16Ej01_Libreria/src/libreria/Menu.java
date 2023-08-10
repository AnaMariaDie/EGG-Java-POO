package libreria;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.servicios.AutorService;
import libreria.servicios.ClienteService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;
import libreria.servicios.PrestamoService;

public class Menu {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibroService ls = new LibroService();
    AutorService as = new AutorService();
    EditorialService es = new EditorialService();
    PrestamoService ps = new PrestamoService();
    ClienteService cs = new ClienteService();

    /**
     * Menu Opciones a realizar.
     */
    public void menu() {
        try {
            int opc = 0;
            do {
                System.out.println("\n********** MENU BASE DE DATOS LIBRERIA **********");
                System.out.println(" 1) Registrar Libro / Autor / Editorial / Cliente");
                System.out.println(" 2) Editar Libro / Autor / Editorial / Cliente");
                System.out.println(" 3) Eliminar Libro / Autor / Editorial / Cliente / Prestamo");
                System.out.println(" 4) Listar Libros / Autores / Editoriales / Clientes / Prestamos");
                System.out.println(" 5) Buscar Autor / Cliente / Libro");
                System.out.println(" 6) Alta a Libros / Autores / Editoriales Eliminadas");
                System.out.println(" 7) Prestamos");
                System.out.println(" 8) Salir");
                opc = leer.nextInt();
                switch (opc) {
                    case 1:
                        menuRegistrar();
                        break;
                    case 2:
                        menuEditar();
                        break;
                    case 3:
                        menuEliminar();
                        break;
                    case 4:
                        menuListar();
                        break;
                    case 5:
                        menuBuscar();
                        break;
                    case 6:
                        menuAlta();
                        break;
                    case 7:
                        menuPrestamo();
                        break;
                    case 8:
                        System.out.println("Usted esta saliendo del sistema . . . ");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
            } while (opc != 8);
        } catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Menu de Registros.
     */
    private void menuRegistrar() {
        System.out.println("1. Libro\n2. Autor\n3. Editorial\n4. Cliente\n5. Volver al Menu Principal");
        int opcI = leer.nextInt();
        switch (opcI) {
            case 1:
                ls.crearLibro();
                break;
            case 2:
                as.crearAutor();
                break;
            case 3:
                es.crearEditorial();
                break;
            case 4:
                cs.crearCliente();
                break;
            case 5:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }

    private void menuEditar() {
        System.out.println("1. Libro\n2. Autor\n3. Editorial\n4. Cliente\n5. Volver al Menu Principal");
        int opcI = leer.nextInt();
        switch (opcI) {
            case 1:
                ls.editarTitulo();
                break;
            case 2:
                as.editarNombre();
                break;
            case 3:
                es.editarNombre();
                break;
            case 4:
                cs.editarCliente();
                break;
            case 5:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }

    /**
     * Menu de Eliminaciones.
     */
    private void menuEliminar() {
        System.out.println("1. Libro\n2. Autor\n3. Editorial\n4. Cliente\n5. Prestamo \n6. Volver al Menu Principal");
        int opcE = leer.nextInt();
        switch (opcE) {
            case 1:
                System.out.println("Los Libros en Existencia son:");
                ls.listarLibros();
                System.out.println("Ingrese el Id del Libro a Eliminar");
                if (ls.eliminarId(leer.nextInt())) {
                    System.out.println("Libro Eliminado Correctamente");
                } else {
                    System.out.println("Ocurrio un Error, el Libro no se pudo Eliminar");
                }
                break;
            case 2:
                System.out.println("Los Autores en la Base son:");
                as.listarAutores();
                System.out.println("Ingrese el Id del Autor a Eliminar");
                if (as.eliminarId(leer.nextInt())) {
                    System.out.println("Autor Eliminado Correctamente");
                } else {
                    System.out.println("Ocurrio un Error, el Autor no se pudo Eliminar");
                }
                break;
            case 3:
                System.out.println("Las Editoriales en la Base son:");
                es.listarEditoriales();
                System.out.println("Ingrese el Id de la Editorial a Eliminar");
                if (es.eliminarId(leer.nextInt())) {
                    System.out.println("Editorial Eliminada Correctamente");
                } else {
                    System.out.println("Ocurrio un Error, la Editorial no se pudo Eliminar");
                }
                break;
            case 4:
                System.out.println("Los Clientes en la Base son:");
                cs.listarClientes();
                System.out.println("Ingrese el Id del Cliente a Eliminar");
                if (cs.eliminarId(leer.nextInt())) {
                    System.out.println("Cliente Eliminado Correctamente");
                } else {
                    System.out.println("Ocurrio un Error, el Cliente no se pudo Eliminar");
                }
                break;
            case 5:
                System.out.println("Los Prestamos en la Base son:");
                ps.listarPrestamos();
                System.out.println("Ingrese el Id del Prestamo a Eliminar");
                if (ps.eliminarId(leer.nextInt())) {
                    System.out.println("Prestamo Eliminado Correctamente");
                } else {
                    System.out.println("Ocurrio un Error, el Prestamo no se pudo Eliminar");
                }
                break;
            case 6:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }

    /**
     * Menu de Listados.
     */
    private void menuListar() {
        System.out.println("1. Libro\n2. Autor\n3. Editorial\n4. Cliente\n5. Prestamos\n6. Volver al Menu Principal");
        int opcL = leer.nextInt();
        switch (opcL) {
            case 1:
                ls.listarLibros();
                break;
            case 2:
                as.listarAutores();
                break;
            case 3:
                es.listarEditoriales();
                break;
            case 4:
                cs.listarClientes();
                break;
            case 5:
                ps.listarPrestamos();
                break;
            case 6:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }

    /**
     * Menu de Busqueda por Opcion.
     */
    private void menuBuscar() {
        System.out.println("1. Autor\n2. Cliente\n3. Libro\n4. Volver al Menu Principal");
        int opcN = leer.nextInt();
        switch (opcN) {
            case 1:
                System.out.println("Ingrese el Nombre del Autor a buscar");
                String nombreAutor = leer.next();
                Autor autor = as.buscarPorNombre(nombreAutor);
                System.out.println(autor.toString());
                break;
            case 2:
                System.out.println("Los Clientes son:");
                cs.listarClientes();
                System.out.println("Ingrese el id del Cliente a buscar");
                Integer cid = leer.nextInt();
                Cliente cliente = cs.buscarId(cid);
                System.out.println(cliente.toString());
                break;
            case 3:
                System.out.println("Elija la opcion para Buscar Libro");
                System.out.println("1. ISBN\n2. Titulo\n3. Nombre Autor\n4. Nombre Editorial\n5. Volver al Menu "
                        + "Principal");
                int opcB = leer.nextInt();
                switch (opcB) {
                    case 1:
                        System.out.println("Ingrese el Codigo ISBN del Libro a buscar");
                        Long isbn = leer.nextLong();
                        Libro libro = ls.buscarPorIsbn(isbn);
                        System.out.println(libro.toString());
                        break;
                    case 2:
                        System.out.println("Ingrese el Titulo del Libro a buscar");
                        String titulo = leer.next();
                        Libro libro1 = ls.buscarPorTitulo(titulo);
                        System.out.println(libro1.toString());
                        break;
                    case 3:
                        System.out.println("Ingrese el Nombre del Autor del Libro a buscar");
                        String nomAut = leer.next();
                        List<Libro> libro2 = ls.buscarPorNombre("Autor", nomAut);
                        break;
                    case 4:
                        System.out.println("Ingrese el Nombre de la Editorial del Libro a buscar");
                        String nomEdit = leer.next();
                        List<Libro> libro3 = ls.buscarPorNombre("Editorial", nomEdit);
                        break;
                    case 5:
                        System.out.println("Volviendo al Menu Principal");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
                break;
            case 4:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
        }
    }

    /**
     * Menu Altas. Modificacion de atributo Alta(evita eliminacion).
     */
    private void menuAlta() {
        System.out.println("1. Libro\n2. Autor\n3. Editorial\n4. Volver al Menu Principal");
        int opcA = leer.nextInt();
        switch (opcA) {
            case 1:
                ls.alta();
                break;
            case 2:
                as.alta();
                break;
            case 3:
                es.alta();
                break;
            case 4:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }

    /**
     * Menu Prestamos.
     */
    private void menuPrestamo() {
        System.out.println("Indique la opcion que desea realizar:\n1. Pedir Libro\n2. Devolver Libro\n3. Prestamos "
                + "por Cliente\n4. Volver al Menu Principal");
        int opcP = leer.nextInt();
        switch (opcP) {
            case 1:
                System.out.println("Los titulos disponibles son:");
                ls.listarLibros();
                System.out.println("Ingrese el Id del Libro que va a solicitar");
                Integer id = leer.nextInt();
                Libro libroP = ls.buscarId(id);
                System.out.println("Los Clientes activos:");
                cs.listarClientes();
                System.out.println("Ingrese el Id del Cliente que solicita el prestamo");
                Integer idCl = leer.nextInt();
                Cliente cliente = cs.buscarId(idCl);
                ps.crearPrestamo(libroP, cliente);
                ls.prestarLibro(libroP);
                break;
            case 2:
                System.out.println("Listado de Prestamos:");
                ps.listarPrestamos();
                System.out.println("Indique el Id del Prestamo");
                Integer idP = leer.nextInt();
                Prestamo prestamoD = ps.buscarId(idP);
                System.out.println("Indique el Id del Libro a devolver");
                Integer idL = leer.nextInt();
                Libro libroD = ls.buscarId(idL);
                if (libroD.getEjemplaresPrestados() == 0) {
                    System.out.println("El Libro que desea devolver no tiene ejemplares en prestamo");
                } else {
                    ps.editarPrestamo(prestamoD);
                    ls.devolverLibro(libroD);
                }
                break;
            case 3:
                System.out.println("Los Clientes son:");
                cs.listarClientes();
                System.out.println("Ingrese el Id del Cliente cuyos Prestamos desea ver");
                Integer clId = leer.nextInt();
                Cliente cliente1 = cs.buscarId(clId);
                List<Prestamo> prestamos = ps.buscarPorCliente(cliente1);
                break;
            case 4:
                System.out.println("Volviendo al Menu Principal");
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }
}
