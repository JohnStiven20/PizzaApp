package app.Modelo.Producto;

import java.util.List;

/**
 * Ingrediente
 */
public class Ingrediente {

    private String nombre;
    private List<String> alergenos;


    public Ingrediente(String nombre, List<String> alergenos) {
        this.nombre = nombre;
        this.alergenos = alergenos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(List<String> alergenos) {
        this.alergenos = alergenos;
    }

    @Override
    public String toString() {
        return "Ingrediente [nombre=" + nombre + ", alergenos=" + alergenos + "]";
    }

}