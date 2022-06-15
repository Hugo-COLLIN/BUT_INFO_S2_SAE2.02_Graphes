package representation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de representer les donnees associes a un graphe
 * representation.GrapheListe est definie par l'ensemble des noms
 * des objets noeuds qu elle stocke, ainsi qu une liste
 * de noeuds permettant de stocker les arcs.
 */
public class GrapheListe implements Graphe {
    /**
     * Liste de l'ensemble des noms des objets noeuds stockes
     */
    private List<String> ensNom;

    /**
     * Liste des noeuds permettant de stocker les arcs.
     */
    private List<Noeud> ensNoeuds;

    private static final String [] LISTE_NOMS_NOEUDS =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * Constructeur qui cree un objet representation.GrapheListe avec ses attributs initialises
     * comme listes vides
     */
    public GrapheListe ()
    {
        this.initAtt();
    }

    /**
     * Constructeur qui cree un objet representation.GrapheListe avec ses attributs initialises
     * a partir des donnees d'un fichier
     * @param fichier Chemin ou est localise le fichier
     * @throws IOException Erreur de lecture du fichier
     */
    public GrapheListe (String fichier) throws IOException {
        this.initAtt();
        this.lireFichier(fichier);
    }

    /**
     * Initialise les attributs ensNom et ensNoeuds a des ArrayList vides
     */
    public void initAtt()
    {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    /**
     * Lit les informations contenues dans un fichier pour les stocker
     * dans les attributs correspondants de representation.GrapheListe
     * @param fichier Chemin ou est localise le fichier
     * @throws IOException Erreur de lecture du fichier
     */
    public void lireFichier (String fichier) throws IOException
    {
        //Creation des flux de lecture pour le fichier
        FileReader fR = new FileReader(fichier);
        BufferedReader bR = new BufferedReader(fR);

        String ligne = bR.readLine();
        while (ligne != null) {
            String [] part = ligne.split("\t");                     //Séparation de la ligne en tableaux de chaines avec les tabulations
            this.ajouterArc(part[0], part[1], Integer.parseInt(part[2])); //Ajout de l'arc a partir des chaines recuperees de la ligne du fichiers
            ligne = bR.readLine();                                        //Lecture de la ligne suivante
        }

        // Fermeture des flux de lecture
        bR.close();
        fR.close();
    }

    /**
     * Methode permettant de retourner la liste des noms des noeuds
     * du graphe
     * @return L'attribut ensNom
     */
    @Override
    public List<String> listeNoeuds()
    {
        return this.ensNom;
    }

    /**
     * Methode permettant de retourner les arcs
     * partant d un noeud
     * @param n noeud pour qui on souhaiterait connaitre
     *          les arcs partant de ce dernier
     * @return liste d'arcs partant de representation.Noeud n
     */
    @Override
    public List<Arc> suivants(String n) {
        List<Arc> s = new ArrayList<>();

        for (Noeud noeud : this.ensNoeuds)
            if (n.equals(noeud.getNom()))
                s = noeud.getAdj();

        return s;
    }

    /**
     * Methode permettant d'ajouter des noeuds et
     * des arcs a un objet representation.GrapheListe.
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
    private void ajouterNoeud(String noeudP)
    {
        boolean present = false;

        for (String nL : ensNom)
            if (nL.equals(noeudP)) {
                present = true;
                break;
            }

        if (!present)
        {
            ensNom.add(noeudP);
            Noeud n = new Noeud(noeudP);
            ensNoeuds.add(n);
        }
    }

    /**
     * Question 24 :
     */
    public void genererGrapheV1(int taille)
    {
        this.ajouterNoeud("1");
        //this.ajouterNoeud(String.valueOf(taille));

        boolean tousLesNoeuds = false;
        while (!tousLesNoeuds)
        {
            tousLesNoeuds = true;
            int coutArc = (int)Math.round(Math.random() * 100);
            String noeudDepart = this.ensNom.get((int)Math.round(Math.random() * (this.ensNoeuds.size() - 1)));
            String noeudArrivee;
            do noeudArrivee = String.valueOf(Math.round(Math.random() * (taille - 1)) + 1);
                while (arcContient(noeudArrivee));

            this.ajouterArc(noeudDepart, noeudArrivee, coutArc);

            for (int i = 1 ; i <= taille ; i ++) //Atest
                if (!arcContient(String.valueOf(i)))
                    tousLesNoeuds = false;

            //System.out.println(noeudDepart + "\t" + noeudArrivee + "\t" + tousLesNoeuds);
        }
    }


    private boolean arcContient (String noeudP)
    {
        for (Noeud n : this.ensNoeuds)
            for (Arc a : n.getAdj())
                if (a.getDest().equals(noeudP))
                    return true;
        return false;
    }

    public void genererGrapheV2(int taille)
    {
        for (int i = 1 ; i <= taille ; i ++)
            this.ajouterNoeud(String.valueOf(i));

        boolean grapheFini = false;
        while (!grapheFini)
        {
            grapheFini = true;

            int coutArc = (int)Math.round(Math.random() * 100);
            String noeudDepart, noeudArrivee;
            do {
                noeudDepart = String.valueOf(Math.round(Math.random() * (taille - 1)) + 1);
                noeudArrivee = String.valueOf(Math.round(Math.random() * (taille - 1)) + 1);
            }
            while (dejaRelie(noeudDepart, noeudArrivee) || noeudDepart.equals(noeudArrivee)); //N'autorise ni plusieurs fois la meme route, ni les arcs d'un noeud sur lui-meme

            this.ajouterArc(noeudDepart, noeudArrivee, coutArc);

            for (int i = 1 ; i <= taille ; i ++)
                if (arcVide(String.valueOf(i)) || !arcContient(String.valueOf(i))) { //if (!arcVide || !arc
                    grapheFini = false;
                    break;
                }
        }
    }

    private boolean arcVide(String noeudP)
    {
        return suivants(noeudP).size() == 0;
    }

    private boolean dejaRelie (String nomNoeudDepartP, String nomNoeudArriveeP)
    {
        for (Noeud n : this.ensNoeuds)
            if (n.getNom().equals(nomNoeudDepartP))
                for (Arc a : n.getAdj())
                    if (a.getDest().equals(nomNoeudArriveeP))
                        return true;
        return false;
    }

    private boolean arcRelie(String noeudP)
    {
        boolean res = false;
        for (Arc a : suivants(noeudP))
        {
            String nomNoeudSuivant = a.getDest();
            res = !nomNoeudSuivant.equals(noeudP);
            if (res) break;
            /*if (!a.getDest().equals(noeudP)) {
                res = true;
                break;
            }*/
            //if (res) break;
        }


        return res;
    }


    /**
     * Redefinition de toString
     * @return une chaine de caractere representant le graphe
     */
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

    /**
     * Cree le code Graphviz permettant de representer le graphe
     * @return une chaine correspondant au code Graphviz du graphe
     */
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

    /**
     * Methode qui permet d'ajouter un nom a l'attribut ensNom
     * @param nom nom d'un noeud
     */
    public void setNom(String nom) {
        this.ensNom.add(nom);
    }

    //Getter
    /**
     * Getter de l'attribut ensNoeuds
     * @return l'attribut ensNoeuds
     */
    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }
}
