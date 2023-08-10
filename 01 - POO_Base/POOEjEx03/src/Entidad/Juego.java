package Entidad;

import java.util.Scanner;

public class Juego {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private int numeroIncognito;
    private int numeroAdivinar;
    private int aciertos = 0;
    private int perdio = 0;
    private final int limite = 3;
    private int intento = 0;
    private boolean bandera = true;

    public Juego() {
    }

    public Juego(int numeroIncognito) {
        this.numeroIncognito = numeroIncognito;
    }

    public int getNumeroIncognito() {
        return numeroIncognito;
    }

    public void setNumeroIncognito(int numeroIncognito) {
        this.numeroIncognito = numeroIncognito;
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getPerdio() {
        return perdio;
    }

    public void setPerdio(int perdio) {
        this.perdio = perdio;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    @Override
    public String toString() {
        return "Juego{" + "numeroIncognito=" + numeroIncognito + ", numeroAdivinar=" + numeroAdivinar 
                + ", aciertos=" + aciertos + ", perdio=" + perdio + ", limite=" + limite + ", intento=" 
                + intento + ", bandera=" + bandera + '}';
    }

    public void iniciarJuego() {
        System.out.println("Jugador 1: Ingresa un numero");
        this.numeroIncognito = leer.nextInt();
        System.out.println("Jugador 2: Adivina el numero (tienes 3 intentos)\n Intento N° 1");
        this.numeroAdivinar = leer.nextInt();
    }

    public void comprobarNumero() {
        do {
            for (int i = 1; i <= this.limite; i++) {
                this.intento += 1;
                if (this.numeroAdivinar > this.numeroIncognito) {
                    System.out.println(" Mas Bajo! Intenta otro numero. Itento N° " + (i + 1));
                    this.numeroAdivinar = leer.nextInt();
                } else {
                    if (this.numeroAdivinar < this.numeroIncognito) {
                        System.out.println(" Mas Alto! Intenta otra vez. Inteno N° " + (i + 1));
                        this.numeroAdivinar = leer.nextInt();
                    } else {
                        if (this.numeroAdivinar == this.numeroIncognito) {
                            this.aciertos += 1;
                            break;
                        } else {
                            if (this.intento == this.limite) {
                                this.perdio += 1;
                                break;
                            }
                        }
                    }
                }
                System.out.println("Quieres jugar de nuevo? si / no");
                String resp = leer.next();
                if (resp.equals("no")) {
                    setBandera(false);
                    setIntento(0);
                    mostrarResultados();
                } else {
                    if (resp.equals("si")) {
                        setIntento(0);
                        iniciarJuego();
                    }
                }
            }
        } while (this.bandera != false);
    }

    public void mostrarResultados() {
        System.out.println("Resultados:\n   Jugador 1 gano " + getPerdio() + " veces");
        System.out.println("   Jugador 2 gano " + getAciertos() + " veces");
    }
}
