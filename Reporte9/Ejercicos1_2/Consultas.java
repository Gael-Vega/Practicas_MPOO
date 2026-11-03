import java.util.Scanner;

public class Consultas {
    Scanner sc = new Scanner(System.in);
    String respuestas;
    int respuestas1;
    double respuestas2;

    public String preguntarNombre(){
        System.out.print("Indique el nombre del estudiante\nRespuesta: ");
        respuestas = sc.nextLine();
        return respuestas;
    }

}