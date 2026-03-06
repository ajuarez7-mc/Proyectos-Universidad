package org.ListasPilas.Pilas;
import org.ListasPilas.Nodos.Nodo;


public class Pila<T> {

    private Nodo<T> Maximo;   // el nodo más alto de la pila
    private int size;

    public Pila() {
        this.Maximo = null;
        this.size = 0;
    }
    //se agrega el void push
    public void push(T valor){
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        nuevoNodo.siguiente = Maximo;
        Maximo = nuevoNodo;
        size++;
    }
    //Se agrega el T pop
    public T pop(){
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer pop(): la pila está vacía.");
        }
        T remover = Maximo.dato;
        Maximo = Maximo.siguiente;
        size--;
    return remover;
    }
    //se agrega el T peek
    public T peek(){
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer peek(): la pila está vacía.");
        }
        return Maximo.dato;
    }

    public boolean isEmpty(){
        return Maximo == null;
    }

    public int size(){
        return size;
    }

    public String imprimir(){
        if (isEmpty()) {
            return "El máximo -> []";
        }
        StringBuilder sb = new StringBuilder("Maximo -> [");

        Nodo<T> actual = Maximo;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(" -> ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
