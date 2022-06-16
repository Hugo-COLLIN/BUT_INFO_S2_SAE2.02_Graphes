package representation;

import java.util.List;

/**
 * Interface permettant de creer des objets de type Graphe
 */
public interface Graphe {

    /**
     * Methode retournant tous les noeuds du graphe
     * sous la forme d une liste de noms des Noeuds
     */
    List<String> listeNoeuds();

    /**
     * Methode retournant tous les arcs partant du
     * noeud dont le nom est en parametre, sous la forme
     * d une liste d arcs
     */
    List<Arc> suivants(String n);

}
