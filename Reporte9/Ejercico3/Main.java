public class Main {


public static void main(String[] args) {

    System.out.println("=== PRUEBAS DEL SISTEMA DE ESTUDIANTES ===");

    // 1. Crear estudiante
    Estudiante estudiante1 = new Estudiante(
        8.5, 20, 250, "Carlos", false, 0, 4
    );

    System.out.println("\n=== DATOS INICIALES ===");

    System.out.println("Nombre: " + estudiante1.getNombre());
    System.out.println("Edad: " + estudiante1.getEdad());
    System.out.println("Promedio: " + estudiante1.getPromedio());
    System.out.println("Creditos: " + estudiante1.getCreditos());
    System.out.println("Adeudos: " + estudiante1.getAdeudos());
    System.out.println("Saldo pendiente: " + estudiante1.getSaldoSinPagar());
    System.out.println("Semestre: " + estudiante1.getSemestre());
    System.out.println("Numero de cuenta: " + estudiante1.getNumeroDeCuenta());

    // 2. Modificar atributos
    System.out.println("\n=== MODIFICACION DE DATOS ===");

    estudiante1.setNombre("Carlos Alberto");
    estudiante1.setPromedio(9.5);
    estudiante1.setEdad(21);
    estudiante1.setCreditos(280);
    estudiante1.setSaldoSinPagar(true, 500);
    estudiante1.setSemestre(5);

    System.out.println("Nombre actualizado: " + estudiante1.getNombre());
    System.out.println("Promedio actualizado: " + estudiante1.getPromedio());
    System.out.println("Edad actualizada: " + estudiante1.getEdad());
    System.out.println("Creditos actualizados: " + estudiante1.getCreditos());
    System.out.println("Saldo actualizado: " + estudiante1.getSaldoSinPagar());
    System.out.println("Semestre actualizado: " + estudiante1.getSemestre());

    // 3. Crear sistema y agregar estudiantes
    System.out.println("\n=== REGISTRO DE ESTUDIANTES ===");

    SistemaGestionEstudiantes sistema = new SistemaGestionEstudiantes();

    Estudiante estudiante2 = new Estudiante(
        7.8, 22, 200, "Andrea", true, 1200, 6
    );

    Estudiante estudiante3 = new Estudiante(
        9.0, 19, 150, "Miguel", false, 0, 2
    );

    sistema.agregarEstudiante(estudiante1);
    sistema.agregarEstudiante(estudiante2);
    sistema.agregarEstudiante(estudiante3);

    sistema.mostrarEstudiantes();

    // 4. Buscar estudiante
    System.out.println("\n=== BUSQUEDA DE ESTUDIANTE ===");

    Estudiante encontrado = sistema.buscarEstudiante(
        estudiante2.getNumeroDeCuenta()
    );

    if (encontrado != null) {
        System.out.println("Estudiante encontrado: " + encontrado.getNombre());
        System.out.println("Numero de cuenta: " + encontrado.getNumeroDeCuenta());
        System.out.println("Promedio: " + encontrado.getPromedio());
    } else {
        System.out.println("Estudiante no encontrado.");
    }

    // 5. Actualizar promedio desde el sistema
    System.out.println("\n=== ACTUALIZACION DESDE EL SISTEMA ===");

    sistema.actualizarPromedio(
        estudiante2.getNumeroDeCuenta(), 9.8
    );

    System.out.println("Nuevo promedio de Andrea: " + encontrado.getPromedio());

    // 6. Mostrar registro final
    System.out.println("\n=== REGISTRO FINAL ===");

    sistema.mostrarEstudiantes();

    System.out.println("\n=== FIN DE LAS PRUEBAS ===");
}

}
