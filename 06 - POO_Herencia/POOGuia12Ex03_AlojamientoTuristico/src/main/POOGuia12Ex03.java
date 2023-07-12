package main;

import entidades.*;
import java.util.*;
import servicios.TurismoServicio;

public class POOGuia12Ex03 {

    public static void main(String[] args) {
        ArrayList<Alojamiento> lugares = crearAlojamientos();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        TurismoServicio ts = new TurismoServicio();
        boolean salir = true;
        do {
            System.out.println("\n**** Menu de Servicios ****");
            System.out.println("\n- Indique la opcion que desea realizar -");
            System.out.println("1. Ver los Alojamientos disponibles\n2. Ver solo los Hoteles (del mas caro "
                    + "al mas barato)\n3. Ver Campings con Restaurante\n4. Ver Residencias con Descuento\n5. "
                    + "Salir");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    ts.mostrarAlojamientos(lugares);
                    break;
                case 2:
                    ts.ordenarHoteles(lugares);
                    break;
                case 3:
                    ts.campingResto(lugares);
                    break;
                case 4:
                    ts.residenciasDesc(lugares);
                    break;
                case 5:
                    System.out.println("Confirma su salida? S/N");
                    if (leer.next().equalsIgnoreCase("S")) {
                        salir = false;
                    }
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (salir);
    }

    /**
     * Metodo que crea una ArrayList de Alojamientos seteados previamente.
     *
     * @return
     */
    public static ArrayList<Alojamiento> crearAlojamientos() {
        ArrayList<Alojamiento> aux = new ArrayList();
        Alojamiento c1 = new Camping(50, 5, true, true, 600, "Campos Anna", "Calle Falsa 123",
                "Public Gardens", "Guille");
        aux.add(c1);
        Alojamiento c2 = new Camping(25, 3, false, false, 200, "Campos Eliseos", "Rue de la Morte 753",
                "Jardines Reales", "Sra. Marie");
        aux.add(c2);
        Alojamiento r1 = new Residencias(60, true, true, true, 300, "Residencias Hanna", "Fake Street 456",
                "Private Filds", "Sr. Tony");
        aux.add(r1);
        Alojamiento r2 = new Residencias(40, false, false, false, 150, "Master Residencias", "Marito Cho 452",
                "Gran Muralla", "Mrs. Mei");
        aux.add(r2);
        Alojamiento fourS = new FourStars('A', "Bar & Resto", 50, 40, 80, 5, "Hotel Lux 4 Stars",
                "Tsim Sha Tsui 159", "Hong Kong", "Wei Wu Xian");
        aux.add(fourS);
        Alojamiento fourS1 = new FourStars('B', "Ottimo Ristorante", 25, 30, 60, 4, "Hotel Di Lusso 4 Stars",
                "Trattoria 862", "La Toscanisa", "Sra. Luisina");
        aux.add(fourS1);
        Alojamiento fiveS = new FiveStars(3, 10, 8, 'A', "RestoBar Luxury", 150, 100, 200, 12,
                "Luxury Hotel 5 Stars", "Myeongdong 789", "Gangnam", "Mr. Seo Joon");
        aux.add(fiveS);
        Alojamiento fiveS1 = new FiveStars(2, 5, 4, 'B', "Le Cuisine", 100, 50, 100, 10,
                "Le Grand Hotel 5 Stars", "Merveilleux Rue 624", "Parisine", "Mrs. Peregrine");
        aux.add(fiveS1);
        return aux;
    }
}
