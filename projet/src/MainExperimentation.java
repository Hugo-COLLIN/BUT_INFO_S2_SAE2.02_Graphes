import implementation.BellmanFord;
import implementation.Dijkstra;
import implementation.Valeur;
import representation.Graphe;
import representation.GrapheListe;

import java.io.File;
import java.io.IOException;

public class MainExperimentation
{
    private static void calculVal(StringBuilder tabRecap, Valeur v)
    {
        long debtTps, finTps;

        debtTps = System.nanoTime();
        v.calculerChemin("E");
        finTps = System.nanoTime();
        tabRecap.append(finTps - debtTps);
        tabRecap.append("\t");
    }

    public static void main(String[] args) throws IOException
    {
        String [] fichiers = {"resources/Graphe_exemple1.txt", "resources/Graphe_boucle.txt"};

        //File f = new File("resource");

        StringBuilder tabRecap = new StringBuilder("TpsApproche\t\t\t\t\t\tbF:E\t\tDj:E\n");
        for (String fichier : fichiers) {
            Graphe g = new GrapheListe(fichier);
            tabRecap.append(fichier + "\t");

            //Bellman-Ford
            System.out.println("\n------------------\nBellman Ford :\n------------------");
            BellmanFord bF = new BellmanFord();
            Valeur v1 = bF.resoudre(g, "A");

            calculVal(tabRecap, v1);

            /*
            debtTps = System.nanoTime();
            v1.calculerChemin("E");
            finTps = System.nanoTime();
            tabRecap.append(finTps - debtTps);
            tabRecap.append("\t");
*/

            //Dijkstra
            System.out.println("\n------------------\nDijkstra :\n------------------");
            Dijkstra dj = new Dijkstra();
            Valeur v2 = dj.resoudre(g, "A");

            calculVal(tabRecap, v2);

            /*
            debtTps = System.nanoTime();
            v2.calculerChemin("E");
            finTps = System.nanoTime();
            tabRecap.append(finTps - debtTps);
            tabRecap.append("\t");

             */

            tabRecap.append("\n");
        }
        System.out.println(tabRecap);
    }
}
