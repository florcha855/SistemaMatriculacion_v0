package org.iesalandalus.programacion.matriculacion.negocio;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import java.util.ArrayList;
import java.util.List;


public class Asignaturas {
    private List<Asignatura> coleccionAsignaturas;

    public Asignaturas(int capacidad) {
        this.coleccionAsignaturas = new ArrayList<>(capacidad);
    }

    private List<Asignatura> copiaProfundaAsignaturas() {
        List<Asignatura> copia = new ArrayList<>();
        for (Asignatura asignatura : coleccionAsignaturas) {
            copia.add(new Asignatura(asignatura));
        }
        return copia;
    }

    public List<Asignatura> get() {
        return copiaProfundaAsignaturas();
    }

    public void insertar(Asignatura asignatura) {
        if (asignatura == null) {
            throw new IllegalArgumentException("No se puede insertar una asignatura nula.");
        }
        if (!coleccionAsignaturas.contains(asignatura)) {
            coleccionAsignaturas.add(asignatura);
        }
    }

    public Asignatura buscar(Asignatura asignatura) {
        if (asignatura == null) {
            return null;
        }
        int index = coleccionAsignaturas.indexOf(asignatura);
        return index != -1 ? new Asignatura(coleccionAsignaturas.get(index)) : null;
    }

    public void borrar(Asignatura asignatura) {
        if (asignatura == null) {
            throw new IllegalArgumentException("No se puede borrar una asignatura nula.");
        }
        coleccionAsignaturas.remove(asignatura);
    }
}