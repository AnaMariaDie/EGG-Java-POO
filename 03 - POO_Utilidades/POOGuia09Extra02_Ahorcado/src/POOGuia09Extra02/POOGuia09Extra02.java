package POOGuia09Extra02;

import java.util.Scanner;
import servicios.AhorcadoService;

public class POOGuia09Extra02 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AhorcadoService as = new AhorcadoService();
        as.crearJuego();
        as.juego();       
    }
}
