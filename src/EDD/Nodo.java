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
public class Nodo {
    private String Nombre;
    private NodoArbol Persona;
    private Nodo pNext;

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
