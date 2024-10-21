/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esteacosta
 * 
 * Clase Nodo para los grafos
 */
public class Nodo {
    private Parada parada;
    private Nodo pNext;
    private Nodo pPrev;
    private Nodo pLNext;
    private Nodo pLPrev;
    private boolean Interseccion;

    public Nodo(Parada parada) {
        this.parada = parada;
        this.pNext = null;
        this.pPrev = null;
        this.pLNext = null;
        this.pLPrev = null;
        this.Interseccion = false;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public Nodo getpPrev() {
        return pPrev;
    }

    public void setpPrev(Nodo pPrev) {
        this.pPrev = pPrev;
    }

    public Nodo getpLNext() {
        return pLNext;
    }

    public void setpLNext(Nodo pLNext) {
        this.pLNext = pLNext;
    }

    public Nodo getpLPrev() {
        return pLPrev;
    }

    public void setpLPrev(Nodo pLPrev) {
        this.pLPrev = pLPrev;
    }
    
    public Parada Parada(){
        return this.parada;
    }
    
    public void cambiarInterseccion(){
        if (this.Interseccion) { 
            this.Interseccion = false;
        } else {
            this.Interseccion = true;
        }
    }
    
    public boolean Interseccion(){
        return this.Interseccion;
    }
    
    
}
