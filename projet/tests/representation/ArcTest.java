package representation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de la classe Arc
 */
class ArcTest {

    /**
     * Objet de type arc
     */
    Arc a;

    /**
     * Initialise l'objet Arc avant chaque test
     */
    @BeforeEach
    void init ()
    {
        a = new Arc(new Noeud("A"), 3);
    }

    /**
     * Verifie l'initialisation des attributs de l'arc
     */
    @Test
    void Arc_ok ()
    {
        assertNotNull(a.getDest());
        assertTrue( a.getCout() >= 0, "doit etre positif");
    }

    /**
     * Verifie que getDest renvoie bien la valeur attendue
     */
    @Test
    void getDest()
    {
        assertEquals("A", a.getDest().toString(), "doivent etre egaux a A");
    }

    /**
     * Verifie que getCout renvoie bien la valeur attendue
     */
    @Test
    void getCout()
    {
        assertEquals(3, a.getCout(), "doivent etre egaux a 3");
    }
}