package com.arena.armas;

public class Arma {
    private int municion;
    protected int cargador;
    int danioBase;
    public String nombre;

    public Arma(String nombre, int municion, int cargador, int danioBase) {
        this.nombre = nombre;
        setMunicion(municion);
        this.cargador = cargador;
        this.danioBase = danioBase;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        if (municion < 0) {
            this.municion = 0;
        } else {
            this.municion = municion;
        }
    }
}
