package Main;

import java.util.ArrayList;
import java.util.List;

//ThreeSat: Clase para crear instancias de 3 sat

public class ThreeSat {
    
    List<Clause> clauses; //Conjunto de clausulas del 3 sat
    
    ThreeSat() {
        clauses = new ArrayList<Clause>();
    }
    
    public void addClause (Clause c) {
        clauses.add(c);
    }
    
    public List<Clause> getClauses() {
        return clauses;
    }
    
}
