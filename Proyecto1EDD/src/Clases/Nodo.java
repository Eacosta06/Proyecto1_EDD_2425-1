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
public class Nodo <T> {
    protected T data;
    protected Nodo <T> pnext;

    //Constructor
    Nodo (T elem){
    data=elem;
    pnext=null;
    }
}
