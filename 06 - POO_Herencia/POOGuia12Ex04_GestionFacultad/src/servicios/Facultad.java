package servicios;

import entidades.*;
import java.util.*;

/**
 * Clase Servicio
 *
 * @author Ana
 */
public class Facultad {

    /**
     * Metodo para crear Personas / Estudiantes / Profesores / Maestranzas segun
     * opcion
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> crearPersonas(List<Persona> listPer, Scanner leer) {
        List<Persona> aux = listPer;
        System.out.println("NOMBRE COMPLETO");
        String nameCompl = leer.next();
        System.out.println("DNI");
        Integer dni = leer.nextInt();
        System.out.println("ESTADO CIVIL");
        String estadoCivil = leer.next();
        int opcion = 0;
        Boolean flag = true;
        do {
            System.out.println("¿Que tipo de persona quiere crear?\n1. Estudiante\n2. Profesor\n3. Maestranza");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("MATERIA");
                    List materias = new ArrayList();
                    materias.add(leer.next());
                    listPer.add(new Estudiante(nameCompl, dni, estadoCivil, materias));
                    flag = false;
                    break;
                case 2:
                    System.out.println("AÑO DE INGRESO");
                    Integer anioIngreso = leer.nextInt();
                    System.out.println("NUMERO DE DESPACHO");
                    Integer numDespacho = leer.nextInt();
                    System.out.println("DEPARTAMENTO");
                    String departamento = leer.next();
                    listPer.add(new Profesor(nameCompl, dni, estadoCivil, anioIngreso, numDespacho, departamento));
                    flag = false;
                    break;
                case 3:
                    System.out.println("AÑO DE INGRESO");
                    Integer anioIngresoM = leer.nextInt();
                    System.out.println("NUMERO DE DESPACHO");
                    Integer numDespachoM = leer.nextInt();
                    System.out.println("SECCION");
                    String section = leer.next();
                    listPer.add(new Maestranza(nameCompl, dni, estadoCivil, anioIngresoM, numDespachoM, section));
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (flag);
        return listPer;
    }

    /**
     * Metodo Sobreescrito para ingresar Personas. Arranca por RegistrarDatos()
     *
     * @param leer
     */
    public void crearPersona(Scanner leer) {
        System.out.println("NOMBRE COMPLETO");
        String nameCompl = leer.next();
        System.out.println("DNI");
        Integer dni = leer.nextInt();
        System.out.println("ESTADO CIVIL");
        String estadoCivil = leer.next();
    }

