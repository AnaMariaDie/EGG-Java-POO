package POOGuia09Ej06;

import entidades.Curso;
import java.util.Scanner;

public class POOGuia09Ej06 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Curso curso1 = new Curso();
        System.out.println(curso1.toString());
        curso1.crearCurso(curso1);
        curso1.calcularGananciaSemana(curso1);
        System.out.println(curso1.toString());
    }
}
