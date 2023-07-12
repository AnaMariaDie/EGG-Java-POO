package main;

public class Uno {

    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Excepcion en metodo() ");
            e.printStackTrace();
        }
    }
    
    /**
     * Al pasar por el bloque try sin problemas (valor = 44) no pasa por el bloque catch y continua en el  
     * bloque finally donde valor = 45 y al finalizar el bloque suma uno; total a imprimirse valor = 46.
     * @return 
     */
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("42");
            valor = valor + 1;
            System.out.println("Valor final del try: " + valor);
        } catch (NumberFormatException e) {
            valor = valor + Integer.parseInt("42");
            System.out.println("Valor final del catch: " + valor);
        } finally {
            valor = valor + 1;
            System.out.println("Valor final del finally: " + valor);
        }
        valor = valor + 1;
        System.out.println("Valor antes del return: " + valor);
        return valor;
    }
}
