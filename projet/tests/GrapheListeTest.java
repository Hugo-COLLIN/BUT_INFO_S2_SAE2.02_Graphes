import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @Test
    void listeNoeuds()
    {
        GrapheListe g = new GrapheListe();
    }

    @Test
    void grapheList_ok ()
    {
        GrapheListe g = new GrapheListe();
        assertNotNull(g.listeNoeuds());

    }

    @Test
    void ajouterArc()
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