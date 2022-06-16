package experimentation;

import representation.GrapheListe;

/**
 * Graphviz avec graphes generes
 */
public class MainGeneration
{
    public static void main(String[] args)
    {
        GrapheListe g = new GrapheListe();
        g.genererGraphe(1);
        //System.out.println(g);
        System.out.println(g.toGraphviz());
    }
}
