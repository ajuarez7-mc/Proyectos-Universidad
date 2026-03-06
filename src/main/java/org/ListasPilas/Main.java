package org.ListasPilas;
//"" < >
import org.ListasPilas.Pilas.Pila;
import org.ListasPilas.Lista.DobleLista;
import org.ListasPilas.Lista.ListaSimple;
public class Main {
    public static void main(String[] args) {
        System.out.println("Pruebas de la Lista simple");
        ListaSimple<Integer> listaSimple = new ListaSimple<>();

        listaSimple.AgregarInicio(10);
        listaSimple.AgregarInicio(5);
        System.out.println("La lista es: " + listaSimple.imprimir() + ", El tamaño es de=" + listaSimple.size());

        listaSimple.AgregarFinal(20);
        System.out.println("Lista:" + listaSimple.imprimir());
        // se imprime de nuevo con el valorFinal

        //BuscarValor
        System.out.println("Se busca el valor 10:" + listaSimple.BuscarValor(10));
        System.out.println("Se busca el valor 99:" + listaSimple.BuscarValor(99));
        //Remover
        System.out.println("remover del Inicio: " + listaSimple.RemoverInicio());
        System.out.println("Lista actual: " + listaSimple.imprimir());
        //Remover hasta quedar vacío
        listaSimple.RemoverInicio();
        listaSimple.RemoverInicio();
        System.out.println("Lista actual: " + listaSimple.imprimir());

        try {
            listaSimple.RemoverInicio();
        }catch (IllegalStateException e){
            System.out.println("Excepción: " + e.getMessage());
        }

        //Fin Lista simple

        //Inicio lista doble
        System.out.println("--------------------");
        System.out.println("DobleLista");
        DobleLista<String> listaDoble = new DobleLista<>();

        listaDoble.AgregarFinal("A");
        listaDoble.AgregarFinal("B");
        listaDoble.AgregarInicio("Z");
        System.out.println("Datos Lista doble:" + listaDoble.imprimir());

        System.out.println("Remover del final: " +listaDoble.QuitarFinal());
        System.out.println("Datos Lista doble:" + listaDoble.imprimir());

        listaDoble.QuitarFinal();
        listaDoble.QuitarFinal();
        System.out.println("Lista actual:" + listaDoble.imprimir());
        try {
            listaDoble.QuitarFinal();
        }catch (IllegalStateException e){
            System.out.println("Excepción: "+ e.getMessage());
        }
        //Fin Lista doblemente enlazada

        //Inicio Pila
        System.out.println("--------------------");
        System.out.println("Pila");
        Pila<Integer> pila = new Pila<>();
        //se hacen los push
        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println("peek: " + pila.peek());

        //pila y pop
        System.out.println("pop: " + pila.pop());
        System.out.println("pop: " + pila.pop());


        pila.pop();
        System.out.println("Después del ultimo pop un IsEmpty: " + pila.isEmpty());
        try {
            pila.pop();
        }catch(IllegalStateException e){
            System.out.println("Excepción:  "+ e.getMessage());
        }
    }
}
