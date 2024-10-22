/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esteacosta
 * Esta clase Nodo se crea para poder almacenar
 * los pFirst de cada línea de metro.
 */
public class Nodo2 {
    private Nodo pNext;
    private Nodo data;

    public Nodo2(Nodo data) {
        this.data = data;
        this.pNext = null;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public Nodo getData() {
        return data;
    }

    public void setData(Nodo data) {
        this.data = data;
    }
    
    public Nodo leer() {
        return this.data;
    }
    
    
}
