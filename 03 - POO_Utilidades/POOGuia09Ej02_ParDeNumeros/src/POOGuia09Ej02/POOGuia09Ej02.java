package POOGuia09Ej02;

import servicios.ParDeNumerosServicio;

public class POOGuia09Ej02 {

    public static void main(String[] args) {
        ParDeNumerosServicio pdns = new ParDeNumerosServicio();
        pdns.mostrarValores();
        double mayor = pdns.devolverMayor();
        double menor = pdns.devolverMenor();
        double mayorL = Math.round(mayor);
        double menorL = Math.round(menor);
        double potencia = pdns.calcularPotencia(mayorL, menorL);
        System.out.println("La potencia del numero mayor " + mayorL + " por el menor " + menorL + " es: " 
                + potencia);
        double raiz = pdns.calcularRaiz(menorL);
        System.out.println("La raiz del numero menor : " + menorL + " es: " + raiz);
    }
}
