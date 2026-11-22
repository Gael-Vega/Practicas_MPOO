/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.pkg12.Saldo;

/**
 *
 * @author gaelv
 */
public class Sueldo {
    private double monto;
    
    public Sueldo(double monto){
        setSueldo(monto);
    }
    
    public void setSueldo(double monto){
        if (monto < 0) throw new IllegalArgumentException("El saldo no puede ser negativo");
        System.out.println("\nAprovado");
        this.monto = monto;
    }
    
    public double getMonto(){
        return monto;
    }
}
