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
    private String Nombre;
    private String Linea;
    private Grafo conexiones;
    private boolean Sucursal;

    public Parada(String Nombre, String Linea) {
        this.Nombre = Nombre;
        this.Linea = Linea;
        this.conexiones = new Grafo();
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
    
    public void CambiarLinea(String line){
        this.Linea = line;
    }
    
    //Retorna el Nombre de la parada
    public String Nombre(){
        return Nombre;
    }
    
    public String Linea(){
        return Linea;
    }
    
    // Retorna el valor de Sucursal
    public boolean Sucursal(){
        return Sucursal;
    }
    public void AgregarConexion(Parada parada){
        Nodo nuevo = new Nodo(parada);
        Nodo2 nuevo2 = new Nodo2(nuevo);
        this.conexiones.agregar(nuevo2);
        
    }

    public Grafo getConexiones() {
        return conexiones;
    }

    public void setConexiones(Grafo conexiones) {
        this.conexiones = conexiones;
    }
    
}
