/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import Clases.*;
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
    //Se crea una lista temporal donde se guardarán las conexiones entre líneas
    Lista2 conexiones;
    Lista2 lineas_metro;

    public Inicializar() {
        conexiones = new Lista2();
        lineas_metro = new Lista2();
    }
    
    /**
     * Esta funcion convierte el string en un objeto iterable, del cual
     * se obtienen las respectivas llaves y valores para crear listas que
     * coresponden a cada línea. También se crean los nodos del grafo.
     */
    
    public Nodo Buscar_Conexion(String nombre){
        Nodo2 aux;
        Nodo parada= null;
        if (!this.conexiones.esVacia()){
            boolean encontrado = false;
            aux = this.conexiones.primero();
            while (aux != null & !encontrado){
                Nodo nParada = aux.getData();
                String Parada = nParada.Parada().Nombre();
                if (Parada.equals(nombre)){
                    parada = nParada;
                    encontrado = true;
                } else {
                    aux = aux.getpNext();
                }
            }
        }
        return parada;
    }
    
    public void Conectar_Paradas(Nodo p1, Nodo p2){
        p1.setpInterseccion(p2);
        p2.setpInterseccion(p1);
        p1.cambiarInterseccion();
        p2.cambiarInterseccion();
    }
    
    public Lista2 Iniciar(String jsonString, Graph grafo){
        
        Nodo2 line_metro;
        
        //Se utiliza la libreria Gson
        Gson gson = new Gson();
        
        //Se transforma el String en un objeto iterable
        JsonElement json = gson.fromJson(jsonString, JsonElement.class);
        JsonObject iterable = json.getAsJsonObject();
        
        //Se hace una lista de llaves
        Set<String> llaves = iterable.keySet();
        
        //Se itera a través de la lista de llaves
        for (String llave : llaves){
            // Se crea  la lista lineas con el nombre de la red de metro
            Lista lineas = new Lista(llave);
            
            JsonElement l_lineas = iterable.get(llave);
            JsonArray lista_lineas = l_lineas.getAsJsonArray();
            
            for (int i = 0; i < lista_lineas.size(); i++){
                JsonObject line = lista_lineas.get(i).getAsJsonObject();
                
                Set<String> llaves2 = line.keySet();
                
                for (String key : llaves2){
                    
                    String linea = key;
                    Lista Llinea = new Lista(key);
                    
                    JsonElement l_paradas = line.get(key);
                    JsonArray lista_paradas = l_paradas.getAsJsonArray();
                    
                    for (int j = 0; j < lista_paradas.size(); j++){
                        Nodo nParada = null;
                        if (lista_paradas.get(j).isJsonObject()){
                            
                            JsonObject Interseccion = lista_paradas.get(j).getAsJsonObject();
                            Set<String> paradas2 = Interseccion.keySet();
                            
                            for (String parada1 : paradas2){
                                Nodo connect = Buscar_Conexion(parada1);
                                if (connect != null){
                                    
                                    if (connect.getpNext() == null & connect.getpPrev() == null) {
                                        Llinea.agregar(connect);
                                        connect.Parada().CambiarLinea(linea);
                                        nParada = connect;
                                    } else {
                                        Llinea.agregar(connect);
                                        connect.Parada().CambiarLinea(linea);
                                    }
                                    
                                    
                                } else {
                                    Nodo connect2 = Buscar_Conexion(Interseccion.get(parada1).getAsString());
                                    if (connect2 != null){
                                        
                                        //Crea la parada 1 y el nodo que la contiene
                                        Parada parada = new Parada(parada1, linea);
                                        nParada = new Nodo(parada);
                                        
                                        this.Conectar_Paradas(nParada, connect2);
                                        connect2.Parada().CambiarLinea(linea);
                                        
                                        Llinea.agregar(nParada);
                                        
                                    } else {
                                        //Crea la parada 1 y el nodo que la contiene
                                        Parada parada = new Parada(parada1, linea);
                                        nParada = new Nodo(parada);

                                        Llinea.agregar(nParada);
                                        // Agrega los nodos a lineas en caso de ser la primera linea
                                        if (i == 0){
                                            lineas.agregar(nParada);
                                        }
                                    
                                        //Obtiene el nombre en String de la segunda parada
                                        String nombreP2 = Interseccion.get(parada1).getAsString();
                                        //Crea la parada 2 y el nodo que la contiene
                                        Parada parada2 = new Parada(nombreP2, linea);
                                        Nodo nParada2 = new Nodo(parada2);
                                        //Crea un Nodo2 que contendrá temporalmente al Nodo nParada2
                                        Nodo2 PConectada = new Nodo2(nParada2);

                                        //Agrega el Nodo2 a la lista de conexiones
                                        this.conexiones.agregar(PConectada);

                                        this.Conectar_Paradas(nParada, nParada2);
                                    }
                                    
                                    
                                }
                            }
                            
                        } else {
                            //Convierte el JsonElement a String
                            JsonPrimitive e_parada = lista_paradas.get(j).getAsJsonPrimitive();
                            String nombre_parada = e_parada.getAsString();
                            
                            //Crea el objeto parada y el Nodo que la contendrá
                            Parada parada = new Parada(nombre_parada, linea);
                            nParada = new Nodo(parada);
                            
                            //Agrega el nodo a la línea actual
                            Llinea.agregar(nParada);
                            
                            // Agrega los nodos a lineas en caso de ser la primera linea
                            if (i == 0){
                                lineas.agregar(nParada);
                            }
                        }
                        
                        if (j ==0 ){
                            line_metro = new Nodo2(nParada);
                            this.lineas_metro.agregar(line_metro);
                        }
                    }
                    
                }
                 
            }
            
        }
        return lineas_metro;
    }
}
