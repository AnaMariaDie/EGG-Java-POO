package entidades;

import java.util.*;
import utilidades.Comparadores;

public class Simulador {

    //maneja alumnos y votaciones
    private String[] nombres = {"Juan ", "Laura ", "Pedro ", "Silvia ", "Lucas ", "Anabelle ", "Santiago ",
        "Gabriela ", "Matias ", "Angela "};
    private String[] apellidos = {"Garcia", "Perez", "Stuart", "West", "Langdon", "Moreno", "Brown", "Lynn",
        "Camp", "James"};
    private Random r = new Random();

    /**
     * Metodo que genera alumnos con nombre, apellido y dni aleatorios, segun la
     * cantidad indicada por usuario.
     *
     * @param cantidad
     * @return
     */
    public ArrayList<Alumno> generadorAlumnos(int cantidad) {
        ArrayList<Alumno> aux = new ArrayList();
        for (int i = 0; i < cantidad; i++) {
            Integer dni = r.nextInt(35000000);
            int p1 = r.nextInt(10);
            int p2 = r.nextInt(10);
            String nom = "";
            String ape = "";
            for (int j = 0; j < nombres.length; j++) {
                if (j == p1) {
                    nom = nombres[p1];
                }
            }
            for (int k = 0; k < apellidos.length; k++) {
                if (k == p2) {
                    ape = apellidos[p2];
                }
            }
            String nomYape = nom + ape;
            Alumno a1 = new Alumno(nomYape, dni, 0);
            aux.add(a1);
        }
        return aux;
    }

    /**
     * Metodo que genera nombres y apellidos de alumnos aleatoriamente, cantidad
     * indicada por el usuario.
     *
     * @param cantidad
     * @return
     */
    public ArrayList<String> crearNombres(int cantidad) {
        ArrayList<String> aux = new ArrayList();
        for (int i = 0; i < cantidad; i++) {
            int p1 = r.nextInt(10);
            int p2 = r.nextInt(10);
            String nom = "";
            String ape = "";
            for (int j = 0; j < nombres.length; j++) {
                if (j == p1) {
                    nom = nombres[p1];
                }
            }
            for (int k = 0; k < apellidos.length; k++) {
                if (k == p2) {
                    ape = apellidos[p2];
                }
            }
            String nomYape = nom + ape;
            aux.add(nomYape);
        }
        return aux;
    }

    /**
     * Metodo que genera dni de alumnos aleatoriamente, cantidad indicada por el
     * usuario. Tuve que modificar el ArrayList a Vector porque me tiraba un
     * error de rango.
     *
     * @param cantidad
     * @return
     */
    public Integer[] crearDocumentos(int cantidad) {
        Integer[] aux = new Integer[cantidad];
        Integer dni = 0;
        for (int i = 0; i < cantidad; i++) {
            dni = r.nextInt(35000000);
            aux[i] = dni;
        }
        return aux;
    }

    /**
     * Metodo llama a crear nombres y dnis aleatorios y los recibe para crear
     * alumnos, segun la cantidad indicada por el usuario.
     *
     * @param cantidad
     * @return
     */
    public ArrayList<Alumno> creadorAlumnos(int cantidad) {
        ArrayList<Alumno> aux = new ArrayList();
        ArrayList<String> nomComp = crearNombres(cantidad);
        Integer[] dnis = crearDocumentos(cantidad);
        for (int i = 0; i < cantidad; i++) {
            Alumno a1 = new Alumno();
            a1.setNombreCompleto(nomComp.get(i));
            a1.setDni(dnis[i]);
            a1.setCantidadVotos(0);
            aux.add(a1);
        }
        return aux;
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        System.out.println(alumnos.toString());
    }

