package entidades;

import enumeraciones.Color;
import java.util.*;

/**
 * Armadura cuenta con un color primario y uno secundario, 2 propulsores(botas),
 * 2 repulsores(guantes/armas) que le permiten volar, nivel de
 * resistencia(dureza rockwell - entero) segun el material de fabricacion, nivel
 * de salud(0 a 100), un generador/bateria(alimenta de energia la armadura) y
 * una consola/sintetizador/casco
 *
 * @author Ana
 */
public class Armadura {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private Random r = new Random();
    private Color colorPrimario = Color.ROJO;
    private Color colorSecundario = Color.DORADO;
    private int nivelResistencia = 150; // (kg se siboloza HRC)
    private int nivelSalud; // (0 a 100) ???
    private Propulsor botaDerecha;
    private Propulsor botaIzquierda;
    private Repulsor guanteDerecho;
    private Repulsor guanteIzquierdo;
    private Consola casco;
    private Generador bateria;

    public Generador getBateria() {
        return bateria;
    }

    public Propulsor getBotaDerecha() {
        return botaDerecha;
    }

    public void setBotaDerecha(Propulsor botaDerecha) {
        this.botaDerecha = botaDerecha;
    }

    public Propulsor getBotaIzquierda() {
        return botaIzquierda;
    }

    public void setBotaIzquierda(Propulsor botaIzquierda) {
        this.botaIzquierda = botaIzquierda;
    }

    public Repulsor getGuanteDerecho() {
        return guanteDerecho;
    }

    public void setGuanteDerecho(Repulsor guanteDerecho) {
        this.guanteDerecho = guanteDerecho;
    }

    public Repulsor getGuanteIzquierdo() {
        return guanteIzquierdo;
    }

    public void setGuanteIzquierdo(Repulsor guanteIzquierdo) {
        this.guanteIzquierdo = guanteIzquierdo;
    }

    public Consola getCasco() {
        return casco;
    }

    public void setCasco(Consola casco) {
        this.casco = casco;
    }
    
    /**
     * Metodo para caminar. Comprueba estado de botas, usa el metodo de calculo de gasto energetico y 
     * provee el valor al generador para que descuente el gasto energetico debido a la accion.
     */
    public void caminar() {
        if (botaDerecha.comprobarEstado() && botaIzquierda.comprobarEstado()) {
            System.out.println("Ingrese el tiempo que camina en minutos");
            float tiempo = leer.nextFloat();
            System.out.println("Ingrese la intensidad de la accion");
            float intensidad = leer.nextFloat();
            float consumo = botaDerecha.caminar(intensidad, tiempo) + botaIzquierda.caminar(intensidad, tiempo);
            bateria.consumoEnergia(consumo);
            botaDerecha.setDanio(botaDerecha.sufrirDanio());
            botaIzquierda.setDanio(botaIzquierda.sufrirDanio());
        } else {
            System.out.println("Una de los Propulsores se encuentra dañado, no podemos caminar");
        }
    }

    /**
     * Metodo para correr. Comprueba estado de botas, usa el metodo de calculo de gasto energetico y 
     * provee el valor al generador para que descuente el gasto energetico debido a la accion.
     */
    public void correr() {
        if (botaDerecha.comprobarEstado() && botaIzquierda.comprobarEstado()) {
            System.out.println("Ingrese el tiempo que corre en minutos");
            float tiempo = leer.nextFloat();
            System.out.println("Ingrese la intensidad de la accion");
            float intensidad = leer.nextFloat();
            float consumo = botaDerecha.correr(intensidad, tiempo) + botaIzquierda.correr(intensidad, tiempo);
            bateria.consumoEnergia(consumo);
            botaDerecha.setDanio(botaDerecha.sufrirDanio());
            botaIzquierda.setDanio(botaIzquierda.sufrirDanio());
        } else {
            System.out.println("Una de los Propulsores se encuentra dañado, no podemos correr");
        }
    }

    /**
     * Metodo para propulsar. Comprueba estado de botas, usa el metodo de calculo de gasto energetico y 
     * provee el valor al generador para que descuente el gasto energetico debido a la accion.
     */
    public void propulsar() {
        if (botaDerecha.comprobarEstado() && botaIzquierda.comprobarEstado()) {
            System.out.println("Ingrese el tiempo que propulsa en minutos");
            float tiempo = leer.nextFloat();
            System.out.println("Ingrese la intensidad de la accion");
            float intensidad = leer.nextFloat();
            float consumo = botaDerecha.propulsar(intensidad, tiempo) + botaIzquierda.propulsar(intensidad, tiempo);
            bateria.consumoEnergia(consumo);
            botaDerecha.setDanio(botaDerecha.sufrirDanio());
            botaIzquierda.setDanio(botaIzquierda.sufrirDanio());
        } else {
            System.out.println("Una de los Propulsores se encuentra dañado, no podemos propulsar");
        }
    }

