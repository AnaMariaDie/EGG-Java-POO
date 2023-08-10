package servicios;

import entidades.Persona;
import java.util.Date;
import java.util.Scanner;

public class PersonaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Persona persona = new Persona();
    // CREA LA PERSONA CON LOS ATRIBUTOS
    public Persona crearPersona() {
        System.out.println("Ingrese su nombre");
        persona.setNombre(leer.next());
        System.out.println("Ingrese su dia de nacimiento");
        int dia = leer.nextInt();
        System.out.println("Ingrese su mes de nacimiento");
        int mes = leer.nextInt();
        System.out.println("Ingrese su año de nacimiento");
        int anio = leer.nextInt();
        // Configuracion de parametros dia mes y año por DATE
        Date fechaNac = new Date(anio, mes, dia);
        persona.setFechaNacimiento(fechaNac);
        return persona;
    }
    // CALCULA LA EDAD DE LA PERSONA Y DEVUELVE ENTERO
    public int calcularEdad() {
        int edadPersona = 0;
        Date hoy = new Date();
        // Si es mes es igual
        if ((hoy.getMonth()+1) == persona.getFechaNacimiento().getMonth()) {
            // Si el dia es menor al de la persona
            if (hoy.getDate() < persona.getFechaNacimiento().getDate()) {
                edadPersona = (hoy.getYear() - (persona.getFechaNacimiento().getYear()) + 1899);
            } else {
                // Si el dia es igual al de la persona ES SU CUMPLEAÑOS
                if (hoy.getDate() == persona.getFechaNacimiento().getDate()) {
                    edadPersona = (hoy.getYear() - (persona.getFechaNacimiento().getYear()) + 1900);
                } else {
                    // Entonces el dia es mayor al de la persona
                    edadPersona = (hoy.getYear() - (persona.getFechaNacimiento().getYear()) + 1900);
                }
            }
        } else {
            // Si el mes es menor aun no cumple. Configuracion de mes de 0 a 11
            if ((hoy.getMonth()+1) < persona.getFechaNacimiento().getMonth()) {
                edadPersona = (hoy.getYear() - (persona.getFechaNacimiento().getYear()) + 1899);
            } else {
                // Entonces el mes de mayor
                edadPersona = (hoy.getYear() - (persona.getFechaNacimiento().getYear()) + 1900);
            }
        }
        return edadPersona;
    }
    // VERIFICA SI LA PERSONA ES MENOR CON RESPECTO A LA EDAD INDICADA
    public boolean menorQue(Persona persona, int edad) {
        boolean resultado = false;
        if (edad > calcularEdad()) {
            resultado = true;
        }
        return resultado;
    }
    // MUESTRA LOS ATRIBUTOS DE LA PERSONA
    public void mostrarPersona() {
        System.out.println("Persona creada:\nNombre: " + persona.getNombre() + "\nFecha de Naciemento: "
                + persona.getFechaNacimiento().getDate() + " / " + persona.getFechaNacimiento().getMonth() + 
                " / " + persona.getFechaNacimiento().getYear());
    }
    
    /*
    package nuevo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class NewMain7 {

    public static void main(String[] args) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse("02/22/2010");
        Date secondDate = sdf.parse("04/27/2020");

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The difference in days is : "+diffrence);
    }

}
    */
}
