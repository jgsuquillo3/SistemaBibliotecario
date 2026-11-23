/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author labespe
 */
public class Biblioteca {
    //atributos
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<MaterialBiblioteca> listaMateriales;
    private ArrayList<Prestamo> listaPrestamos;

    //constructores

    public Biblioteca() {
        listaUsuarios = new ArrayList<>();
        listaMateriales = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }

    public Biblioteca(ArrayList<Usuario> listaUsuarios, ArrayList<MaterialBiblioteca> listaMateriales, ArrayList<Prestamo> listaPrestamos) {
        this.listaUsuarios = listaUsuarios;
        this.listaMateriales = listaMateriales;
        this.listaPrestamos = listaPrestamos;
    }

    //get n set

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<MaterialBiblioteca> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(ArrayList<MaterialBiblioteca> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    //metodos
    public void agregarUsuario(Usuario usuario){
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        if (buscarUsuario(usuario.getCedula()) != null) {
            throw new IllegalStateException("Ya existe un usuario con la cedula " +usuario.getCedula());
        }
        listaUsuarios.add(usuario);
        usuario.setBiblioteca(this);
    }

    public void agregarMaterial(MaterialBiblioteca material){
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser nulo");
        }
        if (buscarMaterial(material.getCodigo()) != null) {
            throw new IllegalStateException("Ya existe un material con el codigo " +material.getCodigo());
        }
        listaMateriales.add(material);
    }

    public Usuario buscarUsuario(String cedula){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCedula().equals(cedula)) {
                return listaUsuarios.get(i);
            }
        }
        return null;
    }

    public MaterialBiblioteca buscarMaterial(String codigo){
        for (int i = 0; i < listaMateriales.size(); i++) {
            if (listaMateriales.get(i).getCodigo().equals(codigo)) {
                return listaMateriales.get(i);
            }
        }
        return null;
    }

    public Prestamo buscarPrestamoActivo(String codigo){
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo p = listaPrestamos.get(i);
            if (p.getFechaDevolucion() == null && p.getMaterial().getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public void prestarMaterial(String codigo, String cedula, String fechaPrestamo){
        Usuario usuario = buscarUsuario(cedula);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no registrado");
        }
        MaterialBiblioteca material = buscarMaterial(codigo);
        if (material == null) {
            throw new IllegalArgumentException("Material no encontrado");
        }
        if (!(material instanceof IPrestamo)) {
            throw new IllegalStateException("Este material es solo de consulta y no se puede prestar");
        }
        int activos = 0;
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo p = listaPrestamos.get(i);
            if (p.getFechaDevolucion() == null && p.getUsuario() == usuario) {
                activos++;
            }
        }
        if (activos >= usuario.getLimitePrestamos()) {
            throw new IllegalStateException("Limite de prestamos excedido (maximo " +usuario.getLimitePrestamos()+ ")");
        }
        IPrestamo prestable = (IPrestamo) material;
        prestable.prestar();
        listaPrestamos.add(new Prestamo(usuario, material, fechaPrestamo, null, 0));
        guardarArchivo();
    }

    public void devolverMaterial(String codigo, String fechaDevolucion, int diasRetraso){
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los dias de retraso no pueden ser negativos");
        }
        MaterialBiblioteca material = buscarMaterial(codigo);
        if (material == null) {
            throw new IllegalArgumentException("Material no encontrado");
        }
        if (!(material instanceof IPrestamo)) {
            throw new IllegalStateException("Este material no se puede devolver");
        }
        Prestamo prestamo = buscarPrestamoActivo(codigo);
        if (prestamo == null) {
            throw new IllegalStateException("No existe un prestamo activo para este material");
        }
        IPrestamo prestable = (IPrestamo) material;
        prestable.devolver();
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setMulta(material.calcularMulta(diasRetraso));
        guardarArchivo();
    }

    public void mostrarUsuarios(){
        System.out.println("==========USUARIOS==========");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario u = listaUsuarios.get(i);
            if (u instanceof Estudiante) {
                ((Estudiante) u).mostrarEstudiante();
            } else if (u instanceof Docente) {
                ((Docente) u).mostrarDocente();
            } else {
                u.mostrarUsuario();
            }
        }
    }

    public void mostrarMateriales(){
        System.out.println("==========MATERIALES==========");
        for (int i = 0; i < listaMateriales.size(); i++) {
            listaMateriales.get(i).mostrarInformacion();
        }
    }

    public void mostrarPrestamos(){
        System.out.println("==========PRESTAMOS==========");
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo p = listaPrestamos.get(i);
            System.out.println("Usuario: " +p.getUsuario().getNombres());
            System.out.println("Material: " +p.getMaterial().getTitulo());
            System.out.println("Fecha de prestamo: " +p.getFechaPrestamo());
            if (p.getFechaDevolucion() == null) {
                System.out.println("Fecha de devolucion: Pendiente");
            } else {
                System.out.println("Fecha de devolucion: " +p.getFechaDevolucion());
            }
            System.out.println("Multa: $" +p.getMulta());
        }
    }

    public void guardarArchivo(){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("prestamos.txt"));
            pw.println("==========MATERIALES PRESTADOS==========");
            for (int i = 0; i < listaPrestamos.size(); i++) {
                Prestamo p = listaPrestamos.get(i);
                pw.println("Usuario: " +p.getUsuario().getNombres()+ " (" +p.getUsuario().getCedula()+ ")");
                pw.println("Material: " +p.getMaterial().getTitulo()+ " (" +p.getMaterial().getCodigo()+ ")");
                pw.println("Fecha de prestamo: " +p.getFechaPrestamo());
                if (p.getFechaDevolucion() == null) {
                    pw.println("Fecha de devolucion: Pendiente");
                } else {
                    pw.println("Fecha de devolucion: " +p.getFechaDevolucion());
                }
                pw.println("Multa: $" +p.getMulta());
                if (p.getMaterial().isDisponible()) {
                    pw.println("Disponibilidad: Disponible");
                } else {
                    pw.println("Disponibilidad: Prestado");
                }
                pw.println("----------");
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
}