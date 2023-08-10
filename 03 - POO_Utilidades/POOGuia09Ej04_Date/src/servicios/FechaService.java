package servicios;

import java.util.Date;
import java.util.Scanner;

public class FechaService {
    // Creamos la fecha de nacimiento ingresada por el usuario, esto con el constructor por parametros
    public Date fechaNacimiento() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese su dia de nacimiento");
        int dia = leer.nextInt();
        System.out.println("Ingrese su mes de nacimiento");
        int mes = leer.nextInt();
        System.out.println("Ingrese su año de nacimiento");
        int anio = leer.nextInt();
        // Configuracion de parametros dia mes y año por DATE
        Date fechaNac = new Date(anio-1900, mes, dia);
        return fechaNac;
    }
    // Creamos una fecha actual(el momento de ejecucion del programa) con el constructor vacio
    public Date fechaActual() {
        Date fechaAct = new Date();
        return fechaAct;
    }
    // Realizamos la comparacion de las fechas creadas
    public int diferencia(Date fechaNac, Date fechaAct) {
        int anios = fechaAct.getYear() - fechaNac.getYear();
        return anios;
    }
}
