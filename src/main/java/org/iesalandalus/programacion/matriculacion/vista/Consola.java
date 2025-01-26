package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.dominio.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consola {

    public static final Scanner scanner = new Scanner(System.in);

    // Constructor privado para evitar instanciación
    private Consola() {}

    public static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion.ordinal() + ". " + opcion);
        }
    }

    public static Opcion elegirOpcion() {
        int eleccion;
        do {
            System.out.print("Introduzca el número de la opción deseada: ");
            eleccion = Integer.parseInt(scanner.nextLine());
        } while (eleccion < 0 || eleccion >= Opcion.values().length);
        return Opcion.values()[eleccion];
    }

    public static Alumno leerAlumno() throws Exception {
        System.out.print("Introduzca el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduzca el DNI del alumno: ");
        String dni = scanner.nextLine();
        System.out.print("Introduzca el correo del alumno: ");
        String correo = scanner.nextLine();
        System.out.print("Introduzca el teléfono del alumno: ");
        String telefono = scanner.nextLine();
        LocalDate fechaNacimiento = leerFecha();
        return new Alumno(nombre, dni, correo, telefono, fechaNacimiento);
    }

    public static Alumno getAlumnoPorDni() throws Exception {
        System.out.print("Introduzca el DNI del alumno: ");
        String dni = scanner.nextLine();
        return new Alumno("Nombre Ficticio", dni, "correo@ficticio.com", "600000000", LocalDate.now().minusYears(18));
    }

    public static LocalDate leerFecha() {
        LocalDate fecha = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (fecha == null) {
            try {
                System.out.print("Introduzca la fecha (dd/MM/yyyy): ");
                String fechaStr = scanner.nextLine();
                fecha = LocalDate.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente.");
            }
        }
        return fecha;
    }

    public static Grado leerGrado() {
        System.out.println("Grados disponibles:");
        for (Grado grado : Grado.values()) {
            System.out.println(grado.ordinal() + ". " + grado);
        }
        int eleccion;
        do {
            System.out.print("Seleccione un grado: ");
            eleccion = Integer.parseInt(scanner.nextLine());
        } while (eleccion < 0 || eleccion >= Grado.values().length);
        return Grado.values()[eleccion];
    }

    public static CicloFormativo leerCicloFormativo() throws Exception {
        System.out.print("Introduzca el código del ciclo formativo: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduzca el nombre del ciclo formativo: ");
        String nombre = scanner.nextLine();
        Grado grado = leerGrado();
        return new CicloFormativo(codigo, nombre, grado);
    }

    public static void mostrarCiclosFormativos(List<CicloFormativo> ciclos) {
        for (CicloFormativo ciclo : ciclos) {
            System.out.println(ciclo);
        }
    }

    public static CicloFormativo getCicloFormativoPorCodigo() throws Exception {
        System.out.print("Introduzca el código del ciclo formativo: ");
        String codigo = scanner.nextLine();
        return new CicloFormativo(codigo, "Nombre Ficticio", Grado.GDCFGS);
    }

    public static Curso leerCurso() {
        System.out.println("Cursos disponibles:");
        for (Curso curso : Curso.values()) {
            System.out.println(curso.ordinal() + ". " + curso);
        }
        int eleccion;
        do {
            System.out.print("Seleccione un curso: ");
            eleccion = Integer.parseInt(scanner.nextLine());
        } while (eleccion < 0 || eleccion >= Curso.values().length);
        return Curso.values()[eleccion];
    }

    public static EspecialidadProfesorado leerEspecialidadProfesorado() {
        System.out.println("Especialidades disponibles:");
        for (EspecialidadProfesorado especialidad : EspecialidadProfesorado.values()) {
            System.out.println(especialidad.ordinal() + ". " + especialidad);
        }
        int eleccion;
        do {
            System.out.print("Seleccione una especialidad: ");
            eleccion = Integer.parseInt(scanner.nextLine());
        } while (eleccion < 0 || eleccion >= EspecialidadProfesorado.values().length);
        return EspecialidadProfesorado.values()[eleccion];
    }

    public static Asignatura leerAsignatura() throws Exception {
        System.out.print("Introduzca el código de la asignatura: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduzca el nombre de la asignatura: ");
        String nombre = scanner.nextLine();
        Curso curso = leerCurso();
        EspecialidadProfesorado especialidad = leerEspecialidadProfesorado();
        return new Asignatura(codigo, nombre, curso, especialidad);
    }

    public static Asignatura getAsignaturaPorCodigo() throws Exception {
        System.out.print("Introduzca el código de la asignatura: ");
        String codigo = scanner.nextLine();
        return new Asignatura(codigo, "Nombre Ficticio", Curso.PRIMERO, EspecialidadProfesorado.INFORMATICA);
    }

    public static void mostrarAsignaturas(List<Asignatura> asignaturas) {
        for (Asignatura asignatura : asignaturas) {
            System.out.println(asignatura);
        }
    }

    public static boolean asignaturaYaMatriculada(List<Asignatura> asignaturas, Asignatura asignatura) {
        return asignaturas.contains(asignatura);
    }

    public static Matricula leerMatricula() throws Exception {
        Alumno alumno = leerAlumno();
        CicloFormativo cicloFormativo = leerCicloFormativo();
        List<Asignatura> asignaturas = new ArrayList<>();
        String respuesta;
        do {
            Asignatura asignatura = leerAsignatura();
            if (!asignaturaYaMatriculada(asignaturas, asignatura)) {
                asignaturas.add(asignatura);
            } else {
                System.out.println("La asignatura ya está matriculada.");
            }
            System.out.print("¿Desea añadir otra asignatura? (S/N): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("S"));
        return new Matricula(alumno, cicloFormativo, asignaturas);
    }

    public static Matricula getMatriculaPorIdentificador() throws Exception {
        System.out.print("Introduzca el identificador de la matrícula: ");
        String identificador = scanner.nextLine();
        Alumno alumno = new Alumno("Nombre Ficticio", "12345678A", "correo@ficticio.com", "600000000", LocalDate.now().minusYears(18));
        CicloFormativo cicloFormativo = new CicloFormativo("CF001", "Ciclo Ficticio", Grado.GDCFGS);
        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura("AS001", "Asignatura Ficticia", Curso.PRIMERO, EspecialidadProfesorado.INFORMATICA));
        return new Matricula(alumno, cicloFormativo, asignaturas);
    }
}
