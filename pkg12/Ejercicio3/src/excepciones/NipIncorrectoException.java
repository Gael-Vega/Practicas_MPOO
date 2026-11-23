package excepciones;

/**
 * Se lanza cuando el NIP proporcionado no coincide con el de la cuenta.
 * Es una excepción verificada (hereda de Exception), por lo que el compilador
 * obliga a capturarla o a declararla con throws.
 */
public class NipIncorrectoException extends Exception {

    private static final long serialVersionUID = 1L;

    public NipIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
