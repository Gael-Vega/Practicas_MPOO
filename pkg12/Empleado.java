/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.pkg12;
import practica.pkg12.Saldo.Sueldo;
import practica.pkg12.Saldo.Puestos;
/**
 *
 * @author gaelv
 */
public class Empleado{
    private String nombre;
    private Sueldo sueldo;
    private Puestos puesto;
    
    public Empleado(String nombre, Sueldo sueldo, Puestos puesto){
        this.nombre = nombre;
        this.sueldo = sueldo;        
        this.puesto = puesto;
    }
    
    public boolean incremento(int porcentaje, Puestos da, Puestos recibe){
        boolean aprovado;
        aprovado = da.getNumero() >  recibe.getNumero() 
                && da.getNumero() != 1 && da.getNumero() != 2 && da.getNumero() != 3;
        if (aprovado){
            if (porcentaje < 0 || porcentaje >50){
                throw new IllegalArgumentException("No se puede aprobar ese incremento");                
            }
            sueldo.setSueldo(sueldo.getMonto()*(1+(porcentaje*0.01)));
            return true;
        }
        else{
            return false;
        }
    }
}
