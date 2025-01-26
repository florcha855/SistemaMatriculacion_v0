package org.iesalandalus.programacion.matriculacion.dominio;

public enum Grado {
    GDCFGB("Ciclo formativo grado basico"),
    GDCFGM("Ciclo formativo grado medio"),
    GDCFGS("Ciclo formativo grado superior");


    private String cadenaAMostrar;

    private Grado(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    public String imprimir() {
        return this.ordinal() + ".-" + cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
