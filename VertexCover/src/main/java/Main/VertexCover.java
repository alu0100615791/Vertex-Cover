package Main;

import java.util.ArrayList;
import java.util.List;


//VertexCover: Se encarga de crear el grafo a partir de la instancia del 3 sat y calcular la cobertura de vertices

public class VertexCover {
    
    List<Literal> literals;         // literales
    ThreeSat ts;                    // Instancia del 3 sat
    Graph graph;                    // grafo creado
    
    VertexCover() {
        literals = new ArrayList<Literal>();
    }
    
    public void addLiteral(Literal l) {
        literals.add(l);
    }
    
    
    //Funcion que crea el grafo a partir de la instancia del 3 sat
    
    public void createGraph() {
        graph = new Graph();
        for (int i = 0; i < literals.size(); i++) {
            if (((i+1) % 2) == 0) {
                literals.get(i).addEdge(literals.get(i), literals.get(i-1));
                literals.get(i-1).addEdge(literals.get(i-1), literals.get(i));
            }     
        }
        List<Clause> clauses = ts.getClauses();
        List<Literal> literalsC;
        for (int i = 0; i < ts.clauses.size(); i++) {
            literalsC = clauses.get(i).getLiterals();
            literalsC.get(0).addEdge(literalsC.get(0), literalsC.get(1));
            literalsC.get(0).addEdge(literalsC.get(0), literalsC.get(2));
            literalsC.get(1).addEdge(literalsC.get(1), literalsC.get(2));
            literalsC.get(1).addEdge(literalsC.get(1), literalsC.get(0));
            literalsC.get(2).addEdge(literalsC.get(2), literalsC.get(1));
            literalsC.get(2).addEdge(literalsC.get(2), literalsC.get(0));
            for (int j = 0; j < literals.size(); j++) {
                if(literals.get(j).getName().equals(literalsC.get(0).getName())) {
                    literals.get(j).addEdge(literals.get(j), literalsC.get(0));
                    literalsC.get(0).addEdge(literalsC.get(0), literals.get(j));
                }
                else if(literals.get(j).getName().equals(literalsC.get(1).getName())) {
                    literals.get(j).addEdge(literals.get(j), literalsC.get(1));
                    literalsC.get(1).addEdge(literalsC.get(1), literals.get(j));
                }
                else if(literals.get(j).getName().equals(literalsC.get(2).getName())) {
                    literals.get(j).addEdge(literals.get(j), literalsC.get(2));
                    literalsC.get(2).addEdge(literalsC.get(2), literals.get(j));
                }
            }
            graph.addLiteral(literalsC.get(0));
            graph.addLiteral(literalsC.get(1));
            graph.addLiteral(literalsC.get(2));
        }
        for (int h = 0; h < literals.size(); h++) {
            int aux = (literals.size() - 1) - h;
            literals.get(aux).setName(literals.get(aux).getName() + "L");
            graph.addLiteralBegin(literals.get(aux));
        }
    }
    
    public void showGraph() {
        graph.showGraph();
    }
    
    public void setTS(ThreeSat t) {
        ts = t;
    }
    
    
    //Funcion que calcula el problema de cobertura de vertices
    
    public void printVC() {
        List<Literal> literalsVC = new ArrayList<Literal>();
        for (int i = 0; i < graph.literals.size(); i++) {
            for (int j = 0; j < graph.literals.get(i).getNumEdges(); j++) {
                if (graph.literals.get(i).edges.get(j).getVisited() == false) {
                    if (!literalsVC.contains(graph.literals.get(i).edges.get(j).getOrigin()))
                        literalsVC.add(graph.literals.get(i).edges.get(j).getOrigin());
                    for (int h = 0; h < graph.literals.size(); h++) {
                        for (int k = 0; k < graph.literals.get(h).getNumEdges(); k++) {
                            if (graph.literals.get(i).edges.get(j).getOrigin() == graph.literals.get(h).edges.get(k).getDestination() && graph.literals.get(i).edges.get(j).getDestination() == graph.literals.get(h).edges.get(k).getOrigin())
                                graph.literals.get(h).edges.get(k).setVisited();
                        }
                    }    
                }
            }
        }
        System.out.println("Literales que forman la Cobertura de vertices:");
        for (int i = 0; i < literalsVC.size(); i++) {
            System.out.println(literalsVC.get(i).getName());
        }
    }
    
}
