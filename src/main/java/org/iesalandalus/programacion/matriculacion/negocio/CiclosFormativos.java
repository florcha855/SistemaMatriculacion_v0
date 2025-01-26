package org.iesalandalus.programacion.matriculacion.negocio;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;


import java.util.ArrayList;
import java.util.List;

public class CiclosFormativos {
    private List<CicloFormativo> coleccionCiclosFormativos;

    public CiclosFormativos(int capacidad) {
        this.coleccionCiclosFormativos = new ArrayList<>(capacidad);
    }

    private List<CicloFormativo> copiaProfundaCiclosFormativos() {
        List<CicloFormativo> copia = new ArrayList<>();
        for (CicloFormativo ciclo : coleccionCiclosFormativos) {
            copia.add(new CicloFormativo(ciclo));
        }
        return copia;
    }

    public List<CicloFormativo> get() {
        return copiaProfundaCiclosFormativos();
    }

    public void insertar(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new IllegalArgumentException("No se puede insertar un ciclo formativo nulo.");
        }
        if (!coleccionCiclosFormativos.contains(cicloFormativo)) {
            coleccionCiclosFormativos.add(cicloFormativo);
        }
    }

    public CicloFormativo buscar(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            return null;
        }
        int index = coleccionCiclosFormativos.indexOf(cicloFormativo);
        return index != -1 ? new CicloFormativo(coleccionCiclosFormativos.get(index)) : null;
    }

    public void borrar(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new IllegalArgumentException("No se puede borrar un ciclo formativo nulo.");
        }
        coleccionCiclosFormativos.remove(cicloFormativo);
    }
}