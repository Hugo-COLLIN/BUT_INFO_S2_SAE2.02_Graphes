import java.util.List;

/**
 * Classe permettant de representer les donnees associes a un graphe
 */
public class GrapheListe implements Graphe {
    /**
     * GrapheListe est definie par l ensemble des noms
     * des objets noeuds qu elle stocke, ainsi qu une liste
     * de noeuds permettant de stocker les arcs.
     */
    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    /**
     * Methode permettant de retourner la liste des noms des noeuds
     * du graphe
     * @return liste de String nom, attribut de la classe GrapheListe
     */
    @Override
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * Methode permettant de retourner les arcs
     * partant d un noeud
     * @param n noeud pour qui on souhaiterait connaitre
     *          les arcs partant de ce dernier
     * @return liste d arcs partant de Noeud n
     */
    @Override
    public List<Arc> suivants(String n) {
        throw new Error("A ecrire");
    }

    /**
     * Methode permettant d ajouter des noeuds et
     * des arcs a un objet GrapheListe.
     * @param depart nom du noeud de depart
     * @param destination nom du noeud d arrivee
     * @param cout cout de cet arc ajoute
     */
    public void ajouterArc(String depart, String destination, double cout) {
        throw new Error("A ecrire");
    }
}
