package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Reader: Lee el fichero para montar el problema

public class Reader {
    
    String filename;
    ThreeSat ts;
    VertexCover vc;
    
    Reader(String f) {
        filename = f;
        ts = new ThreeSat();
        vc = new VertexCover();
    }
    
    void TSBuilder() throws FileNotFoundException {
        File file = new File(filename);                     // Creacion del fichero para su lectura
        Scanner scanner = new Scanner(file);                // Creacion del lector del fichero
        String line;                                        // Linea que se lee del fichero
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] aux = line.split(" ");
            if (aux.length == 1) {
                int numLiterals = Integer.parseInt(aux[0]);
                String nameLit;
                for (int i = 0; i < numLiterals; i++) {
                    nameLit = ("u" + (i+1));
                    Literal litP = new Literal(nameLit, false);
                    Literal litN = new Literal(nameLit, true);
                    vc.addLiteral(litP);
                    vc.addLiteral(litN);
                }
            }
            else {
                Clause clause = new Clause();
                for (int i = 0; i < aux.length; i++) {
                    Literal lit;
                    if("!".equals(aux[i].substring(0,1)))
                        lit = new Literal(aux[i].substring(1, aux[i].length()), true);
                    else
                        lit = new Literal(aux[i], false);
                    clause.addLiteral(lit);
                }
                ts.addClause(clause);
            }
        }
    }
    
    public VertexCover getVC() {
        return vc;
    }
    
    public ThreeSat getTS() {
        return ts;
    }
    
}
