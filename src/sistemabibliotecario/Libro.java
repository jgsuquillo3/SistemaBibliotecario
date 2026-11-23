/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Libro extends MaterialBiblioteca implements IPrestamo {
    //atributos
    private String genero;
    private int numeroPaginas;
    //constructores

    public Libro() {
    }

    public Libro(String genero, int numeroPaginas, String codigo, String titulo, String autor, int anioPublicacion, boolean disponible) {
        super(codigo, titulo, autor, anioPublicacion, disponible);
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
    }
    //get n set
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    //metodos
    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 0.50;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==========DATOS DEL LIBRO==========");
        super.mostrarMaterial();
        System.out.println("Genero: " +genero);
        System.out.println("Numero de paginas: " +numeroPaginas);
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