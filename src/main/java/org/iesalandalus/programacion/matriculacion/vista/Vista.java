package org.iesalandalus.programacion.matriculacion.vista;
import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.dominio.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new IllegalArgumentException("El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutar(opcion);
        } while (opcion != Opcion.SALIR);
    }

    public void terminar() {
        controlador.terminar();
        System.out.println("\nHasta luego :)!");
    }

    private void ejecutar(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_ALUMNO -> insertarAlumno();
            case BUSCAR_ALUMNO -> buscarAlumno();
            case BORRAR_ALUMNO -> borrarAlumno();
            case LISTAR_ALUMNO -> listarAlumnos();
            case INSERTAR_CICLO -> insertarCicloFormativo();
            case BUSCAR_CICLO -> buscarCicloFormativo();
            case BORRAR_CICLO -> borrarCicloFormativo();
            case LISTAR_CICLOS -> listarCiclosFormativos();
            case INSERTAR_ASIGNATURA -> insertarAsignatura();
            case BUSCAR_ASIGNATURA -> buscarAsignatura();
            case BORRAR_ASIGNATURA -> borrarAsignatura();
            case LISTAR_ASIGNATURAS -> listarAsignaturas();
            case INSERTAR_MATRICULA -> insertarMatricula();
            case BUSCAR_MATRICULA -> buscarMatricula();
            case ANULAR_MATRICULA -> anularMatricula();
            case MOSTRAR_MATRICULAS -> listarMatriculas();
            case MOSTRAR_MATRICULAS_ALUMNO -> mostrarMatriculasAlumno();
            case MOSTRAR_MATRICULAS_CICLOFORMATIVO -> mostrarMatriculasCicloFormativo();
            case MOSTRAR_MATRICULAS_CURSOACADEMICO -> mostrarMatriculasCursoAcademico();
            case SALIR -> terminar();
        }
    }

    private void insertarAlumno() {
        try {
            Alumno alumno = Consola.leerAlumno();
            controlador.insertarAlumno(alumno);
            System.out.println("Alumno insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar alumno: " + e.getMessage());
        }
    }

    private void buscarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            Alumno encontrado = controlador.buscarAlumno(alumno);
            if (encontrado != null) {
                System.out.println(encontrado);
            } else {
                System.out.println("Alumno no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }
    }

    private void borrarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            controlador.borrarAlumno(alumno);
            System.out.println("Alumno borrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar alumno: " + e.getMessage());
        }
    }

    private void listarAlumnos() {
        List<Alumno> alumnos = controlador.getAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos que mostrar.");
        } else {
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }
        }
    }

    private void insertarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.leerCicloFormativo();
            controlador.insertarCicloFormativo(ciclo);
            System.out.println("Ciclo formativo insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar ciclo formativo: " + e.getMessage());
        }
    }

    private void buscarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            CicloFormativo encontrado = controlador.buscarCicloFormativo(ciclo);
            if (encontrado != null) {
                System.out.println(encontrado);
            } else {
                System.out.println("Ciclo formativo no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar ciclo formativo: " + e.getMessage());
        }
    }

    private void borrarCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            controlador.borrarCicloFormativo(ciclo);
            System.out.println("Ciclo formativo borrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar ciclo formativo: " + e.getMessage());
        }
    }

    private void listarCiclosFormativos() {
        List<CicloFormativo> ciclos = controlador.getCiclosFormativos();
        if (ciclos.isEmpty()) {
            System.out.println("No hay ciclos formativos que mostrar.");
        } else {
            for (CicloFormativo ciclo : ciclos) {
                System.out.println(ciclo);
            }
        }
    }

    private void insertarAsignatura() {
        try {
            Asignatura asignatura = Consola.leerAsignatura();
            controlador.insertarAsignatura(asignatura);
            System.out.println("Asignatura insertada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar asignatura: " + e.getMessage());
        }
    }

    private void buscarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            Asignatura encontrada = controlador.buscarAsignatura(asignatura);
            if (encontrada != null) {
                System.out.println(encontrada);
            } else {
                System.out.println("Asignatura no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar asignatura: " + e.getMessage());
        }
    }

    private void borrarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            controlador.borrarAsignatura(asignatura);
            System.out.println("Asignatura borrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al borrar asignatura: " + e.getMessage());
        }
    }

    private void listarAsignaturas() {
        List<Asignatura> asignaturas = controlador.getAsignaturas();
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas que mostrar.");
        } else {
            for (Asignatura asignatura : asignaturas) {
                System.out.println(asignatura);
            }
        }
    }

    private void insertarMatricula() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            if (alumno == null) {
                throw new IllegalArgumentException("El alumno no existe.");
            }
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            if (ciclo == null) {
                throw new IllegalArgumentException("El ciclo formativo no existe.");
            }
            Asignatura[] asignaturasDisponibles = controlador.getAsignaturas().toArray(new Asignatura[0]);
            List<Asignatura> asignaturas = Arrays.asList(Consola.elegirAsignaturasMatricula(asignaturasDisponibles));

            Matricula matricula = new Matricula(alumno, ciclo, asignaturas);
            controlador.insertarMatricula(matricula);
            System.out.println("Matricula insertada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar matricula: " + e.getMessage());
        }
    }

    private void buscarMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            Matricula encontrada = controlador.buscarMatricula(matricula);
            if (encontrada != null) {
                System.out.println(encontrada);
            } else {
                System.out.println("Matricula no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar matricula: " + e.getMessage());
        }
    }

    private void anularMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            if (matricula != null) {
                matricula.setFechaAnulacion(LocalDate.now());
                System.out.println("Matricula anulada correctamente.");
            } else {
                System.out.println("Matricula no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al anular matricula: " + e.getMessage());
        }
    }

    private void listarMatriculas() {
        List<Matricula> matriculas = controlador.getMatriculas();
        if (matriculas.isEmpty()) {
            System.out.println("No hay matriculas que mostrar.");
        } else {
            for (Matricula matricula : matriculas) {
                System.out.println(matricula);
            }
        }
    }

    private void mostrarMatriculasAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            List<Matricula> matriculas = controlador.getMatriculas(alumno);
            if (matriculas.isEmpty()) {
                System.out.println("No hay matriculas para este alumno.");
            } else {
                for (Matricula matricula : matriculas) {
                    System.out.println(matricula);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar matriculas: " + e.getMessage());
        }
    }

    private void mostrarMatriculasCicloFormativo() {
        try {
            CicloFormativo ciclo = Consola.getCicloFormativoPorCodigo();
            List<Matricula> matriculas = controlador.getMatriculas(ciclo);
            if (matriculas.isEmpty()) {
                System.out.println("No hay matriculas para este ciclo formativo.");
            } else {
                for (Matricula matricula : matriculas) {
                    System.out.println(matricula);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar matriculas: " + e.getMessage());
        }
    }

    private void mostrarMatriculasCursoAcademico() {
        try {
            String cursoAcademico = String.format("%02d-%02d",
                    LocalDate.now().getYear() % 100,
                    (LocalDate.now().getYear() + 1) % 100);
            List<Matricula> matriculas = controlador.getMatriculas(cursoAcademico);
            if (matriculas.isEmpty()) {
                System.out.println("No hay matriculas para este curso académico.");
            } else {
                for (Matricula matricula : matriculas) {
                    System.out.println(matricula);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar matriculas: " + e.getMessage());
        }
    }
}
