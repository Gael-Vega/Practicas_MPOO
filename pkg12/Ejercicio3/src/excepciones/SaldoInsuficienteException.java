package excepciones;

/**
 * Se lanza cuando se intenta retirar o transferir más dinero del disponible.
 * Es una excepción verificada (hereda de Exception), por lo que el compilador
 * obliga a capturarla o a declararla con throws.
 */
public class SaldoInsuficienteException extends Exception {

    private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
