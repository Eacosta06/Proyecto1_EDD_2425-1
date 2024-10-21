/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esteacosta
 * Clase lista que se utiliza para crear las líneas
 */
public class Lista {
    private Nodo pFirst;
    private Nodo pLast;
    private int tamaño;
    private String nombre;

    public Lista(String nombre) {
        this.pFirst = null;
        this.pLast = null;
        this.tamaño = 0;
        this.nombre = nombre;
    }

    public Nodo Primero() {
        return pFirst;
    }

    public Nodo ultimo() {
        return pLast;
    }

    public int tamaño() {
        return tamaño;
    }
    
    public void agregar(Nodo nuevo){
        pLast.setpNext(nuevo);
        nuevo.setpPrev(pLast);
        pLast = nuevo;
    }
    
    
    
}
