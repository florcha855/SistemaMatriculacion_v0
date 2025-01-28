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
        System.out.println("Seleccione una opcion:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion.ordinal() + ". " + opcion);
        }
    }

    public static Opcion elegirOpcion() {
        int eleccion;
        do {
            System.out.print("Introduzca el numero de la opcion deseada: ");
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
        System.out.print("Introduzca el telefono del alumno: ");
        String telefono = scanner.nextLine();
        LocalDate fechaNacimiento = leerFecha();
        return new Alumno(nombre, dni, correo, telefono, fechaNacimiento);
    }

    public static Alumno getAlumnoPorDni() throws Exception {
        System.out.print("Introduzca el DNI del alumno: ");
        String dni = scanner.nextLine();
        return new Alumno("Sunombre", "dni", "Sucorreo@ejemplo.com", "500000000", LocalDate.now().minusYears(18));
    }

    public static LocalDate leerFecha() {
        LocalDate fecha = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("""
                dd/mm/yyyy""");
        while (fecha == null) {
            try {
                System.out.print("Introduzca la fecha (dd/mm/yyyy): ");
                String fechaStr = scanner.nextLine();
                fecha = LocalDate.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha invalido. Intente nuevamente.");
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
        System.out.print("Introduzca el codigo del ciclo formativo: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduzca el nombre del ciclo formativo: ");
        String nombre = scanner.nextLine();
        Grado grado = leerGrado();
        return new CicloFormativo(codigo, nombre, grado);
    }

    public static void mostrarCiclosFormativos(CicloFormativo[] ciclos) {
        for (CicloFormativo ciclo : ciclos) {
            System.out.println(ciclo);
        }
    }

    public static CicloFormativo getCicloFormativoPorCodigo() throws Exception {
        System.out.print("Introduzca el codigo del ciclo formativo: ");
        String codigo = scanner.nextLine();
        return new CicloFormativo(codigo, "Nombre de ejemplo", Grado.GDCFGS);
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
        System.out.print("Introduzca el codigo de la asignatura: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduzca el nombre de la asignatura: ");
        String nombre = scanner.nextLine();
        Curso curso = leerCurso();
        EspecialidadProfesorado especialidad = leerEspecialidadProfesorado();
        return new Asignatura(codigo, nombre, curso, especialidad);
    }

    public static Asignatura getAsignaturaPorCodigo() throws Exception {
        System.out.print("Introduzca el codigo de la asignatura: ");
        String codigo = scanner.nextLine();
        return new Asignatura(codigo, "Nombre de ejemplo", Curso.PRIMERO, EspecialidadProfesorado.INFORMATICA);
    }

    public static void mostrarAsignaturas(Asignatura[] asignaturas) {
        for (Asignatura asignatura : asignaturas) {
            System.out.println(asignatura);
        }
    }

    public static boolean asignaturaYaMatriculada(List<Asignatura> asignaturas, Asignatura asignatura) {
        return asignaturas.contains(asignatura);
    }

    public static Asignatura[] elegirAsignaturasMatricula(Asignatura[] asignaturasDisponibles) {
        List<Asignatura> asignaturasElegidas = new ArrayList<>();
        String respuesta;
        do {
            System.out.println("Asignaturas disponibles:");
            for (int i = 0; i < asignaturasDisponibles.length; i++) {
                System.out.println(i + ". " + asignaturasDisponibles[i]);
            }
            System.out.print("Elija el numero de la asignatura: ");
            int eleccion = Integer.parseInt(scanner.nextLine());
            if (eleccion >= 0 && eleccion < asignaturasDisponibles.length) {
                Asignatura asignaturaElegida = asignaturasDisponibles[eleccion];
                if (!asignaturaYaMatriculada(asignaturasElegidas, asignaturaElegida)) {
                    asignaturasElegidas.add(asignaturaElegida);
                } else {
                    System.out.println("La asignatura ya esta matriculada.");
                }
            } else {
                System.out.println("Eleccion inválida.");
            }
            System.out.print("¿Desea añadir otra asignatura? (S/N): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("S"));

        return asignaturasElegidas.toArray(new Asignatura[0]);
    }

    public static Matricula leerMatricula(Alumno alumno, Asignatura[] asignaturasElegidas) throws Exception {
        CicloFormativo cicloFormativo = leerCicloFormativo();
        return new Matricula(alumno, cicloFormativo, List.of(asignaturasElegidas));
    }

    public static Matricula getMatriculaPorIdentificador() throws Exception {
        System.out.print("Introduzca el identificador de la matricula: ");
        String identificador = scanner.nextLine();
        Alumno alumno = new Alumno("SuNombre", "12345678A", "correo@ejemplo.com", "500000000", LocalDate.now().minusYears(18));
        CicloFormativo cicloFormativo = new CicloFormativo("CF001", "Ciclo de ejemplo", Grado.GDCFGS);
        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura("AS001", "Asignatura de ejemplo", Curso.PRIMERO, EspecialidadProfesorado.INFORMATICA));
        return new Matricula(alumno, cicloFormativo, asignaturas);
    }
}

