package com.arena.leyendas;

import com.arena.armas.Arma;

public class Leyenda {
    private String apodo;
    private Arma arma;

    public Leyenda(String apodo, Arma arma) {
        this.apodo = apodo;
        this.arma = arma;
    }

    public void disparar() {
        int balasActuales = arma.getMunicion();

        if (balasActuales > 0) {
            arma.setMunicion(balasActuales - 1);
            System.out.println(
                apodo + " disparó. Munición restante: " + arma.getMunicion()
            );
        } else {
            System.out.println("¡Sin munición!");
        }
    }
}
