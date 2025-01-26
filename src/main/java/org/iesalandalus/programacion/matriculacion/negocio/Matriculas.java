package org.iesalandalus.programacion.matriculacion.negocio;

import java.util.ArrayList;
import java.util.List;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;

public class Matriculas {
    private List<Matricula> coleccionMatriculas;

    public Matriculas(int capacidad) {
        this.coleccionMatriculas = new ArrayList<>(capacidad);
    }

    private List<Matricula> copiaProfundaMatriculas() {
        List<Matricula> copia = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            copia.add(new Matricula(matricula));
        }
        return copia;
    }

    public List<Matricula> get() {
        return copiaProfundaMatriculas();
    }

    public void insertar(Matricula matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("No se puede insertar una matrícula nula.");
        }
        if (!coleccionMatriculas.contains(matricula)) {
            coleccionMatriculas.add(matricula);
        }
    }

    public Matricula buscar(Matricula matricula) {
        if (matricula == null) {
            return null;
        }
        int index = coleccionMatriculas.indexOf(matricula);
        return index != -1 ? new Matricula(coleccionMatriculas.get(index)) : null;
    }

    public void borrar(Matricula matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("No se puede borrar una matrícula nula.");
        }
        coleccionMatriculas.remove(matricula);
    }

    public List<Matricula> get(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo.");
        }
        List<Matricula> matriculasAlumno = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            if (matricula.getAlumno().equals(alumno)) {
                matriculasAlumno.add(new Matricula(matricula));
            }
        }
        return matriculasAlumno;
    }

    public List<Matricula> get(String cursoAcademico) {
        if (cursoAcademico == null || cursoAcademico.isEmpty()) {
            throw new IllegalArgumentException("El curso académico no puede ser nulo o vacío.");
        }
        List<Matricula> matriculasCurso = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            if (matricula.getCursoAcademico().equals(cursoAcademico)) {
                matriculasCurso.add(new Matricula(matricula));
            }
        }
        return matriculasCurso;
    }

    public List<Matricula> get(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new IllegalArgumentException("El ciclo formativo no puede ser nulo.");
        }
        List<Matricula> matriculasCiclo = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            if (matricula.getCicloFormativo().equals(cicloFormativo)) {
                matriculasCiclo.add(new Matricula(matricula));
            }
        }
        return matriculasCiclo;
    }
}
