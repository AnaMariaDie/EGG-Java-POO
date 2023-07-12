package entidades;

public class Sala {

    private Asiento[][] salaMatriz = new Asiento[8][6];
    
    public Asiento[][] crearSalaMatriz() {
        String[] columna = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                Asiento asiento = new Asiento();
                asiento.setPosicion((i + 1) + columna[j]);
                asiento.setLugar(" ");
                salaMatriz[i][j] = asiento;
            }
        }
        return salaMatriz;
    }
    
//    public void mostrarAsientos() {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print("[ " + salaMatriz[i][j] + " ]");
//            }
//            System.out.println("");
//        }
//    }

    public Asiento[][] getSalaMatriz() {
        return salaMatriz;
    }

    public void setSalaMatriz(Asiento[][] salaMatriz) {
        this.salaMatriz = salaMatriz;
    }
    
    
}
