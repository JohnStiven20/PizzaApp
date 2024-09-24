package app.Modelo.Pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.Modelo.Interfaces.Pagable;


/**
 * Pedido
 */
public class Pedido implements Pagable {

    public List<LineaPedido> getLineaPedidos() {
        return lineaPedidos;
    }

    public enum EstadoPedido {
        PEDIENTE, ENTREGADO, CANCELADO
    }

    private final int id;
    private Date fecha;
    private float precioTotal;
    private EstadoPedido estado;
    private static int contador = 1;
    private List<LineaPedido> lineaPedidos;

    public Pedido( EstadoPedido estado) {
        this.id = contador;
        this.fecha = new Date();
        this.precioTotal = sumatorioPrecioTotal();
        this.estado = estado;
        this.lineaPedidos = new ArrayList<>();
    }

    public void agregarLineaPedido(LineaPedido lineaPedido) {
        lineaPedidos.add(lineaPedido);
    }

    public float sumatorioPrecioTotal() {

        float sumatorio = 0;

        for (int i = 0; i < 10; i++) {
            sumatorio = sumatorio + lineaPedidos.get(i).getCantidad();
        }

        return sumatorio;
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

    @Override
    public void pagar(double cantidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
