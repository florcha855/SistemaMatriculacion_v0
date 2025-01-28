package org.iesalandalus.programacion.matriculacion.dominio;


import java.util.Objects;

public class Asignatura {
    private static final int MAX_HORAS_ANUALES = 300;
    private static final int MAX_HORAS_DESDOBLE = 6;

    private String identificador;
    private String nombre;
    private int horasAnuales;
    private int horasDesdoble;
    private EspecialidadProfesorado especialidad;
    private Curso curso;

    public Asignatura(String identificador, String nombre, int horasAnuales, int horasDesdoble, EspecialidadProfesorado especialidad, Curso curso) {
        setIdentificador(identificador);
        setNombre(nombre);
        setHorasAnuales(horasAnuales);
        setHorasDesdoble(horasDesdoble);
        setEspecialidad(especialidad);
        setCurso(curso);
    }

    public Asignatura(Asignatura otraAsignatura) {
        if (otraAsignatura == null) {
            throw new IllegalArgumentException("No se puede copiar una asignatura nula.");
        }
        setIdentificador(otraAsignatura.identificador);
        setNombre(otraAsignatura.nombre);
        setHorasAnuales(otraAsignatura.horasAnuales);
        setHorasDesdoble(otraAsignatura.horasDesdoble);
        setEspecialidad(otraAsignatura.especialidad);
        setCurso(otraAsignatura.curso);
    }

    public Asignatura(String codigo, String nombre, Curso curso, EspecialidadProfesorado especialidad) {
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

    public int getHorasAnuales() {
        return horasAnuales;
    }

    public void setHorasAnuales(int horasAnuales) {
        if (horasAnuales <= 0 || horasAnuales > MAX_HORAS_ANUALES) {
            throw new IllegalArgumentException("Las horas anuales deben estar entre 1 y " + MAX_HORAS_ANUALES + ".");
        }
        this.horasAnuales = horasAnuales;
    }

    public int getHorasDesdoble() {
        return horasDesdoble;
    }

    public void setHorasDesdoble(int horasDesdoble) {
        if (horasDesdoble < 0 || horasDesdoble > MAX_HORAS_DESDOBLE) {
            throw new IllegalArgumentException("Las horas de desdoble deben estar entre 0 y " + MAX_HORAS_DESDOBLE + ".");
        }
        this.horasDesdoble = horasDesdoble;
    }

    public EspecialidadProfesorado getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadProfesorado especialidad) {
        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad no puede ser nula.");
        }
        this.especialidad = especialidad;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo.");
        }
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return String.format("Asignatura [identificador=%s, nombre=%s, horas anuales=%d, horas desdoble=%d, especialidad=%s, curso=%s]",
                identificador, nombre, horasAnuales, horasDesdoble, especialidad, curso);
    }

    public String imprimir() {
        return String.format("Asignatura con identificador: %s, nombre: %s, horas anuales: %d, horas desdoble: %d, especialidad: %s, curso: %s",
                identificador, nombre, horasAnuales, horasDesdoble, especialidad, curso);
    }
}
