/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Arbol.NodoArbol;

/**
 * Clase que representa un nodo de una lista enlazada.
 * Cada nodo almacena un objeto de tipo NodoArbol, un nombre, 
 * y una referencia al siguiente nodo en la lista.
 * 
 * @author María Correa
 */
public class Nodo {
    private String Nombre;
    private NodoArbol Persona;
    private Nodo pNext;
    
    /**
     * Constructor de la clase Nodo.
     * 
     * @param Nombre el nombre asociado al nodo.
     * @param Persona el objeto NodoArbol que contiene la información del nodo.
     */
    public Nodo(String Nombre, NodoArbol Persona) {
        this.Nombre = Nombre;
        this.Persona = Persona;
        this.pNext = null;
    }
    
    /**
     * @return the Persona
     */
    public NodoArbol getPersona() {
        return Persona;
    }

    /**
     * @return the pNext
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    
}
