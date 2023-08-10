package servicios;

import entidad.CuentaBancaria;
import java.util.Scanner;

public class CuentaBancariaServicio {
   private Scanner leer = new Scanner(System.in).useDelimiter("\n");
   
    // Metodo Creacion de Cuenta Bancaria con los tres atributos
    public CuentaBancaria crearCuenta() {
        CuentaBancaria cuenta = new CuentaBancaria();
        System.out.println("Ingrese el numero de su cuenta");
        cuenta.setNumeroCuenta(leer.nextInt());
        System.out.println("Ingrese su DNI");
        cuenta.setDniCliente(leer.nextLong());
        System.out.println("Ingrese el saldo de su cuenta");
        cuenta.setSaldoActual(leer.nextDouble());
        return cuenta;
    }
    
    // Metodo para ingresar dinero
    public void ingresarDinero(CuentaBancaria cuenta) {
        System.out.println("Indique el importe a depositar");
        cuenta.setSaldoActual(cuenta.getSaldoActual() + leer.nextDouble());
        System.out.println("Su saldo se ha actualizado, ahora dispone de $ " + cuenta.getSaldoActual());
    }
    
    // Metodo para retirar dinero
    public void retirarDinero(CuentaBancaria cuenta) {
        System.out.println("Indique el importe a retirar");
        double dinero = leer.nextDouble();
        if (dinero > cuenta.getSaldoActual()) {
            System.out.println("No dispone de saldo suficiente para realizar esta transaccion");
            System.out.println("Solo puede retirar: " + cuenta.getSaldoActual());
            System.out.println("Por Favor retire su dinero");
            cuenta.setSaldoActual(0);
        } else {
            System.out.println("Se retiro " + dinero);
            cuenta.setSaldoActual(cuenta.getSaldoActual() - dinero);
            System.out.println("Su saldo quedo en $ " + cuenta.getSaldoActual());
        }
    }
    
    // Metodo para Extraer 20 %
    public void extraccionRapida(CuentaBancaria cuenta) {
        System.out.println("Se extrajo " + (cuenta.getSaldoActual() * 0.20));
        cuenta.setSaldoActual(cuenta.getSaldoActual() * 0.80);
        System.out.println("Ha realizado una extraccion Rapida y su saldo actual es $ " 
                + cuenta.getSaldoActual());
    }
    
    // Metodo de Consulta de saldo
    public void consultarSaldo(CuentaBancaria cuentaBancaria) {
        System.out.println("Su Saldo Actual es de $ " + cuentaBancaria.getSaldoActual());
    }
    
    // Metodo de consulta de todos los datos
    public void consultarDatos(CuentaBancaria cuenta) {
        System.out.println("Numero de Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("DNI del Titular: " + cuenta.getDniCliente());
        System.out.println("Saldo Disponible: " + cuenta.getSaldoActual());
    }
}
