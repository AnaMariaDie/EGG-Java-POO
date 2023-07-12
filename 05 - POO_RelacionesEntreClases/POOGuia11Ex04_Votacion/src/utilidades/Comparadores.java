package utilidades;

import entidades.Alumno;
import entidades.Voto;
import java.util.Comparator;

public class Comparadores {

    public static Comparator<Alumno> comparaVotos = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno a1, Alumno a2) {
            return a2.getCantidadVotos().compareTo(a1.getCantidadVotos());
        }
    };
    
    public static Comparator<Voto> comparaVotosporVoto = new Comparator<Voto>() {
        @Override
        public int compare(Voto v1, Voto v2) {
            return v2.getAlumno().getCantidadVotos().compareTo(v1.getAlumno().getCantidadVotos());
        }
    };
}
