package org.ListasPilas.Lista;
import org.ListasPilas.Nodos.DobleNodo;
public class DobleLista<T> {
    private DobleNodo<T>  cabeza;
    private DobleNodo<T> cola;
    private int size;

    public DobleLista() {
            this.cabeza = null;
            this.cola = null;
            this.size = 0;
    }

    public void AgregarInicio(T valor) {
        DobleNodo<T> nuevoNodo = new DobleNodo<>(valor);

//se repite el mismo proceso de la simple, pero con la variable extra
        if (size == 0){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else{
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        size ++;
    }//Fin agregar Inicio

    public void AgregarFinal(T valor) {
        DobleNodo<T> nuevoNodo = new DobleNodo<>(valor);
        if(cola == null){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        }else{
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        size ++;
    }//fin agregar final

    public T QuitarFinal(){
        if (size == 0){
            throw new IllegalStateException("La lista esta vacía, no se puede eliminar");
        }
        T Quitar = cola.dato;
        if(size == 1){
            cabeza = null;
            cola = null;
        }else{
            cola = cola.anterior;
            cola.siguiente = null;
        }
        size--;
        return Quitar;
    }//fin quitarFinal

    public int size(){
        return size;
    }

    public String imprimir(){
        if (cabeza == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        DobleNodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato);
            actual = actual.siguiente;
            if(actual != null)  sb.append(" <-> ");
        }
        sb.append("]");
        return sb.toString();
    }//fin Imprimir
}
