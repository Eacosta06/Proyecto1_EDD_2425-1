/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author esteacosta
 */

public class Grafo {

    private Nodo2 pFirst;

    private int t;

    public Grafo() {
        this.pFirst = null;
    }

    public Nodo2 primero() {
        return this.pFirst;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public Nodo2 ultimo() {
        Nodo2 aux;
        if (pFirst != null) {
            aux = this.pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
        } else {
            aux = null;
        }
        return aux;
    }

    public void agregar(Nodo2 nuevo) {
        if (this.pFirst != null) {
            this.ultimo().setpNext(nuevo);
        } else {
            this.pFirst = nuevo;
        }
    }

    public boolean esVacia() {
        return this.pFirst == null;
    }

    public void eliminar(Nodo conexion) {
        Nodo2 aux;
        if (!this.esVacia()) {
            aux = this.pFirst;
            if (aux.getData().Parada() == conexion.Parada()) {
                this.pFirst = aux.getpNext();
                aux.setpNext(null);
            } else {
                while (aux != null & aux.getData().Parada() != conexion.Parada()) {
                    aux = aux.getpNext();
                }
                Nodo2 encontrado = aux.getpNext();
                aux.setpNext(encontrado.getpNext());
                encontrado.setpNext(null);
            }
        }
    }

    public void vaciar() {
        this.pFirst = null;
    }

    public void agregarLinea(String NuevaLinea, String nombreLinea) {
        try {
            String[] paradas = NuevaLinea.split("\n");
            Parada paradaAnterior = null;

            for (int i = 0; i < paradas.length; i++) {
                Parada Nuevaparada = new Parada(paradas[i], nombreLinea);
                Nodo nparada = new Nodo(Nuevaparada);
                this.agregar(new Nodo2(nparada));
                if (paradaAnterior != null) {
                    Nuevaparada.AgregarConexion(paradaAnterior);
                    paradaAnterior.AgregarConexion(Nuevaparada);
                }
                paradaAnterior = Nuevaparada;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el dato ingresado");
        }
    }

    private String CoberturaSucursalProfundidad(Nodo2 aux, String resultado, int profundidad) {
        if (aux != null && profundidad <= this.t) {  // Verifica si el nodo actual no es nulo y si la profundidad es menor o igual a t  
            resultado += "\n" + aux.getData().Parada().Nombre(); // Añade el nombre de la parada actual al resultado  
            aux.getData().Parada().getConexiones(); // Obtiene las conexiones de la parada actual
            Grafo conexiones = aux.getData().Parada().getConexiones();// Obtiene el grafo de conexiones de la parada actual  
            Nodo2 auxConexiones = conexiones.pFirst; // Inicializa un nodo para recorrer las conexiones, comenzando desde el primero
            while (auxConexiones != null) { // Itera sobre cada una de las conexiones de la parada actual  
                String nombreConexion = auxConexiones.getData().Parada().Nombre();// Obtiene el nombre de cada conexión 
                if (!resultado.contains(nombreConexion)) {// Verifica si el nombre de la conexión no está en el resultado para evitar duplicados
                    Nodo2 nodoConexion = this.BuscarParada(nombreConexion);   // Busca el nodo correspondiente a la conexión por su nombre 
                    resultado = CoberturaSucursalProfundidad(nodoConexion, resultado, profundidad + 1);

                }
                auxConexiones = auxConexiones.getpNext(); //Avanza al siguiente nodo de conexiones
            }

        }
        return resultado;// Devuelve el resultado acumulado
    }

    public String CoberturaSucursalProfundidad(String nombreParada) {
        Nodo2 nodoParada = this.BuscarParada(nombreParada);  // Busca el nodo correspondiente a la parada a partir de su nombre
        if (nodoParada.getData().Parada().Sucursal()) { // Verifica si la parada encontrada corresponde a una sucursal 
            return this.CoberturaSucursalProfundidad(nodoParada, "", 0); // Llama a la función de cobertura comenzando desde el nodo de la parada 
        } else {
            JOptionPane.showMessageDialog(null, "No hay una sucursal en esta parada"); // Muestra un mensaje si la parada no es una sucursal  
            return "";// Retorna una cadena vacía 
        }

    }

    public String ComprobarCoberturaCompletaProfundidad() {
        Nodo2 aux = this.pFirst;  // Inicializa un nodo auxiliar comenzando desde el primer nodo de la lista 
        String cobertura = ""; // Inicializa una cadena para almacenar la cobertura 
        while (aux != null) { // Itera sobre todos los nodos de la lista
            if (aux.getData().Parada().Sucursal()) { // Verifica si el nodo actual es una sucursal 
                cobertura += this.CoberturaSucursalProfundidad(aux.getData().Parada().Nombre());// Añade a la cobertura el resultado de la función de cobertura para cada sucursal

            }
            aux = aux.getpNext(); // Avanza al siguiente nodo en la lista  
        }
        String paradasFaltantes = ""; // Inicializa una cadena para almacenar las paradas faltantes  
        Nodo2 aux2 = this.pFirst;// Reinicia el nodo auxiliar para comprobar paradas faltantes  
        while (aux2 != null) { // Itera nuevamente sobre todos los nodos de la lista
            if (!cobertura.contains(aux2.getData().Parada().Nombre())) {// Verifica si la parada no está en la cobertura obtenida  
                paradasFaltantes += "\n" + aux2.getData().Parada().Nombre();// Añade el nombre de la parada faltante a la cadena de paradas faltantes  
            }
            aux2 = aux2.getpNext(); // Avanza al siguiente nodo en la lista
        }
        return paradasFaltantes; // Devuelve la lista de paradas faltantes
    }

    public void AnadirSucursal(String nombreParada) {
        Nodo2 nodoParada = this.BuscarParada(nombreParada); // Busca el nodo correspondiente a la parada especificada
        if (nodoParada == null) {  // Verifica si la parada no existe 
            JOptionPane.showMessageDialog(null, "No existe esta parada");
        } else if (nodoParada.getData().Parada().Sucursal()) {  // Verifica si la parada ya tiene una sucursal
            JOptionPane.showMessageDialog(null, "La parada ingresada ya tiene sucursal");
        } else { 
            nodoParada.getData().Parada().agregarSucursal(); // Añade una sucursal a la parada  
            JOptionPane.showMessageDialog(null, "Sucursal agregada con exito");  // Muestra un mensaje indicando que la sucursal fue agregada exitosamente
        }
    }

    public Nodo2 BuscarParada(String nombreParada) {
        Nodo2 aux = this.pFirst; // Inicializa un nodo auxiliar comenzando desde el primer nodo de la lista  
        while (aux != null) { // Itera sobre todos los nodos de la lista 
            if (aux.getData().Parada().Nombre().equalsIgnoreCase(nombreParada)) { // Verifica si el nombre de la parada actual coincide con el nombre buscado (ignorando mayúsculas)  
                return aux; // Retorna el nodo correspondiente si se encuentra  
            }
            aux = aux.getpNext();    // Avanza al siguiente nodo en la lista  

        }
        return null; // Retorna null si no se encuentra la parada

    }

    private String CoberturaSucursalAmplitud(Nodo2 aux3, String listaAmplitud, int amplitud, Nodo2 nodoParada) {
        if (aux3 != null && amplitud <= this.t) {  // Verifica si el nodo auxiliar no es nulo y si la amplitud es menor o igual al límite 't'
            listaAmplitud += "\n" + aux3.getData().Parada().Nombre(); // Agrega el nombre de la parada actual a la lista de amplitud 
            aux3.getData().Parada().getConexiones(); // Obtiene las conexiones de la parada actual  
            Grafo conexiones = aux3.getData().Parada().getConexiones();  // Obtiene el grafo de conexiones de la parada actual  
            Nodo2 auxConexiones = conexiones.pFirst;  // Inicializa un nodo para recorrer las conexiones desde la primera

            while (amplitud <= this.t) { // Mientras no se haya alcanzado la máxima amplitud  
        
                    Nodo2 nodoActual = aux3.getpNext();  // Obtiene el siguiente nodo de la cola   
                    if (nodoActual != null) { // Verifica si el nodo actual no es nulo 
                        listaAmplitud += "\n" + nodoActual.getData().Parada().Nombre(); // Añadir su nombre al resultado  

                         
                        while (auxConexiones != null) {// Explorar todas las conexiones 
                            String nombreConexion = auxConexiones.getData().Parada().Nombre(); // Obtiene el nombre de la conexión actual  
                            
                            if (!listaAmplitud.contains(nombreConexion)) {// Si el nombre de la conexión no está ya en la lista de amplitud
                                Nodo2 nodoConexion = this.BuscarParada(nombreConexion);// Busca el nodo correspondiente a la conexión por su nombre
                                if (nodoConexion != null) { // Verifica si el nodo de conexión encontrado no es nulo  
                                    nodoParada.getData().Parada().agregarSucursal(); // Añadir a la cola  
                                }
                            }
                            auxConexiones = auxConexiones.getpNext(); // Ir al siguiente nodo de conexiones  
                        }
                    }
                }
                amplitud++; // Incrementar la amplitud después de explorar todos los nodos de la capa actual  
            }
        return listaAmplitud; // Devuelve la lista de paradas acumuladas en la amplitud    
    }

    public String CoberturaSucursalAmplitud(String nombreParada) {
        Nodo2 nodoParadas = this.BuscarParada(nombreParada);
        if (nodoParadas != null && nodoParadas.getData().Parada().Sucursal()) {
            return this.CoberturaSucursalAmplitud(nombreParada);
        } else {
            JOptionPane.showMessageDialog(null, "No hay una sucursal en esta parada o la parada no existe");
            return "";
        }
    }

    public String ComprobarCoberturaCompletaAmplitud() {
        Nodo2 aux3 = this.pFirst; // Inicializa un nodo auxiliar comenzando desde el primer nodo de la lista 
        String cobertura = ""; // Inicializa una cadena para almacenar la cobertura 
        while (aux3 != null) { // Itera sobre todos los nodos de la lista 
            if (aux3.getData().Parada().Sucursal()) {// Verifica si el nodo actual es una sucursal
                cobertura += this.CoberturaSucursalAmplitud(cobertura); // Añade a la cobertura el resultado de la función de cobertura para cada sucursal  
            }
            aux3 = aux3.getpNext(); //Avanza al siguiente nodo de la lista
        }
        String paradasFaltantes = ""; // Inicializa una cadena para almacenar las paradas faltantes  
        while (aux3 != null) { // Itera nuevamente sobre todos los nodos de la lista 
            if (!cobertura.contains(aux3.getData().Parada().Nombre())) { // Verifica si la parada no está en la cobertura obtenida  
                paradasFaltantes += "\n" + aux3.getData().Parada().Nombre(); // Añade el nombre de la parada faltante a la cadena de paradas faltantes  
            }
            aux3 = aux3.getpNext();  // Avanza al siguiente nodo en la lista
        }
        return paradasFaltantes; // Devuelve la lista de paradas faltantes
    }
}
