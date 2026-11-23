package historial;

import operaciones.Operacion;

import java.util.ArrayList;

/**
 * Almacena y muestra las operaciones exitosas de una cuenta.
 * Guarda referencias de tipo Operacion: puede contener depósitos, retiros y
 * transferencias a la vez (polimorfismo).
 */
public class Historial {

    private final ArrayList<Operacion> operaciones;

    public Historial() {
        this.operaciones = new ArrayList<>();
    }

    public void agregarOperacion(Operacion operacion) {
        if (operacion != null) {
            operaciones.add(operacion);
        }
    }

    /** Devuelve una copia para que nadie pueda alterar el historial desde fuera. */
    public ArrayList<Operacion> consultarHistorial() {
        return new ArrayList<>(operaciones);
    }

    public void mostrarHistorial() {
        if (operaciones.isEmpty()) {
            System.out.println("La cuenta aún no tiene movimientos.");
            return;
        }
        for (Operacion operacion : operaciones) {
            System.out.println(operacion); // toString() polimórfico
        }
    }
}
