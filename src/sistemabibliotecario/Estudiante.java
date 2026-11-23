/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Estudiante extends Usuario {
    //atributos
    private String carrera;
    private int semestre;
    //constructores

    public Estudiante() {
    }

    public Estudiante(String carrera, int semestre, int id, String cedula, String nombres, int edad, String direccionDomicilio) {
        super(id, cedula, nombres, edad, direccionDomicilio);
        this.carrera = carrera;
        this.semestre = semestre;
    }
    //get n set
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    //metodos
    @Override
    public int getLimitePrestamos(){
        return 3;
    }

    public void mostrarEstudiante(){
        System.out.println("==========DATOS DEL ESTUDIANTE==========");
        super.mostrarUsuario();
        System.out.println("Carrera: " +carrera);
        System.out.println("Semestre: " +semestre);
    }
}