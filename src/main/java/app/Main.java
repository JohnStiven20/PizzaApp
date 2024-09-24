package app;

import app.Controladores.ContraladorPedido;
import app.Controladores.ControladorCliente;

public class Main {

    public static void main(String[] args) {

        ContraladorPedido contraladorPedido = new ContraladorPedido();
        ControladorCliente contraldorCliente = new ControladorCliente();


        contraldorCliente.registradorCliente(1, "48642965N", "Stiven", "Travesia San Miguel de Salinas", "60538142", "stivensolanomacas@gmail.com", "17061990");

        if (contraldorCliente.loginCliente("Stiven", "17061990", "48642965N")) {
            System.out.println("Existe");
        } else {
            System.out.println("No existe");
        }
        
    }
    
}
