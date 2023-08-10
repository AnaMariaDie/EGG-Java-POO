package POOGuia09Ej05;

import entidades.Persona;
import java.util.Scanner;
import servicios.PersonaService;

public class POOGuia09Ej05 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaService ps = new PersonaService();
        Persona persona1 = ps.crearPersona();
        int edadPersona = ps.calcularEdad();
        System.out.println("La edad de la persona es: " + edadPersona);
        System.out.println("Indique una edad");
        int edad = leer.nextInt();
        boolean menorQue1 = ps.menorQue(persona1, edad);
        System.out.println("La persona con respescto a la edad indicada es menor: " + menorQue1);
        ps.mostrarPersona();
    }
}
