package org.iesalandalus.programacion.matriculacion;
import org.iesalandalus.programacion.matriculacion.modelo.modelo;
import org.iesalandalus.programacion.matriculacion.vista.Vista;
import org.iesalandalus.programacion.matriculacion.controlador.Controlador;

public class MainApp {
    public static void main(String[] args) {
        modelo modelo = new modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);

        controlador.comenzar();
    }
}