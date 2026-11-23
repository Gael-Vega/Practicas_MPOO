package principal;

import banco.Banco;
import cuentas.Cuenta;
import excepciones.CuentaNoEncontradaException;
import excepciones.MontoInvalidoException;
import excepciones.NipIncorrectoException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;
import operaciones.Deposito;
import operaciones.Retiro;
import operaciones.Transferencia;

import java.util.Locale;
import java.util.Scanner;

/**
 * Interfaz de consola. Solo pide datos y muestra resultados: la lógica del negocio
 * vive en Banco, Cuenta y las operaciones.
 */
public class Main {

    private final Banco banco = new Banco();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().iniciar();
    }

    public void iniciar() {
        int opcion = 0;
        do {
            mostrarMenu();
            try {
                opcion = leerEntero("Seleccione una opción: ");
                switch (opcion) {
                    case 1 -> registrarCuenta();
                    case 2 -> consultarCuenta();
                    case 3 -> consultarSaldo();
                    case 4 -> depositar();
                    case 5 -> retirar();
                    case 6 -> transferir();
                    case 7 -> consultarHistorial();
                    case 8 -> System.out.println("Gracias por usar el sistema bancario. ¡Hasta pronto!");
                    default -> System.out.println("Opción no válida. Elija un número del 1 al 8.");
                }
            } catch (CuentaNoEncontradaException | NipIncorrectoException
                     | MontoInvalidoException | SaldoInsuficienteException
                     | OperacionInvalidaException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: debe ingresar un número válido.");
            } finally {
                // Se ejecuta siempre, haya o no error, y el menú sigue funcionando.
                if (opcion != 8) {
                    System.out.println("------------------------------------------");
                }
            }
        } while (opcion != 8);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA BANCARIO =====");
        System.out.println("1. Registrar cuenta bancaria");
        System.out.println("2. Consultar cuenta");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Realizar depósito");
        System.out.println("5. Realizar retiro");
        System.out.println("6. Realizar transferencia");
        System.out.println("7. Consultar historial de operaciones");
        System.out.println("8. Salir del sistema");
    }

    // ------------------------------------------------------------------
    // Opciones del menú
    // ------------------------------------------------------------------

    private void registrarCuenta() throws OperacionInvalidaException, MontoInvalidoException {
        String numero = leerTexto("Número de cuenta: ");
        String titular = leerTexto("Titular: ");
        double saldoInicial = leerDecimal("Saldo inicial (0 si no hay): ");
        String nip = leerTexto("NIP (4 dígitos): ");

        // Se usa la sobrecarga de constructores según el saldo inicial.
        Cuenta cuenta = (saldoInicial == 0)
                ? new Cuenta(numero, titular, nip)
                : new Cuenta(numero, titular, saldoInicial, nip);
        banco.registrarCuenta(cuenta);
        System.out.println("Cuenta registrada correctamente: " + cuenta);
    }

    private void consultarCuenta() throws CuentaNoEncontradaException {
        Cuenta cuenta = banco.buscarCuenta(leerTexto("Número de cuenta: "));
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("(El saldo se consulta en la opción 3 con su NIP)");
    }

    private void consultarSaldo() throws CuentaNoEncontradaException, NipIncorrectoException {
        Cuenta cuenta = autenticar();
        System.out.println(String.format(Locale.US, "Saldo disponible: $%,.2f", cuenta.consultarSaldo()));
    }

    private void depositar() throws CuentaNoEncontradaException, MontoInvalidoException,
            SaldoInsuficienteException, OperacionInvalidaException {
        Cuenta cuenta = banco.buscarCuenta(leerTexto("Número de cuenta destino: "));
        double monto = leerDecimal("Monto a depositar: ");
        banco.realizarOperacion(new Deposito(monto, cuenta));
        System.out.println(String.format(Locale.US, "Depósito exitoso. Nuevo saldo: $%,.2f", cuenta.consultarSaldo()));
    }

    private void retirar() throws CuentaNoEncontradaException, NipIncorrectoException,
            MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException {
        Cuenta cuenta = autenticar();
        double monto = leerDecimal("Monto a retirar: ");
        banco.realizarOperacion(new Retiro(monto, cuenta));
        System.out.println(String.format(Locale.US, "Retiro exitoso. Nuevo saldo: $%,.2f", cuenta.consultarSaldo()));
    }

    private void transferir() throws CuentaNoEncontradaException, NipIncorrectoException,
            MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException {
        System.out.println("-- Cuenta origen --");
        Cuenta origen = autenticar();
        Cuenta destino = banco.buscarCuenta(leerTexto("Número de cuenta destino: "));
        double monto = leerDecimal("Monto a transferir: ");
        banco.realizarOperacion(new Transferencia(monto, origen, destino));
        System.out.println(String.format(Locale.US, "Transferencia exitosa. Nuevo saldo de origen: $%,.2f",
                origen.consultarSaldo()));
    }

    private void consultarHistorial() throws CuentaNoEncontradaException, NipIncorrectoException {
        Cuenta cuenta = autenticar();
        System.out.println("Historial de la cuenta " + cuenta.getNumeroCuenta() + ":");
        cuenta.getHistorial().mostrarHistorial();
    }

    // ------------------------------------------------------------------
    // Utilidades de entrada
    // ------------------------------------------------------------------

    /** Pide número de cuenta y NIP, y devuelve la cuenta ya autenticada. */
    private Cuenta autenticar() throws CuentaNoEncontradaException, NipIncorrectoException {
        String numero = leerTexto("Número de cuenta: ");
        String nip = leerTexto("NIP: ");
        return banco.autenticar(numero, nip);
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /** Lanza NumberFormatException si el usuario escribe texto en vez de un número. */
    private int leerEntero(String mensaje) {
        return Integer.parseInt(leerTexto(mensaje));
    }

    private double leerDecimal(String mensaje) {
        return Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
    }
}
