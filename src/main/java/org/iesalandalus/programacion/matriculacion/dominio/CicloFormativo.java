package org.iesalandalus.programacion.matriculacion.dominio;


import java.util.Objects;

public class CicloFormativo {
    private static final int MAX_HORAS = 2000;

    private String identificador;
    private String nombre;
    private int horas;
    private Grado grado;

    public CicloFormativo(String identificador, String nombre, int horas, Grado grado) {
        setIdentificador(identificador);
        setNombre(nombre);
        setGrado(grado);
        this.horas = 0;
    }

    public CicloFormativo(CicloFormativo otroCiclo) {
        if (otroCiclo == null) {
            throw new IllegalArgumentException("No se puede copiar un ciclo formativo nulo.");
        }
        setIdentificador(otroCiclo.identificador);
        setNombre(otroCiclo.nombre);
        setHoras(otroCiclo.horas);
        setGrado(otroCiclo.grado);
    }

    public CicloFormativo(String codigo, String nombreFicticio, Grado grado) {
    }

    public String getIdentificador() {
        return identificador;
    }

    private void setIdentificador(String identificador) {
        if (identificador == null || !identificador.matches("\\d{4}")) {
            throw new IllegalArgumentException("El identificador debe ser un numero de cuatro digitos.");
        }
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio.");
        }
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas <= 0 || horas > MAX_HORAS) {
            throw new IllegalArgumentException("Las horas deben estar entre 1 y " + MAX_HORAS + ".");
        }
        this.horas = horas;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        if (grado == null) {
            throw new IllegalArgumentException("El grado no puede ser nulo.");
        }
        this.grado = grado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CicloFormativo that = (CicloFormativo) o;
        return Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return String.format("CicloFormativo [identificador=%s, nombre=%s, horas=%d, grado=%s]",
                identificador, nombre, horas, grado);
    }

    public String imprimir() {
        return String.format("Ciclo formativo con identificador: %s, nombre: %s, horas: %d, grado: %s",
                identificador, nombre, horas, grado);
    }
}
