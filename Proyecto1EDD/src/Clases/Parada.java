/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esteacosta y carluchocp
 * Clase Parada
 */
public class Parada {
    String Nombre;
    String Linea;
    Lista ParadasVecinas;
    boolean Sucursal;

    public Parada(String Nombre, String linea) {
        this.Nombre = Nombre;
        this.Sucursal = false;
        this.ParadasVecinas = new Lista();
        this.Linea = linea;
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
    
    /**
    *
    * @author carluchocp
    * getters and setters
    */

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public Lista getParadasVecinas() {
        return ParadasVecinas;
    }

    public void setParadasVecinas(Lista ParadasVecinas) {
        this.ParadasVecinas = ParadasVecinas;
    }

    public boolean isSucursal() {
        return Sucursal;
    }

    public void setSucursal(boolean Sucursal) {
        this.Sucursal = Sucursal;
    } 
    
}
