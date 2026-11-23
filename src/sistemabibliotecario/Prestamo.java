/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Prestamo {
    //atributos
    private Usuario usuario;
    private MaterialBiblioteca material;
    private String fechaPrestamo, fechaDevolucion;
    private double multa;

    //constructores

    public Prestamo() {
    }

    public Prestamo(Usuario usuario, MaterialBiblioteca material, String fechaPrestamo, String fechaDevolucion, double multa) {
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = multa;
    }

    //get n set

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MaterialBiblioteca getMaterial() {
        return material;
    }

    public void setMaterial(MaterialBiblioteca material) {
        this.material = material;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}