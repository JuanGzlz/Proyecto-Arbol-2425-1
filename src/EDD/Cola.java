/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Arbol.NodoArbol;

/**
 * Clase Cola
 * Estructura de datos de tipo Cola con sus respectivas primitivas
 * @author María Correa
 * @version 1.0
 */

public class Cola {
    /**
    * @param pFirst variable privada de tipo Nodo que apunta al primer elemento insertado en la cola
    * @param pLast variable privada de tipo Nodo que apunta al último elemento insertado en la cola
    * @param size variable privada de tipo entero que indica la cantidad de elementos que posee la cola
    */
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    /**
     * Constructor de la clase Cola, no recibe parámetro de entrada
     * Automáticamente asigna valores de null a pFirst y pLast, y 0 a size
     */
    
    public Cola() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

     /**
     * Función que indica si la cola es vacía
     * @return true si la cola es vacía y false si la lista no es vacía
     */
    
    public boolean isEmpty(){
        return pFirst == null;
    }
    
    /**
     * Método que encola en la lista la viable de entrada
     * @param N variable de tipo Vertice que se desea encolar
     */
    
    public void encolar(NodoArbol N){
        Nodo NewNodo = new Nodo(N.getNombre(), N);
        if (this.isEmpty()){
            this.pFirst = NewNodo;
            this.pLast = NewNodo;
        } else{
            pLast.setpNext(NewNodo);
            pLast = NewNodo;
        }
        size ++;
    }
    
    /**
     * Función que desencola el primer elemento de la cola
     * @return Nodo desencolado
     */
    
    public Nodo desencolar (){
        if (isEmpty()){
            return null;
        } else{
            Nodo NewNodo = pFirst;
            pFirst = pFirst.getpNext();
            size --;
            return NewNodo;
        }
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
    
}