    /**
     * Metodo que general un listado de votaciones de los alumnos. Cada Alumno
     * puede dar tres votos, pero no puede votar mas de una vez al mismo
     * compañero ni votarse a si mismo.
     *
     * @param alumnos
     * @return
     */
    public ArrayList<Voto> votacion(ArrayList<Alumno> alumnos) {
        ArrayList<Voto> alumVot = new ArrayList();
        int i = 0;
        for (Alumno alumno : alumnos) {
            boolean v = true;
            int voto1 = 0;
            int voto2 = 0;
            int voto3 = 0;
            do {
                voto1 = r.nextInt(alumnos.size());
                voto2 = r.nextInt(alumnos.size());
                voto3 = r.nextInt(alumnos.size());
                if (alumnos.get(i).getDni() != alumnos.get(voto1).getDni()
                        && alumnos.get(i).getDni() != alumnos.get(voto2).getDni()
                        && alumnos.get(i).getDni() != alumnos.get(voto3).getDni()) {
                    v = true;
                } else {
                    v = false;
                }
            } while (v);
            ArrayList<Alumno> compaVotados = new ArrayList();
            compaVotados.add(alumnos.get(voto1));
            alumnos.get(voto1).setCantidadVotos(alumnos.get(voto1).getCantidadVotos() + 1);
            compaVotados.add(alumnos.get(voto2));
            alumnos.get(voto2).setCantidadVotos(alumnos.get(voto2).getCantidadVotos() + 1);
            compaVotados.add(alumnos.get(voto3));
            alumnos.get(voto3).setCantidadVotos(alumnos.get(voto3).getCantidadVotos() + 1);
            Voto v1 = new Voto(alumno, compaVotados);
            alumVot.add(v1);
            i++;
        }
        return alumVot;
    }

    /**
     * Metodo que imprime las votaciones realizadas. El alumno, la cantidad de
     * votos que obtubo y a quienes voto.
     *
     * @param votacion
     */
    public void imprimirVotaciones(ArrayList<Voto> votacion) {
        ArrayList<Voto> votos = votacion;
        for (Voto voto : votos) {
            System.out.println("El Alumno: " + voto.getAlumno().getNombreCompleto() + " tiene "
                    + voto.getAlumno().getCantidadVotos() + " votos, y voto a:\n" + voto.getAlumnos().toString());
        }
    }

    /**
     * Metodo para hacer recuento de votos que organiza segun cantidad de votos.
     *
     * @param votacion
     */
    public ArrayList<Alumno> recuentoVotos(ArrayList<Voto> votacion) {
        ArrayList<Voto> totalVotos = new ArrayList(votacion);
        ArrayList<Alumno> totalAlumnos = new ArrayList();
        for (Voto voto : totalVotos) {
            totalAlumnos.add(voto.getAlumno());
        }
        totalAlumnos.sort(Comparadores.comparaVotos);
        return totalAlumnos;
    }

    /**
     * Metodo para guardar en un Array los facilitadores y los suplentes en otro
     * y mostrarlos por pantalla
     *
     * @param votacion
     */
    public void nombrarFacilitadores(ArrayList<Voto> votacion) {
        ArrayList<Alumno> votosOrdenados = recuentoVotos(votacion);
        ArrayList<Alumno> facilitadores = new ArrayList();
        ArrayList<Alumno> fsuplentes = new ArrayList();
        for (int i = 0; i < votosOrdenados.size(); i++) {
            if (i <= 4) {
                facilitadores.add(votosOrdenados.get(i));
            } else {
                if (i >= 5 && i < 10) {
                    fsuplentes.add(votosOrdenados.get(i));
                }
            }
        }
        // Mostrando listas de facilitadores y suplentes
        System.out.println("Los Facilitadores son: ");
        for (Alumno facilitador : facilitadores) {
            System.out.println(facilitador.getNombreCompleto() + " DNI: " + facilitador.getDni());
        }
        System.out.println("");
        System.out.println("Los Facilitadores Suplentes son:");
        for (Alumno fsuplente : fsuplentes) {
            System.out.println(fsuplente.getNombreCompleto() + " DNI: " + fsuplente.getDni());
        }
    }
}
