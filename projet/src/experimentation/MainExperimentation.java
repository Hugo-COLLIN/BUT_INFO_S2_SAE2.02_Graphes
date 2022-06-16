package experimentation;

import implementation.BellmanFord;
import implementation.Dijkstra;
import implementation.Valeur;
import representation.Graphe;
import representation.GrapheListe;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Tests de performances avec graphes sous forme de fichiers
 */
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
        String pathName = "resources/graphes_exemples/";
        File repertoire = new File(pathName);

        StringBuilder tabRecap = new StringBuilder("TpsApproche\t\t\t\t\t\tbF:E\t\tDj:E\n");
        for (File fichier : Objects.requireNonNull(repertoire.listFiles())) {
            Graphe g = new GrapheListe(pathName + fichier.getName());
            tabRecap.append(fichier.getName() + "\t");

            //Bellman-Ford
            System.out.println("\n------------------\nBellman Ford :\n------------------");
            BellmanFord bF = new BellmanFord();
            Valeur v1 = bF.resoudre(g, "A");
            calculVal(tabRecap, v1);

            //Dijkstra
            System.out.println("\n------------------\nDijkstra :\n------------------");
            Dijkstra dj = new Dijkstra();
            Valeur v2 = dj.resoudre(g, "A");
            calculVal(tabRecap, v2);

            tabRecap.append("\n");
        }
        System.out.println(tabRecap);
    }
}
