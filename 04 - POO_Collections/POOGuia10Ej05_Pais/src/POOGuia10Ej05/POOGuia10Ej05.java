package POOGuia10Ej05;

import servicios.PaisService;

public class POOGuia10Ej05 {

    public static void main(String[] args) {
        
        PaisService ps = new PaisService();
        ps.guardarPaises();
        ps.eliminarPais();
    }
}