    /**
     * Metodo que inicia el registro de una Persona segun cual sea.
     *
     * @param leer
     * @param listPer
     * @return
     */
    public List<Persona> registrarDatos(List<Persona> listPer, Scanner leer) {
        List<Persona> aux = listPer;
        int opcion;
        Boolean flag = true;
        do {
            System.out.println("¿Que tipo de persona quiere crear?\n1. Estudiante\n2. Profesor\n3. Maestranza");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Persona e1 = new Estudiante();
                    e1.crearPersona(leer);
                    aux.add(e1);
                    flag = false;
                    break;
                case 2:
                    Persona pr1 = new Profesor();
                    pr1.crearPersona(leer);
                    aux.add(pr1);
                    flag = false;
                    break;
                case 3:
                    Persona m1 = new Maestranza();
                    m1.crearPersona(leer);
                    aux.add(m1);
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (flag);
        return aux;
    }

    /**
     * Metodo para modificar segun opcion
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> modificar(List<Persona> listPer, Scanner leer) {
        List<Persona> aux = listPer;
        System.out.println("¿Que modificacion desea realizar?\n1. Estado Civil\n2. Reasignacion de Despacho"
                + "\n3. Matricular en nueva Materia\n4. Cambio de Departamento\n5. Traslado de Seccion\n6. Volver");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                aux = cambioCivil(listPer, leer);
                break;
            case 2:
                aux = reasignacionDesp(listPer, leer);
                break;
            case 3:
                aux = nuevaMateria(listPer, leer);
                break;
            case 4:
                aux = cambioDepartamento(listPer, leer);
                break;
            case 5:
                aux = cambioSection(listPer, leer);
                break;
            case 6:
                System.out.println("Volviendo al menu principal . . . ");
                break;
            default:
                System.out.println("Opcion Invalida");
        }
        return aux;
    }

    /**
     * Metodo para Modificar Estado Civil - Accesible a todas las Personas
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> cambioCivil(List<Persona> listPer, Scanner leer) {
        List<Persona> lis = listPer;
        Boolean flag = true;
        System.out.println("ESCRIBA EL DNI PARA VERIFICAR");
        Integer dniV = leer.nextInt();
        for (Persona aux : listPer) {
             if (dniV.equals(aux.getDni())) {
                System.out.println("EL ESTADO CIVIL DE " + aux.getNameCompl() + " ES: " + aux.getEstadoCivil());
                System.out.println("INGRESE EL NUEVO ESTADO CIVIL");
                aux.setEstadoCivil(leer.next());
                System.out.println("ESTADO CIVIL MODIFICADO");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DNI NO ENCONTRADO");
        }
        return lis;
    }

    /**
     * Metodo para Reasignar Despacho de Empleados
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> reasignacionDesp(List<Persona> listPer, Scanner leer) {
        List<Persona> lis = listPer;
        Boolean flag = true;
        System.out.println("ESCRIBA EL DNI PARA VERIFICAR");
        Integer dniL = leer.nextInt();
        for (Persona aux : listPer) {
            if (aux.getDni().equals(dniL)) {
                Empleado emp = (Empleado) aux;
                System.out.println("EL DESPACHO DE " + emp.getNameCompl() + " ES: " + emp.getNumDespacho());
                System.out.println("INGRESE EL NUEVO NUMERO DE DESPACHO");
                emp.setNumDespacho(leer.nextInt());
                System.out.println("DESPACHO MODIFICADO");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DNI NO ENCONTRADO");
        }
        return lis;
    }

    /**
     * Metodo para Agregar una Nueva Materia de Estudiantes
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> nuevaMateria(List<Persona> listPer, Scanner leer) {
        List<Persona> lis = listPer;
        Boolean flag = true;
        System.out.println("ESCRIBA EL DNI PARA VERIFICAR");
        Integer dniL = leer.nextInt();
        for (Persona aux : lis) {
            if (aux.getDni().equals(dniL)) {
                Estudiante est = (Estudiante) aux;
                System.out.println("EL ESTUDIANTE " + est.getNameCompl() + " ESTA INSCRIPTO EN : "
                        + est.getMateria().toString());
                System.out.println("INGRESE LA NUEVA MATERIA QUE DESEA INSCRIBIR");
                List<String> mat = new ArrayList();
                mat.add(leer.next());
                est.setMateria(mat);
                System.out.println("INSCRIPCION REALIZADA");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DNI NO ENCONTRADO");
        }
        return lis;
    }

    /**
     * Metodo para Realizar Cambio de departamento
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> cambioDepartamento(List<Persona> listPer, Scanner leer) {
        List<Persona> lis = listPer;
        Boolean flag = true;
        System.out.println("ESCRIBA EL DNI PARA VERIFICAR");
        Integer dniL = leer.nextInt();
        for (Persona aux : lis) {
            if (aux.getDni().equals(dniL)) {
                Profesor profe = (Profesor) aux;
                System.out.println("EL PROFESOR " + profe.getNameCompl() + " FIGURA EN EL DEPARTAMENTO: "
                        + profe.getDepartamento());
                System.out.println("INGRESE EL NUEVO DEPARTAMENTO");
                profe.setDepartamento(leer.next());
                System.out.println("DEPARTAMENTO MODIFICADO");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DNI NO ENCONTRADO");
        }
        return lis;
    }

    /**
     * Metodo para Cambiar la Seccion de un Maestranza
     *
     * @param listPer
     * @param leer
     * @return
     */
    public List<Persona> cambioSection(List<Persona> listPer, Scanner leer) {
        List<Persona> lis = listPer;
        Boolean flag = true;
        System.out.println("ESCRIBA EL DNI PARA VERIFICAR");
        Integer dniL = leer.nextInt();
        for (Persona aux : lis) {
            if (aux.getDni().equals(dniL)) {
                Maestranza maes = (Maestranza) aux;
                System.out.println("EL EMPLEADO DE MAESTRANZA " + maes.getNameCompl() + " FIGURA EN LA "
                        + "SECCION: " + maes.getSection());
                System.out.println("INGRESE LA NUEVA SECCION");
                maes.setSection(leer.next());
                System.out.println("SECCION MODIFICADA");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DNI NO ENCONTRADO");
        }
        return lis;
    }

    /**
     * Metodo para Mostrar todos los atributos de los Objetos
     *
     * @param listPer
     */
    public void mostarPersona(List<Persona> listPer) {
        for (Persona persona : listPer) {
            if (persona instanceof Maestranza) {
                Maestranza maes = (Maestranza) persona;
                System.out.println(maes.toString());
            } else {
                if (persona instanceof Profesor) {
                    Profesor profe = (Profesor) persona;
                    System.out.println(profe.toString());
                } else {
                    if (persona instanceof Estudiante) {
                        Estudiante est = (Estudiante) persona;
                        System.out.println(est.toString());
                    }
                }
            }
        }
    }
}
