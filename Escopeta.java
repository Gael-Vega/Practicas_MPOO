package com.arena.app;

import com.arena.armas.Arma;

public class Escopeta extends Arma {

    public Escopeta() {
        super("Escopeta de Asalto", 30, 10, 25);
        // Compila: cargador es protected y esta clase hereda de Arma.
        this.cargador = 10;

        // No descomentes la siguiente línea:
        // this.danioBase = 25; // No compila: danioBase tiene acceso de paquete.
    }
}
