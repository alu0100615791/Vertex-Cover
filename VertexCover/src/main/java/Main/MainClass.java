package Main;

import java.io.FileNotFoundException;
import java.util.Scanner;

//MainClass: Clase Principal

public class MainClass {
    public static void main (String [ ] args) throws FileNotFoundException {
        String fn;
        System.out.println("Introduce el nombre del fichero 3Sat: ");
        Scanner scanner = new Scanner(System.in);
        fn = scanner.nextLine();
        Reader rd = new Reader(fn);
        
        rd.TSBuilder();
        ThreeSat ts = rd.getTS();
        VertexCover vc = rd.getVC();
        vc.setTS(ts);
        vc.createGraph();
        vc.showGraph();
        vc.printVC();
    }
}
