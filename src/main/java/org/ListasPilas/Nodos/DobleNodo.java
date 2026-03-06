package org.ListasPilas.Nodos;

public class DobleNodo<T> {
    public T dato;
    public DobleNodo<T> siguiente;
    public DobleNodo<T> anterior;

    public DobleNodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
//se termina la clase DobleNodo con el añadido de la variable anterior
}
