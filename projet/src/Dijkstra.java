import representation.Graphe;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme
{

    @Override
    public Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();
        List<String> q = new ArrayList<>();

        //init
        valeur.setValeur(depart, 0);
        for (String nomNoeud : g.listeNoeuds())
            if (!depart.equals(nomNoeud))
            {
                valeur.setValeur(nomNoeud, Double.MAX_VALUE);
                q.add(nomNoeud);
            }

        while (q.size() != 0)
        {
            double tmp;
            for (String s : q);
        }




        //for (String s : g.listeNoeuds())
        return null;
    }
    /*
    Entr´ees :
    G un graphe orient´e avec une pond´eration (poids) positive des arcs
    A un sommet (d´epart) de G
    D´ebut
    Q <- {} // utilisation d’une liste de noeuds `a traiter
    Pour chaque sommet v de G faire
    v.distance <- Infini
    v.parent <- Ind´efini
    Q <- Q U {v} // ajouter le sommet v `a la liste Q
    Fin Pour
    A.distance <- 0
    Tant que Q est un ensemble non vide faire
    u <- un sommet de Q telle que u.distance est minimale
    Q <- Q \ {u} // enlever le sommet u de la liste Q
    Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
    D <- u.distance + poids(u,v)
    Si D < v.distance
    Alors v.distance <- D
    v.parent <- u
    Fin Si
    Fin Pour
    Fin Tant que
    Fin
     */
}
