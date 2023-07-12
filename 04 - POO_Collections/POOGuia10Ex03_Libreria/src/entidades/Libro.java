package entidades;

import java.util.Objects;

public class Libro {

    private String titulo;
    private String autor;
    private int cantEjemplares;
    private int ejemPrestados;

    public Libro() {
    }

    public Libro(String titulo, String autor, int cantEjemplares, int ejemPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantEjemplares = cantEjemplares;
        this.ejemPrestados = ejemPrestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    public int getEjemPrestados() {
        return ejemPrestados;
    }

    public void setEjemPrestados(int ejemPrestados) {
        this.ejemPrestados = ejemPrestados;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "Titulo = " + titulo + ", Autor = " + autor + ", Cant. Ejemplares = " 
                + cantEjemplares + ", Ejemp. Prestados = " + ejemPrestados + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.autor);
        hash = 79 * hash + this.cantEjemplares;
        hash = 79 * hash + this.ejemPrestados;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.cantEjemplares != other.cantEjemplares) {
            return false;
        }
        if (this.ejemPrestados != other.ejemPrestados) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }

    
}
