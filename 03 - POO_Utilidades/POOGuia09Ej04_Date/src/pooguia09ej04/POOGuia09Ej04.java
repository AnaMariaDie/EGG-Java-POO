package pooguia09ej04;

import java.util.Date;
import servicios.FechaService;

public class POOGuia09Ej04 {

    public static void main(String[] args) {
        FechaService fs = new FechaService();
        Date fechaNac = fs.fechaNacimiento();
        System.out.println("Fecha de Nacimiento: " + fechaNac.getDate() + " / " + fechaNac.getMonth() + " / " 
                + fechaNac.getYear());
        Date fechaAct = fs.fechaActual();
        // La configuracion de mes es 0 a 11 por eso agrego + 1 y la de años es - 1900, por eso sumo la misma 
        // cantidad para que indique el año actual
        System.out.println("Fecha Actual: " + fechaAct.getDate() + " / " + (fechaAct.getMonth()+1) + " / " 
                + (fechaAct.getYear()+1900));
        int aniosDiferencia = fs.diferencia(fechaNac, fechaAct);
        System.out.println("Diferencia en años: " + aniosDiferencia);
    }
    
}
