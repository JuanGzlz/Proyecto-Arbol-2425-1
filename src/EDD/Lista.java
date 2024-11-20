/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Arbol.NodoArbol;

/**
 * Clase que implementa una lista enlazada simple.
 * La lista permite almacenar nodos que contienen objetos de tipo NodoArbol.
 * Incluye operaciones básicas como agregar, eliminar, buscar y verificar la existencia de nodos.
 * 
 * @author Admin
 */
public class Lista {
    private Nodo pFirst;
    private int size;
    
    /**
     * Constructor de la clase Lista.
     * Inicializa una lista vacía.
     */
    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty(){
        return getpFirst() == null;
    }
    
    /**
     * Agrega un nodo al final de la lista.
     * 
     * @param tree el nodo del árbol que se desea agregar a la lista.
     */
    public void addLast (NodoArbol tree){
        Nodo NuevoNodo = new Nodo(tree.getNombre(), tree);
        if (isEmpty()){
            this.setpFirst(NuevoNodo);
        } else{
            Nodo aux = this.getpFirst();
            while(aux.getpNext()!=null){
                aux = aux.getpNext();
            }
            aux.setpNext(NuevoNodo);
        }
        setSize(getSize()+1);
    }
    
    /**
     * Elimina un nodo de la lista si coincide con el nodo proporcionado.
     * 
     * @param Nodo el nodo del árbol que se desea eliminar.
     */
    public void eliminateNodo(NodoArbol Nodo){
        if(this.isEmpty() == false){
        if (getpFirst().getPersona() == Nodo){
            setpFirst(getpFirst().getpNext());
        }else{
            Nodo aux = getpFirst();
            while (aux.getpNext() != null){
                if(aux.getpNext().getPersona() == Nodo){
                    aux.setpNext(aux.getpNext().getpNext());
                    setSize(getSize()-1);
                    System.out.println("Se elimino " + Nodo.getNombre() + " " + Nodo.getNumeral());
                    return;
                }
                aux = aux.getpNext();
            }
        }
        }
    }
    
    /**
     * Verifica si un nodo existe en la lista.
     * 
     * @param Nodo el nodo del árbol que se desea buscar.
     * @return true si el nodo existe, false en caso contrario.
     */
    public boolean NodoExiste(NodoArbol Nodo){
        Nodo aux = this.getpFirst();
        while(aux != null){
            if (aux.getPersona() == Nodo){
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }
    
    /**
     * Busca un nodo en la lista que coincida con el nombre proporcionado.
     * 
     * @param nombre el nombre del nodo que se desea buscar.
     * @return el nodo encontrado, o null si no existe.
     */
    public Nodo buscarNodo(String nombre){
        Nodo aux = this.getpFirst();
        if(!isEmpty()){
            while(aux!= null){
                String name = aux.getNombre();
                if(name.toLowerCase().equals(nombre.toLowerCase())){
                    return aux;
                }
                aux = aux.getpNext();
            }
        }
        return aux;
    }

    /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
