/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import Clases.*;
import org.graphstream.graph.*;
import com.google.gson.*;
import java.util.Set;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author esteacosta Esta clase es la que lee y convierte los archivos JSON a
 * listas, además de crear el grafo
 */
public class Inicializar {

    //Se crea una lista temporal donde se guardarán las conexiones entre líneas
    Grafo conexiones;
    Grafo lineas_metro;
    String anterior;
    Graph grafo;
    Parada paradaAnterior;

    public Inicializar() {
        conexiones = new Grafo();
        lineas_metro = new Grafo();
    }

    /**
     * Esta funcion convierte el string en un objeto iterable, del cual se
     * obtienen las respectivas llaves y valores para crear listas que
     * coresponden a cada línea. También se crean los nodos del grafo.
     *
     * @param nombre
     * @return
     */
    public Nodo Buscar_Conexion(String nombre) {
        Nodo2 aux;
        Nodo parada = null;
        
        //Busca si la conexion existe
        if (!this.conexiones.esVacia()) {
            boolean encontrado = false;
            aux = this.conexiones.primero();
            while (aux != null & !encontrado) {
                Nodo nParada = aux.getData();
                String Parada = nParada.Parada().Nombre();
                if (Parada.equals(nombre)) {
                    parada = nParada;
                    encontrado = true;
                } else {
                    aux = aux.getpNext();
                }
            }
        }
        return parada;
    }
    
    //Conecta dos paradas
    public void Conectar_Paradas(Nodo p1, Nodo p2, boolean existe) {
        p1.setpInterseccion(p2);
        p2.setpInterseccion(p1);
        p1.cambiarInterseccion();
        p2.cambiarInterseccion();
        if (!existe) {
            //Si no están hechas las paradas en GraphStream, las conecta.
            Node nodo = grafo.addNode(p1.Parada().Nombre());
            nodo.setAttribute("ui.label", p1.Parada().Nombre());
            Node nodo2 = grafo.addNode(p2.Parada().Nombre());
            nodo2.setAttribute("ui.label", p2.Parada().Nombre());
            Edge borde = grafo.addEdge(p1.Parada().Nombre() + p2.Parada().Nombre(), p1.Parada().Nombre(), p2.Parada().Nombre());
        }

    }

    public Graph retornar_grafo() {
        return grafo;
    }

    public void añadir_borde(String ant, String act) {
        //Crea borde en GraphStream
        if (grafo.getEdge(ant + act) == null) {
            grafo.addEdge(ant + act, ant, act);
        }
    }

