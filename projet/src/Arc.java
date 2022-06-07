/*
Classe representant un arc partant d un noeud.
 */

public class Arc {
    /*
    Un objet de type Arc est decrit par le nom du noeud destination de l arc
    et le cout correspondant au poids(cout) de l arc
     */
    private String dest;
    private double cout;


    public Arc(Noeud n, double c) {
        this.dest=n.getNom();
        if (c>0) {
            this.cout=c;
        } else {
            this.cout=0;
        }
    }

}
