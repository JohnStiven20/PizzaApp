package app.Producto;

import app.Enums.Size;

public class Bebida extends Producto {

    private Size size;

    public Bebida(String nombre, double precio, Size size) {
        super(nombre, precio);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Bebida [size=" + size + "]";
    }


}
