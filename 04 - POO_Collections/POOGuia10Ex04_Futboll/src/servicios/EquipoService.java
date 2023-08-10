package servicios;

import entidad.EquipoDe;
import java.util.ArrayList;
import utilidades.Comparadores;

public class EquipoService {

    public void mostrarEquipo(ArrayList<EquipoDe> division) {
        for (EquipoDe equipoDe : division) {
            System.out.println(equipoDe);
        }
        System.out.println("");
    }
    
    public void ordenPuntos(ArrayList<EquipoDe> division) {
        division.sort(Comparadores.ordenarPorPuntos);
    }
    
    public void reinicioTemporada(ArrayList<EquipoDe> division) {
        for (EquipoDe equipoDe : division) {
            equipoDe.setCantidadPartidosEmpatados(0);
            equipoDe.setCantidadPartidosGanados(0);
            equipoDe.setCantidadPartidosJugados(0);
            equipoDe.setCantidadPartidosPerdidos(0);
            equipoDe.setPuntosTotales(0);
        }
        division.sort(Comparadores.ordenarPorNombre);
        mostrarEquipo(division);
    }
    
    public void equipoGanador(ArrayList<EquipoDe> division) {
        ordenPuntos(division);
        System.out.println(division.get(0).getNombreEquipo());
    }
    
    public void equipoEliminado(ArrayList<EquipoDe> division) {
        ordenPuntos(division);
        System.out.println(division.get(division.size() - 1).getNombreEquipo());
        division.remove(division.size() - 1);
    }
    
}
