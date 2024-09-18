package app.Producto;

public abstract class Producto {

    protected final int id;
    protected static int contador = 1;
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return " [id=" + id + ", nombre=" + nombre + ", precio=" + precio;
    }
    
}