    /**
     * Metodo para volar. Comprueba estado de botas y guantes, usa el metodo de calculo de gasto energetico 
     * y provee el valor al generador para que descuente el gasto energetico debido a la accion.
     */
    public void volar() {
        if (botaDerecha.comprobarEstado() && botaIzquierda.comprobarEstado()
                && guanteDerecho.comprobarEstado() && guanteIzquierdo.comprobarEstado()) {
            System.out.println("Ingrese el tiempo que vuela en minutos");
            float tiempo = leer.nextFloat();
            System.out.println("Ingrese la intensidad del vuelo");
            float intensidad = leer.nextFloat();
            float consumo = botaDerecha.volar(intensidad, tiempo) + botaIzquierda.volar(intensidad, tiempo)
                    + guanteDerecho.volar(intensidad, tiempo) + guanteIzquierdo.volar(intensidad, tiempo);
            bateria.consumoEnergia(consumo);
            botaDerecha.setDanio(botaDerecha.sufrirDanio());
            botaIzquierda.setDanio(botaIzquierda.sufrirDanio());
            guanteDerecho.setDanio(guanteDerecho.sufrirDanio());
            guanteIzquierdo.setDanio(guanteIzquierdo.sufrirDanio());
        } else {
            System.out.println("Un de los Propulsores y/o Repulsores se encuentra dañado, no podemos volar");
        }
    }

    /**
     * Vuelo Evasivo Division de energia restante a los dispositivos para el escape. Recibe la reserva de
     * energia para dividir entre las partes y emprender el escape.
     * @param enerBotas
     * @param enerGuantes 
     */
    public void volarEvasivo(float enerBotas, float enerGuantes) {
        float enerBota = enerBotas / 2;
        float enerGuante = enerGuantes / 2;
        botaDerecha.volarEvasivo(enerBota);
        botaIzquierda.volarEvasivo(enerBota);
        guanteDerecho.volarEvasivo(enerGuante);
        guanteIzquierdo.volarEvasivo(enerGuante);
  
    }
    
    /**
     * Metodo para atacar con los guantes. Comprueba el daño en cada parte y si no esta dañada emplea el 
     * ataque estipulado. Usa el metodo de calculo de gasto energetico y provee el valor al generador para 
     * que descuente el gasto energetico debido a la accion.
     */
    public int atacar() {
        System.out.println("Ingrese el tiempo que ataca en minutos");
        float tiempo = leer.nextFloat();
        System.out.println("Ingrese la intensidad del ataque");
        float intensidad = leer.nextFloat();
        float consumo = 0;
        if (!guanteDerecho.isDanio()) {
            consumo += guanteDerecho.atacar(intensidad, tiempo);
        }
        if(!guanteIzquierdo.isDanio()) {
            consumo += guanteIzquierdo.atacar(intensidad, tiempo);
        }
        bateria.consumoEnergia(consumo);
        guanteDerecho.setDanio(guanteDerecho.sufrirDanio());
        guanteIzquierdo.setDanio(guanteIzquierdo.sufrirDanio());
        return (int) consumo;
    }

    /**
     * Metodo que muestra el estado de cada parte de la armadura.
     */
    public void mostrarEstado() {
        if (casco.danio) {
            System.out.println("El Casco se encuentra sin daños");
        } else {
            System.out.println("El Casco se encuentra dañado.\nIniciando intentos de reparacion");
        }
        if (guanteDerecho.danio) {
            System.out.println("El Guante Derecho se encuentra sin daños");
        } else {
            System.out.println("El Guante Derecho se encuentra dañado.\nIniciando intentos de reparacion");
        }
        if (guanteIzquierdo.danio) {
            System.out.println("El Guante Izquierdo se encuentra sin daños");
        } else {
            System.out.println("El Guante Izquierdo se encuentra dañado.\nIniciando intentos de reparacion");
        }
        if (botaDerecha.danio) {
            System.out.println("El Bota Derecha se encuentra sin daños");
        } else {
            System.out.println("El Bota Derecha se encuentra dañado.\nIniciando intentos de reparacion");
        }
        if (botaIzquierda.danio) {
            System.out.println("El Bota Izquierda se encuentra sin daños");
        } else {
            System.out.println("El Bota Izquierda se encuentra dañado.\nIniciando intentos de reparacion");
        }
    }

}
