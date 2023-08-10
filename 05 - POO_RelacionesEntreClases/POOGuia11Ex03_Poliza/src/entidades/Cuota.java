package entidades;

import java.time.LocalDate;

public class Cuota {

    private Integer numCuota;
    private Integer montoCuota;
    private Boolean paga;
    private LocalDate fechaDeVencimiento;

    public Integer getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(Integer numCuota) {
        this.numCuota = numCuota;
    }

    public Integer getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(Integer montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Cuota() {
    }

    public Cuota(Integer numCuota, Integer montoCuota, Boolean paga, LocalDate fechaDeVencimiento) {
        this.numCuota = numCuota;
        this.montoCuota = montoCuota;
        this.paga = paga;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    @Override
    public String toString() {
        return "\nCuotas: " + "N° Cuota:" + numCuota + ", Monto Cuota: " + montoCuota + ", Paga: " + paga 
                + ", Fecha Vencimiento: " + fechaDeVencimiento;
    }

}
