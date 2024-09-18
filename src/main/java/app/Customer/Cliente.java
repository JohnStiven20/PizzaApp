package app.Customer;

import app.Interfaces.Pagable;

public class Cliente implements  Pagable {

    private int id;
    private String  dni;
    private String nombre;
    private String telefono;
    private String email;
    private String password;

    public Cliente(int id, String dni, String nombre, String telefono, String email, String password) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
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

    public void realizarPedido() {

    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", email="
                + email + ", password=" + password + "]";
    }

    @Override
    public void pagar(double cantidad) {
        System.out.println("Pagar");
    }

}
