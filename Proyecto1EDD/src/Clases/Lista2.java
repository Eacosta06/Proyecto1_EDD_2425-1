/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esteacosta
 */
public class Lista2 {
    private Nodo2 pFirst;

    public Lista2() {
        this.pFirst = null;
    }
    
    public Nodo2 primero(){
        return this.pFirst;
    }
    
    public Nodo2 ultimo(){
        Nodo2 aux;
        if (pFirst != null){
            aux = this.pFirst;
            while (aux.getpNext()!= null){
                aux = aux.getpNext();
            }
        } else {
            aux = null;
        }
        return aux;
    }
    
    public void agregar(Nodo2 nuevo){
        if (this.pFirst != null){
            this.ultimo().setpNext(nuevo);
        } else {
            this.pFirst = nuevo;
        }
    }
    
    public boolean esVacia(){
        return this.pFirst == null;
    }
    
    public void eliminar(Nodo conexion){
        Nodo2 aux;
        if (!this.esVacia()){
            aux = this.pFirst;
            if (aux.getData().Parada() == conexion.Parada()){
                this.pFirst = aux.getpNext();
                aux.setpNext(null);
            } else {
                while (aux != null & aux.getData().Parada() != conexion.Parada()){
                    aux = aux.getpNext();
                }
                Nodo2 encontrado = aux.getpNext();
                aux.setpNext(encontrado.getpNext());
                encontrado.setpNext(null);
            }
        }
    }
    
    public void vaciar(){
        this.pFirst = null;
    }
    
}
