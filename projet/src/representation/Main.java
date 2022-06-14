package representation;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        System.out.println(g);
        System.out.println(g.toGraphviz());

        Graphe g2 = new GrapheListe("resources/Graphe_exemple1.txt");
        System.out.println(g2);

    }
}
