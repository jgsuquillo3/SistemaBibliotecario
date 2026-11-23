/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Usuario {
    //atributos
    private int id, edad;
    private String cedula, nombres, direccionDomicilio;
    private Biblioteca biblioteca;

    //constructores

    public Usuario() {
    }

    public Usuario(int id, String cedula, String nombres, int edad, String direccionDomicilio) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.direccionDomicilio = direccionDomicilio;
    }

    //get n set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    //metodos
    public int getLimitePrestamos(){
        return 3;
    }

    public void mostrarUsuario(){
        System.out.println("Id: " +id);
        System.out.println("Cedula: " +cedula);
        System.out.println("Nombres: " +nombres);
        System.out.println("Edad: " +edad);
        System.out.println("Direccion: " +direccionDomicilio);
    }

    public void consultarMateriales(){
        if (biblioteca == null) {
            throw new IllegalStateException("El usuario no pertenece a ninguna biblioteca");
        }
        biblioteca.mostrarMateriales();
    }

    public void solicitarPrestamo(String codigo, String fechaPrestamo){
        if (biblioteca == null) {
            throw new IllegalStateException("El usuario no pertenece a ninguna biblioteca");
        }
        biblioteca.prestarMaterial(codigo, cedula, fechaPrestamo);
    }
}