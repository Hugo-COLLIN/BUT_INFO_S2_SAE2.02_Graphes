import representation.Graphe;
import representation.GrapheListe;

import java.io.IOException;

public class MainExperimentation
{
    public static void main(String[] args) throws IOException
    {
        Graphe g = new GrapheListe("resources/Graphe_exemple1.txt");

        System.out.println("\n------------------\nBellman Ford :\n------------------");
        BellmanFord bF = new BellmanFord();
        Valeur v1 = bF.resoudre(g, "A");

        //Dijkstra
        //Dijkstra dj = new Dijkstra();
        //Valeur v2 = dj.resoudre(g, "A");


    }
}
