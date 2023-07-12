package entidades;

public class ArrayIndex {

    /*
    Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
    generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
    de rango).
     */
    private int[] numeros;
    /**
     * Vector con 2 posiciones
     */
    public ArrayIndex() {
        numeros = new int[2];
    }
    /**
     * Intento de modificacion de un numero que recibe un indice a modificar y el valor que se modificara.
     * Posible Tipo de Excepcion ArrayIndexOutOfBoundsException (indice del arreglo fuera de rango)
     * @param indice
     * @param valor 
     */
    public void setNumber(int indice, int valor) {
        try {
            numeros[indice] = valor;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El indice esta fuera de rango!");
        }
    }

}
