package experimentation;

import representation.Graphe;
import representation.GrapheListe;

public class MainGeneration
{
    public static void main(String[] args)
    {
        GrapheListe g = new GrapheListe();
        g.genererGrapheV2(1);
        //System.out.println(g);
        System.out.println(g.toGraphviz());
    }
}
