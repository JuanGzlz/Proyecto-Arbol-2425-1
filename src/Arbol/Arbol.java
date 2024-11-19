/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import EDD.Lista;
import EDD.Nodo;

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
    
    private Lista DFS_Recursivo(NodoArbol Actual, NodoArbol Resultado, Lista Linaje){
        Linaje.addLast(Actual);
        if (Actual.NombreCompleto().equals(Resultado.NombreCompleto())){
            System.out.println("AAAAAAAAAAAAAA");
            return Linaje;
        }else if(Actual.getfSon() != null){
            Lista ResultadoHijo = DFS_Recursivo(Actual.getfSon(), Resultado, Linaje);
            if (ResultadoHijo.NodoExiste(Resultado) == true){
                return ResultadoHijo;
            }
        }
                
        if (Actual.getnBrother() != null){
            Lista ResultadoHermano = DFS_Recursivo(Actual.getnBrother(), Resultado, Linaje);
            if (ResultadoHermano.NodoExiste(Resultado) == true){
                return ResultadoHermano;
            }
        }
        Linaje.eliminateNodo(Actual);
        return Linaje;
    }
}
