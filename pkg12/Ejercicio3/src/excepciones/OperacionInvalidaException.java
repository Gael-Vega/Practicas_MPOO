package excepciones;

/**
 * Se lanza cuando una operación no cumple las condiciones para ejecutarse.
 * Es una excepción verificada (hereda de Exception), por lo que el compilador
 * obliga a capturarla o a declararla con throws.
 */
public class OperacionInvalidaException extends Exception {

    private static final long serialVersionUID = 1L;

    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
