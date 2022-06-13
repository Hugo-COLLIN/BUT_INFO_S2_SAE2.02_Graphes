import representation.Arc;
import representation.Graphe;
import representation.GrapheListe;

import java.util.List;
import java.util.Objects;

public class BellmanFord
{
    Valeur resoudre(Graphe g, String depart)
    {
        Valeur valeur = new Valeur();
        //g = (GrapheListe)g;

        //init
        valeur.setValeur(depart, 0);
        for (int i = 0; i < g.listeNoeuds().size() ; i ++)
        {
            if (!depart.equals(g.listeNoeuds().get(i)))
                valeur.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            //List<Arc> lA = g.suivants(g.listeNoeuds().get(i))
        }

        //etapes
        boolean isPtFixe;
        do {
            isPtFixe = true;
            for (int i = 0 ; i < g.listeNoeuds().size() ; i ++)
            {
                for (int j = 0 ; j < g.suivants(g.listeNoeuds().get(i)).size() ; j ++)
                {
                    g.suivants(g.listeNoeuds().get(i)).get(j).getCout()
                }

                    /*for (String s : g.listeNoeuds())
                {
                    if (valeur.getValeur(s) > valeur.getValeur(g.listeNoeuds().get(i) + ))
                }*/
            }
        }
        while (!isPtFixe);


        return valeur;
    }
}
