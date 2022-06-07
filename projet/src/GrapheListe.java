import java.util.ArrayList;
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
    private ArrayList<String> ensNom;
    private ArrayList<Noeud> ensNoeuds;

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
        List<Arc> s=new ArrayList<>();
        for (int i=0; i<this.ensNoeuds.size(); i++) {
            if (n.equals(ensNoeuds.get(i).getNom())) {
                s=ensNoeuds.get(i).getAdj();
            }
        }
        return s;
    }

    /**
     * Methode permettant d ajouter des noeuds et
     * des arcs a un objet GrapheListe.
     * @param depart nom du noeud de depart
     * @param destination nom du noeud d arrivee
     * @param cout cout de cet arc ajoute
     */
    public void ajouterArc(String depart, String destination, double cout) {
        boolean noeudTrouveDepart=false;
        boolean noeudTrouveArrive=false;
        for (int i=0; i<this.ensNom.size(); i++) {
            if (this.ensNom.get(i).equals(depart)) {
                noeudTrouveDepart=true;
            }
            if (this.ensNom.get(i).equals(destination)) {
                noeudTrouveArrive=true;
            }
        }
        if ((noeudTrouveArrive)&&(noeudTrouveDepart)) {
            this.ens
        }
        throw new Error("A ecrire");
    }
}
