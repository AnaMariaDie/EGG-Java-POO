package pruebaoperacion;

import Entidad.Operacion;

public class PruebaOperacion {

    public static void main(String[] args) {
        // Objero creado con Constructor Vacio
        Operacion op1 = new Operacion();
        op1.crearOperacion();
        System.out.println(op1.toString());

        System.out.println("La Suma de los numeros es = " + op1.sumar());
        System.out.println("La Resta de los numeros es = " + op1.restar());
        System.out.println("La Multiplicacion de los numeros es = " + op1.multiplicar());
        System.out.println("La Division de los numeros es = " + op1.dividir());
    }

}
