/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen2;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE CONSTRUCTORES ===");

        try {
            new Efectivo(0, "ORD-2");
            System.out.println("ORD-2: El pago fue creado correctamente.");
        } catch (MontoInvalidoException e) {
            System.out.println("ORD-2 | Pago no creado | " + e.getMessage());
        }

        // Prueba: CLABE con longitud incorrecta.
        try {
            new Transferencia(2500.00, "ORD-5", "12345");
            System.out.println("ERROR: se aceptó una CLABE inválida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Prueba de CLABE invalida: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== PROCESAMIENTO DE PAGOS ===");

        // Incluye pagos por debajo, exactamente en el límite y por encima del límite.
        Pago[] lote = {
            new Tarjeta(1000.00, "ORD-1"),
            new Transferencia(2500.00, "ORD-4", "012345678901234567"),
            new Efectivo(9000.00, "ORD-3"),
            new Efectivo(500.00, "ORD-6"),
            new Tarjeta(10500.00, "ORD-7"),
            new Tarjeta(10000.00, "ORD-8"),
            new Transferencia(50000.00, "ORD-9", "123456789012345678"),
            new Efectivo(8000.00, "ORD-10"),
            new Transferencia(50001.00, "ORD-11", "123456789012345678")
        };

        double totalCobrado = 0.0;
        double comisionesAcumuladas = 0.0;
        int pagosRechazados = 0;

        // Arreglo para registrar las referencias de los pagos aprobados.
        String[] pagosProcesados = new String[lote.length];
        int cantidadProcesados = 0;

        for (Pago pago : lote) {
            try {
                System.out.println(pago.procesar());

                double comision = pago.calcularComision();
                totalCobrado += pago.monto + comision;
                comisionesAcumuladas += comision;
                pagosProcesados[cantidadProcesados] = pago.referencia;
                cantidadProcesados++;

            } catch (PagoRechazadoException e) {
                pagosRechazados++;
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

        System.out.println("=== RESUMEN ===");
        System.out.println("Total cobrado: $" + String.format(Locale.US, "%.2f", totalCobrado));
        System.out.println("Comisiones acumuladas: $"
            + String.format(Locale.US, "%.2f", comisionesAcumuladas));
        System.out.println("Pagos rechazados: " + pagosRechazados);

        System.out.println();
        System.out.println("=== PAGOS PROCESADOS CORRECTAMENTE ===");
        for (int i = 0; i < cantidadProcesados; i++) {
            System.out.println(pagosProcesados[i]);
        }
    }
}
