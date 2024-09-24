package app.Modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

import app.Modelo.Producto.Ingrediente;
import app.Modelo.Producto.Pasta;
import app.Modelo.Producto.Producto;



public class LineaPedido {

    public static int getContador() {
        return contador;
    }
    
    private final int id;
    private static int contador = 1;
    private int cantidad;
    private Producto producto;

    public LineaPedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.id = contador++;
        this.producto = producto;

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaPedido [id=" + id + ", cantidad=" + cantidad + "]";
    }

    public int getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public static void main(String[] args) {

        List<Ingrediente> list = new ArrayList<>();
        
        LineaPedido lineaPedido = new LineaPedido(contador, new Pasta("nombre", contador, list));
    }

}