    public Grafo Iniciar(String jsonString) {

        Nodo2 line_metro;
        this.conexiones.vaciar();
        this.lineas_metro.vaciar();

        //Se utiliza la libreria Gson
        Gson gson = new Gson();

        //Se transforma el String en un objeto iterable
        JsonElement json = gson.fromJson(jsonString, JsonElement.class);
        JsonObject iterable = json.getAsJsonObject();

        //Se hace una lista de llaves
        Set<String> llaves = iterable.keySet();

        //Se itera a través de la lista de llaves
        for (String llave : llaves) {
            // Se crea  la lista lineas con el nombre de la red de metro
            Lista lineas = new Lista(llave);
            
            //Se establece un grafo vacío.
            System.setProperty("org.graphstream.ui", "swing");
            grafo = new MultiGraph(llave);
            this.anterior = null;
            this.paradaAnterior = null;
            
            JsonElement l_lineas = iterable.get(llave);
            JsonArray lista_lineas = l_lineas.getAsJsonArray();
            
            //Recorre las lineas
            for (int i = 0; i < lista_lineas.size(); i++) {
                JsonObject line = lista_lineas.get(i).getAsJsonObject();

                Set<String> llaves2 = line.keySet();
                
                for (String key : llaves2) {

                    String linea = key;
                    Lista Llinea = new Lista(key);

                    JsonElement l_paradas = line.get(key);
                    JsonArray lista_paradas = l_paradas.getAsJsonArray();
                    
                    //Recorre las paradas
                    for (int j = 0; j < lista_paradas.size(); j++) {
                        Nodo nParada = null;
                        if (lista_paradas.get(j).isJsonObject()) {

                            JsonObject Interseccion = lista_paradas.get(j).getAsJsonObject();
                            Set<String> paradas2 = Interseccion.keySet();
                            
                            //Si la parada tiene conexión
                            for (String parada1 : paradas2) {
                                Nodo connect = Buscar_Conexion(parada1);
                                if (connect != null) {
                                    nParada = connect;
                                    if (connect.getpNext() == null & connect.getpPrev() == null) {
                                        Llinea.agregar(connect);
                                        connect.Parada().CambiarLinea(linea);
                                    }
                                    
                                } else {
                                    Nodo connect2 = Buscar_Conexion(Interseccion.get(parada1).getAsString());
                                    if (connect2 != null) {

                                        //Crea la parada 1 y el nodo que la contiene
                                        Parada parada = new Parada(parada1, linea);
                                        nParada = new Nodo(parada);

                                        this.Conectar_Paradas(nParada, connect2, true);
                                        connect2.Parada().CambiarLinea(linea);

                                        Llinea.agregar(nParada);

                                    } else {
                                        //Crea la parada 1 y el nodo que la contiene
                                        Parada parada = new Parada(parada1, linea);
                                        nParada = new Nodo(parada);

                                        Llinea.agregar(nParada);
                                        // Agrega los nodos a lineas en caso de ser la primera linea
                                        if (i == 0) {
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

                                        this.Conectar_Paradas(nParada, nParada2, false);
                                    }
                                }
                            }
                            //Cuando no está conectada la parada
                            if (nParada != null && nParada.Parada() != null) {
                                Nodo2 paradaExistente = this.lineas_metro.BuscarParada(nParada.Parada().Nombre());
                            if (paradaExistente != null) {
                                nParada = paradaExistente.getData();
                            }
                            
                                String nombreP2 = Interseccion.get(nParada.Parada().Nombre()).getAsString();
                                Parada parada2 = new Parada(nombreP2, "");
                                Nodo nParada2 = new Nodo(parada2);
                                nParada.Parada().AgregarConexion(parada2);
                                parada2.AgregarConexion(nParada.Parada());
                                line_metro = new Nodo2(nParada2);
                                this.lineas_metro.agregar(line_metro);
                            }
                            
                            //Si es la primera parada de la línea
                            if (j == 0) {
                                line_metro = new Nodo2(nParada);
                                this.lineas_metro.agregar(line_metro);
                                anterior = nParada.Parada().Nombre();
                                paradaAnterior = nParada.Parada();

                            } else {
                                String actual = nParada.Parada().Nombre();
                                nParada.Parada().AgregarConexion(paradaAnterior);
                                if (paradaAnterior != null) {
                                    paradaAnterior.AgregarConexion(nParada.Parada());
                                }
                                line_metro = new Nodo2(nParada);

                                this.lineas_metro.agregar(line_metro);
                                Edge borde = grafo.addEdge(anterior + actual, anterior, actual);
                                anterior = actual;
                                paradaAnterior = nParada.Parada();
                            }
                        } else {
                            //Convierte el JsonElement a String
                            JsonPrimitive e_parada = lista_paradas.get(j).getAsJsonPrimitive();
                            String nombre_parada = e_parada.getAsString();

                            Nodo2 paradaExistente = this.lineas_metro.BuscarParada(nombre_parada);
                            //Crea el objeto parada y el Nodo que la contendrá
                            Parada parada = new Parada(nombre_parada, linea);
                            nParada = new Nodo(parada);
                            if (paradaExistente != null) {
                                parada = paradaExistente.getData().Parada();
                                nParada = paradaExistente.getData();
                            }
                            //Agrega el nodo a la línea actual
                            Llinea.agregar(nParada);

                            // Agrega los nodos a lineas en caso de ser la primera linea
                            if (i == 0) {
                                lineas.agregar(nParada);
                            }

                            if (j == 0) {

                                line_metro = new Nodo2(nParada);
                                this.lineas_metro.agregar(line_metro);
                                anterior = nParada.Parada().Nombre();
                                paradaAnterior = nParada.Parada();
                                if (grafo.getNode(anterior) == null) {
                                    Node nodo = grafo.addNode(anterior);
                                    nodo.setAttribute("ui.label", anterior);
                                }
                            } else {

                                String actual = nParada.Parada().Nombre();
                                nParada.Parada().AgregarConexion(paradaAnterior);
                                if (paradaAnterior != null) {
                                    paradaAnterior.AgregarConexion(nParada.Parada());
                                }
                                line_metro = new Nodo2(nParada);

                                this.lineas_metro.agregar(line_metro);
                                if (grafo.getNode(actual) == null) {
                                    Node nodo = grafo.addNode(actual);
                                    nodo.setAttribute("ui.label", actual);
                                    Edge borde = grafo.addEdge(anterior + actual, anterior, actual);
                                } else {
                                    this.añadir_borde(anterior, actual);
                                }
                                anterior = actual;
                                paradaAnterior = nParada.Parada();

                            }
                        }
                    }
                }
            }
        }
        return lineas_metro;
    }
}
