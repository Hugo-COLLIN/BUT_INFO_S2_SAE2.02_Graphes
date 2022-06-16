package implementation;

import representation.Arc;
import representation.Graphe;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme
{

    public Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();
        List<String> nomsNoeudsParcours = new ArrayList<>();

        //init
        valeur.setValeur(depart, 0);
        nomsNoeudsParcours.add(depart);
        for (String nomNoeud : g.listeNoeuds())
            if (!depart.equals(nomNoeud)) {
                valeur.setValeur(nomNoeud, Double.MAX_VALUE);
                nomsNoeudsParcours.add(nomNoeud);
            }
        //System.out.println(valeur);

        //Recherche du chemin le plus court
        double distMin, d;
        String nomNoeudDistMin = depart;
        List<Arc> arcsSuivants = g.suivants(nomNoeudDistMin);
        boolean endBoucle = false;

        while (!endBoucle) {
            for (Arc arcSuivant : arcsSuivants) {
                distMin = valeur.getValeur(nomNoeudDistMin) + arcSuivant.getCout();
                String nomNoeudSuivant = arcSuivant.getDest();
                if (valeur.getValeur(nomNoeudSuivant) > distMin) {
                    valeur.setValeur(nomNoeudSuivant, distMin);
                    valeur.setParent(nomNoeudSuivant, nomNoeudDistMin);
                }
            }
            nomsNoeudsParcours.remove(nomNoeudDistMin);


            if (nomsNoeudsParcours.isEmpty())
                endBoucle = true;
            else {
                nomNoeudDistMin = nomsNoeudsParcours.get(nomsNoeudsParcours.size() - 1);
                d = valeur.getValeur(nomNoeudDistMin);
                for (int i = 0; i < nomsNoeudsParcours.size() - 1; i++)
                    if (d > valeur.getValeur(nomsNoeudsParcours.get(i))) {
                        nomNoeudDistMin = nomsNoeudsParcours.get(i);
                        d = valeur.getValeur(nomNoeudDistMin);
                    }
            }
            arcsSuivants = g.suivants(nomNoeudDistMin);
            //System.out.println(valeur);
        }
        return valeur;
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