package app.Controladores.dao;

import java.sql.SQLException;
import java.util.List;

import app.Modelo.Ingrediente;
import app.Modelo.Producto;

public interface ProductoDao {

    void delete(Producto producto) throws SQLException;

    void update(Producto producto, String dirrecion, String telefono, String apellidos) throws SQLException;

    void save(Producto producto) throws SQLException;

    List<Producto> getAllProducts() throws SQLException;

    List<Ingrediente> getIngredientsByProduct(Producto producto) throws SQLException;

    List<String> getAlergonosbyIngredient(Ingrediente producto) throws SQLException;

    
}
