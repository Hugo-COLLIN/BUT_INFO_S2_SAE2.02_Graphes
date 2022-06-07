import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @Test
    void listeNoeuds_ok()
    {
        //Initialisation
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 3);

        //Method
        List<String> res = g.listeNoeuds();

        //Test
        assertEquals(res);
    }

    @Test
    void getEnsNoeuds_ok()
    {

    }

    @Test
    void grapheList_ok ()
    {
        GrapheListe g = new GrapheListe();
        assertNotNull(g.listeNoeuds());
        assertNotNull(g.getEnsNoeuds());
    }

    @Test
    void ajouterArc_ok()
    {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 3);
        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");

        List<String> res = g.listeNoeuds();

        assertEquals(comp, res, "doivent etre egaux");
    }



    @Test
    void suivants()
    {

    }


}