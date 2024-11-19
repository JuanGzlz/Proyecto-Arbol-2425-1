/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Arbol.Arbol;
import Arbol.ArbolVisualizer;
import Arbol.NodoArbol;
import EDD.HashTable;
import EDD.Lista;
import EDD.Nodo;
import EDD.TableManager;
import Funciones.JsonChooser;
import Funciones.JsonDecoder;
import java.io.IOException;


/**
 *
 * @author Admin
 */
public class ProyectoArboles {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) throws IOException, InterruptedException {
        JsonChooser newFile = new JsonChooser();
        newFile.chooseFile();
        JsonDecoder newChose = new JsonDecoder(newFile.getJson());
        HashTable tabla = newChose.crearHashTable();
//        NodoArbol newNodo = tabla.busquedaHasheo("Viserys Targaryen, First of his name, son of Aegon the Conqueror");
        HashTable tabla2 = newChose.HashTableMotes(tabla);
        NodoArbol newNodo2 = tabla2.busquedaHasheo("Daeron the Good");
//        NodoArbol newNodo3 = tabla2.busquedaHasheo("Baelor Breakspear");
        
        TableManager creador = new TableManager();
        creador.CrearEstructuras(newChose);
        Lista l = creador.getTree().DFS(newNodo2);
        Nodo aux = l.getpFirst();
        while(aux != null){
            System.out.println(aux.getPersona().getNombre());
            System.out.println(aux.getPersona().getNumeral());
            aux = aux.getpNext();
        }
//        ArbolVisualizer g = new ArbolVisualizer(creador.getTree(), creador.getTablaNombre());
//        g.mostrarArbol();
    }

}
