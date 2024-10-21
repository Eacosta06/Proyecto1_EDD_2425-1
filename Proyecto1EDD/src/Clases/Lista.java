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
/**
 *
 * @author Carlo Carpentieri
 * @param <T> 
 */
public class Lista <T> {
    private Nodo <T> pFirst;
    
    /**
    * Constructor para la clase lista, decimos que la variable pFirst de tipo apuntador inicia apuntando a null
    * @author Carlo Carpentieri
    * @param <T> Es un parametro de tipo genérico, sirve para crear clases, interfaces y métodos
    */
    public Lista(Nodo<T> pFirst) {
        this.pFirst = null;
    }
    
    /**
    * Metodo para indicar si esta vacio o no
    * @author Carlo Carpentieri
    */
    public boolean esVacio(){
    return pFirst==null;
    }
    
    /**
    * Metodo para insertar un nuevo nodo en la lista
    * @author Carlo Carpentieri
    * @param x es el dato de tipo generico a insertar, y pValor es de tipo apuntador
    */
    public void insertar(T x, Nodo <T> pValor){
    Nodo <T> pNew=new Nodo <>(x);
    if (esVacio()){
         pFirst=pNew;
        }else{
        pNew.pnext=pValor.pnext;
        pValor.pnext=pNew;
        }
    }
}
