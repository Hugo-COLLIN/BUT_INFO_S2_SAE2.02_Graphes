import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    GrapheListe g;

    @BeforeEach
    void init ()
    {
        g = new GrapheListe();
    }

    @Test
    void listeNoeuds_ok()
    {
        //Initialisation
        g.setNom("A");
        g.setNom("B");

        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");

        //Method
        List<String> res = g.listeNoeuds();

        //Test
        assertEquals(comp, res, "doivent etre egaux");
    }

    @Test
    void grapheList_ok ()
    {
        assertNotNull(g.listeNoeuds());
        assertNotNull(g.getEnsNoeuds());
    }

    @Test
    void ajouterArc_ok()
    {
        g.ajouterArc("A", "B", 3);
        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");

        List<String> res = g.listeNoeuds();

        assertEquals(comp, res, "doivent etre egaux");
    }



    @Test
    void suivants() //TODO
    {
        //Initialisation
        g.ajouterArc("A", "B", 3);
        g.ajouterArc("A", "C", 4);

        List<Arc> comp = g.getEnsNoeuds().get(0).getAdj();

        //Method
        List<Arc> res = g.suivants("A");

        //Test
        for (int i = 0 ; i < g.getEnsNoeuds().size() ; i ++)
            assertEquals(comp.get(i), g.getEnsNoeuds().get(i));


        assertEquals(comp, res, "doivent etre egaux");
    }



}