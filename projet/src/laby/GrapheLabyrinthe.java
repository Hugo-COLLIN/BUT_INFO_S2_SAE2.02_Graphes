package laby;

import representation.Arc;
import representation.Graphe;
import representation.Noeud;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Q31
 */
public class GrapheLabyrinthe implements Graphe
{
    //Attributes
    Labyrinthe laby;

    public GrapheLabyrinthe (Labyrinthe l)
    {
        this.laby = l;
    }

    /**
     * Methode retournant tous les noeuds du graphe
     * sous la forme d une liste de noms des Noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        return null;
    }

    /**
     * Methode retournant tous les arcs partant du
     * noeud dont le nom est en parametre, sous la forme
     * d une liste d arcs
     *
     * @param n
     */
    @Override
    public List<Arc> suivants(String n) {
        /*
        for (String action : Labyrinthe.ACTIONS)
        {

        }
        List<Arc> s = new ArrayList<>();

        for (int [] noeud : Labyrinthe.getSuivant())
            if (n.equals(noeud.getNom()))
                s = noeud.getAdj();

        return s;*/
        return null;
    }
}
