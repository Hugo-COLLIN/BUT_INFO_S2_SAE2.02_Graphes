package laby;

import representation.GrapheListe;

import java.io.IOException;

public class MainGenGrapheLaby
{
    public static void main(String[] args) throws IOException
    {
        Labyrinthe labyrinthe = new Labyrinthe("resources/labySimple/laby0.txt");
        GrapheListe g = new GrapheListe();

        g = labyrinthe.genererGraphe();

        System.out.println(g);
        System.out.println(g.toGraphviz());

    }
}
