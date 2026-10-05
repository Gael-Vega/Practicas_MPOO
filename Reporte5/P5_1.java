import java.util.Scanner;
public class P5_1 {

	public float mercancía() {
		Scanner read=new Scanner(System.in);
		float Sandia=20, Frijol=18, Leche=50, Galleta=25, Vino=100, precio=0;
		int ar;
		System.out.println("\n¿Qué desea comprar de los 5 artículos que tenemos?");
		System.out.println("| Opción  | Artículo| Precio  |");
		System.out.println("|    1    |  Sandía |   20$   |");
		System.out.println("|    2    |  Frijol |   18$   |");
		System.out.println("|    3    |  Leche  |   50$   |");
		System.out.println("|    4    | Galleta |   25$   |");
		System.out.println("|    5    |  Vino   |   100$  |");
		
		System.out.println("Ingrese -1 cuando termine de escojer sus productos");
		do {
			System.out.println("Seleccione una opción: ");
			ar=read.nextInt();
			switch(ar) {
			case 1:
					precio+=Sandia;
				break;
			case 2:
					precio+=Frijol;
				break;
			case 3:
					precio+=Leche;
				break;
			case 4:
					precio+=Galleta;
				break;
			case 5:
					precio+=Vino;
				break;
			case -1:
				System.out.println("Todos los artículos seleccionados");
				break;
			default:
				System.out.println("Opción inválida, ingrese otra");
				break;
			}
		}while(ar!=-1);
		return precio;
	}
}