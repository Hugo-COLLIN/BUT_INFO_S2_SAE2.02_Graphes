import representation.Graphe;
import representation.GrapheListe;

import java.io.IOException;

public class MainExperimentation
{
    public static void main(String[] args) throws IOException
    {
        Graphe g = new GrapheListe("resources/Graphe_exemple1.txt");

        //Bellman Ford
        BellmanFord bF = new BellmanFord();
        Valeur v1 = bF.resoudre(g, "A");
        //System.out.println(v1);
        //System.out.println(v1.valeur);
        //System.out.println(v1.parent);

        //Dijkstra
        BellmanFord dj = new BellmanFord();
        Valeur v2 = dj.resoudre(g, "A");


    }
}
