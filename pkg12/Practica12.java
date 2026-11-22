/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica.pkg12;
import java.util.Scanner;
import practica.pkg12.Saldo.Sueldo;
import practica.pkg12.Saldo.Puestos;
/**
 *
 * @author gaelv
 */
public class Practica12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int respuesta = 2;

        do{
        System.out.print("1. Ejercicio 1\n2. Ejercicio 2\n3. Salir\nRespuesta: ");
        respuesta = sc.nextInt();
        switch (respuesta) {

            case 1:
                System.out.println("\n--- Pruebas de Sueldo ---");

                try {
                    Sueldo sueldo1 = new Sueldo(10000);
                    System.out.println("Sueldo: " + sueldo1.getMonto());

                    Sueldo sueldo2 = new Sueldo(-4000);
                    System.out.println("Sueldo: " + sueldo2.getMonto());

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }  
                System.out.println();
                break;
                
            case 2:
                System.out.println("\n--- Sistema de gestion de empleados ---");

                // Prueba 1: Incremento del 5%
                Sueldo sueldo1 = new Sueldo(10000);
                Empleado emp1 = new Empleado("Jose", sueldo1, Puestos.ANALISTA);

                System.out.println("\nPrueba 1: Incremento del 5%");
                System.out.println("Sueldo original: " + sueldo1.getMonto());

                boolean resultado1 = emp1.incremento(5, Puestos.SUPERVISOR, Puestos.ANALISTA);

                System.out.println("Aprobado: " + resultado1);
                System.out.println("Nuevo sueldo: " + sueldo1.getMonto());


                // Prueba 2: Incremento del 10%
                Sueldo sueldo2 = new Sueldo(10000);
                Empleado emp2 = new Empleado("Pedro", sueldo2, Puestos.ANALISTA);

                System.out.println("\nPrueba 2: Incremento del 10%");
                System.out.println("Sueldo original: " + sueldo2.getMonto());

                boolean resultado2 = emp2.incremento(10, Puestos.JEFE, Puestos.ANALISTA);

                System.out.println("Aprobado: " + resultado2);
                System.out.println("Nuevo sueldo: " + sueldo2.getMonto());


                // Prueba 3: Incremento del 15%
                Sueldo sueldo3 = new Sueldo(10000);
                Empleado emp3 = new Empleado("Luis", sueldo3, Puestos.ANALISTA);

                System.out.println("\nPrueba 3: Incremento del 15%");
                System.out.println("Sueldo original: " + sueldo3.getMonto());

                boolean resultado3 = emp3.incremento(15, Puestos.DIRECTOR, Puestos.ANALISTA);

                System.out.println("Aprobado: " + resultado3);
                System.out.println("Nuevo sueldo: " + sueldo3.getMonto());


                // Prueba 4: Incremento del 50%
                Sueldo sueldo4 = new Sueldo(10000);
                Empleado emp4 = new Empleado("Carlos", sueldo4, Puestos.ANALISTA);

                System.out.println("\nPrueba 4: Incremento del 50%");
                System.out.println("Sueldo original: " + sueldo4.getMonto());

                boolean resultado4 = emp4.incremento(50, Puestos.DIRECTOR, Puestos.ANALISTA);

                System.out.println("Aprobado: " + resultado4);
                System.out.println("Nuevo sueldo: " + sueldo4.getMonto());


                // Prueba 5: Incremento rechazado
                Sueldo sueldo5 = new Sueldo(10000);
                Empleado emp5 = new Empleado("Miguel", sueldo5, Puestos.AUXILIAR);

                System.out.println("\nPrueba 5: Incremento rechazado");
                System.out.println("Sueldo original: " + sueldo5.getMonto());

                boolean resultado5 = emp5.incremento(10, Puestos.ANALISTA, Puestos.AUXILIAR);

                System.out.println("Aprobado: " + resultado5);
                System.out.println("Nuevo sueldo: " + sueldo5.getMonto());


                // Prueba 6: Porcentaje inválido
                Sueldo sueldo6 = new Sueldo(10000);
                Empleado emp6 = new Empleado("Andres", sueldo6, Puestos.ANALISTA);

                System.out.println("\nPrueba 6: Incremento del 51%");
                System.out.println("Sueldo original: " + sueldo6.getMonto());

                try {
                    boolean resultado6 = emp6.incremento(51, Puestos.DIRECTOR, Puestos.ANALISTA);
                    System.out.println("Aprobado: " + resultado6);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                System.out.println("Nuevo sueldo: " + sueldo6.getMonto());
                System.out.println();
                break;
            case 3:
                System.out.println("Hasta luego");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        
        }while(respuesta !=3);
        sc.close();
    }
}