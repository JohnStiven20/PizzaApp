package app.Controladores;

import java.sql.SQLException;
import java.util.List;

import app.Controladores.dao.ProductoDao;
import app.Controladores.dao.impl.JbcProductoDao;
import app.Modelo.Ingrediente;
import app.Modelo.Producto;

public class ControladorProducto {

    private final ProductoDao productoDao;

    public ControladorProducto() {
        this.productoDao = new JbcProductoDao();
    }

    public void save(Producto producto) throws SQLException {
        productoDao.save(producto);
    }

    public void delete(Producto producto) throws SQLException {
        productoDao.delete(producto);
    }

    /**
     *
     * ESTE SITIO PATA EL UPDATE
     * @throws SQLException
     *
     */

    public List<Producto> getAllProducts() throws SQLException {
        return productoDao.getAllProducts();
    }

    public List<Ingrediente> getIngredientsByProduct(Producto producto) throws SQLException{
        return productoDao.getIngredientsByProduct(producto);
    }

    public List<String> getAlergenosByIngredient(Ingrediente ingrediente) throws SQLException {
        return productoDao.getAlergonosbyIngredient(ingrediente);
    }

    public void  catalogoProductos() throws SQLException{
        productoDao.getAllProducts().forEach(x -> System.out.println(x));
    }

}
