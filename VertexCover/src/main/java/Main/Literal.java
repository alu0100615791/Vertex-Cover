package Main;

import java.util.ArrayList;
import java.util.List;


// Clase Literal: Define las literales de una instancia 3Sat

public class Literal {
    
    String name;            // Nombre del literal
    boolean negative;       // Indica si el literal tiene valor negativo o positivo
    List<Edge> edges;       // Lista de aristas del literal
    
    Literal(String n, boolean ng) {
        edges = new ArrayList<Edge>();
        negative = ng;
        if (negative == true)
            name = ("-"+n);
        else
            name = n;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getNegative() {
        return negative;
    }
    
    public void addEdge(Literal o, Literal d) {
        Edge edge = new Edge(o,d);
        edges.add(edge);
    }
    
    public int getNumEdges() {
        return edges.size();
    }
    
    public void setName(String n) {
        name = n;
    }
}
