package service;

import java.util.HashMap;

public class Producto {

    private static HashMap<String, Producto> productos = new HashMap<>();
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public static HashMap<String, Producto> getProductos() {
        return productos;
    }

    public static void setProducts(HashMap<String, Producto> productos) {
        Producto.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void addProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    public void removeProducto(String nombre) {
        productos.remove(nombre);
    }

    public void updateProducto(String nombre, Producto producto) {
        productos.replace(nombre, producto);
    }

    public void showProductos() {
        for (Producto producto : productos.values()) {
            System.out.println("*********************************");
            System.out.println("Nombre del producto: " + producto.getNombre());
            System.out.println("Descripción del producto: " + producto.getDescripcion());
            System.out.println("Precio del producto: " + producto.getPrecio());
            System.out.println("*********************************");
        }
    }
}
