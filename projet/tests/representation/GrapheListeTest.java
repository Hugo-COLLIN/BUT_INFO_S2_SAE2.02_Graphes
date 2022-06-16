package representation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import representation.Arc;
import representation.GrapheListe;
import representation.Noeud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    GrapheListe g1;

    void initGrapheExemple()
    {
        g1.ajouterArc("A", "B", 12);
        g1.ajouterArc("A", "D", 87);
        g1.ajouterArc("B", "E", 11);
        g1.ajouterArc("C", "A", 19);
        g1.ajouterArc("D", "B", 23);
        g1.ajouterArc("D", "C", 10);
        g1.ajouterArc("E", "D", 43);
    }

    @BeforeEach
    void init ()
    {
        g1 = new GrapheListe();
    }

    @Test
    void listeNoeuds_ok()
    {
        //Initialisation
        g1.setNom("A");
        g1.setNom("B");

        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");

        //Method
        List<String> res = g1.listeNoeuds();

        //Test
        assertEquals(comp, res, "doivent etre egaux");
    }

    @Test
    void grapheListVide_ok ()
    {
        assertNotNull(g1.listeNoeuds());
        assertNotNull(g1.getEnsNoeuds());
    }

    /*
    @Test
    void grapheListParams_ok () throws IOException {
        representation.GrapheListe g2 = new representation.GrapheListe("resources/Graphe_boucle.txt");

        String [] nomNoeuds = {"A", "B", "C"};

        List<representation.Noeud> objetNoeuds = new ArrayList<representation.Noeud>();
        objetNoeuds.add(new representation.Noeud("A"));
        objetNoeuds.add(new representation.Noeud("B"));
        objetNoeuds.add(new representation.Noeud("C"));

        //Tests
        assertNotNull(g1.listeNoeuds());
        assertNotNull(g1.getEnsNoeuds());

        assertEquals(objetNoeuds.size(), g2.getEnsNoeuds().size(), "doivent etre egaux");

        for (int i = 0; i < g1.listeNoeuds().size() ; i ++)
            assertEquals(nomNoeuds[i], g1.listeNoeuds().get(i), "doivent etre egaux");

        for (int i = 0; i < g1.getEnsNoeuds().size() ; i ++)
            assertEquals(objetNoeuds.get(i), g1.getEnsNoeuds().get(i), "doivent etre egaux");
    }
    */
    /*
    @Test
    void ajouterArc_OK ()
    {
        //Init
        g1.ajouterArc("A", "B", 3);
        g1.ajouterArc("A", "C", 4);

        String [] nomNoeuds = {"A", "B", "C"};

        List<representation.Noeud> objetNoeuds = new ArrayList<representation.Noeud>();
        objetNoeuds.add(new representation.Noeud("A"));
        objetNoeuds.add(new representation.Noeud("B"));
        objetNoeuds.add(new representation.Noeud("C"));

        //Tests
        assertNotNull(g1.listeNoeuds());
        assertNotNull(g1.getEnsNoeuds());

        for (int i = 0; i < g1.listeNoeuds().size() ; i ++)
            assertEquals(nomNoeuds[i], g1.listeNoeuds().get(i), "doivent etre egaux");

        for (int i = 0; i < g1.getEnsNoeuds().size() ; i ++)
            assertEquals(objetNoeuds.get(i), g1.getEnsNoeuds().get(i), "doivent etre egaux");
    }

     */

    @Test
    void ajouterArc_ok()
    {
        //Initialisation
        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");

        //Method
        g1.ajouterArc("A", "B", 3);
        List<String> res = g1.listeNoeuds();

        //Test
        assertEquals(comp, res, "doivent etre egaux");
    }

    @Test
    void ajouterArc_listeDbl()
    {
        //Initialisation
        List<String> comp = new ArrayList<>();
        comp.add("A");
        comp.add("B");
        comp.add("C");

        //Method
        g1.ajouterArc("A", "B", 3);
        g1.ajouterArc("A", "C", 4);
        List<String> res = g1.listeNoeuds();

        //Test
        assertEquals(comp, res, "doivent etre egaux");
    }



    @Test
    void suivants_ok ()
    {
        //Init
        g1.ajouterArc("A", "B", 3);
        g1.ajouterArc("A", "C", 4);

        //List<representation.Arc> attendu1 = g.getEnsNoeuds().get(0).getAdj();
        List<Arc> attendu2 = new ArrayList<Arc>();

        Noeud nB = new Noeud("B");
        attendu2.add(new Arc(nB, 3));

        Noeud nC = new Noeud("C");
        attendu2.add(new Arc(nC, 4));

        //Methode
        List<Arc> res = g1.suivants("A");

        for (int i = 0 ; i < res.size() ; i ++)
        {
            assertEquals(attendu2.get(i).getDest(), res.get(i).getDest(), "destinations doivent etre egales");
            assertEquals(attendu2.get(i).getCout(), res.get(i).getCout(), "cout doivent etre egaux");
        }
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
        String res = g1.toString();

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
        String res = g1.toGraphviz();

        //Test
        assertEquals(attendu, res, "doivent etre egaux");
    }

    @Test
    void lireFichier_test () throws IOException {
        // init
        GrapheListe g = new GrapheListe();
        g.ajouterArc("1", "2", 18);
        g.ajouterArc("2", "1", 12);
        g.ajouterArc("2", "3", 13);
        g.ajouterArc("3", "2", 20);

        // methode
        GrapheListe res = new GrapheListe();
        res.lireFichier("resources/graphes_exemples/Graphe4.txt");

        // Test
        assertEquals(g.suivants(g.listeNoeuds().get(0)).get(0).getDest(), res.suivants(res.listeNoeuds().get(0)).get(0).getDest(), "doivent avoir la meme destination");
        assertEquals(g.suivants(g.listeNoeuds().get(0)).get(0).getCout(), res.suivants(res.listeNoeuds().get(0)).get(0).getCout(), "doivent avoir le meme cout");
        assertEquals(g.suivants(g.listeNoeuds().get(1)).get(0).getDest(), res.suivants(res.listeNoeuds().get(1)).get(0).getDest(), "doivent avoir la meme destination");
        assertEquals(g.suivants(g.listeNoeuds().get(1)).get(0).getCout(), res.suivants(res.listeNoeuds().get(1)).get(0).getCout(), "doivent avoir le meme cout");
        assertEquals(g.suivants(g.listeNoeuds().get(1)).get(1).getDest(), res.suivants(res.listeNoeuds().get(1)).get(1).getDest(), "doivent avoir la meme destination");
        assertEquals(g.suivants(g.listeNoeuds().get(1)).get(1).getCout(), res.suivants(res.listeNoeuds().get(1)).get(1).getCout(), "doivent avoir le meme cout");
        assertEquals(g.suivants(g.listeNoeuds().get(2)).get(0).getDest(), res.suivants(res.listeNoeuds().get(2)).get(0).getDest(), "doivent avoir la meme destination");
        assertEquals(g.suivants(g.listeNoeuds().get(2)).get(0).getCout(), res.suivants(res.listeNoeuds().get(2)).get(0).getCout(), "doivent avoir le meme cout");
    }


}