package experimentation;

import implementation.BellmanFord;
import implementation.Valeur;
import representation.GrapheListe;

public class MainExperimentationGenere
{
    private static GrapheListe g;
    public static void geneGraphe(int i)
    {
        long dateInit = System.nanoTime();

        g = new GrapheListe();
        g.genererGrapheV2(i);

        long dateFin = System.nanoTime();
        System.out.print(dateFin - dateInit + "\t");
    }

    public static void bFResolv ()
    {
        BellmanFord bF = new BellmanFord();
        Valeur v = bF.resoudre(g, "1");
    }

    public static void main(String[] args) {

        System.out.println("NbNoeuds\tTpsGene\tTpsBF\tTpsDj\tRatioAlgos");
        for (int i = 50 ; i <= 1000 ; i += 50)
        {
            System.out.print(i + "\t");
            geneGraphe(i);

            bFResolv();

            System.out.println("");


        }

    }
}
