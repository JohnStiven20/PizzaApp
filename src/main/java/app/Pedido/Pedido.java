package app.Pedido;

import java.util.Date;
import java.util.List;

import app.Enums.EstadoPedido;
import app.Interfaces.Pagable;

/**
 * Pedido
 */
public class Pedido implements Pagable{

    private final int id;
    private Date fecha;
    private float precioTotal;
    private EstadoPedido estado;
    private static int contador = 1;
    private List<LineaPedido> lineaPedidos;

    public Pedido(int id,float precioTotal, EstadoPedido estado) {
        this.id = contador;
        this.fecha = new Date();
        this.precioTotal = precioTotal;
        this.estado = estado;
    }

    public void finalizar() {

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