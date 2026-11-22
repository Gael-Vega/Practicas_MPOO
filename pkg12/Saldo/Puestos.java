/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practica.pkg12.Saldo;

/**
 *
 * @author gaelv
 */
public enum Puestos {
    PRACTICANTE(1),AUXILIAR(2), ANALISTA(3), SUPERVISOR(4), JEFE(5), DIRECTOR(6);
    
    private final int numero;
    
    Puestos(int numero) {
        this.numero = numero;
    }
    
    public int getNumero(){
        return numero;
    }
}
