/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esteacosta
 * Clase Parada
 */
public class Parada {
    String Nombre;
    boolean Sucursal;

    public Parada(String Nombre) {
        this.Nombre = Nombre;
        this.Sucursal = false;
    }
    
    // Convierte Sucursal a True
    public void agregarSucursal(){
        this.Sucursal = true;
    }
    
    // Convierte Sucursal a False
    public void quitarSucursal(){
        this.Sucursal = false;
    }
    
    //Retorna el Nombre de la parada
    public String Nombre(){
        return Nombre;
    }
    
    // Retorna el valor de Sucursal
    public boolean Sucursal(){
        return Sucursal;
    }
    
    
}
