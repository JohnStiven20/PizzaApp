package app.Producto;

import java.util.List;

import app.Enums.Size;

/**
 * Pizza
 */
public class Pizza  extends Producto{

    private Size size;
    private List<Ingrediente> ingredientes;

    public Pizza(String nombre, double precio, Size size, List<Ingrediente> ingredientes) {
        super(nombre, precio);
        this.size = size;
        this.ingredientes = ingredientes;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "Pizza [ " + super.toString() + " size=" + size + "]";
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

}