package app.Controladores;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import app.Modelo.Cliente;
import app.Modelo.GestionBasicaFicheros;
import app.Modelo.Producto;

public class ControladorCliente {

    private List<Cliente> listaClientes;
    private static Cliente clienteActual;
    private ContraladorPedido contraladorPedido;

    public ControladorCliente() {

        listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1, "12345678A", "Juan Perez", "654321987", "juan.perez@example.com","password123", null, "Calle Falsa 123"));
        listaClientes.add(new Cliente(2, "87654321B", "Maria Garcia", "612345678", "maria.garcia@example.com", "password456", null, "Avenida Siempreviva 742"));
        listaClientes.add(new Cliente(3, "11223344C", "Carlos Lopez", "698765432", "carlos.lopez@example.com","password789", null, "Paseo de la Reforma 100"));
        listaClientes.add(new Cliente(4, "55667788D", "Ana Martinez", "622334455", "ana.martinez@example.com","password012", null, "Calle Principal 456"));

    }

    public void registradorCliente(int id, String dni, String nombre, String telefono, String dirreccion, String email,
            String password, boolean admin) throws Exception {

        boolean ClienteExiste = listaClientes.stream().anyMatch(x -> x.getDni().equals(dni));

        if (!ClienteExiste) {
            listaClientes.add(new Cliente(id, dni, nombre, telefono, email, dirreccion, password, null, admin));
        } else {
            throw new Exception("El cliente ya existe");
        }

    }

    public void loginCliente(String nombre, String password, String dni) throws EOFException {

        clienteActual = listaClientes.stream().filter(x -> {
            return x.getDni().equals(dni) && x.getNombre().equals(nombre) && x.getPassword().equals(password);

        }).findFirst().orElse(null);

        if (clienteActual != null) {
            System.out.println("El cliente registrado en la base de datos");
            contraladorPedido = new ContraladorPedido(clienteActual);
        } else {
            throw new EOFException("El cliente ya esta presente");
        }

    }

    public void logOut(String dni) {

        listaClientes.forEach(cliente -> {
            if (cliente.getDni().equals(dni)) {
                listaClientes.remove(cliente);
            }
        });

    }

    public void agregarLineaPedido(int cantidad, Producto producto) throws Exception {
        if (clienteActual != null) {
            this.contraladorPedido.agregarLineaPedido(cantidad, producto);

        } else {
            throw new Exception("El cliente ya esta presente");
        }
    }


    public List<Cliente> importarClientes(String nombre) throws Exception {

        return GestionBasicaFicheros.importarClientes(nombre);

    }

    public void exportarClientesXML(List<Cliente> listaClientes, String nombreFile) throws JAXBException {
        GestionBasicaFicheros.exportarClientesXML(listaClientes, nombreFile);
    }

    public List<Cliente> importarClientesXML(String nombre) throws JAXBException {
        return GestionBasicaFicheros.importarClientesXML(nombre);
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

}
