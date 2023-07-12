package main;

public class Dos {

    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Excepcion en metodo() ");
            e.printStackTrace();
        }
    }

    /**
     * Al llegar a la linea 23 (valor = 1) salta error que se captura en linea 27 y modifica en la linea 
     * 28 (valor = 43), pasa por bloque finally y suma uno y al salir suma uno total a imprimirse  
     * valor = 45.
     * @return 
     */
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("W");
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
