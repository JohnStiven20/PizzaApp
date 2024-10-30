package app;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.Controladores.ContraladorPedido;
import app.Controladores.ControladorCliente;
import app.Controladores.ControladorIngrediente;
import app.Modelo.Bebida;
import app.Modelo.Cliente;
import app.Modelo.Enums.Size;
import app.Modelo.Ingrediente;
import app.Modelo.Interfaces.Pagable;
import app.Modelo.PagarEfectivo;
import app.Modelo.Pasta;
import app.Modelo.Pizza;

public class Main {

  public static void main(String[] args) {

    /*
     * AL CREAR EL CONTROLADOR PEDIDO EL USUARIO ES NULL HASTA LOGEARSE
     */
    ControladorIngrediente controladorIngrediente = new ControladorIngrediente();
    ContraladorPedido contraladorPedido = new ContraladorPedido(null);
    ControladorCliente contraldorCliente = new ControladorCliente();

    /*
     * ME LOGEADO CON UN CLIENTE EXISTENTE EN LAS LISTA DE CLIENTES
     * Si NO TE LOGEAS FALLA EL PROGRAMA
     */
    try {
      contraldorCliente.loginCliente("Juan Perez", "password123", "12345678A");
    } catch (EOFException e) {
      System.out.println(e.getMessage());
    }

    /**
     * -------------------------------------------------------------------------------------
     * LISTA DE INGREDIENTES DE PIZZA Y PASTA
     */
    List<Ingrediente> listaIngredientesPizza = new ArrayList<>();

    listaIngredientesPizza.add(new Ingrediente("Queso Mozzarella", List.of("Lacteo", "Hola", "Hola2")));
    listaIngredientesPizza.add(new Ingrediente("Salsa de Tomate", List.of()));
    listaIngredientesPizza.add(new Ingrediente("Jamón", List.of("Sulfitos", "Lacteo")));

    List<Ingrediente> listaIngredientesPasta = new ArrayList<>();

    listaIngredientesPasta.add(new Ingrediente("Salsa Boloñesa", List.of("Sulfitos", "Falesio")));
    listaIngredientesPasta.add(new Ingrediente("Salsa Carbonara", List.of("Lácteos", "Huevos")));
    listaIngredientesPasta.add(new Ingrediente("Queso Parmesano", List.of("Lácteos")));

    /*
     * -----------------------------------------------------------------------------
     * ---------------
     * -----------------------------------------------------------------------------
     * ---------------
     */

    /*
     * AGREGAR LOS PRODUCTOS EN EL PEDIDO ACTUAL DEL CLIENTE
     */
    try {
      contraldorCliente.agregarLineaPedido(10, new Pizza("Stolana", 5, Size.MEDIANO, listaIngredientesPizza));
      contraldorCliente.agregarLineaPedido(10, new Bebida("Nestea", 5, Size.GRANDE));
      contraldorCliente.agregarLineaPedido(10, new Pasta("Masa del Pilar", 5, listaIngredientesPasta));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    /**
     * *****************************************************************************************************
     */
    System.out.println(contraldorCliente.getClienteActual());

    try {
      contraldorCliente.registradorCliente(9, "12345678A", "Juan Perez", "654321987", "Calle Falsa 123", "juan.perez@example.com",
          "securepass", false);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    // contraldorCliente.registradorCliente(5, "48642966J", "Stiven", "602 381 142","Travesi del Pato","Stivensolanomacas@gmail.com", "17061990", null, true);
    System.out.println(contraldorCliente.getClienteActual());

    System.out.println("-------------------------------------------------------------------");

    try {
      contraladorPedido.recorrerListaLineasPedidos();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println("---------------------------------------------------------------------");
    System.out.println(contraladorPedido.getPedido());
    Pagable pagable = new PagarEfectivo();
    try {
      contraladorPedido.finalizarPedido(pagable);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      contraldorCliente.exportarClientesXML(contraldorCliente.getListaClientes(), "admi.txt");
    } catch (JAXBException e) {
      System.out.println(e.getMessage());
    }

    try {
      List<Cliente> listaClientes = contraldorCliente.importarClientesXML("clientes.xml");

      listaClientes.forEach(x -> System.out.println(x));

    } catch (JAXBException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("------------------------------------------------------------------------------------------");

    try {
      System.out.println("viva españa");
      contraldorCliente.importarClientes("admin.txt").forEach(x -> System.out.println(x + "viva españa"));



    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      controladorIngrediente.exportarIngredientes(listaIngredientesPizza, "ingredientes.csv");
    } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("-------------------------------------------------------------------------------------");
    List<Ingrediente> nuevaListaIngredientes = null;
    try {
      nuevaListaIngredientes = controladorIngrediente.importatIngredientes("ingredientes.csv");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    nuevaListaIngredientes.forEach(x -> System.out.println(x));
  }

}
