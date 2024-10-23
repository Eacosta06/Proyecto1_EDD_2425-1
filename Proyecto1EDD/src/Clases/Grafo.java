/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author carluchocp
 */
public class Grafo {
    String Nombre;
    int T;
    Lista Nodos;

    public Grafo(String Nombre, int T, Lista Nodos) {
        this.Nombre = Nombre;
        this.T = T;
        this.Nodos = Nodos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
    }

    public Lista getNodos() {
        return Nodos;
    }

    public void setNodos(Lista Nodos) {
        this.Nodos = Nodos;
    }
    
    
}
