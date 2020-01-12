package Main;

import java.util.ArrayList;
import java.util.List;


//Graph Clase que almacena el grafo creado

public class Graph {
    
    List<Literal> literals;
    
    Graph() {
        literals = new ArrayList<Literal>();
    }
    
    public void addLiteral(Literal l) {
        literals.add(l);
    }
    
    public void addLiteralBegin(Literal l) {
        literals.add(0, l);
    }
    
    public void showGraph() {
        for (int i = 0; i < literals.size(); i ++) {
            System.out.println(literals.get(i).getName());
            System.out.println("-----");
            for (int j = 0; j < literals.get(i).getNumEdges(); j++)
                System.out.println(literals.get(i).edges.get(j).getOrigin().getName() + " --> " + literals.get(i).edges.get(j).getDestination().getName());
            System.out.println("\n");
        }
    }
    
    public List<Literal> getNodes() {
        return literals;
    }
    
    public int getNumEdges() {
        int n = 0;
        for (int i = 0; i < literals.size(); i++) {
            for (int j = 0; j < literals.get(i).getNumEdges(); j++) {
                n++;
            }
        }
        return n;
    }
    
}
