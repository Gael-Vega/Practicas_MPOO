public class Dron {
    private String modelo;
    private int bateria;
    private float altura;

    public Dron(String modelo, int bateria, float altura) {
        this.modelo = modelo;
        setBateria(bateria);
        setAltura(altura);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        if (bateria < 0) bateria = 0;
        if (bateria > 100) bateria = 100;
        this.bateria = bateria;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura < 0) altura = 0;
        this.altura = altura;
    }

    private boolean verificarBateria() {
        return this.bateria >= 20;
    }

    public String despegar() {
        if (verificarBateria()) {
            return "Despegando...";
        } else {
            return "No despegada: menos de 20% de batería.";
        }
    }
}
