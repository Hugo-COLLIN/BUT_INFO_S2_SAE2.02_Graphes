import representation.GrapheListe;

import java.io.IOException;
import java.util.List;

public class MainDijkstra
{
    public static void main(String[] args) throws IOException {

        GrapheListe g = new GrapheListe("resources/Graphe_exemple1.txt");

        //System.out.println(g);

        Dijkstra dj = new Dijkstra();
        Valeur v = dj.resoudre(g, "A");
        System.out.println(v);

        List<String> cheminE = v.calculerChemin("E");
        System.out.println(cheminE);

        List<String> cheminC = v.calculerChemin("C");
        System.out.println(cheminC);
    }
}
