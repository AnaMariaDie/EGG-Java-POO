package main;

import entidad.EquipoDe;
import java.util.*;
import servicios.EquipoService;

/*
2) En este ejercicio vamos a mostrar la tabla de posiciones final de un torneo del deporte que deseen. 
Para ello deberán crear una clase llamada "EquipoDe…" que represente a un equipo del deporte seleccionado. 
La clase debe tener los siguientes atributos: nombre del equipo, ciudad, cantidad de partidos jugados, ganados, 
perdidos y empatados, y puntos totales. En el programa principal, crear una lista de tipo "EquipoDe…" y agregar 
10 objetos de tipo equipo a la lista. Luego, mostrar por pantalla de forma ordenada según cantidad de puntos los 
nombres de cada equipo, su cantidad de puntos, partidos jugados, ganados, perdidos y empatados. Una vez finalizado 
el torneo, determinar el equipo ganador, eliminar al último equipo de la tabla por haber descendido, sumar al nuevo 
equipo que ascendió de la división inferior, reiniciar los valores de partidos y puntos a 0 para el inicio del 
siguiente campeonato y mostrar la lista en orden alfabético de los equipos.
 */
public class POOGuia10Ex04 {

    public static void main(String[] args) {

        ArrayList<EquipoDe> division = new ArrayList<>();
        division.add(new EquipoDe("Francia", "Europa", 10, 9, 1, 0, 17));
        division.add(new EquipoDe("Alemania", "Europa", 10, 8, 2, 0, 18));
        division.add(new EquipoDe("Austria", "Europa", 10, 7, 3, 0, 13));
        division.add(new EquipoDe("Inglaterra", "Europa", 10, 8, 2, 0, 14));
        division.add(new EquipoDe("España", "Europa", 10, 9, 1, 0, 19));
        division.add(new EquipoDe("Turquia", "Europa", 10, 9, 1, 0, 15));
        division.add(new EquipoDe("Holanda", "Europa", 10, 7, 2, 1, 16));
        division.add(new EquipoDe("Grecia", "Europa", 10, 8, 1, 1, 11));
        division.add(new EquipoDe("China", "Europa", 10, 9, 1, 0, 12));
        division.add(new EquipoDe("Suecia", "Europa", 10, 8, 2, 0, 10));
        
        EquipoService es = new EquipoService();
        System.out.println("**** Equipos Cargados ****");
        es.mostrarEquipo(division);
        System.out.println("**** Equipos Ordenados por Puntos ****");
        es.ordenPuntos(division);
        es.mostrarEquipo(division);
        System.out.println("**** Equipos Ganador ****");
        es.equipoGanador(division);
        System.out.println("**** Equipos Eliminado ****");
        es.equipoEliminado(division);
        System.out.println("**** Equipos Inicio de Temporada ****");
        es.reinicioTemporada(division);
    }

}
