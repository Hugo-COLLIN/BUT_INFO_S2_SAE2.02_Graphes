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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noeud noeud = (Noeud) o;
        return Objects.equals(nom, noeud.nom) && Objects.equals(adj, noeud.adj);
    }
}
