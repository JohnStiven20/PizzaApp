package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.Controladores.ControladorCliente;
import app.Controladores.ControladorProducto;
import app.Controladores.dao.impl.JbcProductoDao;
import app.Enums.Size;
import app.Modelo.Bebida;
import app.Modelo.Cliente;
import app.Modelo.Ingrediente;
import app.Modelo.Pasta;
import app.Modelo.Pizza;
import app.Modelo.Producto;
import app.Modelo.utils.DatabaseConfPizzeria;

public class MainPizzeria {

    public static void main(String[] args) {

        try {

            DatabaseConfPizzeria.dropTlables();
            DatabaseConfPizzeria.createTable();

            ControladorCliente controladorCliente = new ControladorCliente();
            ControladorProducto controladorProducto = new ControladorProducto();

            ArrayList<Cliente> lista = new ArrayList<>();
            


            lista.add(new Cliente("48642965R", "Stiven", "602 381 142", "stiven.solano@gmail.com", "Travesía", "1234",null, true, "Solano"));
            lista.add(new Cliente("29854713P", "Lucía", "654 123 987", "lucia.martinez@gmail.com", "Avenida Central","5678", null, true, "Martínez"));
            lista.add(new Cliente("73985624T", "Carlos", "698 321 456", "carlos.perez@gmail.com", "Calle Luna", "9012", null, false, "Pérez"));
            lista.add(new Cliente("12369874L", "María", "611 456 789", "maria.garcia@gmail.com", "Plaza Mayor", "3456", null, true, "García"));
            lista.add(new Cliente("45612378D", "Ana", "622 987 654", "ana.lopez@gmail.com", "Camino Real", "7890", null,true, "López"));
            lista.add(new Cliente("87459623K", "Jorge", "633 258 147", "jorge.ramirez@gmail.com", "Carrera Norte",
                    "1123", null, false, "Ramírez"));
            lista.add(new Cliente("59874123M", "Elena", "644 369 852", "elena.sanchez@gmail.com", "Callejón Sur",
                    "4456", null, true, "Sánchez"));
            lista.add(new Cliente("78912365Z", "Miguel", "655 147 258", "miguel.diaz@gmail.com", "Boulevard Este",
                    "7789", null, false, "Díaz"));
            lista.add(new Cliente("14785236H", "Isabel", "666 321 987", "isabel.castro@gmail.com", "Paseo del Río",
                    "1230", null, true, "Castro"));
            lista.add(new Cliente("96385247J", "Alberto", "677 852 963", "alberto.moreno@gmail.com", "Ronda Oeste",
                    "4567", null, true, "Moreno"));

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

            for (Cliente cliente : lista) {
                controladorCliente.save(cliente);
            }

            controladorProducto.catalogoProductos();


        //      JbcProductoDao d = new JbcProductoDao();
        //     d.getAlergonosbyIngredient(new Ingrediente(3,"Cebolla", otrosAlergenos)).forEach(x -> System.out.println(x));


            // Cliente cliente = controladorCliente.findByEmail("stiven.solano@gmail.com");
            // Cliente cliente1 =
            // controladorCliente.findByEmail("alberto.moreno@gmail.com");

            // controladorCliente.delete(cliente);
            // controladorCliente.update(cliente1, "Paseo del Río", "666 321 987",
            // "Castro");

            // List<Cliente> listaNueva = controladorCliente.getAllCusturmers();

            // System.out.println("------------------------------CLIENTES---------------------------------");
            // listaNueva.stream().forEach(x -> System.out.println(x.toString()));
            // System.out.println("------------------------------PRODUCTOS---------------------------------");
            // controladorProducto.getAllProducts().stream().forEach(x ->
            // System.out.println(x));
            // System.out.println("------------------------------ALOGENO---------------------------------");
            // DatabaseConfPizzeria.save("Salchicha", getConnection());

            // System.out.println("-----------------------------
            // TOMATE---------------------------------");
            // System.out.println("------------------------------ALOGENO---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
