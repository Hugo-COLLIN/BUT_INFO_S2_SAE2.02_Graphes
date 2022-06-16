package representation;

import org.junit.jupiter.api.Test;
import representation.Noeud;

import static org.junit.jupiter.api.Assertions.*;

class NoeudTest {
    /**
     * Classe de tests de la classe Noeud
     */

    Noeud n1, n2;

    /**
     * Verifie que deux noeuds soient egaux car de meme nom
     */

    @Test
    void equals_memeNom()
    {
        //Initialisation
        n1 = new Noeud("Noeud1");
        n2 = new Noeud("Noeud1");

        //Method
        boolean res = n1.equals(n2);

        //Test
        assertTrue(res, "Noeuds doivent etre egaux car de meme nom");
    }

    /**
     * Verifie que deux noeuds ne soient pas egaux car noms differents
     */

    @Test
    void equals_nomDifferent()
    {
        //Initialisation
        n1 = new Noeud("Noeud1");
        n2 = new Noeud("Noeud2");

        //Method
        boolean res = n1.equals(n2);

        //Test
        assertFalse(res, "Noeuds ne doivent pas etre egaux car pas le meme nom");
    }

    /**
     * Verifie qu un arc a bel et bien ete ajoute au noeud
     */

    @Test
    void ajouterArc_ok()
    {
        //Initialisation
        n1 = new Noeud("Noeud1");

        //Method
        n1.ajouterArc("Noeud2", 3);

        // Test
        assertEquals(n1.getAdj().get(0).getCout(), 3, "le cout de l arc doit etre de 3");
        assertEquals(n1.getAdj().get(0).getDest(), "Noeud2", "le noeud de destination doit etre Noeud2");

    }

    /**
     * Verifie que la methode getNom retourne bien le bon nom
     */

    @Test
    void getNom_ok()
    {
        //Initialisation
        n1 = new Noeud("Noeud1");

        String res = n1.getNom();

        //Test
        assertEquals("Noeud1", res, "doit etre la meme chaine");

    }

    /*
    @Test
    void getAdj()
    {
        //Initialisation
        n1 = new representation.Noeud("Noeud1");
        n1.ajouterArc("Noeud2", 3);
        List<representation.Arc> tmp = new ArrayList<>();
        representation.Arc a = new representation.Arc("Noeud2", 3)

        List<representation.Arc> res = n1.getAdj();

        //Test
        assertEquals("Noeud1", res, "doit etre la meme chaine");
    }

     */

    @Test
    void setNom() {
    }

    @Test
    void setAdj() {
    }
}