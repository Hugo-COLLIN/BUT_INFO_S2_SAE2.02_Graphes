package implementation;

import implementation.BellmanFord;
import implementation.Valeur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import representation.GrapheListe;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BellmanFordTest {

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
        BellmanFord bf = new BellmanFord();
        Valeur test = bf.resoudre(g1, "A");

        // Test de la methode
        assertEquals(v.getValeur("A"), test.getValeur("A"), "Les valeurs doivent etre identiques");
        assertEquals(v.getValeur("B"), test.getValeur("B"), "Les valeurs doivent etre identiques");
        assertEquals(v.getValeur("C"), test.getValeur("C"), "Les valeurs doivent etre identiques");
        assertEquals(v.getValeur("D"), test.getValeur("D"), "Les valeurs doivent etre identiques");
        assertEquals(v.getValeur("E"), test.getValeur("E"), "Les valeurs doivent etre identiques");

        assertEquals(v.getParent("B"), test.getParent("B"), "Les parents doivent etre identiques");
        assertEquals(v.getParent("C"), test.getParent("C"), "Les parents doivent etre identiques");
        assertEquals(v.getParent("D"), test.getParent("D"), "Les parents doivent etre identiques");
        assertEquals(v.getParent("E"), test.getParent("E"), "Les parents doivent etre identiques");
    }
}
