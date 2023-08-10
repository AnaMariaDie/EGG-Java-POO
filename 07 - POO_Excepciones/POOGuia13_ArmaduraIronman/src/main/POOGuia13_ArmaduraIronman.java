package main;

import entidades.*;
import java.util.*;

public class POOGuia13_ArmaduraIronman {

    public static void main(String[] args) {
        
        Jarvis jarvis = new Jarvis();
        jarvis.mostrarEstadoArmadura();
        jarvis.estadoBateria();
        jarvis.revisandoDispositivos();
        ArrayList<Enemigo> objetivos = jarvis.radarVersion();
        jarvis.destruyendoEnemigo(objetivos);
    }
}
