package org.ListasPilas.Lista;

import org.ListasPilas.Nodos.Nodo;

//se importa la clase nodo del paquete nodo
public class ListaSimple<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int size;

    public ListaSimple() {

        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public void AgregarInicio(T valor)
    {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if(size==0){//se comprueba que la lista no este vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else{
            nuevoNodo.siguiente = cabeza;//Si la lista no esta vacía
            cabeza = nuevoNodo;
        }
        size++;
    }//fin del void agregar inicio

    public void AgregarFinal(T valor)
    {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (size == 0){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else{
                cola.siguiente = nuevoNodo;
                cola = nuevoNodo;
        }
        size++;
    }//fin del agregarFinal

    public T RemoverInicio()
    {
        if(size==0){
            throw new IllegalStateException("La lista ya se encuentra vacía");//mensaje de error si la lista vacía
        }

        T remover = cabeza.dato;
        cabeza = cabeza.siguiente;
        size--;

        if(size==0){
            cola = null;
        }
        return remover;

    }//Fin removerInicio

    public boolean BuscarValor(T valor){
        Nodo<T> actual = cabeza;
        while(actual != null){
            if(actual.dato.equals(valor)){
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }//fin buscarValor

    public int size(){
        return size;
    }

    public String imprimir(){
        if (cabeza == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //se necesita un nodo el cual recorrer
        Nodo<T> actual = cabeza;
        while(actual != null){
            sb.append(actual.dato);
            actual = actual.siguiente;
            if(actual != null) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }
}
