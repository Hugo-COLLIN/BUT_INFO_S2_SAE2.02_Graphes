package experimentation;

import implementation.BellmanFord;
import implementation.Dijkstra;
import implementation.Valeur;
import representation.GrapheListe;

import java.io.IOException;
import java.util.Scanner;

public class MainExperimentationGenere
{
    private static GrapheListe g;

    private static long calculVal(StringBuilder tabRecap, Valeur v)
    {
        long debtTps, finTps;

        debtTps = System.nanoTime();
        v.calculerChemin("E");
        finTps = System.nanoTime();
        long duree = finTps - debtTps;
        tabRecap.append(duree + "\t");
        return duree;
    }

    public static void geneGraphe(StringBuilder tabRecap, int i)
    {
        long dateInit = System.nanoTime();

        g = new GrapheListe();
        g.genererGrapheV2(i);

        long dateFin = System.nanoTime();

        long duree = dateFin - dateInit;
        tabRecap.append(duree).append("\t");
    }

    public static void bFResolv ()
    {
        BellmanFord bF = new BellmanFord();
        Valeur v = bF.resoudre(g, "1");
    }

    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de noeuds : ");
        int nbNoeuds = sc.nextInt();
        System.out.println("Nombre d'essais : ");
        int nbEssais = sc.nextInt();
*/

        StringBuilder tabRecap = new StringBuilder("NbNoeuds\tTpsGene\tTpsBF\tTpsDj\tRatioAlgos\n");
        for (int i = 1 ; i <= 1000 ; i ++)
        {
            tabRecap.append(i + "\t\t\t");
            geneGraphe(tabRecap, i);
            //g.genererGrapheV2(i);


            //Bellman-Ford
            //System.out.println("\n------------------\nBellman Ford :\n------------------");
            BellmanFord bF = new BellmanFord();
            Valeur v1 = bF.resoudre(g, "1");
            double bFTps = calculVal(tabRecap, v1);

            //Dijkstra
            //System.out.println("\n------------------\nDijkstra :\n------------------");
            Dijkstra dj = new Dijkstra();
            Valeur v2 = dj.resoudre(g, "1");
            double djTps = calculVal(tabRecap, v2);

            double ratio = djTps / bFTps;

            tabRecap.append(ratio).append("\t");

            tabRecap.append("\n");

            if (i % 10 >= 5)
                if (String.valueOf(i).length() <= 2)
                    i += 5;
                else
                    i += 95;
            System.out.println(tabRecap);
        }



    }
}
