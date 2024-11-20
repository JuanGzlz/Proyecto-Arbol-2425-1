/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import EDD.Lista;
import EDD.Nodo;

/**
 * Clase que representa un árbol general con nodos de tipo {@link NodoArbol}.
 * Ofrece métodos para establecer la raíz del árbol y realizar búsquedas
 * en profundidad (DFS) para encontrar un nodo específico.
 * 
 * @author Admin
 */
public class Arbol {
    /**
     * @param Raiz Raíz del árbol.
     */
    private NodoArbol Raiz;
    
    /**
     * Constructor por defecto. 
     * Inicializa un árbol vacío con la raíz nula.
     */
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
    
    /**
     * Realiza una búsqueda en profundidad (DFS) para encontrar el linaje desde
     * la raíz del árbol hasta un nodo específico.
     * 
     * @param Resultado Nodo que se desea encontrar.
     * @return Una lista que contiene los nodos del linaje desde la raíz hasta
     *         el nodo encontrado. Si el nodo no existe, devuelve una lista vacía.
     */
    public Lista DFS (NodoArbol Resultado){
        Lista Linaje = new Lista();
        return DFS_Recursivo(this.getRaiz(), Resultado, Linaje);
    }
    
    /**
     * Método recursivo que realiza la búsqueda en profundidad (DFS).
     * Examina los nodos hijos y hermanos del nodo actual.
     * 
     * @param Actual Nodo actual que se está procesando.
     * @param Resultado Nodo que se desea encontrar.
     * @param Linaje Lista que acumula los nodos visitados en el camino.
     * @return Una lista que contiene los nodos del linaje desde la raíz hasta
     *         el nodo encontrado. Si el nodo no existe, devuelve una lista vacía.
     */
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
