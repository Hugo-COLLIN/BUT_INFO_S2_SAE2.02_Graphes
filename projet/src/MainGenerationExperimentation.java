import representation.Graphe;
import representation.GrapheListe;

public class MainGenerationExperimentation
{
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.genererGraphe(1000);
        //System.out.println(g);
        System.out.println(g.toGraphviz());
    }
}