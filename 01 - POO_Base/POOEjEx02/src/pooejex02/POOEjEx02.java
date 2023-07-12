package pooejex02;

import Entidad.Puntos;

public class POOEjEx02 {

    public static void main(String[] args) {
        
        Puntos punto1 = new Puntos();
        punto1.crearPuntos();
        System.out.println("La distancia de los puntos indicados es: " + punto1.calcularDistancia());
        
    }
    
}
