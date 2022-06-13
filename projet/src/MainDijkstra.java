import representation.GrapheListe;

import java.util.List;

public class MainDijkstra
{
    public static void main(String[] args) {

        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

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
