package entidades;

import java.util.*;

/**
 * Jarvis controla la armadura y obtiene informacion e ella para notificar a
 * Stark.
 *
 * @author Ana
 */
public class Jarvis {

    private Random r = new Random();
    private Armadura armadura;
    private final int fueraRango = 5000;

    /**
     * Muestra el nivel de la bateria(energia) en porcentaje.
     */
    public void estadoBateria() {
        System.out.println("Sr. el nivel de Bateria restante es del " + armadura.getBateria().estadoBateria()
                + " porciento");
    }

    /**
     * Muestra Estado de la Armadura(metodo de Armadura) parte por parte.
     */
    public void mostrarEstadoArmadura() {
        armadura.mostrarEstado();
    }

    /**
     * Metodo que Revisa Dispositivos Dañados y de estarlo comienza la
     * reparacion hasta lograrla.
     */
    public void revisandoDispositivos() {
        int reparar = 0;
        int bucle = 0;
        do {
            if (armadura.getBotaDerecha().isDanio()) {
                reparar = r.nextInt(100);
                if (reparar <= 30) {
                    armadura.getBotaDerecha().setDanio(false);
                    System.out.println("Propulsor Derecho reparado");
                    bucle++;
                } else {
                    System.out.println("No se ha podido reparar el Propulsor Derecho\nSeguire intentando Sr.");
                }
            }
            if (armadura.getBotaIzquierda().isDanio()) {
                reparar = r.nextInt(100);
                if (reparar <= 30) {
                    armadura.getBotaIzquierda().setDanio(false);
                    System.out.println("Propulsor Izquierdo reparado");
                    bucle++;
                } else {
                    System.out.println("No se ha podido reparar el Propulsor Izquierdo\nSeguire intentando Sr.");
                }
            }
            if (armadura.getGuanteDerecho().isDanio()) {
                reparar = r.nextInt(100);
                if (reparar <= 30) {
                    armadura.getGuanteDerecho().setDanio(false);
                    System.out.println("Repulsor Derecho reparado");
                    bucle++;
                } else {
                    System.out.println("No se ha podido reparar el Repulsor Derecho\nSeguire intentando Sr.");
                }
            }
            if (armadura.getGuanteIzquierdo().isDanio()) {
                reparar = r.nextInt(100);
                if (reparar <= 30) {
                    armadura.getGuanteIzquierdo().setDanio(false);
                    System.out.println("Repulsor Izquierdo reparado");
                    bucle++;
                } else {
                    System.out.println("No se ha podido reparar el Repulsor Izquierdo\nSeguire intentando Sr.");
                }
            }
        } while (bucle != 4);
    }

    /**
     * Simulador - Radar detecta hasta 10 objetos con sus coordenadas y la
     * resistencia del objeto. Hostiles o no. Armadura siempre en coordenana
     * (0,0,0).
     *
     * @return
     */
    public ArrayList<Enemigo> radarVersion() {
        ArrayList<Enemigo> objetivos = new ArrayList();
        int detectaObj = r.nextInt(10); // se detectan objetivos si el numero es menor a 5
        int objDetectados = r.nextInt(20); // cantidad detectada de objetivos
        if (detectaObj < 5 && objDetectados != 0) {
            System.out.println("Se han detectado " + objDetectados + " objetos.\nSe procede a su evaluacion");
            int contHostil = 0;
            for (int i = 0; i < objDetectados; i++) {
                int hostilRand = r.nextInt(10);
                boolean hostil = false;
                if (hostilRand < 5) {
                    hostil = true;
                    contHostil++; // objetivos no hostiles
                }
                // se setean con atributos de distancia, resistencia y hostilidad
                int a = r.nextInt(100);
                int b = r.nextInt(100);
                int c = r.nextInt(100);
                // se calcula la distancia al objetivo
                int distancia = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
                int resistencia = r.nextInt(500);
                // se agrega a la lista de enemigos hostiles o no
                objetivos.add(new Enemigo(distancia, resistencia, hostil));
            }
            System.out.println("De los objetivos detectados solo " + (objDetectados - contHostil)
                    + " califican como Hostiles");
        } else {
            System.out.println("Ningun objeto detectado");
        }
        return objetivos;
    }

    /**
     * Simulador de ataque. Chequear primero si ambos guantes estan sin daño
     * antes de proceder al ataque.
     *
     * @param objetivos
     */
    public void simuladorAtaques(ArrayList<Enemigo> objetivos) {

    }

    /**
     * Metodo para Atacar Enemigo. Mientras sea hostil, su rango sea menor a
     * 5000 mts y tenga resistencia. Se ataca con ambos repulsores si estan
     * sanos.
     *
     * @param objetivos
     */
    public void destruyendoEnemigo(ArrayList<Enemigo> objetivos) {
        for (Enemigo objetivo : objetivos) {
            if (objetivo.isHostil()) {
                if (objetivo.getDistancia() > this.fueraRango) {
                    System.out.println("El objetivo es hostil pero se encuentra fuera del rango de ataque");
                } else {
                    while (objetivo.getResistencia() != 0) {
                        if (armadura.getGuanteDerecho().isDanio() && armadura.getGuanteIzquierdo().isDanio()) {
                            System.out.println("Ambos Repulsores se encuentran dañados, no pueden disparar"
                                    + "Sugiero acciones evasivas Sr."); 
                            break;
                        } else {
                            float bateria = armadura.getBateria().estadoBateria();
                                if (bateria < 10) {
                                    System.out.println("Bateria en 10%\nIniciando acciones avasivas");
                                    break;
                            }
                            objetivo.setResistencia(objetivo.getResistencia() - armadura.atacar());
                        }
                    }
                    System.out.println("Objetivo Hostil Destruido");
                }
            } else {
                System.out.println("Objetivo no hostil");
            }
        }
        accionesEvasivas();
    }
    
    /**
     * Metodo para Evadir Enemigo en caso de que la energia de la bateria sea menor al 10% o ambos guantes 
     * esten dañados. Debemos volar al menos 10 km lejos del enemigo. Velocidad de vuelo promedio 300km/hora.
     */
    public void accionesEvasivas() {
        float restante = armadura.getBateria().getCargaRestante();
        float enerGuantes = (40 * restante) / 100;
        float enerBotas = (60 * restante) / 100;
        armadura.volarEvasivo(enerBotas, enerGuantes);   
        System.out.println("Alejandonos del peligro...");
    }
}
