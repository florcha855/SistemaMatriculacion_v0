package org.iesalandalus.programacion.matriculacion.negocio;
import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import java.util.ArrayList;
import java.util.List;

public class Alumnos {
    private List<Alumno> coleccionAlumnos;

    public Alumnos(int capacidad) {
        this.coleccionAlumnos = new ArrayList<>(capacidad);
    }

    private List<Alumno> copiaProfundaAlumnos() {
        List<Alumno> copia = new ArrayList<>();
        for (Alumno alumno : coleccionAlumnos) {
            copia.add(new Alumno(alumno));
        }
        return copia;
    }

    public List<Alumno> get() {
        return copiaProfundaAlumnos();
    }

    public void insertar(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("No se puede insertar un alumno nulo.");
        }
        if (!coleccionAlumnos.contains(alumno)) {
            coleccionAlumnos.add(alumno);
        }
    }

    public Alumno buscar(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        int index = coleccionAlumnos.indexOf(alumno);
        return index != -1 ? new Alumno(coleccionAlumnos.get(index)) : null;
    }

    public void borrar(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("No se puede borrar un alumno nulo.");
        }
        coleccionAlumnos.remove(alumno);
    }
}
