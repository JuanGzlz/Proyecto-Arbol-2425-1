/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 * Clase NodoArbol
 * Representa un nodo en un árbol con múltiples atributos personales y conexiones familiares.
 * Incluye referencias al primer hijo y al siguiente hermano en la estructura jerárquica.
 * @author Admin
 * @version 1.0
 */
public class NodoArbol {
    /**
     * @param Nombre Nombre del individuo.
     * @param Numeral Numeral del individuo.
     * @param Papa Nombre del padre.
     * @param Mama Nombre de la madre.
     * @param Apodo Apodo del individuo.
     * @param Titulo Título del individuo.
     * @param Casado Cónyuge del individuo.
     * @param Ojos Color de ojos.
     * @param Pelo Color de cabello.
     * @param Hijos Hijos del individuo.
     * @param Notas Notas adicionales.
     * @param Destino Destino del individuo.
     * @param fSon Referencia al primer hijo del nodo.
     * @param nBrother Referencia al siguiente hermano del nodo.
     */

    private String Nombre;
    private String Numeral;
    private String Papa;
    private String Mama;
    private String Apodo;
    private String Titulo;
    private String Casado;
    private String Ojos;
    private String Pelo;
    private String Hijos;
    private String Notas;
    private String Destino;
    private NodoArbol fSon;
    private NodoArbol nBrother;
    
    /**
     * Constructor para inicializar un nodo con todos sus atributos.
     *
     * @param Nombre Nombre del individuo.
     * @param Numeral Numeral del individuo.
     * @param Papa Nombre del padre.
     * @param Mama Nombre de la madre.
     * @param Apodo Apodo del individuo.
     * @param Titulo Título del individuo.
     * @param Casado Cónyuge del individuo.
     * @param Ojos Color de ojos.
     * @param Pelo Color de cabello.
     * @param Hijos Hijos del individuo.
     * @param Notas Notas adicionales.
     * @param Destino Destino del individuo.
     * 
     */
    public NodoArbol(String Nombre, String Numeral, String Papa, String Mama, String Apodo, String Titulo, String Casado, String Ojos, String Pelo, String Hijos, String Notas, String Destino) {
        this.Nombre = Nombre;
        this.Numeral = Numeral;
        this.Papa = Papa;
        this.Mama = Mama;
        this.Apodo = Apodo;
        this.Titulo = Titulo;
        this.Casado = Casado;
        this.Ojos = Ojos;
        this.Pelo = Pelo;
        this.Hijos = Hijos;
        this.Notas = Notas;
        this.Destino = Destino;
        this.fSon = null;
        this.nBrother = null;
    }

    

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the Numeral
     */
    public String getNumeral() {
        return Numeral;
    }
    
    /**
     * @return the fSon
     */
    public NodoArbol getfSon() {
        return fSon;
    }

    /**
     * @param fSon the fSon to set
     */
    public void setfSon(NodoArbol fSon) {
        this.fSon = fSon;
    }

    /**
     * @return the nBrother
     */
    public NodoArbol getnBrother() {
        return nBrother;
    }

    /**
     * @param nBrother the nBrother to set
     */
    public void setnBrother(NodoArbol nBrother) {
        this.nBrother = nBrother;
    }
    
     /**
     * Agrega un hijo al nodo actual. Si ya tiene hijos, el nuevo hijo será agregado como el hermano del último hijo existente.
     * @param hijo Nodo que representa al nuevo hijo.
     */
    public void AgregarHijo(NodoArbol hijo){
        if(fSon==null){
            this.setfSon(hijo);
        } else{
            NodoArbol PrimerHijo = this.getfSon();
            while(PrimerHijo.getnBrother() != null){
                PrimerHijo = PrimerHijo.getnBrother();
            }
            PrimerHijo.setnBrother(hijo);
        }
    }

    /**
     * @return the Mama
     */
    public String getMama() {
        return Mama;
    }

    /**
     * @return the Apodo
     */
    public String getApodo() {
        return Apodo;
    }

    /**
     * @return the Titulo
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @return the Casado
     */
    public String getCasado() {
        return Casado;
    }

    /**
     * @return the Ojos
     */
    public String getOjos() {
        return Ojos;
    }

    /**
     * @return the Pelo
     */
    public String getPelo() {
        return Pelo;
    }

    /**
     * @return the Hijos
     */
    public String getHijos() {
        return Hijos;
    }

    /**
     * @return the Notas
     */
    public String getNotas() {
        return Notas;
    }

    /**
     * @return the Destino
     */
    public String getDestino() {
        return Destino;
    }

    /**
     * @return the Papa
     */
    public String getPapa() {
        return Papa;
    }
    
    /**
     * Obtiene el nombre completo del individuo.
     * @return Cadena que contiene el nombre completo del individuo.
     */
    public String NombreCompleto(){
        return this.getNombre() + ", " + this.getNumeral() + " of his name, son of " + this.getPapa();
    }
    
    /**
     * Devuelve todos los datos del nodo en formato legible.
     * Si algún atributo no tiene valor(no se tiene informacion), se muestra como "???".
     * @return Cadena que contiene todos los atributos del nodo.
     */
    public String DevolverDatos(){
        String Mama = "";
        if(this.getMama().equals("")){
            Mama = "???";
        } else{
            Mama = this.getMama();
        }
        
        String Apodo = "";
        if(this.getApodo().equals("")){
            Apodo = "???";
        } else{
            Apodo = this.getApodo();
        }
        
        String Titulo = "";
        if(this.getTitulo().equals("")){
            Titulo = "???";
        } else{
            Titulo = this.getTitulo();
        }
        
        String Casado = "";
        if(this.getCasado().equals("")){
            Casado = "???";
        } else{
            Casado = this.getCasado();
        }
        
        String Hijos = "";
        if(this.getHijos().equals("")){
            Hijos = "???";
        } else{
            Hijos = this.getHijos();
        }
        
        String Notas = "";
        if(this.getNotas().equals("")){
            Notas = "???";
        } else{
            Notas = this.getNotas();
        }
        
        String Destino = "";
        if(this.getDestino().equals("")){
            Destino = "???";
        } else{
            Destino = this.getDestino();
        }
        
        String Datos = """
                       Nombre: %s
                       Numeral: %s
                       Padre: %s
                       Madre: %s
                       Apodo: %s
                       Titulo: %s
                       Esposa: %s
                       Ojos: %s
                       Pelo: %s
                       Hijos: %s
                       Notas: %s
                       Destino: %s
                       """.formatted(this.getNombre(), this.getNumeral(), this.getPapa(), Mama, Apodo, Titulo, Casado, this.getOjos(), this.getPelo(), Hijos, Notas, Destino);
        return Datos;
    }
}
