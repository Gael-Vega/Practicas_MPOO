package excepciones;

/**
 * Se lanza cuando se intenta operar con una cuenta que no existe.
 * Es una excepción verificada (hereda de Exception), por lo que el compilador
 * obliga a capturarla o a declararla con throws.
 */
public class CuentaNoEncontradaException extends Exception {

    private static final long serialVersionUID = 1L;

    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
