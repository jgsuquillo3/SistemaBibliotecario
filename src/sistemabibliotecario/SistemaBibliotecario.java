/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemabibliotecario;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author labespe
 */
public class SistemaBibliotecario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int op;
        do {
            System.out.println("==========SISTEMA DE BIBLIOTECA ESPE==========");
            System.out.println("1.- Registrar estudiante");
            System.out.println("2.- Registrar docente");
            System.out.println("3.- Registrar libro");
            System.out.println("4.- Registrar revista");
            System.out.println("5.- Registrar tesis");
            System.out.println("6.- Ver usuarios");
            System.out.println("7.- Ver materiales");
            System.out.println("8.- Consultar materiales (usuario)");
            System.out.println("9.- Prestar material");
            System.out.println("10.- Devolver material");
            System.out.println("11.- Ver prestamos");
            System.out.println("12.- Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                op = 0;
            }
            sc.nextLine();
            switch (op) {
                case 1: {
                    System.out.println("==========REGISTRO DE ESTUDIANTE==========");
                    System.out.print("Ingrese cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Ingrese nombres: ");
                    String nombres = sc.nextLine();
                    boolean edadV = false;
                    int edad = 0;
                    while (!edadV) {
                        try {
                            System.out.print("Ingrese edad: ");
                            edad = sc.nextInt();
                            sc.nextLine();
                            if (edad < 0) {
                                System.out.println("La edad no puede ser negativa");
                            } else {
                                edadV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    System.out.print("Ingrese direccion: ");
                    String direccion = sc.nextLine();
                    System.out.print("Ingrese carrera: ");
                    String carrera = sc.nextLine();
                    boolean semestreV = false;
                    int semestre = 0;
                    while (!semestreV) {
                        try {
                            System.out.print("Ingrese semestre: ");
                            semestre = sc.nextInt();
                            sc.nextLine();
                            if (semestre <= 0) {
                                System.out.println("Solo ingrese numeros positivos");
                            } else {
                                semestreV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    try {
                        biblioteca.agregarUsuario(new Estudiante(carrera, semestre, biblioteca.getListaUsuarios().size() + 1, cedula, nombres, edad, direccion));
                        System.out.println("Estudiante registrado correctamente");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("==========REGISTRO DE DOCENTE==========");
                    System.out.print("Ingrese cedula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Ingrese nombres: ");
                    String nombres = sc.nextLine();
                    boolean edadV = false;
                    int edad = 0;
                    while (!edadV) {
                        try {
                            System.out.print("Ingrese edad: ");
                            edad = sc.nextInt();
                            sc.nextLine();
                            if (edad < 0) {
                                System.out.println("La edad no puede ser negativa");
                            } else {
                                edadV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    System.out.print("Ingrese direccion: ");
                    String direccion = sc.nextLine();
                    System.out.print("Ingrese departamento: ");
                    String departamento = sc.nextLine();
                    System.out.print("Ingrese especialidad: ");
                    String especialidad = sc.nextLine();
                    try {
                        biblioteca.agregarUsuario(new Docente(departamento, especialidad, biblioteca.getListaUsuarios().size() + 1, cedula, nombres, edad, direccion));
                        System.out.println("Docente registrado correctamente");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.println("==========REGISTRO DE LIBRO==========");
                    System.out.print("Ingrese codigo: ");
                    String codigo = sc.nextLine();
                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese autor: ");
                    String autor = sc.nextLine();
                    boolean anioV = false;
                    int anio = 0;
                    while (!anioV) {
                        try {
                            System.out.print("Ingrese anio de publicacion: ");
                            anio = sc.nextInt();
                            sc.nextLine();
                            if (anio < 1450 || anio > Year.now().getValue()) {
                                System.out.println("Anio de publicacion invalido");
                            } else {
                                anioV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    System.out.print("Ingrese genero: ");
                    String genero = sc.nextLine();
                    boolean paginasV = false;
                    int paginas = 0;
                    while (!paginasV) {
                        try {
                            System.out.print("Ingrese numero de paginas: ");
                            paginas = sc.nextInt();
                            sc.nextLine();
                            if (paginas <= 0) {
                                System.out.println("Solo ingrese numeros positivos");
                            } else {
                                paginasV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    try {
                        biblioteca.agregarMaterial(new Libro(genero, paginas, codigo, titulo, autor, anio, true));
                        System.out.println("Libro registrado correctamente");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("==========REGISTRO DE REVISTA==========");
                    System.out.print("Ingrese codigo: ");
                    String codigo = sc.nextLine();
                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese autor: ");
                    String autor = sc.nextLine();
                    boolean anioV = false;
                    int anio = 0;
                    while (!anioV) {
                        try {
                            System.out.print("Ingrese anio de publicacion: ");
                            anio = sc.nextInt();
                            sc.nextLine();
                            if (anio < 1450 || anio > Year.now().getValue()) {
                                System.out.println("Anio de publicacion invalido");
                            } else {
                                anioV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    boolean edicionV = false;
                    int edicion = 0;
                    while (!edicionV) {
                        try {
                            System.out.print("Ingrese numero de edicion: ");
                            edicion = sc.nextInt();
                            sc.nextLine();
                            if (edicion <= 0) {
                                System.out.println("Solo ingrese numeros positivos");
                            } else {
                                edicionV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    System.out.print("Ingrese categoria: ");
                    String categoria = sc.nextLine();
                    try {
                        biblioteca.agregarMaterial(new Revista(edicion, categoria, codigo, titulo, autor, anio, true));
                        System.out.println("Revista registrada correctamente");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("==========REGISTRO DE TESIS==========");
                    System.out.print("Ingrese codigo: ");
                    String codigo = sc.nextLine();
                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese autor: ");
                    String autor = sc.nextLine();
                    boolean anioV = false;
                    int anio = 0;
                    while (!anioV) {
                        try {
                            System.out.print("Ingrese anio de publicacion: ");
                            anio = sc.nextInt();
                            sc.nextLine();
                            if (anio < 1450 || anio > Year.now().getValue()) {
                                System.out.println("Anio de publicacion invalido");
                            } else {
                                anioV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    System.out.print("Ingrese tema: ");
                    String tema = sc.nextLine();
                    System.out.print("Ingrese departamento: ");
                    String departamento = sc.nextLine();
                    try {
                        biblioteca.agregarMaterial(new Tesis(tema, departamento, codigo, titulo, autor, anio, true));
                        System.out.println("Tesis registrada correctamente");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6:
                    biblioteca.mostrarUsuarios();
                    break;
                case 7:
                    biblioteca.mostrarMateriales();
                    break;
                case 8: {
                    System.out.print("Ingrese cedula del usuario: ");
                    String cedula = sc.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(cedula);
                    if (usuario == null) {
                        System.out.println("Usuario no registrado");
                    } else {
                        usuario.consultarMateriales();
                    }
                    break;
                }
                case 9: {
                    System.out.print("Ingrese cedula del usuario: ");
                    String cedula = sc.nextLine();
                    System.out.print("Ingrese codigo del material: ");
                    String codigo = sc.nextLine();
                    System.out.print("Ingrese fecha de prestamo: ");
                    String fechaPrestamo = sc.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(cedula);
                    if (usuario == null) {
                        System.out.println("Usuario no registrado");
                    } else {
                        try {
                            usuario.solicitarPrestamo(codigo, fechaPrestamo);
                            System.out.println("Prestamo realizado correctamente");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case 10: {
                    System.out.print("Ingrese codigo del material: ");
                    String codigo = sc.nextLine();
                    System.out.print("Ingrese fecha de devolucion: ");
                    String fechaDevolucion = sc.nextLine();
                    boolean retrasoV = false;
                    int diasRetraso = 0;
                    while (!retrasoV) {
                        try {
                            System.out.print("Ingrese dias de retraso (0 si no hay): ");
                            diasRetraso = sc.nextInt();
                            sc.nextLine();
                            if (diasRetraso < 0) {
                                System.out.println("Los dias de retraso no pueden ser negativos");
                            } else {
                                retrasoV = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Solo ingrese numeros enteros");
                            sc.nextLine();
                        }
                    }
                    try {
                        biblioteca.devolverMaterial(codigo, fechaDevolucion, diasRetraso);
                        System.out.println("Material devuelto correctamente");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 11:
                    biblioteca.mostrarPrestamos();
                    break;
                case 12:
                    biblioteca.guardarArchivo();
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 12);
        sc.close();
    }

}