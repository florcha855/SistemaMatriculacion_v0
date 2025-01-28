package org.iesalandalus.programacion.matriculacion.modelo;
import java.util.List;
import org.iesalandalus.programacion.matriculacion.dominio.*;
import org.iesalandalus.programacion.matriculacion.negocio.*;

public class modelo {
    private Alumnos alumnos;
    private Asignaturas asignaturas;
    private CiclosFormativos ciclosFormativos;
    private Matriculas matriculas;

    public void comenzar() {
        alumnos = new Alumnos(20);
        asignaturas = new Asignaturas(50);
        ciclosFormativos = new CiclosFormativos(10);
        matriculas = new Matriculas(100);
    }

    public void terminar() {
        System.out.println("El modelo ha terminado.");
    }

    public void insertarAlumno(Alumno alumno) {
        alumnos.insertar(alumno);
    }

    public void insertarAsignatura(Asignatura asignatura) {
        asignaturas.insertar(asignatura);
    }

    public void insertarCicloFormativo(CicloFormativo cicloFormativo) {
        ciclosFormativos.insertar(cicloFormativo);
    }

    public void insertarMatricula(Matricula matricula) {
        matriculas.insertar(matricula);
    }

    public Alumno buscarAlumno(Alumno alumno) {
        return alumnos.buscar(alumno);
    }

    public Asignatura buscarAsignatura(Asignatura asignatura) {
        return asignaturas.buscar(asignatura);
    }

    public CicloFormativo buscarCicloFormativo(CicloFormativo cicloFormativo) {
        return ciclosFormativos.buscar(cicloFormativo);
    }

    public Matricula buscarMatricula(Matricula matricula) {
        return matriculas.buscar(matricula);
    }

    public void borrarAlumno(Alumno alumno) {
        alumnos.borrar(alumno);
    }

    public void borrarAsignatura(Asignatura asignatura) {
        asignaturas.borrar(asignatura);
    }

    public void borrarCicloFormativo(CicloFormativo cicloFormativo) {
        ciclosFormativos.borrar(cicloFormativo);
    }

    public void borrarMatricula(Matricula matricula) {
        matriculas.borrar(matricula);
    }

    public List<Alumno> getAlumnos() {
        return alumnos.get();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas.get();
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return ciclosFormativos.get();
    }

    public List<Matricula> getMatriculas() {
        return matriculas.get();
    }

    public List<Matricula> getMatriculas(Alumno alumno) {
        return matriculas.get(alumno);
    }

    public List<Matricula> getMatriculas(CicloFormativo cicloFormativo) {
        return matriculas.get(cicloFormativo);
    }

    public List<Matricula> getMatriculas(String cursoAcademico) {
        return matriculas.get(cursoAcademico);
    }
}
