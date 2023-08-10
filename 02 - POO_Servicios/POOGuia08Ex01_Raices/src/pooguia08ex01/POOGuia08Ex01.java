package pooguia08ex01;

import entidades.Raices;
import servicios.RaicesServicio;

public class POOGuia08Ex01 {

    public static void main(String[] args) {
        RaicesServicio rs1 = new RaicesServicio();
        Raices r1 = rs1.crearRaices();
        rs1.calcular(r1);
    }
    
}
