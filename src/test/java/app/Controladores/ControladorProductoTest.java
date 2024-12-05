package app.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Enums.Size;
import app.Modelo.Bebida;
import app.Modelo.Ingrediente;
import app.Modelo.Pasta;
import app.Modelo.Pizza;
import app.Modelo.Producto;

public class ControladorProductoTest {

    ControladorProducto controladorProducto;

    @BeforeEach
    void setUp() {
        controladorProducto = new ControladorProducto();
    }

    @Test
    void testCatalogoProductos() {

        try {

            ArrayList<Ingrediente> listaIngredietes = new ArrayList<>();
            ArrayList<Ingrediente> listaIngredietes1 = new ArrayList<>();

            ArrayList<Producto> listaProductos = new ArrayList<>();
            ArrayList<Producto> listaProductos1 = new ArrayList<>();

            List<String> alergenos = Arrays.asList(
                    "Lactosa",
                    "Mostaza",
                    "Sésamo",
                    "Sulfitos");

            List<String> otrosAlergenos = Arrays.asList(
                    "Lactitol",
                    "Trazas de frutos secos",
                    "Pescado",
                    "Apio",
                    "Lactosa",
                    "Crustáceos",
                    "Moluscos",
                    "Dióxido de azufre",
                    "Lactitol",
                    "Proteína de leche");

            List<String> alergenosUnicos = Arrays.asList(
                    "Apio",
                    "Dióxido de azufre",
                    "Sésamo",
                    "Lactitol",
                    "Trazas de frutos secos",
                    "Pescado",
                    "Sulfitos",
                    "Moluscos",
                    "Lactosa",
                    "Proteína de leche",
                    "Mostaza",
                    "Crustáceos");

            int suma1 = alergenos.size();
            int suma2 = otrosAlergenos.size();
            int suma3 = alergenosUnicos.size();
            System.out.println(suma1 + suma2 + suma3);

            listaIngredietes.add(new Ingrediente("Tomate", alergenos));
            listaIngredietes.add(new Ingrediente("Cebolla", otrosAlergenos));
            listaIngredietes.add(new Ingrediente("Patata", alergenos));
            listaIngredietes.add(new Ingrediente("Pimiento", otrosAlergenos));
            listaIngredietes1.add(new Ingrediente("Tarta", alergenosUnicos));

            Pasta producto2 = new Pasta("Pasta", 80, listaIngredietes);
            Bebida bebida = new Bebida("Bebida", 70, Size.GRANDE);
            Pizza pizza = new Pizza("Cuatro quesos", 7, Size.MEDIANO, listaIngredietes);
            Pizza pizza1 = new Pizza("d", 90, Size.ENANO, listaIngredietes1);

            listaProductos.add(pizza1);
            listaProductos.add(producto2);
            listaProductos.add(bebida);
            listaProductos.add(pizza);

            listaProductos1.add(new Pizza("Bebida", 14, Size.GRANDE, listaIngredietes1));

            for (Producto product : listaProductos) {
                controladorProducto.save(product);
            }

            for (Producto elem : listaProductos1) {
                controladorProducto.save(elem);
            }

            controladorProducto.catalogoProductos();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetAlergenosByIngredient() {

    }

    @Test
    void testGetAllProducts() {

    }

    @Test
    void testGetIngredientsByProduct() {

    }

    @Test
    void testSave() {

    }
}
