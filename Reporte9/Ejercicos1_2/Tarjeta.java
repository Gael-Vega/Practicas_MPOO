import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Tarjeta {
    private String titular;
    private String nip;
    private String numero;
    private LocalDate fechaDeExpedicion;
    private LocalDate fechaDeExpiracion;
    private String cvv;
    private boolean contactless;
    private double saldo;

    public Tarjeta (String titular, String nip, boolean contactless, double saldo ){
        setTitular(titular);
        setNip(nip);
        setNumero();
        fechaDeExpedicion = LocalDate.now();
        setFechaDeExpiracion();
        setCvv();
        this.contactless = contactless;
        setSaldo(saldo);
    }

    private void setFechaDeExpiracion(){
        this.fechaDeExpiracion = fechaDeExpedicion.plusYears(5);  
    }

    private void setNip(String nip){
        if (nip == null || nip.length() != 4 || !nip.matches("\\d{4}")) throw new IllegalArgumentException("NIP invalido");
        this.nip = nip;
    }

    private void setTitular(String titular){
        if (titular == null || titular.isBlank()) titular = "JOAQUIN PEREZ";
        this.titular = titular;
    }

    private void setSaldo(double saldo){
        if (saldo < 0) saldo = 0;
        this.saldo = saldo;
    }

    private void setNumero(){
        long minimo = 1_000_000_000_000_000L; 
        long maximo = 9_999_999_999_999_999L; 

        long numeroLong = ThreadLocalRandom.current().nextLong(minimo, maximo + 1);

        String numeroEnTexto = String.valueOf(numeroLong);

        this.numero = numeroEnTexto;
    }

    private void setCvv(){
        long minimo = 100L; 
        long maximo = 999L; 

        long numeroLong = ThreadLocalRandom.current().nextLong(minimo, maximo + 1);

        String cvvEnTexto = String.valueOf(numeroLong);

        this.cvv = cvvEnTexto;
    }

    public String getTitular(){
        return titular;
    }

    public String getNip () {
        return nip;
    }

    public String getNumero () {
        return numero;
    }

    public LocalDate getFechaDeExpedicion (){
        return fechaDeExpedicion;
    }

    public LocalDate getFechaDeExpiracion () {
        return fechaDeExpiracion;
    }

    public String getCvv () {
        return cvv;
    }

    public boolean getContactless () {
        return contactless;
    }

    public double getSaldo () {
        return saldo;
    } 

    public String toString() {
        return "\nTitular: " + titular + "\nNumero de tarjeta: " + numero + "\nNIP: " + nip + "\nFecha de expedicion: " + fechaDeExpedicion + "\nFecha de expiracion: " + fechaDeExpiracion + "\nCvv: " + cvv + "\nContactless: " + contactless + "\nSaldo: " + saldo;
    }
}