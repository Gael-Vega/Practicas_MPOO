import java.util.concurrent.ThreadLocalRandom;

public class Estudiante {
    Consultas c = new Consultas();
    private double promedio;
    private int edad;
    private String nombre;
    private int creditos;
    private boolean adeudos;
    private double saldoSinPagar;
    private int semestre;
    private String numeroDeCuenta;

    public Estudiante(double promedio, int edad, int creditos, String nombre, boolean adeudos, double saldoSinPagar, int semestre){
        setNombre(nombre);
        setPromedio(promedio);
        setEdad(edad);
        setCreditos(creditos);
        this.adeudos = adeudos; 
        setSaldoSinPagar(adeudos, saldoSinPagar);
        setSemestre(semestre);
        setNumeroDeCuenta();
    }

    public void setNombre(String nombre){
        while (nombre == null || nombre.isBlank()){
            nombre = c.preguntarNombre();
        }
        this.nombre = nombre;
    }

    public void setPromedio(double promedio){
        if (promedio > 10 ) promedio = 10;
        if (promedio < 0) promedio = 0;
        this.promedio = promedio; 
    }

    public void setEdad(int edad){
        if (edad < 0) edad = 0;
        this.edad = edad; 
    }

    public void setCreditos(int creditos){
        if (creditos < 0) creditos = 0;
        this.creditos = creditos; 
    }

    public void setNumeroDeCuenta(){
        long minimo = 100_000_000L; 
        long maximo = 999_999_999L; 

        long numeroLong = ThreadLocalRandom.current().nextLong(minimo, maximo + 1);

        String numeroEnTexto = String.valueOf(numeroLong);

        this.numeroDeCuenta = numeroEnTexto;
    }

    public void setSaldoSinPagar(boolean adeudos, double saldoSinPagar){
        if (!adeudos || saldoSinPagar < 0) {
            this.saldoSinPagar = 0;
        } else {
            this.saldoSinPagar = saldoSinPagar;
        }
    }

    public void setSemestre(int semestre){
        if (semestre < 1) semestre = 1;
        this.semestre = semestre;
    }

    public double getPromedio(){
        return promedio;
    }

    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCreditos(){
        return creditos;
    }

    public boolean getAdeudos(){
        return adeudos;
    }

    public double getSaldoSinPagar(){
        return saldoSinPagar;
    }

    public int getSemestre(){
        return semestre;
    }

    public String getNumeroDeCuenta(){
        return numeroDeCuenta;
    }
}