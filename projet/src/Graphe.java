import java.util.List;

public interface Graphe {

    /**
     * Methode retournant tous les noeuds du graphe
     * sous la forme d une liste de noms des Noeuds
     */
    public List<String> listeNoeuds();

    /**
     * Methode retournant tous les arcs partant du
     * noeud dont le nom est en parametre, sous la forme
     * d une liste d arcs
     */
    public List<Arc> suivants(String n);

}
