package app.Controladores;

import app.Modelo.Cliente;
import app.Modelo.Interfaces.Pagable;
import app.Modelo.LineaPedido;
import app.Modelo.Pedido;
import app.Modelo.Pedido.EstadoPedido;
import app.Modelo.Producto;

public class ContraladorPedido {

    private static Pedido pedido;
    private static Cliente cliente;

    public ContraladorPedido(Cliente usuario) {
        cliente = usuario;
    }

    public void finalizarPedido(Pagable pagable) throws Exception {
        if (cliente != null) {
            if (pedido != null) {
                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println(pedido.getEstado());
                pagable.pagar(pedido.getPrecioTotal());
            } else {
                throw new Exception("No hay pedido");
            }
        } else {
            throw new Exception("No hay usuario o se ha deslogeado");
        }
    }

    public void entregarPedido() throws Exception {
        if (cliente != null) {
            if (pedido != null) {
                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println(pedido.getEstado());
            } else {
                throw new Exception("No hay pedido");
            }
        } else {
            throw new Exception("No hay usuario o se ha deslogeado");

        }
    }

    public void cancelarPedido() throws Exception {

        if (cliente != null) {
            if (pedido != null) {
                pedido.setEstado(EstadoPedido.CANCELADO);
                System.out.println(pedido.getEstado());
            } else {
                throw new Exception("No hay pedido");
            }
        } else {
            throw new Exception("No hay usuario o se ha deslogeado");
        }
    }

    public void agregarLineaPedido(int cantidad, Producto producto) throws Exception {

        if (cliente != null) {
            if (pedido == null) {
                pedido = new Pedido(EstadoPedido.PEDIENTE);
                pedido.agregarLineaPedido(new LineaPedido(cantidad, producto));

            } else {
                throw new Exception("No hay pedido");
            }
        } else {
            throw new Exception("No hay usuario o se ha deslogeado");
        }
    }

    public void recorrerListaLineasPedidos() throws Exception {

        if (cliente != null) {
            if (pedido != null) {
                pedido.getLineaPedidos().forEach(lineas -> System.out.println(lineas));
            } else {
                throw new Exception("No hay pedido");
            }
        } else {
            throw new Exception("No hay usuario o se ha deslogeado");

        }
    }

    public Pedido getPedido() {
        return pedido;
    }

}
