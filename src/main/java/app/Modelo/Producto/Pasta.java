package app.Modelo.Producto;

import java.util.List;

public class Pasta extends Producto{

    private List<Ingrediente> ingredientes;

    public Pasta(String nombre, double precio, List<Ingrediente> ingredientes) {
        super(nombre, precio);
        this.ingredientes = ingredientes;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Pasta [ingredientes=" + ingredientes + "]";
    }

}
