package TestCancion;

import Entidad.Cancion;

public class TestCancion {

    public static void main(String[] args) {
         // Objeto con Constructor vacio
        Cancion cancion1 = new Cancion();
        cancion1.ingresarCancion();
        System.out.println("Valores Cancion1 " + cancion1.toString());
        Cancion cancion2 = new Cancion();
        cancion2.ingresarCancion();
        System.out.println("Valores Cancion2 " + cancion2.toString());
    }
    
}
