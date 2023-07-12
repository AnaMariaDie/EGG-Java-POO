package main;

public class Tres {

    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Excepcion en metodo()");
            e.printStackTrace();
        }
    }

    /**
     * Al llegar a la linea 24 (valor = 1) salta error que se captura en linea 28 y vuelve a ocurrir el error
     * que interrumpe el programa, aunque sin importar que, se pasa por el bloque finally donde suma uno, 
     * total a imprimirse valor = 2.
     *
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
            valor = valor + Integer.parseInt("W");
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
