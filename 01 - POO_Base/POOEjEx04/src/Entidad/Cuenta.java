package Entidad;

import java.util.Scanner;

public class Cuenta {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private String titular;
    private String ingresoTitular;
    private int clave;
    private int ingresoClase;
    private double saldo = 1000;
    private boolean banderaDatos = true;
    private boolean banderaMenu = true;

    public Cuenta() {
    }

    public Cuenta(String titular, int clave, double saldo) {
        this.titular = titular;
        this.clave = clave;
        this.saldo = saldo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getIngresoTitular() {
        return ingresoTitular;
    }

    public void setIngresoTitular(String ingresoTitular) {
        this.ingresoTitular = ingresoTitular;
    }

    public int getIngresoClase() {
        return ingresoClase;
    }

    public void setIngresoClase(int ingresoClase) {
        this.ingresoClase = ingresoClase;
    }
    
   public boolean isBanderaDatos() {
        return banderaDatos;
    }

    public void setBanderaDatos(boolean banderaDatos) {
        this.banderaDatos = banderaDatos;
    }

    public boolean isBanderaMenu() {
        return banderaMenu;
    }

    public void setBanderaMenu(boolean banderaMenu) {
        this.banderaMenu = banderaMenu;
    }

    @Override
    public String toString() {
        return "Cuenta{" + " titular = " + titular + ", clave = " + clave + ", saldo = " + saldo + '}';
    }

    public void ingresarCuenta() {
        System.out.println(" **** Bienvenido Banco Ana ****");
        System.out.println(" ------------------------------ ");
        System.out.println(" Ingrese su nombre ");
        this.titular = leer.next();
        System.out.println("Ingresa tu clave de 4 digitos para operar");
        this.clave = leer.nextInt();
        System.out.println(titular + " Te registraste correctamente");
        System.out.println("*** Gracias por usar el sistema del Banco Ana ***");
        System.out.println(" ----------------------------------------------- ");
    }

    public void comprobarDatos() {
        System.out.println(" **** Bienvenido Banco Ana ****");
        System.out.println(" ------------------------------ ");
        do {
            System.out.println(" Ingrese su nombre ");
            this.ingresoTitular = leer.next();
            System.out.println("Ingresa tu clave de 4 digitos para operar");
            this.ingresoClase = leer.nextInt();
        if (!(this.titular.equals(this.ingresoTitular) && this.clave == this.ingresoClase)) {
            System.out.println("Los datos ingresados son incorrectos, intente nuevamente");
            System.out.println("--------------------------------");
            setBanderaDatos(false);
        } else {
            setBanderaDatos(true);
        }
        } while (banderaDatos != true); 
        desplegarMenu();
    }

    public void desplegarMenu() {
        do {
            System.out.println("--------------------------------");
            System.out.println("Que operacion quieres realizar");
            System.out.println("*** 1. Consultar saldo ***");
            System.out.println("*** 2. Retirar Dinero  ***");
            System.out.println("*** 3. Salir del Banco ***");
            int opcion = leer.nextInt();
            System.out.println("--------------------------------");
            switch (opcion) {
                case 1:
                    consultaSaldo();
                    break;
                case 2:
                    retirarDinero();
                    break;
                case 3:
                    System.out.println("Usted esta saliendo del sistema\nGracias por utilizar los servicios del Banco Ana");
                    System.out.println("--------------------------------");
                    setBanderaMenu(false);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("--------------------------------");
            }
        } while (isBanderaMenu());
    }

    public void retirarDinero() {
        System.out.println("Ingrese el importe a retirar");
        int dinero = leer.nextInt();
        System.out.println("--------------------------------");
        if (dinero > this.saldo) {
            System.out.println("Su saldo es insuficiente para realizar esta operacion");
        } else {
            this.saldo = this.saldo - dinero;
            System.out.println("Usted retiro: " + dinero);
            System.out.println("Su saldo quedo en: " + this.saldo);
        }
    }

    public void consultaSaldo() {
        System.out.println("Su saldo disponible es: " + this.saldo);
    }
}
