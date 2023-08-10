package servicios;

import entidades.*;
import java.util.*;

/**
 * Falta Metodo para ingreso manual de Tipos de Alojamiento
 *
 * @author Ana
 */
public class TurismoServicio {

    /**
     * Muestra Todos los Alojamientos en el ArrayList
     *
     * @param lugares
     */
    public void mostrarAlojamientos(ArrayList<Alojamiento> lugares) {
        for (Alojamiento lugar : lugares) {
            if (lugar instanceof FiveStars) {
                FiveStars fiveS = (FiveStars) lugar;
                System.out.println(fiveS.toString() + " Precio Habitacion: $ " + fiveS.precioHabitacion());
            } else {
                if (lugar instanceof FourStars) {
                    FourStars fourS = (FourStars) lugar;
                    System.out.println(fourS.toString() + " Precio Habitacion: $ " + fourS.precioHabitacion());
                } else {
                    if (lugar instanceof Residencias) {
                        Residencias resi = (Residencias) lugar;
                        System.out.println(resi.toString() + " Precio Habitacion: $ " + resi.valorEntrada());
                    } else {
                        if (lugar instanceof Camping) {
                            Camping camp = (Camping) lugar;
                            System.out.println(camp.toString() + " Precio Habitacion: $ " + camp.valorEntrada());
                        }
                    }
                }
            }
        }
    }

    /**
     * Mustra Todos los Hoteles Ordenamos por Precio del Mas Caro al Mas Barato
     *
     * @param lugares
     */
    public void ordenarHoteles(ArrayList<Alojamiento> lugares) {
        ArrayList<FourStars> aux = new ArrayList();
        for (Alojamiento lugar : lugares) {
            if (lugar instanceof FiveStars) {
                FiveStars fiveS = (FiveStars) lugar;
                aux.add(fiveS);
            } else {
                if (lugar instanceof FourStars) {
                    FourStars fourS = (FourStars) lugar;
                    aux.add(fourS);
                }
            }
        }
        Collections.sort(aux, compararPrecio);
        for (FourStars fourStars : aux) {
            System.out.println(fourStars.toString() + " Precio Habitacion: $ " + fourStars.precioHabitacion());
        }
    }

    /**
     * Metodo Comparator para ordenar por Precio de Habitacion(Hotel)
     */
    public static Comparator<FourStars> compararPrecio = new Comparator<FourStars>() {
        @Override
        public int compare(FourStars o1, FourStars o2) {
            return o2.precioHabitacion().compareTo(o1.precioHabitacion());
        }
    };

    /**
     * Muestra Todos los Campings con Restaurant
     *
     * @param lugares
     */
    public void campingResto(ArrayList<Alojamiento> lugares) {
        for (Alojamiento lugar : lugares) {
            if (lugar instanceof Camping) {
                Camping camp = (Camping) lugar;
                if (camp.isResto()) {
                    System.out.println("Camping con Restaurante");
                    System.out.println(camp.toString());
                }
            }
        }
    }

    /**
     * Muestra Todas las Residencias con Descuento
     *
     * @param lugares
     */
    public void residenciasDesc(ArrayList<Alojamiento> lugares) {
        for (Alojamiento lugar : lugares) {
            if (lugar instanceof Residencias) {
                Residencias resi = (Residencias) lugar;
                if (resi.isDescGremio()) {
                    System.out.println("Residencias con Descuento");
                    System.out.println(resi.toString());
                }
            }
        }
    }

}
