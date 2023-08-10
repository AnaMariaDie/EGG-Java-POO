package POOGuia09;

import servicios.EstudiantesService;

public class POOGuia09 {

    public static void main(String[] args) {
        EstudiantesService estserv = new EstudiantesService();
        estserv.crearEstudiantes();
        estserv.mostrar(estserv.mayorPromedio());
        // i *= 2 hace que i se multiplique por 2
        for (int i = 2; i <= 128; i *= 2) {
            System.out.println("i " + i);
        }
    }

}
