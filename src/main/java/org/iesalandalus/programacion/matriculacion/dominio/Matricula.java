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
        this(otra.identificador, otra.alumno, otra.cicloFormativo, new ArrayList<>(otra.asignaturas),
                otra.fechaMatricula, otra.cursoAcademico);
        this.fechaAnulacion = otra.fechaAnulacion;
    }

    public Matricula(Alumno alumno, CicloFormativo cicloFormativo, List<Asignatura> asignaturas) {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser un número positivo.");
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
            throw new IllegalArgumentException("El número máximo de asignaturas es " + MAX_ASIGNATURAS + ".");
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
            throw new IllegalArgumentException("La matrícula no puede registrarse con más de " + MAX_DIAS_RETRASO + " días de retraso.");
        }
        this.fechaMatricula = fechaMatricula;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        if (fechaAnulacion != null) {
            if (fechaAnulacion.isBefore(fechaMatricula)) {
                throw new IllegalArgumentException("La fecha de anulación no puede ser anterior a la fecha de matrícula.");
            }
            if (ChronoUnit.MONTHS.between(fechaMatricula, fechaAnulacion) > MAX_MESES_ANULACION) {
                throw new IllegalArgumentException("La fecha de anulación no puede superar los " + MAX_MESES_ANULACION + " meses desde la fecha de matrícula.");
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

    public String asignaturasMatricula() {
        return asignaturas.stream()
                .map(Asignatura::getNombre)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    public String imprimir() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaAnulacionStr = fechaAnulacion != null ? fechaAnulacion.format(formatter) : "No anulada";
        return String.format("Matrícula con identificador: %d para el alumno: %s %s, DNI: %s, en el ciclo: %s, curso: %s, fecha de matrícula: %s, fecha de anulación: %s",
                identificador, alumno.getNombre(), alumno.getDni(),
                cicloFormativo.getNombre(), cursoAcademico, fechaMatricula.format(formatter), fechaAnulacionStr);
    }

    @Override
    public String toString() {
        return String.format("Matrícula [identificador=%d, alumno=%s, ciclo formativo=%s, fecha matrícula=%s, fecha anulación=%s, curso académico=%s]",
                identificador, alumno, cicloFormativo, fechaMatricula, fechaAnulacion, cursoAcademico);
    }
}

