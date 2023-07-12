package POOGuia09Ej01;
import java.util.Scanner;
import servicios.CadenaServicio;
public class POOGuia09Ej01 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese una frase");
        String frase = leer.next();
        CadenaServicio cs = new CadenaServicio(frase);
        
        cs.mostrarVocales();
        
        cs.invertirFrase();
        System.out.println("Indique el caracter que quiere buscar");
        String letra = leer.next();
        cs.vecesRepetido(letra);
        
        System.out.println("Ingrese una nueva frase");
        String frase1 = leer.next();
        cs.compararLongitud( frase1);
        cs.unirFrases(frase1);
        
        System.out.println("Ingrese una letra para reemplazar");
        char leter = leer.next().charAt(0);
        cs.reemplazar(leter);
        
        System.out.println("Ingrese una letra para verificar si esta en la frase");
        String letra2 = leer.next();
        System.out.println(cs.contiene(letra2));
    }
}
