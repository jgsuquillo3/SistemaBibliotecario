/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

/**
 *
 * @author labespe
 */
public class Docente extends Usuario {
    //atributos
    private String departamento, especialidad;
    //constructores

    public Docente() {
    }

    public Docente(String departamento, String especialidad, int id, String cedula, String nombres, int edad, String direccionDomicilio) {
        super(id, cedula, nombres, edad, direccionDomicilio);
        this.departamento = departamento;
        this.especialidad = especialidad;
    }
    //get n set
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    //metodos
    @Override
    public int getLimitePrestamos(){
        return 5;
    }

    public void mostrarDocente(){
        System.out.println("==========DATOS DEL DOCENTE==========");
        super.mostrarUsuario();
        System.out.println("Departamento: " +departamento);
        System.out.println("Especialidad: " +especialidad);
    }
}