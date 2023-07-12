package entidades;

import enumeraciones.Cobertura;
import enumeraciones.Pago;
import java.time.LocalDate;
import java.util.ArrayList;

public class Poliza {

    private Integer numPoliza;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer cantidadCuotas;
    private Pago formaDePago;
    private Integer montoAsegurado;
    private Boolean incluyeGranizo;
    private Integer montoMaximoGranizo;
    private Cobertura tipoCobertura;
    private Vehiculo vehiculo;
    private ArrayList<Cuota> cuotas;

    public ArrayList<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(ArrayList<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(Integer numPoliza) {
        this.numPoliza = numPoliza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Pago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(Pago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Integer getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(Integer montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public Boolean getIncluyeGranizo() {
        return incluyeGranizo;
    }

    public void setIncluyeGranizo(Boolean incluyeGranizo) {
        this.incluyeGranizo = incluyeGranizo;
    }

    public Integer getMontoMaximoGranizo() {
        return montoMaximoGranizo;
    }

    public void setMontoMaximoGranizo(Integer montoMaximoGranizo) {
        this.montoMaximoGranizo = montoMaximoGranizo;
    }

    public Cobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(Cobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Poliza() {
    }

    public Poliza(Integer numPoliza, Integer cantidadCuotas, Pago formaDePago, Integer montoAsegurado, 
            Boolean incluyeGranizo, Integer montoMaximoGranizo, Cobertura tipoCobertura, Vehiculo vehiculo) {
        this.numPoliza = numPoliza;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now().plusYears(1);
        this.cantidadCuotas = cantidadCuotas;
        this.formaDePago = formaDePago;
        this.montoAsegurado = montoAsegurado;
        this.incluyeGranizo = incluyeGranizo;
        this.montoMaximoGranizo = montoMaximoGranizo;
        this.tipoCobertura = tipoCobertura;
        this.vehiculo = vehiculo;
    }

    public Poliza(Integer numPoliza, Integer cantidadCuotas, Pago formaDePago, Integer montoAsegurado, 
            Boolean incluyeGranizo, Integer montoMaximoGranizo, Cobertura tipoCobertura, Vehiculo vehiculo, 
            ArrayList<Cuota> cuotas) {
        this.numPoliza = numPoliza;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now().plusYears(1);
        this.cantidadCuotas = cantidadCuotas;
        this.formaDePago = formaDePago;
        this.montoAsegurado = montoAsegurado;
        this.incluyeGranizo = incluyeGranizo;
        this.montoMaximoGranizo = montoMaximoGranizo;
        this.tipoCobertura = tipoCobertura;
        this.vehiculo = vehiculo;
        this.cuotas = cuotas;
    }
    
    @Override
    public String toString() {
        return "Poliza{" + "N°:" + numPoliza + ", Fecha Inicio: " + fechaInicio + ", Fecha Fin: " 
                + fechaFin + ", Cantidad Cuotas: " + cantidadCuotas + ", Forma De Pago: " + formaDePago 
                + ",\nMonto Asegurado: " + montoAsegurado + ", Incluye Granizo: " + incluyeGranizo 
                + ", Monto Maximo Granizo: " + montoMaximoGranizo + ", Tipo Cobertura: " + tipoCobertura 
                + ", " + vehiculo + ", " + cuotas + "}\n";
    }

}
