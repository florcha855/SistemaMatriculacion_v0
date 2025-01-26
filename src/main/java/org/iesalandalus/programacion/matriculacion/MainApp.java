package org.iesalandalus.programacion.matriculacion;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.vista.Consola;
import org.iesalandalus.programacion.matriculacion.vista.Opcion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private List<Alumno> alumnos;
    private List<Asignatura> asignaturas;
    private List<CicloFormativo> ciclosFormativos;
    private List<Matricula> matriculas;

    public MainApp() {
        alumnos = new ArrayList<>();
        asignaturas = new ArrayList<>();
        ciclosFormativos = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    public void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_ALUMNO:
                insertarAsignatura();
                break;
            case BUSCAR_ALUMNO:
                buscarAsignatura();
                break;
            case BORRAR_ALUMNO:
                borrarAsignatura();
                break;
            case LISTAR_ALUMNO:
                mostrarAlumnos();
                break;
            case LISTAR_ASIGNATURAS:
                mostrarAsignaturas();
                break;
            case INSERTAR_CICLO:
                insertarCicloFormativo();
                break;
            case BUSCAR_CICLO:
                buscarCicloFormativo();
                break;
            case BORRAR_CICLO:
                borrarCicloFormativo();
                break;
            case LISTAR_CICLOS:
                mostrarCiclosFormativos();
                break;
            case INSERTAR_MATRICULA:
                insertarMatricula();
                break;
            case BUSCAR_MATRICULA:
                buscarMatricula();
                break;
            case ANULAR_MATRICULA:
                anularMatricula();
                break;
            case MOSTRAR_MATRICULAS:
                mostrarMatriculas();
                break;
            case MOSTRAR_MATRICULAS_ALUMNO:
                mostrarMatriculasPorAlumno();
                break;
            case MOSTRAR_MATRICULAS_CICLOFORMATIVO:
                mostrarMatriculasPorCicloFormativo();
                break;
            case MOSTRAR_MATRICULAS_CURSOACADEMICO:
                mostrarMatriculasPorCursoAcademico();
                break;
        }
    }

    private void insertarAlumno() {
        try {
            Alumno alumno = Consola.leerAlumno();
            if (alumnos.add(alumno)) {
                System.out.println("Alumno insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el alumno.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar alumno: " + e.getMessage());
        }
    }

    private void buscarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            int index = alumnos.indexOf(alumno);
            if (index != -1) {
                System.out.println(alumnos.get(index));
            } else {
                System.out.println("El alumno no existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }
    }

    private void borrarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            if (alumnos.remove(alumno)) {
                System.out.println("Alumno borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el alumno.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar alumno: " + e.getMessage());
        }
    }

    private void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos almacenados.");
        } else {
            alumnos.forEach(System.out::println);
        }
    }

    private void insertarAsignatura() {
        try {
            Asignatura asignatura = Consola.leerAsignatura();
            if (asignaturas.add(asignatura)) {
                System.out.println("Asignatura insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la asignatura.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar asignatura: " + e.getMessage());
        }
    }

    private void buscarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            int index = asignaturas.indexOf(asignatura);
            if (index != -1) {
                System.out.println(asignaturas.get(index));
            } else {
                System.out.println("La asignatura no existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar asignatura: " + e.getMessage());
        }
    }

    private void borrarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            if (asignaturas.remove(asignatura)) {
                System.out.println("Asignatura borrada correctamente.");
            } else {
                System.out.println("No se pudo borrar la asignatura.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar asignatura: " + e.getMessage());
        }
    }

    private void mostrarAsignaturas() {
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas almacenadas.");
        } else {
            asignaturas.forEach(System.out::println);
        }
    }

    private void insertarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.leerCicloFormativo();
            if (ciclosFormativos.add(cicloFormativo)) {
                System.out.println("Ciclo formativo insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el ciclo formativo.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar ciclo formativo: " + e.getMessage());
        }
    }

    private void buscarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            int index = ciclosFormativos.indexOf(cicloFormativo);
            if (index != -1) {
                System.out.println(ciclosFormativos.get(index));
            } else {
                System.out.println("El ciclo formativo no existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar ciclo formativo: " + e.getMessage());
        }
    }

    private void borrarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            if (ciclosFormativos.remove(cicloFormativo)) {
                System.out.println("Ciclo formativo borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el ciclo formativo.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar ciclo formativo: " + e.getMessage());
        }
    }

    private void mostrarCiclosFormativos() {
        if (ciclosFormativos.isEmpty()) {
            System.out.println("No hay ciclos formativos almacenados.");
        } else {
            ciclosFormativos.forEach(System.out::println);
        }
    }

    private void insertarMatricula() {
        try {
            Matricula matricula = Consola.leerMatricula();
            if (matriculas.add(matricula)) {
                System.out.println("Matrícula insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la matrícula.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar matrícula: " + e.getMessage());
        }
    }

    private void buscarMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            int index = matriculas.indexOf(matricula);
            if (index != -1) {
                System.out.println(matriculas.get(index));
            } else {
                System.out.println("La matrícula no existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar matrícula: " + e.getMessage());
        }
    }

    private void anularMatricula() {
        if (matriculas.isEmpty()) {
            System.out.println("No hay matrículas para anular.");
            return;
        }

        System.out.println("Lista de matrículas:");
        for (int i = 0; i < matriculas.size(); i++) {
            System.out.println(i + ": " + matriculas.get(i));
        }

        System.out.print("Seleccione el número de la matrícula a anular: ");
        int seleccion = Integer.parseInt(Consola.scanner.nextLine());

        if (seleccion < 0 || seleccion >= matriculas.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Matricula matricula = matriculas.get(seleccion);
        LocalDate fechaAnulacion = Consola.leerFecha();

        try {
            matricula.setFechaAnulacion(fechaAnulacion);
            System.out.println("Matrícula anulada correctamente.");
        } catch (Exception e) {
            System.out.println("No se pudo anular la matrícula: " + e.getMessage());
        }
    }

    private void mostrarMatriculas() {
        if (matriculas.isEmpty()) {
            System.out.println("No hay matrículas almacenadas.");
        } else {
            matriculas.forEach(System.out::println);
        }
    }

    private void mostrarMatriculasPorAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            List<Matricula> matriculasAlumno = matriculas.stream()
                    .filter(m -> m.getAlumno().equals(alumno))
                    .toList();

            if (matriculasAlumno.isEmpty()) {
                System.out.println("No hay matrículas para este alumno.");
            } else {
                matriculasAlumno.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar matrículas del alumno: " + e.getMessage());
        }
    }

    private void mostrarMatriculasPorCicloFormativo() {
        Consola.mostrarCiclosFormativos(ciclosFormativos);
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            List<Matricula> matriculasCiclo = matriculas.stream()
                    .filter(m -> m.getCicloFormativo().equals(ciclo))
                    .toList();

            if (matriculasCiclo.isEmpty()) {
                System.out.println("No hay matrículas para este ciclo formativo.");
            } else {
                matriculasCiclo.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar matrículas del ciclo formativo: " + e.getMessage());
        }
    }

    private void mostrarMatriculasPorCursoAcademico() {
        System.out.print("Introduzca el curso académico (YYYY-YYYY): ");
        String cursoAcademico = Consola.scanner.nextLine();

        List<Matricula> matriculasCurso = matriculas.stream()
                .filter(m -> m.getCursoAcademico().equals(cursoAcademico))
                .toList();

        if (matriculasCurso.isEmpty()) {
            System.out.println("No hay matrículas para este curso académico.");
        } else {
            matriculasCurso.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        Opcion opcion;

        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            app.ejecutarOpcion(opcion);
        } while (opcion != Opcion.SALIR);

        System.out.println("Gracias por usar la aplicación. ¡Hasta pronto!");
    }
}

