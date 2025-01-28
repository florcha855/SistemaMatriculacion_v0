package org.iesalandalus.programacion.matriculacion.vista;

public enum Opcion {
    INSERTAR_ALUMNO("Inserta un alumno"),
    BUSCAR_ALUMNO("Busca un alumno"),
    BORRAR_ALUMNO("Borra un alumno"),
    LISTAR_ALUMNO("Mostrar alumnos"),
    INSERTAR_CICLO("Inserta un ciclo formativo"),
    BUSCAR_CICLO ("Busca un ciclo formativo"),
    BORRAR_CICLO ("Borra un ciclo formativo"),
    LISTAR_CICLOS ("Muestra los ciclos formativos"),
    INSERTAR_ASIGNATURA("Inserta una asignatura"),
    BUSCAR_ASIGNATURA ("Busca una asignatura"),
    BORRAR_ASIGNATURA ("Borra una asignatura"),
    LISTAR_ASIGNATURAS ("Lista las asignaturas"),
    INSERTAR_MATRICULA ("Inserta una matricula"),
    BUSCAR_MATRICULA ("Busca una matricula"),
    ANULAR_MATRICULA ("Anula una matricula"),
    MOSTRAR_MATRICULAS ("Muestra las matriculas"),
    MOSTRAR_MATRICULAS_ALUMNO ("Muestra las matriculas de un alumno"),
    MOSTRAR_MATRICULAS_CICLOFORMATIVO ("Muestra las matriculas de un ciclo formativo"),
    MOSTRAR_MATRICULAS_CURSOACADEMICO ("Muestra las matriculas de un curso academico"),
    SALIR("Salir");

    private String mensaje;

    private Opcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return this.ordinal() + " .- " + this.mensaje;
    }
}