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
    private int iN;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.iN = 0;
    }

    public Nodo Primero() {
        return pFirst;
    }

    public Nodo ultimo() {
        return pLast;
    }

    public int tamaño() {
        return iN;
    }
    
    public boolean esVacia(){
        return pFirst==null;
    }
    
    public void agregar(Nodo nuevo){
        if (!esVacia()){
            pLast.setpNext(nuevo);
            nuevo.setpPrev(pLast);
            pLast = nuevo;
        } else {
            pFirst = pLast = nuevo;
        }
        iN++;
    }
    
    public void Eliminar(Nodo nodo){
        if (!esVacia()){
            
        }
    }
    
    /**
    *
    * @author carluchocp
    * getters and setters
    */
    
    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getiN() {
        return iN;
    }

    public void setiN(int iN) {
        this.iN = iN;
    }
    
}
