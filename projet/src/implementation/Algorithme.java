package implementation;

import representation.Graphe;

public interface Algorithme
{
    /**
     * Permet de calculer le plus court chemin
     * @param g graphe
     * @param depart noeud de depart
     * @return Objet valeur contenant le plus court chemin pour chaque noeud
     */
    public Valeur resoudre(Graphe g, String depart);
}
