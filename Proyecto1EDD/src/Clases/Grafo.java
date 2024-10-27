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
        if (aux != null && profundidad <= this.t) {
            //Parada cantidadparadas = lineas_metro.get(i);
            resultado += "\n" + aux.getData().Parada().Nombre();
            aux.getData().Parada().getConexiones();
            Grafo conexiones = aux.getData().Parada().getConexiones();
            Nodo2 auxConexiones = conexiones.pFirst;
            while (auxConexiones != null) {
                String nombreConexion = auxConexiones.getData().Parada().Nombre();
                if (!resultado.contains(nombreConexion)) {
                    Nodo2 nodoConexion = this.BuscarParada(nombreConexion);
                    resultado = CoberturaSucursalProfundidad(nodoConexion, resultado, profundidad + 1);

                }
                auxConexiones = auxConexiones.getpNext();
            }

        }
        return resultado;
    }

    public String CoberturaSucursalProfundidad(String nombreParada) {
        Nodo2 nodoParada = this.BuscarParada(nombreParada);
        if (nodoParada.getData().Parada().Sucursal()) {
            return this.CoberturaSucursalProfundidad(nodoParada, "", 0);
        } else {
            JOptionPane.showMessageDialog(null, "No hay una sucursal en esta parada");
            return "";
        }

    }

    public String ComprobarCoberturaCompletaProfundidad() {
        Nodo2 aux = this.pFirst;
        String cobertura = "";
        while (aux != null) {
            if (aux.getData().Parada().Sucursal()) {
                cobertura += this.CoberturaSucursalProfundidad(aux.getData().Parada().Nombre());

            }
            aux = aux.getpNext();
        }
        String paradasFaltantes = "";
        Nodo2 aux2 = this.pFirst;
        while (aux2 != null) {
            if (!cobertura.contains(aux2.getData().Parada().Nombre())) {
                paradasFaltantes += "\n" + aux2.getData().Parada().Nombre();
            }
            aux2 = aux2.getpNext();
        }
        return paradasFaltantes;
    }

    public void AnadirSucursal(String nombreParada) {
        Nodo2 nodoParada = this.BuscarParada(nombreParada);
        if (nodoParada == null) {
            JOptionPane.showMessageDialog(null, "No existe esta parada");
        } else if (nodoParada.getData().Parada().Sucursal()) {
            JOptionPane.showMessageDialog(null, "La parada ingresada ya tiene sucursal");
        } else {
            nodoParada.getData().Parada().agregarSucursal();
            JOptionPane.showMessageDialog(null, "Sucursal agregada con exito");
        }
    }

    public Nodo2 BuscarParada(String nombreParada) {
        Nodo2 aux = this.pFirst;
        while (aux != null) {
            if (aux.getData().Parada().Nombre().equalsIgnoreCase(nombreParada)) {
                return aux;
            }
            aux = aux.getpNext();

        }
        return null;
    }
    public String CoberturaSucursalAmplitud(String nombreParada){
        return "";
    }
    public String ComprobarCoberturaCompletaAmplitud() {
        return "";
    }
}
