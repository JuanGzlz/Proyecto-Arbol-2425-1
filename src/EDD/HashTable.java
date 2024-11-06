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
public class HashTable {
    private Nodo[] Hash;

    public HashTable() {
        this.Hash = new Nodo[1009];
    }
    
    private void insertNodo (NodoArbol persona){
        Nodo newNodo = new Nodo(persona.getNombre(), persona.getNumeral(), persona);
        int indice = newNodo.getNombre().hashCode() % Hash.length;
        if (Hash[indice] == null){
            Hash[indice] = newNodo;
        }else{
            Nodo current = Hash[indice];
            while (current.getpNext() != null){
                current = current.getpNext();
            }
            current.setpNext(newNodo);
        }
    }
}
