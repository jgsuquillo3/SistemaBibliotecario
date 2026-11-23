/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Revista extends MaterialBiblioteca implements IPrestamo {
    //atributos
    private int numeroEdicion;
    private String categoria;
    //constructores

    public Revista() {
    }

    public Revista(int numeroEdicion, String categoria, String codigo, String titulo, String autor, int anioPublicacion, boolean disponible) {
        super(codigo, titulo, autor, anioPublicacion, disponible);
        this.numeroEdicion = numeroEdicion;
        this.categoria = categoria;
    }
    //get n set
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //metodos
    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 1.0;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==========DATOS DE LA REVISTA==========");
        super.mostrarMaterial();
        System.out.println("Numero de edicion: " +numeroEdicion);
        System.out.println("Categoria: " +categoria);
    }

    @Override
    public void prestar() {
        if (isDisponible()) {
            setDisponible(false);
        } else {
            throw new IllegalStateException("El material no esta disponible");
        }
    }

    @Override
    public void devolver() {
        if (isDisponible()) {
            throw new IllegalStateException("El material ya fue devuelto");
        }
        setDisponible(true);
    }
}