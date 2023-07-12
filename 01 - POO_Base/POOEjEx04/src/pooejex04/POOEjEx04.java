package pooejex04;

import Entidad.Cuenta;
import java.util.Scanner;

public class POOEjEx04 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Cuenta cuenta1 = new Cuenta();
        cuenta1.ingresarCuenta();
        cuenta1.comprobarDatos();
    }
}
