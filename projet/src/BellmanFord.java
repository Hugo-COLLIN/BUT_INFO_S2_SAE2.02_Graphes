import representation.Arc;
import representation.Graphe;
import representation.GrapheListe;

import java.util.List;
import java.util.Objects;

public class BellmanFord
{
    public Valeur resoudre(Graphe g, String depart)
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
        boolean isPtFixe = false;
        do {
            isPtFixe = true;
            for (int i = 0 ; i < g.listeNoeuds().size() ; i ++)
            {
                for (int j = 0 ; j < g.suivants(g.listeNoeuds().get(i)).size() ; j ++)
                {
                    String tmpNoeud = g.suivants(g.listeNoeuds().get(i)).get(j).getDest();
                    double tmpActualVal= valeur.getValeur(tmpNoeud);
                    double tmpNewVal = valeur.getValeur(g.listeNoeuds().get(i)) + g.suivants(g.listeNoeuds().get(i)).get(j).getCout();
                    if (tmpNewVal < tmpActualVal)
                    {
                        valeur.setValeur(tmpNoeud, tmpNewVal);
                        valeur.setParent(tmpNoeud, g.listeNoeuds().get(i));
                        isPtFixe = false;
                    }

                    //g.suivants(g.listeNoeuds().get(i)).get(j).getCout()
                }

            }
        }
        while (!isPtFixe);


        return valeur;
    }
}

// String tmpNoeud=suivants().getDest();
//tmpVal=v.getValeur(tmpNoeud);
//if ((v.getValeur(g.listeNoeuds().get(i)) + g.listeNoeuds().suivants().get(j).getCout()) > tmpVal)
//	v.setValeur(tmpVal, g.listeNoueds().get(i))