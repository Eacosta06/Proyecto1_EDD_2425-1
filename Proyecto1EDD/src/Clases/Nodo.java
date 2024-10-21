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
/**
 *
 * @author Carlo Carpentieri
 * @param <T> 
 */
public class Nodo <T> {
    protected T data;
    protected Nodo <T> pnext;

    /**
    * Constructor para la clase nodo
    * @author Carlo Carpentieri
    * @param <T> Es un parametro de tipo genérico, sirve para crear clases, interfaces y métodos
    */
    Nodo (T elem){
    data=elem;
    pnext=null;
    }
}
