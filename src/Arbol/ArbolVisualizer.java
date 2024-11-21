/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;
import EDD.HashTable;
import EDD.Lista;
import EDD.Nodo;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.view.ViewerListener;

/**
 * Clase para visualizar un árbol de datos utilizando GraphStream.
 * Permite representar un árbol como un grafo, interactuar con sus nodos y 
 * visualizar relaciones y linajes en un entorno gráfico.
 * 
 * @author valen
 */
public class ArbolVisualizer implements ViewerListener{
    /**
     * @param graph Grafo que representa visualmente el árbol.
     * @param arbol Árbol que se desea visualizar.
     * @param tabla hash table que almacena datos de los nodos del árbol para búsquedas rápidas.
     * @param loop Indicador de bucle para mantener el programa interactivo.
     * @param viewer Objeto Viewer de GraphStream para manejar la visualización.
     * @param fromViewer Objeto ViewerPipe para interactuar con el grafo.
     */
    private Graph graph;
    private Arbol arbol;
    private HashTable tabla;
    private boolean loop;
    private Viewer viewer;
    private ViewerPipe fromViewer;
    
    /**
     * Constructor de la clase.
     * 
     * @param arbolito El árbol que se desea visualizar.
     * @param tabla La hash table con información de los nodos.
     */
    public ArbolVisualizer(Arbol arbolito, HashTable tabla) {
        this.arbol = arbolito;
        this.tabla = tabla;
        this.graph = null;
        this.loop = true;
        System.setProperty("org.graphstream.ui", "swing");
    }
    
     /**
     * Muestra visualmente el árbol en una ventana utilizando GraphStream.
     * Establece la estructura inicial del grafo basada en el árbol y
     * mantiene un bucle para gestionar eventos interactivos.
     */
    public void mostrarArbol() {
        this.graph = new SingleGraph("GRAFO: Game of Thrones");
        this.viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        this.fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
	fromViewer.addSink(this.graph);
        this.CrearRelacion();
        this.loop = true;

	new Thread(() -> {
            while(loop) {
                    fromViewer.pump(); // or fromViewer.blockingPump(); in the nightly builds
            }
	}).start();
    }
    
        @Override
	public void viewClosed(String id) {
            loop = false;
	}

