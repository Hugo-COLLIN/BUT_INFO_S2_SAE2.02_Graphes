package implementation;

import representation.Graphe;

public class BellmanFord implements Algorithme
{
    public Valeur resoudre(Graphe g, String depart)
    {
        Valeur valeur = new Valeur();
        //g = (GrapheListe)g;

        //init
        valeur.setValeur(depart, 0);
        /*
        //List<Arc> lA = g.suivants(g.listeNoeuds().get(i))
        for (int i = 0; i < g.listeNoeuds().size() ; i ++)
            if (!depart.equals(g.listeNoeuds().get(i)))
                valeur.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);

         */

        for (String nomNoeud : g.listeNoeuds())
            if (!depart.equals(nomNoeud))
                valeur.setValeur(nomNoeud, Double.MAX_VALUE);
        //System.out.println(valeur);

        //etapes
        boolean isPtFixe;
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
                    //System.out.println(i + "\t" + j + "\t" + valeur.valeur + "\t" + valeur.parent);
                }
            }
            //System.out.println(valeur);
        }
        while (!isPtFixe);


        return valeur;
    }
}

// String tmpNoeud=suivants().getDest();
//tmpVal=v.getValeur(tmpNoeud);
//if ((v.getValeur(g.listeNoeuds().get(i)) + g.listeNoeuds().suivants().get(j).getCout()) > tmpVal)
//	v.setValeur(tmpVal, g.listeNoueds().get(i))