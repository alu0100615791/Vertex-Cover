package Main;


//Edge: Clase que indica una arista del grafo

public class Edge {
    
    Literal origin;
    Literal destination;
    boolean visited;
    
    Edge(Literal lo, Literal ld) {
        origin = lo;
        destination = ld;
        visited = false;
    }
    
    public Literal getOrigin() {
        return origin;
    }
    
    public Literal getDestination() {
        return destination;
    }
    
    public void setVisited() {
        visited = true;
    }
    
    public boolean getVisited() {
        return visited;
    }
    
}