        @Override
	public void buttonPushed(String id) {
                graph.getNode(id).setAttribute("ui.style", "fill-color: blue;");
                NodoArbol N = this.tabla.busquedaHasheo(id);
                if(N==null){
                    JOptionPane.showMessageDialog(null,
                    ("No se tiene información sobre esta persona."),
                        "", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    String Datos = N.DevolverDatos();
                    JOptionPane.showMessageDialog(null,
                    (Datos),
                        "", JOptionPane.INFORMATION_MESSAGE);
                }
                graph.getNode(id).setAttribute("ui.style", "fill-color: green;");
	}

        @Override
	public void buttonReleased(String id) {
            //no hace nada
        }
        @Override
        public void mouseOver(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseLeft(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    /**
     * Crea las relaciones entre los nodos del árbol para construir el grafo.
     */
    public void CrearRelacion(){
        NodoArbol root = arbol.getRaiz();
        AgregarHijos(root);
    }
    
    /**
     * Agrega los nodos hijos y las relaciones al grafo de forma recursiva.
     * 
     * @param visita Nodo actual que se está procesando.
     */
    private void AgregarHijos(NodoArbol visita){
        if(this.graph.getNode(visita.NombreCompleto())==null){
            this.graph.addNode(visita.NombreCompleto()).setAttribute("ui.label", visita.getNombre() + ", " + visita.getNumeral() + " of his name");
            this.graph.getNode(visita.NombreCompleto()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
        }
        NodoArbol Hijo = visita.getfSon();
        String[] HijosCompleto = visita.getHijos().split(", ");
        while(Hijo != null){
            if(this.graph.getNode(Hijo.NombreCompleto())==null){
                this.graph.addNode(Hijo.NombreCompleto()).setAttribute("ui.label", Hijo.getNombre() + ", " + Hijo.getNumeral() + " of his name");
                this.graph.getNode(Hijo.NombreCompleto()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
            }
            this.graph.addEdge(visita.NombreCompleto() + "-" + Hijo.NombreCompleto(), visita.NombreCompleto(), Hijo.NombreCompleto());
            for(int i = 0; i < HijosCompleto.length; i++){
                if(Hijo.getNombre().contains(HijosCompleto[i])){
                    HijosCompleto[i] = "null";
                }
            }
            AgregarHijos(Hijo);
            Hijo = Hijo.getnBrother();
        }
        for(int i = 0; i < HijosCompleto.length; i++){
            if(!HijosCompleto[i].equals("null") && !HijosCompleto[i].equals("")){
                this.graph.addNode(HijosCompleto[i] + " hijo de " + visita.getNombre()).setAttribute("ui.label", HijosCompleto[i]);
                this.graph.getNode(HijosCompleto[i] + " hijo de " + visita.getNombre()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
                this.graph.addEdge(visita.NombreCompleto() + "-" + HijosCompleto[i] + " hijo de " + visita.getNombre(), visita.NombreCompleto(), HijosCompleto[i] + " hijo de " + visita.getNombre());
            }
        }
    }
    
    /**
     * Muestra visualmente una lista de linajes como un grafo.
     * 
     * @param Linaje Lista que contiene los nodos de linaje a visualizar.
     */
    public void mostrarAntepasados(Lista Linaje) {
        this.graph = new SingleGraph("GRAFO: Lista Linaje");
        this.viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        this.fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
	fromViewer.addSink(this.graph);
        this.AgregarLinaje(Linaje);
        this.loop = true;
        
        new Thread(() -> {
            while(loop) {
                    fromViewer.pump(); // or fromViewer.blockingPump(); in the nightly builds

            }
	}).start();
    }
    
    /**
     * Agrega nodos y relaciones de linaje al grafo.
     * 
     * @param Linaje Lista de nodos que representan el linaje.
     */
    public void AgregarLinaje(Lista Linaje){
        Nodo aux = Linaje.getpFirst();
        int j = 0;
        if(Linaje.getSize() == 1){
            this.graph.addNode(aux.getPersona().NombreCompleto()).setAttribute("ui.label", aux.getPersona().getNombre() + ", " + aux.getPersona().getNumeral() + " of his name");
            this.graph.getNode(aux.getPersona().NombreCompleto()).setAttribute("ui.style", "fill-color: yellow; shape: circle; size: 20px;");
        }
        while(j < Linaje.getSize() - 1){
        NodoArbol visita = aux.getPersona();
        if(this.graph.getNode(visita.NombreCompleto())==null){
            this.graph.addNode(visita.NombreCompleto()).setAttribute("ui.label", visita.getNombre() + ", " + visita.getNumeral() + " of his name");
            this.graph.getNode(visita.NombreCompleto()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
        }
        NodoArbol Hijo = visita.getfSon();
        String[] HijosCompleto = visita.getHijos().split(", ");
        while(Hijo != null){
            if(this.graph.getNode(Hijo.NombreCompleto())==null){
                this.graph.addNode(Hijo.NombreCompleto()).setAttribute("ui.label", Hijo.getNombre() + ", " + Hijo.getNumeral() + " of his name");
                this.graph.getNode(Hijo.NombreCompleto()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
            }
            this.graph.addEdge(visita.NombreCompleto() + "-" + Hijo.NombreCompleto(), visita.NombreCompleto(), Hijo.NombreCompleto());
            for(int i = 0; i < HijosCompleto.length; i++){
                if(Hijo.getNombre().contains(HijosCompleto[i])){
                    HijosCompleto[i] = "null";
                }
            }
            Hijo = Hijo.getnBrother();
        }
        for(int i = 0; i < HijosCompleto.length; i++){
            if(!HijosCompleto[i].equals("null") && !HijosCompleto[i].equals("")){
                this.graph.addNode(HijosCompleto[i] + " hijo de " + visita.getNombre()).setAttribute("ui.label", HijosCompleto[i]);
                this.graph.getNode(HijosCompleto[i] + " hijo de " + visita.getNombre()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
                this.graph.addEdge(visita.NombreCompleto() + "-" + HijosCompleto[i] + " hijo de " + visita.getNombre(), visita.NombreCompleto(), HijosCompleto[i] + " hijo de " + visita.getNombre());
            }
        }
        j++;
        aux = aux.getpNext();
        }
        this.graph.getNode(aux.getPersona().NombreCompleto()).setAttribute("ui.style", "fill-color: yellow;");
    }
    
    public void mostrarDescendencia(NodoArbol Elegido) {
        this.graph = new SingleGraph("GRAFO: Lista Linaje");
        this.viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        this.fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
	fromViewer.addSink(this.graph);
        this.AgregarDescendencia(Elegido);
        this.loop = true;
        
	new Thread(() -> {
            while(loop) {
                    fromViewer.pump(); // or fromViewer.blockingPump(); in the nightly builds
            }
	}).start();
    }
    
    private void AgregarDescendencia(NodoArbol visita){
        if(this.graph.getNode(visita.NombreCompleto())==null){
            this.graph.addNode(visita.NombreCompleto()).setAttribute("ui.label", visita.getNombre() + ", " + visita.getNumeral() + " of his name");
            this.graph.getNode(visita.NombreCompleto()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
        }
        NodoArbol Hijo = visita.getfSon();
        String[] HijosCompleto = visita.getHijos().split(", ");
        for(int i = 0; i < HijosCompleto.length; i++){
            System.out.println(HijosCompleto[i]);
        }
        System.out.println("");
        while(Hijo != null){
            if(this.graph.getNode(Hijo.NombreCompleto())==null){
                this.graph.addNode(Hijo.NombreCompleto()).setAttribute("ui.label", Hijo.getNombre() + ", " + Hijo.getNumeral() + " of his name");
                this.graph.getNode(Hijo.NombreCompleto()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
            }
            this.graph.addEdge(visita.NombreCompleto() + "-" + Hijo.NombreCompleto(), visita.NombreCompleto(), Hijo.NombreCompleto());
            for(int i = 0; i < HijosCompleto.length; i++){
                if(Hijo.getNombre().contains(HijosCompleto[i])){
                    HijosCompleto[i] = "null";
                }
            }
            AgregarDescendencia(Hijo);
            Hijo = Hijo.getnBrother();
        }
        for(int i = 0; i < HijosCompleto.length; i++){
            if(!HijosCompleto[i].equals("null") && !HijosCompleto[i].equals("")){
                this.graph.addNode(HijosCompleto[i] + " hijo de " + visita.getNombre()).setAttribute("ui.label", HijosCompleto[i]);
                this.graph.getNode(HijosCompleto[i] + " hijo de " + visita.getNombre()).setAttribute("ui.style", "fill-color: green; shape: circle; size: 20px;");
                this.graph.addEdge(visita.NombreCompleto() + "-" + HijosCompleto[i] + " hijo de " + visita.getNombre(), visita.NombreCompleto(), HijosCompleto[i] + " hijo de " + visita.getNombre());
            }
        }
    }
}


