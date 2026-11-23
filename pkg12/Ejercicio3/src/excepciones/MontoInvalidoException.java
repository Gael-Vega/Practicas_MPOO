package excepciones;

/**
 * Se lanza cuando el monto es igual o menor a cero (o no es un número válido).
 * Es una excepción verificada (hereda de Exception), por lo que el compilador
 * obliga a capturarla o a declararla con throws.
 */
public class MontoInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
