package laby;

import implementation.BellmanFord;
import implementation.Valeur;
import representation.GrapheListe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Q30
 */
public class MainGenGrapheLaby
{
    public static void main(String[] args) throws IOException
    {
        Labyrinthe labyrinthe;
        GrapheListe g;
        List<Valeur> valsGraphes = new ArrayList<>();
        File rep = new File("resources/labySimple/");

        for (File fichier : rep.listFiles())
        {
            labyrinthe = new Labyrinthe(fichier.getPath());
            g = labyrinthe.genererGraphe();
            //System.out.println(g);
            System.out.println(g.toGraphviz());

            BellmanFord bF = new BellmanFord();
            Valeur v = bF.resoudre(g, "\"(1,1)\"");
            valsGraphes.add(v);

            //System.out.println(v.calculerChemin("\"(5,2)\""));
        }

        System.out.println("\n" + valsGraphes.get(0).calculerChemin("\"(5,2)\""));
        System.out.println(valsGraphes.get(1).calculerChemin("\"(8,5)\""));
        System.out.println(valsGraphes.get(2).calculerChemin("\"(15,2)\""));
    }
}
