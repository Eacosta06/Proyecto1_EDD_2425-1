/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class Redes {

    private static class Node {

        Parada data;
        Node next;

        public Node(Parada data) {
            this.data = data;
        }
    }

    class ListaNueva {

        private Node head;
        private int size;

        public ListaNueva() {
            head = null;
            size = 0;
        }

        public void add(Parada parada) {
            Node newNode = new Node(parada);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        public Parada get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        public int size() {
            return size;
        }

        public boolean contains(Parada parada) {
            Node current = head;
            while (current != null) {
                if (current.data.equals(parada)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    private static class SimpleQueue {

        private Node head;
        private Node tail;
        private int size;

        public void offer(Parada parada) {
            size++;
            Node newNode = new Node(parada);
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = tail;
            }
        }

        public Parada poll() {
            if (head == null) {
                return null;
            }
            size--;
            Parada data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return data;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    private class SimpleSet {

        private ListaNueva list;

        public SimpleSet() {
            this.list = new ListaNueva();

        }

        public void add(Parada parada) {
            if (!contains(parada)) {
                list.add(parada);
            }
        }

        public boolean contains(Parada parada) {
            Node aux = list.head;
                
            while (aux != null) {
                if (aux.data.equals(parada)) {
                    return true;
                }
                aux = aux.next;
            }
            return false;
        }
    }

    private ListaNueva paradas;

    public Redes() {
        paradas = new ListaNueva();
    }

    public void nuevaParada(Parada parada) {
        paradas.add(parada);
    }

    public ListaNueva getParadas() {
        return paradas;
    }

    /*public ListaNueva obtenerCobertura(Parada sucursal, int t) {
        SimpleSet cubiertas = new SimpleSet();
        SimpleQueue queue = new SimpleQueue();
        SimpleSet visitados = new SimpleSet();

        queue.offer(sucursal);
        visitados.add(sucursal);

        for (int i = 0; i < t && !queue.isEmpty(); i++) {
            int size = queue.getSize();
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
        return cubiertas.list;
    }
    */
}
