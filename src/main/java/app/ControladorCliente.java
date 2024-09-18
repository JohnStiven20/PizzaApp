package app;

import java.util.ArrayList;
import java.util.List;

import app.Customer.Cliente;

public class ControladorCliente {

    private List<Cliente> listaClientes;

    public ControladorCliente() {
        this.listaClientes = new ArrayList<>();
    }

    

    public boolean registradorCliente(int id, String dni, String nombre, String direccion, String telefono, String email, String password) {

        Cliente cliente = new Cliente(id, dni, nombre, telefono, email, password);

        if (cliente.getDni() != null) {
            return false;
        } else if (cliente.getNombre() != null) {
            return false;
        } else if (cliente.getPassword() != null) {
            return false;
        }

        return true;
    }

    public boolean loginCliente(String nombre, String password, String dni) {

        int contador = 0;

        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                contador++;
            } else if (cliente.getNombre().equals(nombre)) {
                contador++;
            } else if (cliente.getPassword().equals(password)) {
                contador++;
            }

            if (contador == 3) {
                return true;
            }
            contador = 0;
        }

        return false;
    }

    // public void agregarLineaPedido(Lien) {

    // } 
}
