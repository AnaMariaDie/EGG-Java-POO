package servicios;

import java.util.Arrays;

public class ArregloService {

    public double [] inicializarA(double arregloA[]) {
        for (int i = 0; i < arregloA.length; i++) {
            arregloA[i] = Math.round(Math.random() * 100);
        }
        return arregloA;
    }
    
    public void mostrarArreglo(double arreglo[]) {
        System.out.println("Arreglo: " + Arrays.toString(arreglo));
    }
    
    public double [] ordenarArreglo(double arregloA[]) {
        Arrays.sort(arregloA);
        return arregloA;
    }
    
    public double [] inicializarB(double arregloA[], double arregloB[]) {
        for (int i = 0; i < arregloB.length; i++) {
            if (i < 11) {
                arregloB[i] = arregloA[i];
            } else {
                arregloB[i] = 0.5;
            }
        }
        return arregloB;
    }
}
