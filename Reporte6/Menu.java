import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Instancias de tus clases
        TablaDeMultiplicar t = new TablaDeMultiplicar();
        NumerosPrimos n = new NumerosPrimos();
        ATM a = new ATM();

        int opcion;

        do {            
            System.out.println("\n============================");
            System.out.println("       MENÚ PRINCIPAL       ");
            System.out.println("============================");
            System.out.println("1. Tabla de multiplicar");
            System.out.println("2. Mostrar Números Primos");
            System.out.println("3. Simulador ATM (Cajero)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("\n¿De qué número quieres la tabla de multiplicar?: ");
                    int num = teclado.nextInt();                        
                    System.out.print("¿Hasta qué número quieres multiplicar?: ");
                    int tamTabla = teclado.nextInt();                        
                    
                    int[] tabla = t.Multiplicar(num, tamTabla); 
                    System.out.println("\n--- Resultado Tabla del " + num + " ---");
                    for (int i = 0; i < tabla.length; i++) {
                        System.out.println(num + " x " + (i + 1) + " = " + tabla[i]);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Números Primos (del 2 al 10) ---");
                    n.verificacion();
                    System.out.println(); // Salto de línea al finalizar
                    break;

                case 3:
                    // Submenú para el cajero automático
                    int opcionAtm;
                    do {
                        System.out.println("\n--- MENÚ CAJERO ATM ---");
                        System.out.println("1. Depositar dinero");
                        System.out.println("2. Retirar dinero");
                        System.out.println("3. Consultar saldo");
                        System.out.println("4. Regresar al menú principal");
                        System.out.print("Elige una opción del ATM: ");
                        opcionAtm = teclado.nextInt();

                        switch (opcionAtm) {
                            case 1:
                                System.out.print("Ingresa la cantidad a depositar: $");
                                float deposito = teclado.nextFloat();
                                a.Depositos(deposito);
                                System.out.println("¡Depósito realizado con éxito!");
                                break;
                            case 2:
                                System.out.print("Ingresa la cantidad a retirar: $");
                                float retiro = teclado.nextFloat();
                                if (a.Retiros(retiro)) {
                                    System.out.println("¡Retiro exitoso!");
                                } else {
                                    System.out.println("Fondos insuficientes o saldo en cero.");
                                }
                                break;
                            case 3:
                                System.out.println("Tu saldo actual es: $" + a.ConsultaSal());
                                break;
                            case 4:
                                System.out.println("Regresando al menú principal...");
                                break;
                            default:
                                System.out.println("Opción de ATM inválida.");
                        }
                    } while (opcionAtm != 4);
                    break;

                case 4:
                    System.out.println("¡Gracias por usar el sistema! Saliendo...");
                    break;

                default: 
                    System.out.println("Opción no válida. Por favor, elige un número entre 1 y 4.");
            }            

        } while (opcion != 4);

        teclado.close();
    }
}