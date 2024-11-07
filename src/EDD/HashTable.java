/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
import Arbol.NodoArbol;
import static java.lang.Math.abs;

/**
 *
 * @author Admin
 */
public class HashTable {
    private String NombreTabla;
    private Nodo[] Hash;

    public HashTable(String nombre) {
        this.NombreTabla = nombre;
        this.Hash = new Nodo[1009];
    }
    
    /**
     * @return the NombreTabla
     */
    public String getNombreTabla() {
        return NombreTabla;
    }
    
    public void insertNodo (NodoArbol persona, String Nombre){
        Nodo newNodo = new Nodo(Nombre, persona.getNumeral(), persona);
        int indice = buscarIndex(Nombre);
        if (Hash[indice] == null){
            Hash[indice] = newNodo;
        }else{
            Nodo current = Hash[indice];
            while (current.getpNext() != null){
                current = current.getpNext();
            }
            current.setpNext(newNodo);
        }
        System.out.println(Nombre);
    }
    
    private int buscarIndex (String nombre){
        int indice = nombre.hashCode() % Hash.length;
        return abs(indice);
    }
    
    public NodoArbol busquedaHasheo (String nombre){
        int ind = buscarIndex(nombre);
        NodoArbol newArbol = null;
        Nodo newNodo = Hash[ind];
        while (newNodo != null){
            if (newNodo.getNombre().equals(nombre)){
                newArbol = newNodo.getPersona();
                break;
            }
            newNodo = newNodo.getpNext();
        }
        return newArbol;
    }

}
