/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Tesis extends MaterialBiblioteca {
    //atributos
    private String tema, departamento;
    //constructores

    public Tesis() {
    }

    public Tesis(String tema, String departamento, String codigo, String titulo, String autor, int anioPublicacion, boolean disponible) {
        super(codigo, titulo, autor, anioPublicacion, disponible);
        this.tema = tema;
        this.departamento = departamento;
    }
    //get n set
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    //metodos
    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 1.5;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("==========DATOS DE LA TESIS==========");
        super.mostrarMaterial();
        System.out.println("Tema: " +tema);
        System.out.println("Departamento: " +departamento);
    }
}