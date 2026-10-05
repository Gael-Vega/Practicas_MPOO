import java.util.Scanner;
import java.time.LocalDate;

public class P5 {

	enum membresia {
		PLATA, ORO, DIAMANTE;
	}
		
	public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();

		Scanner read = new Scanner(System.in);
		P5_1 com = new P5_1();
            
        boolean cumpleaños = false;
		int d;
        String m = "plata";

        System.out.print("¿Qué mes es su cumpleaños?\nRespuesta: ");
        int mesCumpleaños = read.nextInt();
        read.nextLine();

        System.out.print("Que dia es su cumpleaños?\nRespuesta: ");
        int diaCumpleaños = read.nextInt();
        read.nextLine();

        if (diaCumpleaños == fechaActual.getDayOfMonth() && mesCumpleaños == fechaActual.getMonthValue()) {
            cumpleaños = true;
        }

        do{
			System.out.println("\n¿Qué día de la semana es hoy?\n1.Lunes\n2.Martes\n3.Miercoles");
            System.out.print("4.Jueves\n5.Viernes\n6.Sabado\n7.Domingo\nRespuesta: ");
			d = read.nextInt();
            read.nextLine();
            if (d<1 || d>7){
                System.out.println("\n"+d+" no es una opcion valida");
            }
        } while(d<1 || d>7);

        membresia mem = null;
        do {
			System.out.print("\n¿Qué membresia tiene?\nRespuesta:");
			m = read.nextLine();
            switch (m.toUpperCase()) {
                case "PLATA":
                    mem = membresia.PLATA;
                    break;
                case "ORO":
                    mem = membresia.ORO;
                    break;
                case "DIAMANTE":
                    mem = membresia.DIAMANTE;
                    break;
                default: 
                    m = "Membresía inválida";
                    System.out.println(m);           
            }
        }while(m.equals("Membresía inválida")); 

        float cuenta = com.mercancía();

        if (cumpleaños) {
            cuenta *= 0.5;
        }
        else{
            switch (mem){
                case PLATA:
                    cuenta *=.95;
                    break;
                case ORO:
                    cuenta *=.92;
                    break;
                case DIAMANTE:
                    cuenta *=.88;
                    break;
            }

            if (d==1 || d==4){
                cuenta *=.88;
            }
            else if(d==2 && (mem == membresia.ORO || mem == membresia.DIAMANTE)){
                cuenta *=.90;
            }
        }

        System.out.println("La cuenta total por la compra es: "+cuenta);

	}
}