package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Matricula {
    private static final int MAX_HORAS = 1000;
    private static final int MAX_ASIGNATURAS = 10;
    private static final long MAX_DIAS_RETRASO = 15;
    private static final long MAX_MESES_ANULACION = 6;

    private int identificador;
    private Alumno alumno;
    private CicloFormativo cicloFormativo;
    private List<Asignatura> asignaturas;
    private LocalDate fechaMatricula;
    private LocalDate fechaAnulacion;
    private String cursoAcademico;

    public Matricula(int identificador, Alumno alumno, CicloFormativo cicloFormativo, List<Asignatura> asignaturas,
                     LocalDate fechaMatricula, String cursoAcademico) {
        setIdentificador(identificador);
        setAlumno(alumno);
        setCicloFormativo(cicloFormativo);
        setAsignaturas(asignaturas);
        setFechaMatricula(fechaMatricula);
        setCursoAcademico(cursoAcademico);
    }

    public Matricula(Matricula otra) {
        if (otra == null) {
            throw new IllegalArgumentException("No se puede copiar una matrícula nula.");
        }
        this.identificador = otra.identificador;
        this.alumno = new Alumno(otra.alumno);
        this.cicloFormativo = new CicloFormativo(otra.cicloFormativo);
        this.asignaturas = new ArrayList<>(otra.asignaturas);
        this.fechaMatricula = otra.fechaMatricula;
        this.fechaAnulacion = otra.fechaAnulacion;
        this.cursoAcademico = otra.cursoAcademico;
    }

    public Matricula(Alumno alumno, CicloFormativo cicloFormativo, List<Asignatura> asignaturas) {
        int identificador = Math.abs(Objects.hash(alumno, cicloFormativo, LocalDate.now()));
        String cursoAcademico = String.format("%02d-%02d",
                LocalDate.now().getYear() % 100,
                (LocalDate.now().getYear() + 1) % 100);

        setIdentificador(identificador);
        setAlumno(alumno);
        setCicloFormativo(cicloFormativo);
        setAsignaturas(asignaturas);
        setFechaMatricula(LocalDate.now());
        setCursoAcademico(cursoAcademico);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser un numero positivo.");
        }
        this.identificador = identificador;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = Objects.requireNonNull(alumno, "El alumno no puede ser nulo.");
    }

    public CicloFormativo getCicloFormativo() {
        return cicloFormativo;
    }

    public void setCicloFormativo(CicloFormativo cicloFormativo) {
        this.cicloFormativo = Objects.requireNonNull(cicloFormativo, "El ciclo formativo no puede ser nulo.");
    }

    public List<Asignatura> getAsignaturas() {
        return new ArrayList<>(asignaturas);
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        if (asignaturas == null || asignaturas.isEmpty()) {
            throw new IllegalArgumentException("La lista de asignaturas no puede ser nula o vacía.");
        }
        if (asignaturas.size() > MAX_ASIGNATURAS) {
            throw new IllegalArgumentException("El numero maximo de asignaturas es " + MAX_ASIGNATURAS + ".");
        }
        this.asignaturas = new ArrayList<>(asignaturas);
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        if (fechaMatricula == null) {
            throw new IllegalArgumentException("La fecha de matrícula no puede ser nula.");
        }
        if (ChronoUnit.DAYS.between(fechaMatricula, LocalDate.now()) > MAX_DIAS_RETRASO) {
            throw new IllegalArgumentException("La matrícula no puede registrarse con mas de " + MAX_DIAS_RETRASO + " dias de retraso.");
        }
        this.fechaMatricula = fechaMatricula;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        if (fechaAnulacion != null) {
            if (fechaAnulacion.isBefore(fechaMatricula)) {
                throw new IllegalArgumentException("La fecha de anulacion no puede ser anterior a la fecha de matricula.");
            }
            if (ChronoUnit.MONTHS.between(fechaMatricula, fechaAnulacion) > MAX_MESES_ANULACION) {
                throw new IllegalArgumentException("La fecha de anulacion no puede superar los " + MAX_MESES_ANULACION + " meses desde la fecha de matricula.");
            }
        }
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        if (!cursoAcademico.matches("\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("El curso académico debe tener el formato dd-dd.");
        }
        this.cursoAcademico = cursoAcademico;
    }

    public boolean superaMaximoNumeroHorasMatricula() {
        int totalHoras = asignaturas.stream().mapToInt(Asignatura::getHorasAnuales).sum();
        return totalHoras > MAX_HORAS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return identificador == matricula.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Matricula [identificador=%d, alumno=%s, ciclo formativo=%s, fecha matricula=%s, fecha anulacion=%s, curso academico=%s]",
                identificador, alumno, cicloFormativo, fechaMatricula.format(formatter),
                fechaAnulacion != null ? fechaAnulacion.format(formatter) : "No anulada", cursoAcademico);
    }
}
