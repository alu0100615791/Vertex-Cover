package Main;

import java.util.ArrayList;
import java.util.List;

//Clause: Define una clausula del 3 sat

public class Clause {
    
    List<Literal> literals;
    
    Clause() {
        literals = new ArrayList<Literal>();
    }
    
    public void addLiteral(Literal l) {
        literals.add(l);
    }
    
    public List<Literal> getLiterals() {
        return literals;
    }
}
