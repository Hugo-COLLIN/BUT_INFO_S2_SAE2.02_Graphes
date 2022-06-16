package experimentation;

import implementation.BellmanFord;
import implementation.Dijkstra;
import implementation.Valeur;
import representation.GrapheListe;

import java.util.Scanner;

/**
 * Tests de performances avec graphes generes automatiquement
 */
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
        tabRecap.append(duree).append("\t");
        return duree;
    }

    public static long geneGraphe(StringBuilder tabRecap, int i)
    {
        long dateInit = System.nanoTime();

        g = new GrapheListe();
        g.genererGraphe(i);

        long dateFin = System.nanoTime();

        long duree = dateFin - dateInit;
        tabRecap.append(duree).append("\t");
        return duree;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de noeuds : ");
        int nbNoeuds = sc.nextInt();
        System.out.print("Nombre d'essais : ");
        int nbEssais = sc.nextInt();

        double moyBF = 0, moyDj = 0, moyRatio = 0;

        StringBuilder tabRecap = new StringBuilder("NbNoeuds\tTpsGene\tTpsBF\tTpsDj\tRatioAlgos\n");
        for (int i = 1 ; i <= nbEssais ; i ++)
        {
            tabRecap.append(i).append("\t\t\t");
            double geneTps = geneGraphe(tabRecap, nbNoeuds);

            //Bellman-Ford
            BellmanFord bF = new BellmanFord();
            Valeur v1 = bF.resoudre(g, "1");
            double bFTps = calculVal(tabRecap, v1);
            moyBF += bFTps;

            //Dijkstra
            Dijkstra dj = new Dijkstra();
            Valeur v2 = dj.resoudre(g, "1");
            double djTps = calculVal(tabRecap, v2);
            moyDj += djTps;

            double ratio = djTps / bFTps;
            moyRatio += ratio;
            tabRecap.append(ratio).append("\t\n");

            double allTps = geneTps + bFTps + djTps;

            System.out.println("Essai " + i + " fait en " + (allTps / 10E6) + " mili-secondes");
        }

        moyBF /= nbEssais;
        moyDj /= nbEssais;
        moyRatio /= nbEssais;

        tabRecap.append("Tot :\t\t\t---\t").append(moyBF).append("\t").append(moyDj).append("\t").append(moyRatio);
        System.out.println(tabRecap);
    }
}
