package entidades;

public class NIF {
    
    private long nDNI;
    private String letra;
    private String letras [] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
        "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
    
    // Constructores
    public NIF() {
    }

    public NIF(long nDNI, String letra) {
        this.nDNI = nDNI;
        this.letra = letra;
    }
    
    // Getters y Setters

    public long getnDNI() {
        return nDNI;
    }

    public void setnDNI(long nDNI) {
        this.nDNI = nDNI;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String[] getLetras() {
        return letras;
    }

    public void setLetras(String[] letras) {
        this.letras = letras;
    }

}
