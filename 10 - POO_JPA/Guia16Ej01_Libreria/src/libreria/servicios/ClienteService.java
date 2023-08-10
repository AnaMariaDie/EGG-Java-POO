package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

public class ClienteService {

    private final ClienteDAO DAO;
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ClienteService() {
        this.DAO = new ClienteDAO();
    }

    /**
     * Crea un Cliente y lo guarda en la base de datos.
     *
     */
    public void crearCliente() {
        Cliente cliente = new Cliente();
        try {
            System.out.println("Ingrese el nombre del Cliente");
            String nombre = leer.next();
            System.out.println("Ingrese el apellido del Cliente");
            String apellido = leer.next();
            System.out.println("Ingrese el documento del Cliente");
            Long dni = leer.nextLong();
            System.out.println("Ingrese el telefono del Cliente");
            String telefono = leer.next();
            cliente.setNombre(validarCadena(nombre));
            cliente.setApellido(validarCadena(apellido));
            cliente.setDni(validarDni(dni));
            cliente.setTelefono(validarCadena(telefono));
            DAO.guardar(cliente);
            System.out.println("Cliente ingresado exitosamente");
        } catch (NullPointerException npe) {
            System.out.println("Error al ingresar un dato del Cliente");
        } catch (Exception e) {
            System.out.println("Error al ingresar el Cliente");
        }
    }

    /**
     * Busca y muestra el Cliente con los valores actuales por ID y luego
     * modifica segun se indique.
     */
    public void editarCliente() {
        try {
            System.out.println("El Listado de Clientes actuales es: ");
            listarClientes();
            System.out.println("Indique el Id del Cliente a modificar");
            Integer id = leer.nextInt();
            Cliente cliente = DAO.buscarId(id);
            int opcion = 0;
            do {
                System.out.println("Indique el valor que desea modificar:\n1. Nombre\n2. Apellido\n3. Documento\n4. "
                    + "Telefono\n5. Finalizar Edicion");
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        cliente.setNombre(editarCadena("nombre"));
                        break;
                    case 2:
                        cliente.setApellido(editarCadena("apellido"));
                        break;
                    case 3:
                        cliente.setDni(editarDocumento("documento"));
                        break;
                    case 4:
                        cliente.setTelefono(editarCadena("telefono"));
                        break;
                    case 5:
                        System.out.println("Edicion finalizada");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                }
            } while (opcion != 5);
            DAO.editar(cliente);
            System.out.println("Nombre Cliente modificado");
        } catch (Exception e) {
            System.out.println("No se pudo modificar");
        }
    }

    /**
     * Edita la cadena del tipo recibido por parametro.
     */
    private String editarCadena(String cadena) {
        System.out.println("Ingrese el nuevo " + cadena + " del Cliente");
        String valor = validarCadena(leer.next());
        return valor;
    }

    /**
     * Edita el documento del cliente.
     */
    private Long editarDocumento(String cadena) {
        System.out.println("Ingrese el nuevo " + cadena + " del Cliente");
        Long valor = validarDni(leer.nextLong());
        return valor;
    }

    /**
     * Elimina un Cliente por titulo.
     *
     * @param id
     * @return
     */
    public boolean eliminarId(Integer id) {
        try {
            Cliente cliente = DAO.buscarId(id);
            DAO.eliminar(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar");
            return false;
        }
    }

    /**
     * Busca Cliente por Id.
     *
     * @param id
     * @return
     */
    public Cliente buscarId(Integer id) {
        Cliente cliente = null;
        try {
            cliente = DAO.buscarId(id); 
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
        }
        return cliente;
    }

    /**
     * Valida el Cliente, si ya se encuentra ingresado.
     *
     * @param dni
     * @return
     */
    public Cliente buscarPorDni(Long dni) {
        Cliente cliente = null;
        try {
            cliente = DAO.buscarPorDni(dni);
        } catch (Exception e) {
            System.out.println("No se encuentra en la base de datos");
        }
        return cliente;
    }
    
    /**
     * Lista los Clientes en la base de datos.
     *
     */
    public void listarClientes() {
        try {
            List<Cliente> clientes = DAO.listarTodos();
            mostrarClientes(clientes);
        } catch (NullPointerException npe) {
            System.out.println("La base de datos esta vacia");
        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    /**
     * Mostrar los Clientees que estan de Alta.
     *
     * @param clientes
     */
    public void mostrarClientes(List<Cliente> clientes) {
        List<Cliente> listado = clientes;
        for (Cliente cliente : listado) {
            System.out.println("\n * Cliente *" + " Id: " + cliente.getId() + " - Nombre: " + cliente.getNombre() 
                    + " - Apellido: " + cliente.getApellido() + "\nDNI: " + cliente.getDni()+" - Telefono: " + 
                    cliente.getTelefono());
        }
        System.out.println("");
    }

    /**
     * Valida el DNI.
     *
     * @param dni
     * @return
     */
    public Long validarDni(Long dni) {
        boolean salir = true;
        do {
            try {
                if (dni == 0) {
                    System.out.println("Debe ingresar un Documento Valido");
                    dni = leer.nextLong();
                } else {
                    return dni;
                }
            } catch (NullPointerException npe) {
                System.out.println("Error al setear el Dato");
            } catch (Exception e) {
                System.out.println("Error al ingresar el Documento");
            }
        } while (salir);
        return dni;
    }

    /**
     * Valida cadena(nombre, apellido y telefono).
     *
     * @param cadena
     * @return
     */
    public String validarCadena(String cadena) {
        boolean salir = true;
        do {
            try {
                if (cadena.isEmpty()) {
                    System.out.println("Debe ingresar un dato valido");
                    cadena = leer.next();
                } else {
                    return cadena;
                }
            } catch (NullPointerException npe) {
                System.out.println("Error al setear el Dato");
            } catch (Exception e) {
                System.out.println("Error al ingresar el Dato");
            }
        } while (salir);
        return cadena;
    }
}
