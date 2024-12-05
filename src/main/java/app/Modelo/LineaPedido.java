package app.Modelo;

public class LineaPedido {

    private int id;
    private int cantidad;
    private Producto producto;

    public LineaPedido(int id, int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.id = id;
        this.producto = producto;
    }

    public LineaPedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return "LineaPedido [id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}
