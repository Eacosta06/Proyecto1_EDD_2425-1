/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author maria
 */

//Redes la usamos para almacenar y calcular la cobertura de una sucursal con el parametro t determinado
public class Redes {
    private List<Parada> paradas;
    
    public Redes() {
        paradas = new ArrayList<>();
    }
    public void nuevaParada (Parada parada) {
        paradas.add(parada);
    }
    public List<Parada> getParadas() {  
        return paradas; 
    }
    public List<Parada> obtenerCobertura(Parada sucursal, int t) {  
        Set<Parada> cubiertas = new HashSet<>();  
        Queue<Parada> queue = new LinkedList<>();  
        Set<Parada> visitados = new HashSet<>();  
        
        queue.offer(sucursal);  
        visitados.add(sucursal);  

        for (int i = 0; i < t && !queue.isEmpty(); i++) {  
            int size = queue.size();  
            for (int j = 0; j < size; j++) {  
                Parada actual = queue.poll();  
                cubiertas.add(actual);  

                for (Parada conexion : actual.getConexiones()) {  
                    if (!visitados.contains(conexion)) {  
                        visitados.add(conexion);  
                        queue.offer(conexion);  
                    }  
                }  
            }  
        }
        return new ArrayList<>(cubiertas);
    }
}