package implementation;

import representation.Graphe;

public class BellmanFord implements Algorithme
{
    public Valeur resoudre(Graphe g, String depart)
    {
        Valeur valeur = new Valeur();

        //init
        valeur.setValeur(depart, 0);

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
                }
            }
            //System.out.println(valeur);
        }
        while (!isPtFixe);


        return valeur;
    }
}

/*
fonction pointFixe (Graphe g InOut, Noeud depart)
début
// initialisation
L(depart) <- 0
pour i allant de 0 à g.listeNoeuds().size() faire
	si g.listeNoeuds().get(i) =/= depart faire
		L(g.ListeNoeuds().get(i)) <- + infini
	fin si
fin pour
// fin initialisation
// étapes
boolean pointFixe = faux
tant que (!pointFixe) faire
	pointFixe <- vrai
	pour i allant de 0 à g.ListeNoeuds().size() faire
		pour j allant de 0 à g.suivants(g.ListeNoeuds().get(i)).size faire
			tmpNoeud <- g.suivants(g.listeNoeuds().get(i)).get(j).getDest()
			tmpActualVal <- L(tmpNoeud)
tmpNewVal <- L((g.listeNoeuds().get(i)) + g.suivants(g.listeNoeuds().get(i)).get(j).getCout()
			si (tmpNewVal < tmpActualVal) faire
				L(tmpNoeud) <- tmpNewVal
				L(tmpNoeud).setParent <- g.listeNoeuds().get(i)
				pointFixe <- faux
			fsi
		fpour
	fpour
ftantque
fin

Lexique:
g : Graphe, graphe étudié
depart : Noeud, noeud d'origine du chemin recherché
L : valeur de la distance entre le noeud d'origine et le noeud en paramètre de L
i : entier, itération
pointFixe : booléen, vrai si deux étapes successives se répètent (c'est-à-dire il n'y a eu aucun changement entre deux étapes). Il correspond à l'état de point fixe.
j : entier, itération
tmpNoeud : Noeud, valeur courante du Noeud de destination par rapport au Noeud étudié dans la boucle.
tmpActualVal : réel, valeur courante de tmpNoeud (L(tmpNoeud))
tmpNewVal : réel, valeur courante du Noeud étudié dans la boucle additionnée au coût de l'arc le reliant à tmpNoeud
 */