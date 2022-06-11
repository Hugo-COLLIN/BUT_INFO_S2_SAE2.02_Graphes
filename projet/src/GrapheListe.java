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
    public void ajouterArc(String depart, String destination, double cout)
    {
        // creation et ajout des noeuds en parametre
        ajouterNoeud(depart);
        ajouterNoeud(destination);

        // verification que les noeuds existent bien dans les listes
        boolean noeudTrouveDepart=false;
        boolean noeudTrouveArrive=false;

        // indice des noeuds (iD = indice depart, iA = indice destination)
        int iD=-1;
        int iA=-1;

        // parcours des listes pour verifier la presence des noeuds et leurs positions
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

        // si les noeuds existent alors on peut ajouter l arc avec le cout en parametre
        if ((noeudTrouveArrive)&&(noeudTrouveDepart)) {
            ensNoeuds.get(iD).ajouterArc(ensNoeuds.get(iA).getNom(), cout);
        }
    }

    /**
     * Verifie si un noeud identique (meme nom) existe deja dans le graphe. Si c'est un nouveau
     * noeud, la methode ajoute le nom du noeud dans ensNom, cree un objet noeud correspondant
     * et l'ajoute dans ensNoeuds.
     * @param noeudP nom du noeud a ajouter
     */
    public void ajouterNoeud(String noeudP)
    {
        boolean present = false;

        for (String nL : ensNom)
            if (nL.equals(noeudP))
                present = true;

        if (!present)
        {
            ensNom.add(noeudP);
            Noeud n = new Noeud(noeudP);
            ensNoeuds.add(n);
        }
    }

    public String toString() {
        StringBuilder msg=new StringBuilder("");
        // La premiere boucle s'occupe des noeuds de depart
        for (Noeud noeud : this.ensNoeuds) {
            msg.append(noeud.getNom() + " -> ");
            // La deuxieme boucle d indentation j s occupe des noeuds d arrivee et du cout
            // de l'arc utilise
            for (int j = 0; j < noeud.getAdj().size(); j++) {
                msg.append(noeud.getAdj().get(j).getDest()
                        + "(" + (int) noeud.getAdj().get(j).getCout() + ") ");
            }
            // saut a la ligne
            msg.append("\n");
        }
        return msg.toString();
    }

    public String toGraphviz ()
    {
        StringBuilder msg=new StringBuilder("digraph G {\n");
        for (Noeud noeud : this.ensNoeuds)
            for (int j = 0; j < noeud.getAdj().size(); j++)
                msg.append( "\t"
                        + noeud.getNom() + " -> "
                        + noeud.getAdj().get(j).getDest()
                        + " [label = " + (int) noeud.getAdj().get(j).getCout() + "]\n"
                );
        //Accolade de fin
        msg.append("}");

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
