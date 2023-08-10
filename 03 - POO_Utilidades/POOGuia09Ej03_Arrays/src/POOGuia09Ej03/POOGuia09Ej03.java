package POOGuia09Ej03;

import servicios.ArregloService;

public class POOGuia09Ej03 {

    public static void main(String[] args) {
        
        double arregloA [] = new double [50];
        double arregloB [] = new double [20];
        
        ArregloService as = new ArregloService();
        as.inicializarA(arregloA);
        as.mostrarArreglo(arregloA);
        as.ordenarArreglo(arregloA); 
        as.inicializarB(arregloA, arregloB); 
        as.mostrarArreglo(arregloA); 
        as.mostrarArreglo(arregloB);
    }
}
