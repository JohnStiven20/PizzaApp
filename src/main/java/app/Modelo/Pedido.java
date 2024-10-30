package app.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Pedido
 */
public class Pedido {


    public enum EstadoPedido {
        PEDIENTE, ENTREGADO, CANCELADO
    }

    private final int id;
    private Date fecha;
    private float precioTotal;
    private EstadoPedido estado;
    private static int contador = 1;
    private List<LineaPedido> lineaPedidos;
    private Cliente cliente;

    public Pedido(EstadoPedido estado) {
        this.id = contador;
        this.fecha = new Date();
        this.estado = estado;
        this.lineaPedidos = new ArrayList<>();
        this.precioTotal = 0;
    }

    public void agregarLineaPedido(LineaPedido lineaPedido) {
        lineaPedidos.add(lineaPedido);
        this.precioTotal = (float) lineaPedidos.stream().mapToDouble(x -> x.getCantidad() * x.getProducto().getPrecio()).sum();
    }

    public List<LineaPedido> getLineaPedidos() {
        return lineaPedidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", fecha=" + fecha + ", precioTotal=" + precioTotal + ", estado=" + estado + "]";
    }

}
