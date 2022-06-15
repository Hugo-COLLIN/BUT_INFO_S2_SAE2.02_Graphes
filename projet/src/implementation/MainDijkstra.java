package implementation;

import representation.GrapheListe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainDijkstra
{
    public static void main(String[] args) throws IOException {
        String [] fichiers ={"resources/Graphe_exemple1.txt", "resources/Graphe_boucle.txt"};

        for (String fichier : fichiers)
        {
            GrapheListe g = new GrapheListe(fichier);

            //Resolution des plus courts chemins du graphe g avec Dijkstra
            Dijkstra dj = new Dijkstra();
            Valeur v = dj.resoudre(g, "A");

            //Chemin pour chaque noeud
            for (String noeud : g.listeNoeuds())
            {
                List<String> chemin = v.calculerChemin(noeud);
                System.out.println(noeud + " : " + chemin);
            }
            System.out.println("-------------------------------------------------\n");
        }
    }
}
