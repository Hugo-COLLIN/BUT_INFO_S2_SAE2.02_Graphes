import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Noeud
{
    String nom;
    List<Arc> adj;

    public Noeud (String nomP)
    {
        this.nom = nomP;
        this.adj = new List<Arc>();
    }


    public boolean equals(Noeud n2) {
        return this.nom.equals(n2.nom);
    }


    @Override
    public boolean equals(Object o) {
        Noeud p = (Noeud) o;
        return this.nom.equals(p.nom);
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
