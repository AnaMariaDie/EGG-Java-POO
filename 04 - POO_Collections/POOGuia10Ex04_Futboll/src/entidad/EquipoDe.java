package entidad;

public class EquipoDe {

    private String nombreEquipo;
    private String ciudad;
    private Integer cantidadPartidosJugados;
    private Integer cantidadPartidosGanados;
    private Integer cantidadPartidosPerdidos;
    private Integer cantidadPartidosEmpatados;
    private Integer puntosTotales;

    public EquipoDe() {
    }

    public EquipoDe(String nombreEquipo, String ciudad, Integer cantidadPartidosJugados, 
            Integer cantidadPartidosGanados, Integer cantidadPartidosPerdidos, Integer cantidadPartidosEmpatados, 
            Integer puntosTotales) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.cantidadPartidosJugados = cantidadPartidosJugados;
        this.cantidadPartidosGanados = cantidadPartidosGanados;
        this.cantidadPartidosPerdidos = cantidadPartidosPerdidos;
        this.cantidadPartidosEmpatados = cantidadPartidosEmpatados;
        this.puntosTotales = puntosTotales;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCantidadPartidosJugados() {
        return cantidadPartidosJugados;
    }

    public void setCantidadPartidosJugados(Integer cantidadPartidosJugados) {
        this.cantidadPartidosJugados = cantidadPartidosJugados;
    }

    public Integer getCantidadPartidosGanados() {
        return cantidadPartidosGanados;
    }

    public void setCantidadPartidosGanados(Integer cantidadPartidosGanados) {
        this.cantidadPartidosGanados = cantidadPartidosGanados;
    }

    public Integer getCantidadPartidosPerdidos() {
        return cantidadPartidosPerdidos;
    }

    public void setCantidadPartidosPerdidos(Integer cantidadPartidosPerdidos) {
        this.cantidadPartidosPerdidos = cantidadPartidosPerdidos;
    }

    public Integer getCantidadPartidosEmpatados() {
        return cantidadPartidosEmpatados;
    }

    public void setCantidadPartidosEmpatados(Integer cantidadPartidosEmpatados) {
        this.cantidadPartidosEmpatados = cantidadPartidosEmpatados;
    }

    public Integer getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(Integer puntosTotales) {
        this.puntosTotales = puntosTotales;
    }
    
    @Override
    public String toString() {
        return "EquipoDe{" + "Nombre = " + nombreEquipo + ", Ciudad = " + ciudad + 
                ", Partidos Jugados = " + cantidadPartidosJugados + ", Partidos Ganados = " + 
                cantidadPartidosGanados + ", Partidos Perdidos = " + cantidadPartidosPerdidos + 
                ", Partidos Empatados = " + cantidadPartidosEmpatados + ", Puntos Totales = " 
                + puntosTotales + '}';
    }
     
}
