package laby;

import implementation.BellmanFord;
import implementation.Valeur;
import representation.GrapheListe;

import java.io.File;
import java.io.IOException;

public class MainGenGrapheLaby
{
    public static void main(String[] args) throws IOException
    {
        Labyrinthe labyrinthe;
        GrapheListe g;
        File rep = new File("resources/labySimple/");

        for (File fichier : rep.listFiles())
        {
            labyrinthe = new Labyrinthe(fichier.getPath());
            g = labyrinthe.genererGraphe();
            //System.out.println(g);
            System.out.println(g.toGraphviz());

            BellmanFord bF = new BellmanFord();
            Valeur v = bF.resoudre(g, "\"(1,1)\"");

        }
    }
}
