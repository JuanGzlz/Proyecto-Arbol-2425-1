/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Arbol.NodoArbol;

/**
 *
 * @author Admin
 */
public class Lista {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return getpFirst() == null;
    }
    
    public void addLast (NodoArbol tree){
        Nodo NuevoNodo = new Nodo(tree.getNombre(), tree);
        if (isEmpty()){
            setpFirst(NuevoNodo);
            setpLast(NuevoNodo);
        } else{
            getpLast().setpNext(NuevoNodo);
            setpLast(NuevoNodo);
        }
        setSize(getSize()+1);
    }
    
    public void eliminateNodo(NodoArbol Nodo){
        if(this.isEmpty() == false || Nodo != null){
        if (getpFirst().getPersona() == Nodo){
            setpFirst(getpFirst().getpNext());
        }else{
            Nodo aux = getpFirst();
            Nodo prev = getpFirst();
            while (aux != null){
                if(aux.getPersona() != Nodo){
                    prev.setpNext(aux.getpNext());
                    aux.setpNext(null);
                    setSize(getSize()-1);
                    return ;
                }
                prev = aux;
                aux = aux.getpNext();
            }
        }
        }
    }
    
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
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
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
