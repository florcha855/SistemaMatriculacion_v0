package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alumno {
    private static final String ER_NOMBRE = "^([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)(\\s+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$";
    private static final String ER_DNI = "^[0-9]{8}[A-Z]$";
    private static final String ER_CORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String ER_TELEFONO = "^[69][0-9]{8}$";
    private static final String FORMATO_FECHA = "dd/mm/yyyy";
    private static final int MIN_EDAD_ALUMNADO = 16;

    private String nombre;
    private String dni;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String nia;

    public Alumno(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setDni(dni);
        setCorreo(correo);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        setNia();
    }

    public Alumno(Alumno alumno) {
        if (alumno == null) {
            throw new NullPointerException("No se puede copiar un alumno nulo.");
        }
        setNombre(alumno.nombre);
        setDni(alumno.dni);
        setCorreo(alumno.correo);
        setTelefono(alumno.telefono);
        setFechaNacimiento(alumno.fechaNacimiento);
        this.nia = alumno.nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo.");
        }
        String nombreFormateado = formateaNombre(nombre);
        if (!nombreFormateado.matches(ER_NOMBRE)) {
            throw new IllegalArgumentException("El nombre no tiene un formato valido.");
        }
        this.nombre = nombreFormateado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null) {
            throw new NullPointerException("El DNI no puede ser nulo.");
        }
        dni = dni.trim().toUpperCase();
        if (!dni.matches(ER_DNI)) {
            throw new IllegalArgumentException("El DNI no tiene un formato valido.");
        }
        if (!validarLetraDni(dni)) {
            throw new IllegalArgumentException("La letra del DNI no es valida.");
        }
        this.dni = dni;
    }

    private boolean validarLetraDni(String dni) {
        try {
            String letrasValidas = "ABCDEFGHIJKLMNOPQRSTWX";
            String numero = dni.substring(0, 8);
            char letraProvista = dni.charAt(8);
            int numeroInt = Integer.parseInt(numero);
            char letraCalculada = letrasValidas.charAt(numeroInt % 23);
            return letraProvista == letraCalculada;
        } catch (Exception e) {
            return false;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null) {
            throw new NullPointerException("El correo no puede ser nulo.");
        }
        if (!correo.matches(ER_CORREO)) {
            throw new IllegalArgumentException("El correo no tiene un formato valido.");
        }
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null) {
            throw new NullPointerException("El telefono no puede ser nulo.");
        }
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("El telefono no tiene un formato valido.");
        }
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new NullPointerException("La fecha de nacimiento no puede ser nula.");
        }
        if (fechaNacimiento.plusYears(MIN_EDAD_ALUMNADO).isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("El alumno debe tener al menos 16 anios.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNia() {
        return nia;
    }

    private void setNia() {
        String nombreInicial = nombre.toLowerCase().replaceAll("\\s+", "");
        String iniciales = nombreInicial.substring(0, Math.min(4, nombreInicial.length()));
        String numerosDni = dni.substring(5, 8);
        this.nia = iniciales + numerosDni;
    }

    private String formateaNombre(String nombre) {
        String[] palabras = nombre.trim().split("\\s+");
        StringBuilder nombreFormateado = new StringBuilder();
        for (String palabra : palabras) {
            if (!nombreFormateado.isEmpty()) {
                nombreFormateado.append(" ");
            }
            nombreFormateado.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1).toLowerCase());
        }
        return nombreFormateado.toString();
    }

    public String getIniciales() {
        StringBuilder iniciales = new StringBuilder();
        for (String palabra : nombre.split("\\s+")) {
            if (!palabra.isEmpty()) {
                iniciales.append(palabra.charAt(0));
            }
        }
        return iniciales.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return dni.equals(alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return String.format("nombre=%s (%s), DNI=%s, correo=%s, telefono=%s, fecha nacimiento=%s, NIA=%s",
                nombre, getIniciales(), dni, correo, telefono,
                fechaNacimiento.format(DateTimeFormatter.ofPattern(FORMATO_FECHA)), nia);
    }
}

