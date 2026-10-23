package com.arena.app;

import com.arena.armas.Arma;
import com.arena.leyendas.Leyenda;

public class Main {
    public static void main(String[] args) {
        Arma armaPrincipal = new Arma("Pistola", 10, 5, 15);
        Leyenda jugador = new Leyenda("Goku", armaPrincipal);

        for (int i = 0; i < 5; i++) {
            jugador.disparar();
        }

        // Esta línea no compila porque arma y municion no son accesibles
        // directamente desde Main:
        // jugador.arma.municion = 100;
    }
}
