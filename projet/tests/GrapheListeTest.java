import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    GrapheListe g;

    void initGrapheExemple()
    {
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);
    }

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
        //Initialisation
        g.ajouterArc("A", "B", 3);
        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");

        //Method
        List<String> res = g.listeNoeuds();

        //Test
        assertEquals(comp, res, "doivent etre egaux");
    }

    @Test
    void ajouterArc_listeDbl()
    {
        //Initialisation
        g.ajouterArc("A", "B", 3);
        g.ajouterArc("A", "C", 4);
        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");
        comp.add("C");

        //Method
        List<String> res = g.listeNoeuds();

        //Test
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

    @Test
    void toString_ok ()
    {
        //Init
        initGrapheExemple();

        String attendu = "A -> B(12) D(87) \n" +
                "B -> E(11) \n" +
                "D -> B(23) C(10) \n" +
                "E -> D(43) \n" +
                "C -> A(19) \n";

        //Methode
        String res = g.toString();

        //Test
        assertEquals(attendu, res, "doivent etre egaux");
    }

    @Test
    void toGraphviz_ok ()
    {
        //Init
        initGrapheExemple();

        String attendu = "digraph G {\n" +
                "\tA -> B [label = 12]\n" +
                "\tA -> D [label = 87]\n" +
                "\tB -> E [label = 11]\n" +
                "\tD -> B [label = 23]\n" +
                "\tD -> C [label = 10]\n" +
                "\tE -> D [label = 43]\n" +
                "\tC -> A [label = 19]\n" +
                "}";

        //Methode
        String res = g.toGraphviz();

        //Test
        assertEquals(attendu, res, "doivent etre egaux");
    }


}