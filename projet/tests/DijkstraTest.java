import implementation.Dijkstra;
import implementation.Valeur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import representation.GrapheListe;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {

    GrapheListe g1;

    @BeforeEach
    void initGrapheExemple()
    {
        g1 = new GrapheListe();
        g1.ajouterArc("A", "B", 12);
        g1.ajouterArc("A", "D", 87);
        g1.ajouterArc("B", "E", 11);
        g1.ajouterArc("C", "A", 19);
        g1.ajouterArc("D", "B", 23);
        g1.ajouterArc("D", "C", 10);
        g1.ajouterArc("E", "D", 43);
    }

    @Test
    void resoudre_Test()
    {
        // initialisation
        Valeur v=new Valeur();
        v.setValeur("A", 0);
        v.setValeur("B", 12);
        v.setParent("B", "A");
        v.setValeur("C", 76);
        v.setParent("C", "D");
        v.setValeur("D", 66);
        v.setParent("D", "E");
        v.setValeur("E", 23);
        v.setParent("E", "B");

        // Appel de la methode
        Dijkstra dj = new Dijkstra();
        Valeur test= dj.resoudre(g1, "A");

        // Test de la methode
        assertEquals(v, test, "Les valeurs doivent etre identiques");
    }
}
