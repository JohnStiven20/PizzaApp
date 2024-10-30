package app.Modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import app.Modelo.Interfaces.Pagable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente implements  Pagable {

    @XmlAttribute
    private int id;
    private String  dni;
    private String nombre;
    private String telefono;
    private String email;
    private String password;
    private List<Pedido> listaPedidos;
    private Boolean admin;
    private String direccion;

    public Cliente(int id, String dni, String nombre, String telefono, String email,String direccion , String password, List<Pedido> listaPedidos, Boolean admin) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.listaPedidos = listaPedidos;
        this.admin = admin;
        this.direccion = direccion;
    }

    

    public Cliente(int id, String dni, String nombre, String telefono, String email, String password,List<Pedido> listaPedidos, String direccion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.listaPedidos = listaPedidos;
        this.direccion = direccion;
        this.admin = false;
    }



    public Cliente() {
    }

    
    public int getId() {
        return id;
    }

    public Boolean getAdmin() {
        return admin;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", email="
                + email + ", password=" + password + ", admin=" + admin + ", direccion=" + direccion + "]";
    }

    @Override
    public void pagar(double cantidad) {
        System.out.println("Pagar");
    }


    public String getDireccion() {
        return direccion;
    }

}
