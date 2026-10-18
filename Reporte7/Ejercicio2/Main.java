public class Main {
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa("Misterios a la orden");

        float salarioMinimoBase = -300.0f;

        CEO ceo = new CEO("Fred", "Junta Directiva", "12 años de experiencia en dirección", 1, salarioMinimoBase, 1500000.0f, 25.5f,
            "Liderar la expansión global", 15.0f );

        Tecnico tecnico = new Tecnico("María Pérez", "Gerente de Operaciones", "5 años en soporte e infraestructura", 2, salarioMinimoBase, 
            "Redes y Ciberseguridad", "Certificación Cisco CCNA", 160, 5.0f );

        Vendedor vendedor = new Vendedor("Luis Gómez", "Director Comercial", "3 años en ventas", 3, salarioMinimoBase, 52, 0.10f, 25, 4.0f);

        miEmpresa.agregarEmpleado(ceo);
        miEmpresa.agregarEmpleado(tecnico);
        miEmpresa.agregarEmpleado(vendedor);

        miEmpresa.presentacion();
    }
}