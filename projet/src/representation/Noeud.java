package representation;

import java.util.ArrayList;
import java.util.List;

public class Noeud
{
    /**
     * nom du nœud qui permet de l’identifier
     */
    String nom;

    /**
     *  liste des arcs reliant ce nœud `a ses nœuds adjacents
     */
    List<Arc> adj;

    /**
     * constructeur prenant en param`etre le nom du noeud
     * et initialisant la liste adj `a une liste vide
     * @param nomP nom du noeud
     */
    public Noeud (String nomP)
    {
        this.nom = nomP;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * redefinition de la methode
     * equals(Object o) dans la classe representation.Noeud qui specifie que deux noeuds sont egaux
     * si et seulement si leurs noms sont egaux (on suppose ainsi que le nom d’un noeud
     * identifie le noeud de maniere unique).
     * @param o
     * @return boolean representant l'egalite des noeuds
     */
    @Override
    public boolean equals(Object o) {
        Noeud p = (Noeud) o;
        return this.nom.equals(p.nom);
    }

    /**
     *  ajoute un arc allant vers le noeud destination avec un cout de cout a la liste
     * adj.
     * @param destination
     * @param cout
     */
    public void ajouterArc(String destination, double cout)
    {
        Noeud n = new Noeud(destination);
        this.adj.add(new Arc(n, cout));
    }

    //Getters
    public String getNom() {
        return nom;
    }

    public List<Arc> getAdj() {
        return adj;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdj(List<Arc> adj) {
        this.adj = adj;
    }
}
