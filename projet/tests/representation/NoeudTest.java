package representation;

import org.junit.jupiter.api.Test;
import representation.Noeud;

import static org.junit.jupiter.api.Assertions.*;

class NoeudTest {

    Noeud n1, n2;

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

    @Test
    void ajouterArc_ok()
    {
        //Initialisation
        n1 = new Noeud("Noeud1");

        //Method
        n1.ajouterArc("Noeud2", 3);




    }

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