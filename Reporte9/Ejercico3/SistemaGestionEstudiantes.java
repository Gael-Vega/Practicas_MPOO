import java.util.ArrayList;

public class SistemaGestionEstudiantes {
    private ArrayList<Estudiante> listaEstudiantes;

    public SistemaGestionEstudiantes() {
        this.listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            listaEstudiantes.add(estudiante);
        }
    }

    public void mostrarEstudiantes() {
        if (listaEstudiantes.isEmpty()) {
            return;
        }
        for (Estudiante e : listaEstudiantes) {
            System.out.println("Nombre: " + e.getNombre() + "\nCuenta: " + e.getNumeroDeCuenta() + "\nPromedio: " + e.getPromedio() + "\nSemestre: " + e.getSemestre());
        }
    }

    public Estudiante buscarEstudiante(String numeroDeCuenta) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getNumeroDeCuenta().equals(numeroDeCuenta)) {
                return e;
            }
        }
        return null;
    }

    public void actualizarPromedio(String numeroDeCuenta, double nuevoPromedio) {
        Estudiante e = buscarEstudiante(numeroDeCuenta);
        if (e != null) {
            e.setPromedio(nuevoPromedio);
        }
    }
}