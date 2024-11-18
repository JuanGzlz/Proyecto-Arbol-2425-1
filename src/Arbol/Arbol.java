/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import EDD.Lista;

/**
 *
 * @author Admin
 */
public class Arbol {
    private NodoArbol Raiz;

    public Arbol() {
        this.Raiz = null;
    }

    /**
     * @return the Raiz
     */
    public NodoArbol getRaiz() {
        return Raiz;
    }

    /**
     * @param Raiz the Raiz to set
     */
    public void setRaiz(NodoArbol Raiz) {
        this.Raiz = Raiz;
    }
    
    public Lista DFS (NodoArbol Resultado){
        Lista Linaje = new Lista();
        return DFS_Recursivo(this.getRaiz(), Resultado, Linaje);
    }
    
    public Lista DFS_Recursivo(NodoArbol Actual, NodoArbol Resultado, Lista Linaje){
        Linaje.addLast(Actual);
        if (Actual == Resultado){
            return Linaje;
        }else if(Actual.getfSon() != null){
            Linaje = DFS_Recursivo(Actual.getfSon(), Resultado, Linaje);
            if (Linaje.NodoExiste(Resultado) == true){
                return Linaje;
            }else{
                Linaje.eliminateNodo(Actual);
            }
        }
        
        if (Actual.getnBrother() != null){
            Linaje = DFS_Recursivo(Actual.getnBrother(), Resultado, Linaje);
            if (Linaje.NodoExiste(Resultado) == true){
                return Linaje;
            }else{
                Linaje.eliminateNodo(Actual);
                return Linaje;
            }
        }
        return Linaje;
    }
}
