/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import Clases.Lista;
import Clases.Nodo;
import Clases.Parada;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import com.google.gson.*;
import java.util.Set;
/**
 *
 * @author esteacosta
 * Esta clase es la que lee y convierte los archivos
 * JSON a listas, además de crear el grafo
 */
public class Inicializar {

    public Inicializar() {
    }
    
    /**
     * Esta funcion convierte el string en un objeto iterable, del cual
     * se obtienen las respectivas llaves y valores para crear listas que
     * coresponden a cada línea. También se crean los nodos del grafo.
     */
    public void Iniciar(String jsonString, Graph grafo, Lista lineas){
        
        //Se utiliza la libreria Gson
        Gson gson = new Gson();
        
        //Se transforma el String en un objeto iterable
        JsonElement json = gson.fromJson(jsonString, JsonElement.class);
        JsonObject iterable = json.getAsJsonObject();
        
        //
        Set<String> llaves = iterable.keySet();
        
        //
        Lista paradas = new Lista();
        for (String llave : llaves){
            // Se crea  la lista lineas con el nombre de la red de metro
            lineas = new Lista(llave);
            
            JsonElement l_lineas = iterable.get(llave);
            JsonArray lista_lineas = l_lineas.getAsJsonArray();
            
            for (int i = 0; i < lista_lineas.size(); i++){
                JsonObject line = lista_lineas.get(i).getAsJsonObject();
                
                Set<String> llaves2 = line.keySet();
                
                for (String key : llaves2){
                    
                    Lista linea = new Lista(key);
                    
                    JsonElement l_paradas = line.get(key);
                    JsonArray lista_paradas = l_paradas.getAsJsonArray();
                    
                    for (int j = 0; j < lista_paradas.size(); i++){
                        
                    }
                }
            }
        }

        /**
        *
        * @author carluchocp
        * si las paradas estan vacias agregar uno, y si no estan vacias crea uno y lo agrega con los demas
        * crear los nodos en el grafo sin intersecciones y duplicados. 
        */
//        if (paradas.esVacia()) {
//            Parada parada = new Parada("nombre", "linea");
//            paradas.agregar(new Nodo(parada)); 
//        } else {
//            Parada parada = new Parada("nombre", "linea");
//            paradas.getpLast().Parada().getParadasVecinas().agregar(new Nodo(parada));
//            parada.getParadasVecinas().agregar(paradas.getpLast());
//            paradas.agregar(new Nodo(parada));
//        }
    }
}
