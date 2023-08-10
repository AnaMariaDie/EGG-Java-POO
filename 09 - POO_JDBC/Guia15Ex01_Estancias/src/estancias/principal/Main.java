package estancias.principal;

import estancias.entidades.Familias;
import estancias.servicios.FamiliasService;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        FamiliasService fs = new FamiliasService();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc = 0;
        do {
            System.out.println("********** MENU **********");
            System.out.println("1) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
            System.out.println("2) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de "
                    + "agosto de 2020 y el 31 de agosto de 2020 en Reino Unido");
            System.out.println("3) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail");
            System.out.println("4) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una "
                    + "fecha dada y un número de días específico.");
            System.out.println("5) Listar los datos de todos los clientes que en algún momento realizaron una "
                    + "estancia y la descripción de la casa donde la realizaron");
            System.out.println("6) Listar todas las estancias que han sido reservadas por un cliente, mostrar el "
                    + "nombre, país y ciudad del cliente y además la información de la casa que reservó. La que "
                    + "reemplazaría a la anterior");
            System.out.println("7) Debido a la devaluación de la libra esterlina con respecto al euro se desea "
                    + "incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios"
                    + "actualizados");
            System.out.println("8) Obtener el número de casas que existen para cada uno de los países diferentes");
            System.out.println("9) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas "
                    + "(comentarios) que están ‘limpias’");
            System.out.println("10) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las"
                    + "fechas");
            System.out.println("11) Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    fs.listarFamHijosEdadMax();
                    break;
                case 2:
                    break;
                case 3:
                    Collection<Familias> familias = fs.buscarFamiliaPorEmail();
                    fs.imprimirFamilias(familias);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    System.out.println("Usted esta saliendo del sistema . . . ");
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        } while (opc != 11);
    }
}
