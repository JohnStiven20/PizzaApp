package app.Controladores;

import java.util.ArrayList;
import java.util.List;

import app.Modelo.Customer.Cliente;
import app.Modelo.Pedido.Pedido;

public class ControladorCliente {

    private List<Cliente> listaClientes;
    private static Pedido pedido;
    private Cliente clienteActual;

    public ControladorCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public boolean registradorCliente(int id, String dni, String nombre, String direccion, String telefono, String email, String password) {

        this.clienteActual = new Cliente(id, dni, nombre, telefono, email, password);

        if (this.clienteActual.getDni() == null) {
            return false;
        } else if (this.clienteActual.getNombre() == null) {
            return false;
        } else if (this.clienteActual.getPassword() == null) {
            return false;
        }

        listaClientes.add(clienteActual);
        return true;
    }

    public boolean loginCliente(String nombre, String password, String dni) {

        int contador = 0;

        for (Cliente cliente : listaClientes) {

            if (cliente.getDni().equals(dni)) {
                contador++;
            }
            if (cliente.getNombre().equals(nombre)) {
                contador++;
            }
    
            if (cliente.getPassword().equals(password)) {
                contador++;
            }
            
             if (contador == 3) {
                return true;
            }
            contador = 0;
        }

        return false;
    }


    
}
