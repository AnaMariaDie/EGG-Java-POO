package POOGuia08Ej01;

import entidad.CuentaBancaria;
import java.util.Scanner;
import servicios.CuentaBancariaServicio;

public class POOGuia08Ej01 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        // Instanciamos la Cuenta Servicios
        CuentaBancariaServicio ctaServ = new CuentaBancariaServicio();
        // Usamos el metodo de Servicios para crear el objeto
        CuentaBancaria cuenta = ctaServ.crearCuenta();
        char respuesta = 'a';
        int opcion;
        do {
            System.out.println("1. Ingresar");
            System.out.println("2. Retirar");
            System.out.println("3. Extracción Rápida");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Consultar Datos");
            System.out.println("6. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    ctaServ.ingresarDinero(cuenta);
                    break;
                case 2:
                    ctaServ.retirarDinero(cuenta);
                    break;
                case 3:
                    ctaServ.extraccionRapida(cuenta);
                    break;
                case 4:
                    ctaServ.consultarSaldo(cuenta);
                    break;
                case 5:
                    ctaServ.consultarDatos(cuenta);
                    break;
                case 6:
                    System.out.println("Desea Salir");
                    respuesta = leer.next().charAt(0);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!(respuesta == 's'));
        System.out.println("Saliendo del sistema . . .");
    }
}
