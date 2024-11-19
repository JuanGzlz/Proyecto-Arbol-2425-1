/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;
import EDD.HashTable;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.view.ViewerListener;

/**
 *
 * @author valen
 */
public class ArbolVisualizer implements ViewerListener{
    private Graph graph;
    private Arbol arbol;
    private HashTable tabla;
    private boolean loop;
    
    
    public ArbolVisualizer(Arbol arbolito, HashTable tabla) {
        this.arbol = arbolito;
        this.tabla = tabla;
        this.graph = new MultiGraph("GRAFO: ");
        this.loop = true;
        System.setProperty("org.graphstream.ui", "swing");
    }
    
    public void mostrarArbol() {
        this.CrearRelacion();
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
	fromViewer.addSink(this.graph);

		// Then we need a loop to do our work and to wait for events.
		// In this loop we will need to call the
		// pump() method before each use of the graph to copy back events
		// that have already occurred in the viewer thread inside
		// our thread.

	while(loop) {
		fromViewer.pump(); // or fromViewer.blockingPump(); in the nightly builds

			// here your simulation code.

			// You do not necessarily need to use a loop, this is only an example.
			// as long as you call pump() before using the graph. pump() is non
			// blocking.  If you only use the loop to look at event, use blockingPump()
			// to avoid 100% CPU usage. The blockingPump() method is only available from
			// the nightly builds.
	}
    }
    
        @Override
	public void viewClosed(String id) {
		loop = false;
                this.graph.clear();
	}

        @Override
	public void buttonPushed(String id) {
                graph.getNode(id).setAttribute("ui.style", "fill-color: green;");
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
                graph.getNode(id).setAttribute("ui.style", "fill-color: red;");
	}

        @Override
	public void buttonReleased(String id) {
            
        }
    
    public void CrearRelacion(){
        NodoArbol root = arbol.getRaiz();
        AgregarHijos(root);
        
        
    }
    
    private void AgregarHijos(NodoArbol visita){
        if(this.graph.getNode(visita.NombreCompleto())==null){
            this.graph.addNode(visita.NombreCompleto()).setAttribute("ui.label", visita.getNombre() + ", " + visita.getNumeral() + " of his name");
            this.graph.getNode(visita.NombreCompleto()).setAttribute("ui.style", "fill-color: red; shape: circle; size: 20px;");
        }
        NodoArbol Hijo = visita.getfSon();
        String[] HijosCompleto = visita.getHijos().split(", ");
        while(Hijo != null){
            if(this.graph.getNode(Hijo.NombreCompleto())==null){
                this.graph.addNode(Hijo.NombreCompleto()).setAttribute("ui.label", Hijo.getNombre() + ", " + Hijo.getNumeral() + " of his name");
                this.graph.getNode(Hijo.NombreCompleto()).setAttribute("ui.style", "fill-color: red; shape: circle; size: 20px;");
            }
            this.graph.addEdge(visita.NombreCompleto() + "-" + Hijo.NombreCompleto(), visita.NombreCompleto(), Hijo.NombreCompleto());
            AgregarHijos(Hijo);
            Hijo = Hijo.getnBrother();
        }
    }
    
    
}


