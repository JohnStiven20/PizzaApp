package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import app.Modelo.Ingrediente;
import app.Modelo.utils.DatabaseConfPizzeria;
import static app.Modelo.utils.DatabaseConfPizzeria.getConnection;

public class MainPrueba {

    public static void main(String[] args) {



        try {
            DatabaseConfPizzeria.dropTlables();
            DatabaseConfPizzeria.createTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        List<String> alergenos = Arrays.asList(
                "Lactosa",
                "Gluten",
                "Fructosa",
                "Soja",
                "Huevo",
                "Cacahuetes",
                "Mariscos",
                "Mostaza",
                "Sésamo",
                "Sulfitos"
        );

        List<String> otrosAlergenos = Arrays.asList(
                "Lactitol",
                "Trazas de frutos secos",
                "Pescado",
                "Apio",
                "Altramuz",
                "Crustáceos",
                "Moluscos",
                "Dióxido de azufre",
                "Caseína",
                "Proteína de leche"
        );

        Ingrediente ingrediente = new Ingrediente(1, "Tomate", alergenos);
        Ingrediente ingrediente2 = new Ingrediente(2, "Tomate", otrosAlergenos);


        try {

            Connection connection = getConnection();


            // controladorProducto.saveIngrediente(ingrediente, connection);
      

            System.out.println("-----------------------------------DEVOLVER EL ID DE UN INGREDIENTE----------------------------------------------");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
