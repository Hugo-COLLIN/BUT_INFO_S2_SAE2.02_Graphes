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

    public GrapheListe ()
    {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

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
        Noeud nD=new Noeud(depart);
        Noeud nA=new Noeud(destination);
        ensNoeuds.add(nD);
        ensNoeuds.add(nA);
        ensNom.add(depart);
        ensNom.add(destination);
        boolean noeudTrouveDepart=false;
        boolean noeudTrouveArrive=false;
        int iD=-1;
        int iA=-1;
        for (int i=0; i<this.ensNoeuds.size(); i++) {
            if (this.ensNoeuds.get(i).getNom().equals(depart)) {
                noeudTrouveDepart=true;
                iD=i;
            }
            if (this.ensNoeuds.get(i).getNom().equals(destination)) {
                noeudTrouveArrive=true;
                iA=i;
            }
        }
        if ((noeudTrouveArrive)&&(noeudTrouveDepart)) {
            ensNoeuds.get(iD).ajouterArc(ensNoeuds.get(iA).getNom(), cout);
        }
    }

    public String toString() {
        StringBuilder msg=new StringBuilder("");
        for (int i=0; i<this.ensNoeuds.size(); i++) {
            msg.append(this.ensNoeuds.get(i).getNom()+" -> ");
            for (int j=0; j<this.ensNoeuds.get(i).getAdj().size(); j++) {
                msg.append(this.ensNoeuds.get(i).getAdj().get(j).getDest()
                + "(" + this.ensNoeuds.get(i).getAdj().get(j).getCout() + ")");
            }
            msg.append("\n");
        }
        return msg.toString();
    }

    //Getter
    public ArrayList<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }

    //Setters
    public void setNom(String nom) {
        this.ensNom.add(nom);
    }

    public void setEnsNoeuds(ArrayList<Noeud> ensNoeuds) {
        this.ensNoeuds = ensNoeuds;
    }

}
