package entidades;

public class Sala {
    
    public Asiento[][] crearSalaMatriz() {
        String[] columna = {"A", "B", "C", "D", "E", "F"};
        Asiento[][] salaMatriz = new Asiento[8][6];
        for (int i = salaMatriz.length - 1; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                Asiento asiento = new Asiento();
                asiento.setPosicion((i + 1) + columna[j]);
                asiento.setLugar(" ");
                salaMatriz[i][j] = asiento;
            }
        }
        return salaMatriz;
    }
 
}
