/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

import java.time.Year;

/**
 *
 * @author labespe
 */
public abstract class MaterialBiblioteca {
    //atributos
    private String codigo, titulo, autor;
    private int anioPublicacion;
    private boolean disponible;

    //constructores

    public MaterialBiblioteca() {
    }

    public MaterialBiblioteca(String codigo, String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    //get n set

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion < 1450 || anioPublicacion > Year.now().getValue()) {
            throw new IllegalArgumentException("Anio de publicacion invalido");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //metodos
    public abstract double calcularMulta(int diasRetraso);

    public abstract void mostrarInformacion();

    public void mostrarMaterial() {
        System.out.println("Codigo: " +codigo);
        System.out.println("Titulo: " +titulo);
        System.out.println("Autor: " +autor);
        System.out.println("Anio de publicacion: " +anioPublicacion);
        System.out.println("Disponible: " +disponible);
    }
}