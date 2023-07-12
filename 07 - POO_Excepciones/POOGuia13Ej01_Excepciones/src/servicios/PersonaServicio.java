package servicios;

import entidades.Persona;
import java.util.Scanner;

public class PersonaServicio {

    // Metodo para crear persona
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {
        Persona persona = new Persona();
        System.out.println("Ingrese el nombre de la Persona");
        persona.setNombre(leer.next());
        System.out.println("Ingrese la edad de la Persona");
        persona.setEdad(leer.nextInt());
        System.out.println("Ingrese el sexo de la Persona: \nH = Hombre\nM = Mujer\nO = Otro ");
        String letra = leer.next();
        boolean validar = false;
        do {
            if (letra.equalsIgnoreCase("H") || letra.equalsIgnoreCase("M") || letra.equalsIgnoreCase("O")) {
                persona.setSexo(letra);
                validar = true;
            } else {
                System.out.println("La opcion ingresada no es valida, por favor ingrese nuevamente");
                letra = leer.next();
            }
        } while (validar == false);
        System.out.println("Ingrese el peso de la Persona");
        persona.setPeso(leer.nextDouble());
        System.out.println("Ingrese la altura de la Persona");
        persona.setAltura(leer.nextDouble());
        return persona;
    }

    // Metodo Comprobar si es mayor de edad
//    public boolean esMayorDeEdad(Persona persona) {
//        return persona.getEdad() >= 18;
//    }
    /**
     * Metodo para atrapar posible Excepcion por valores nulos. Excepcion
     * NullPointerException
     *
     * @param persona
     * @return
     */
    public boolean esMayorDeEdad(Persona persona) {
        try {
            if (persona.getEdad() >= 18) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("FillInStackTrace " + e.fillInStackTrace());
            System.out.println("PrintStackTrace ");
            e.printStackTrace(System.out);
            // Colocando System.out ordena el mensaje como saldria al momento de la ejecucion del programa
            System.out.println("LocalizedMessage");
            System.out.println(e.getLocalizedMessage());
        }
        return false;
    }

    // Metodo calcular IMC Indice de Masa Corporal
    public int calcularIMC(Persona persona) {
        int resultado;
        double valorIMC = persona.getPeso() / (Math.pow(persona.getAltura(), 2));
        if (valorIMC < 20) {
            resultado = -1;
        } else {
            if (valorIMC <= 25) {
                resultado = 0;
            } else { // es mayor a 25
                resultado = 1;
            }
        }
        return resultado;
    }
}
