package servicios;

import entidades.*;
import enumeraciones.*;
import java.time.LocalDate;
import java.util.*;

public class ServicioPoliza {

    private ArrayList<Poliza> polizas = new ArrayList<>();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Crea un cliente con datos aleatorios
     *
     * @return
     */
    public Cliente crearCliente() {
        Random r = new Random();
        return new Cliente("Cliente", r.nextInt(100000), "abcd@gmail.com", "calle falsa 123", r.nextInt(1000000));
    }

    public void mostrarCliente() {
        System.out.println(crearCliente());
    }

    /**
     * Crea un vehiculo con datos aleatorios
     *
     * @return
     */
    public Vehiculo crearVehiculo() {
        return new Vehiculo("FIAT", "Cronos", 2020, "ABC123", "CBA321", "NEGRO", Tipo.SEDAN, crearCliente());
    }

    public void mostrarVehiculo() {
        System.out.println(crearVehiculo());
    }

    /**
     * Crea una poliza con datos aleatorios
     */
    public void crearPoliza() {
        Poliza p = new Poliza(55555, 6, Pago.CHEQUE, 5000000, true, 300000, Cobertura.TODO_RIESGO, crearVehiculo());
        ArrayList<Cuota> aux = new ArrayList();
        for (int i = 0; i < p.getCantidadCuotas(); i++) {
            Cuota cuota = new Cuota(i + 1, 15000, false, LocalDate.now().plusMonths(i + 1));
            aux.add(cuota);
        }
        p.setCuotas(aux);
        polizas.add(p);
    }

    /**
     * Crea multiples polizas segun lo indiquemos y las envia al ArrayList que
     * tiene el servicio como atributo.
     */
    public void llenador() {
        for (int i = 0; i < 3; i++) {
            crearPoliza();
        }
    }

    public void mostrarPoliza() {
        System.out.println(polizas.toString());
    }

    /**
     * Ingreso de Datos de Cliente Manualmente solicitando los datos al usuario.
     * @return 
     */
    public Cliente ingresoCliente() {
        System.out.println("*** Ingrese los Datos del Cliente ***\nIngrese el Nombre y Apellido");
        String nombreApellido = leer.next();
        System.out.println("Ingrese el DNI");
        Integer dni = leer.nextInt();
        System.out.println("Ingrese el E-mail");
        String mail = leer.next();
        System.out.println("Ingrese el Domicilio");
        String domicilio = leer.next();
        System.out.println("Ingrese el Numero de Telefono");
        Integer telefono = leer.nextInt();
        return new Cliente(nombreApellido, dni, mail, domicilio, telefono);
    }
    
    /**
     * Ingreso de Datos de Vehilulo Manualmente solicitando los datos al usuario.
     *
     * @return
     */
    public Vehiculo ingresoVehiculo() {
        System.out.println("*** Ingrese los datos del Vehiculo a Asegurar ***\nIngrese la Marca");
        String marca = leer.next();
        System.out.println("Ingrese el Modelo");
        String modelo = leer.next();
        System.out.println("Ingrese el año");
        Integer anio = leer.nextInt();
        System.out.println("Ingrese el Numero del Motor");
        String motor = leer.next();
        System.out.println("Ingrete el Numero de Chasis");
        String chasis = leer.next();
        System.out.println("Ingrese el color");
        String color = leer.next();
        System.out.println("Indique el tipo de Vehiculo\n1. CAMIONETA\n2. SEDAN\n3. UTILITARIO\n4. MOTO\n5. LANCHA");
        int opcion = leer.nextInt();
        Tipo tipo = null;
        switch (opcion) {
            case 1:
                tipo = Tipo.CAMIONETA;
                break;
            case 2:
                tipo = Tipo.SEDAN;
                break;
            case 3:
                tipo = Tipo.UTILITARIO;
                break;
            case 4:
                tipo = Tipo.MOTO;
                break;
            case 5:
                tipo = Tipo.LANCHA;
                break;
        }
        /*
        Otra forma mas eficiente de asignar una opcion a partir de un enum.
        Integer opcion = read.nextInt();
        for (Tipo tipo : Tipo.values()) {
            if (tipo.ordinal() == opcion) {
                System.out.println("Usted eligió: " + tipo.name());
            }
        }
        */
        // Setear el cliente ya creado. Llamaos al ingreso de datos realizado para el cliente.
        return new Vehiculo(marca, modelo, anio, motor, chasis, color, tipo, ingresoCliente());
    }

