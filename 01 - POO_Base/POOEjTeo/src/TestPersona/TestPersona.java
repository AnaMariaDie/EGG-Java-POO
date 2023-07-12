package TestPersona;

import Entidad.Persona;

public class TestPersona {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "Perez", 20);
      
        System.out.println("persona1: nombre " + persona1.getNombre() + " apellido " + persona1.getApellido()
                + " edad " + persona1.getEdad());
        
        Persona persona2 = new Persona("Jose", "Martinez", 20);
        Persona persona3 = new Persona("Leo", "Morales", 24);
        Persona persona4 = new Persona("Laura", "Torres", 43);
                
        persona2.setEdad(23);
        persona3.setEdad(42);
        System.out.println("persona2: nombre " + persona2.getNombre() + " apellido " + persona2.getApellido()
                + " edad " + persona2.getEdad());
        System.out.println("persona3: nombre " + persona3.getNombre() + " apellido " + persona3.getApellido()
                + " edad " + persona3.getEdad());
    }
}
