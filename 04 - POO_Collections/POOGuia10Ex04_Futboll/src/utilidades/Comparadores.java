package utilidades;

import entidad.EquipoDe;
import java.util.Comparator;

public class Comparadores {

    public static Comparator<EquipoDe> ordenarPorPuntos = new Comparator<EquipoDe>() {
        @Override
        public int compare(EquipoDe o1, EquipoDe o2) {
            return o2.getPuntosTotales().compareTo(o1.getPuntosTotales());
        }
    };
    
    public static Comparator<EquipoDe> ordenarPorNombre = new Comparator<EquipoDe>() {
        @Override
        public int compare(EquipoDe o1, EquipoDe o2) {
            return o1.getNombreEquipo().compareTo(o2.getNombreEquipo());
        }
    };
}
