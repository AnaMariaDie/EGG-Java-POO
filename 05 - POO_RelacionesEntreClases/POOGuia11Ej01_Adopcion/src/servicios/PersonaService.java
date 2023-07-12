package servicios;

import entidades.*;
import java.util.*;

public class PersonaService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Persona> personas;
    private ArrayList<Perro> perros;

    public PersonaService() {
        // Creo el constructor con las personas y perros para que ya los tenga;
        Perro pet1 = new Perro("Inu", Raza.MESTIZO, 5, Tamano.MEDIANO);
        Perro pet2 = new Perro("Kibo", Raza.PEKINES, 7, Tamano.CHICO);
        Perro pet3 = new Perro("Susan", Raza.DOBERMAN, 6, Tamano.GRANDE);
        Perro pet4 = new Perro("Mancha", Raza.OBEJERO_ALEMAN, 4, Tamano.GRANDE);
        Perro pet5 = new Perro("Coli", Raza.PUG, 2, Tamano.CHICO);
        Perro pet6 = new Perro("Doggi", Raza.MANTO_NEGRO, 9, Tamano.GRANDE);
        perros = new ArrayList<>();
        perros.add(pet1);
        perros.add(pet2);
        perros.add(pet3);
        perros.add(pet4);
        perros.add(pet5);
        perros.add(pet6);
        Persona p1 = new Persona("Charlie", "Brown", 35, 33574853, null);
        Persona p2 = new Persona("Lorena", "Parra", 25, 37514853, null);
        Persona p3 = new Persona("Pepe", "Galan", 52, 16574548, null);
        Persona p4 = new Persona("Luis", "Sanchez", 33, 29545423, null);
        Persona p5 = new Persona("Alicia", "Milan", 25, 23554592, null);
        Persona p6 = new Persona("Silvia", "Duran", 62, 12585623, null);
        personas = new ArrayList<>();
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);
    }

    public void menu() {
        int opcion = 0;
        String nomPerro = "";
        do {
            System.out.println("***** Menu Centro de Adopciones *****");
            int total = 0;
            for (Persona persona : personas) {
                System.out.println("Bienvenido " + persona.getNombre());
                System.out.println("Desea adoptar un perro ? S/N");
                String re = leer.next();
                if (re.equalsIgnoreCase("S")) {
                    mostrarPerros();
                    System.out.println("\n * Ingrese el nombre del Perro que desea adoptar");
                    nomPerro = leer.next();
                    for (int i = 0; i < perros.size(); i++) {
                        if (perros.get(i).getNombre().equalsIgnoreCase(nomPerro)) {
                            persona.setPerro(perros.get(i));
                            perros.remove(i);
                            total++;
                        }
                    }
                }
                if (total == 0) {
                    System.out.println("Ningun perro ha sido adoptado");
                }
            }
        } while (opcion != 0);
        adopcionesRealizadas();
    }

    public void mostrarPerros() {
        System.out.println("--- Perros listos para adoptar ---");
        for (Perro perro : perros) {
            System.out.println(perro.toString());
        }
    }

    public void adopcionesRealizadas() {
        for (Persona persona : personas) {
            if (persona.getPerro() == null) {
                System.out.println(persona.getNombre() + " " + persona.getApellido() + " no ha adoptado ningun "
                        + "perro");
            } else {
                System.out.println(persona.getNombre() + " " + persona.getApellido() + " ha adoptado a "
                        + persona.getPerro().toString());
            }
        }
    }
}
