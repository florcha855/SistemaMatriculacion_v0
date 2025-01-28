package org.iesalandalus.programacion.matriculacion.controlador;
import org.iesalandalus.programacion.matriculacion.modelo.modelo;
import org.iesalandalus.programacion.matriculacion.vista.Vista;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import java.util.List;

public class Controlador {
    private modelo modelo;
    private Vista vista;

    public Controlador(modelo modelo, Vista vista) {
        if (modelo == null) {
            throw new IllegalArgumentException("El modelo no puede ser nulo.");
        }
        if (vista == null) {
            throw new IllegalArgumentException("La vista no puede ser nula.");
        }
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void comenzar() {
        modelo.comenzar();
        vista.comenzar();
    }

    public void terminar() {
        modelo.terminar();
        vista.terminar();
    }

    public void insertarAlumno(Alumno alumno) {
        modelo.insertarAlumno(alumno);
    }

    public void insertarAsignatura(Asignatura asignatura) {
        modelo.insertarAsignatura(asignatura);
    }

    public void insertarCicloFormativo(CicloFormativo cicloFormativo) {
        modelo.insertarCicloFormativo(cicloFormativo);
    }

    public void insertarMatricula(Matricula matricula) {
        modelo.insertarMatricula(matricula);
    }

    public Alumno buscarAlumno(Alumno alumno) {
        return modelo.buscarAlumno(alumno);
    }

    public Asignatura buscarAsignatura(Asignatura asignatura) {
        return modelo.buscarAsignatura(asignatura);
    }

    public CicloFormativo buscarCicloFormativo(CicloFormativo cicloFormativo) {
        return modelo.buscarCicloFormativo(cicloFormativo);
    }

    public Matricula buscarMatricula(Matricula matricula) {
        return modelo.buscarMatricula(matricula);
    }

    public void borrarAlumno(Alumno alumno) {
        modelo.borrarAlumno(alumno);
    }

    public void borrarAsignatura(Asignatura asignatura) {
        modelo.borrarAsignatura(asignatura);
    }

    public void borrarCicloFormativo(CicloFormativo cicloFormativo) {
        modelo.borrarCicloFormativo(cicloFormativo);
    }

    public void borrarMatricula(Matricula matricula) {
        modelo.borrarMatricula(matricula);
    }

    public List<Alumno> getAlumnos() {
        return modelo.getAlumnos();
    }

    public List<Asignatura> getAsignaturas() {
        return modelo.getAsignaturas();
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return modelo.getCiclosFormativos();
    }

    public List<Matricula> getMatriculas() {
        return modelo.getMatriculas();
    }

    public List<Matricula> getMatriculas(Alumno alumno) {
        return modelo.getMatriculas(alumno);
    }

    public List<Matricula> getMatriculas(CicloFormativo cicloFormativo) {
        return modelo.getMatriculas(cicloFormativo);
    }

    public List<Matricula> getMatriculas(String cursoAcademico) {
        return modelo.getMatriculas(cursoAcademico);
    }
}