    /**
     * Ingreso de Datos de Poliza Manualmente solicitado los datos al usuario.
     */
    public void ingresoPoliza() {
        System.out.println("Ingrese el numero de Poliza a asignar");
        Integer numPoliza = leer.nextInt();
        // Si el ingreso es manual
//        System.out.println("Ingrese la fecha de inicio de la poliza");
//        System.out.println("Escriba el dia (dd)");
//        Integer dia = leer.nextInt();
//        System.out.println("Escriba el mes(mm)");
//        Integer mes = leer.nextInt();
//        System.out.println("Escriba el año(yyyy)");
//        Integer anio = leer.nextInt();
//        LocalDate fechaInicio = LocalDate.of(anio, mes, dia);
        // Seteo de fecha al momento de su creacion como inicio
        System.out.println("Se indica como fecha de Inicio el dia de hoy.");
        // LocalDate fechaInicio = LocalDate.now(); // Lo realiza el constructor
        System.out.println("Se indica como fecha de Vencimiento, un año a partir de la fecha de inicio");
        // LocalDate fechafin = LocalDate.now().plusYears(1); // Lo setea el constructor
        System.out.println("Indique la cantidad de cuotas");
        Integer cantCuotas = leer.nextInt();
        System.out.println("Ingrese la forma de pago:\n1. EFECTIVO\n2. TRANSFERENCIA\n3. CHEQUE\n4. DEBITO "
                + "AUTOMATICO");
        int opcion = leer.nextInt();
        Pago fpago = null;
        switch (opcion) {
            case 1:
                fpago = Pago.EFECTIVO;
                break;
            case 2:
                fpago = Pago.TRANSFERENCIA;
                break;
            case 3:
                fpago = Pago.CHEQUE;
                break;
            case 4:
                fpago = Pago.DEBITO_AUTOMATICO;
                break;
        }
        System.out.println("Ingrese el Monto Asegurado");
        Integer montoAsegurado = leer.nextInt();
        System.out.println("Indique si incluye granizo");
        Boolean incluyeGranizo = false;
        String resp = leer.next();
        if (resp.equalsIgnoreCase("S")) {
            incluyeGranizo = true;
        }
        System.out.println("Ingrese Monto Maximo por Granizo");
        Integer montoMaximoGranizo = leer.nextInt();
        System.out.println("Indique el tipo de cobertura\n1. TERCEROS COMPLETO\n2. TODO RIESGO\n3. RESPONSABILIDAD "
                + "CIVIL");
        int opcion2 = leer.nextInt();
        Cobertura cobertura = null;
        switch (opcion2) {
            case 1:
                cobertura = Cobertura.TERCEROS_COMPLETO;
                break;
            case 2:
                cobertura = Cobertura.TODO_RIESGO;
                break;
            case 3:
                cobertura = Cobertura.RESPONSABILIDAD_CIVIL;
                break;
        }
        // Setear el vehiculo ya creado. Llamaos al ingreso de datos realizado para el vehiculo.
        Poliza p = new Poliza(numPoliza, cantCuotas, fpago, montoAsegurado, incluyeGranizo, montoMaximoGranizo, 
                cobertura, ingresoVehiculo(), crearCuotas(cantCuotas));
        polizas.add(p);
    }
    
    /**
     * Metodo para generar cuotas por pagar con monto sin setear(mismo para todas y con vencimientos a 1 mes)
     * @param cantCuotas
     * @return 
     */
    public ArrayList<Cuota> crearCuotas(Integer cantCuotas) {
        ArrayList<Cuota> aux = new ArrayList();
        for (int i = 0; i < cantCuotas; i++) {
            // Seteo de monto de cuotas por pagar con vencimientos a un mes
            Cuota cuota = new Cuota(i + 1, 15000, false, LocalDate.now().plusMonths(i + 1));
            aux.add(cuota);
        }
        return aux;
    }
    
}
