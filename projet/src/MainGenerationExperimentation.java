import representation.GrapheListe;

public class MainGenerationExperimentation
{
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        //g.genererGrapheV1(1000);
        g.genererGrapheV2(10);
        System.out.println(g.toGraphviz());
    }
}
