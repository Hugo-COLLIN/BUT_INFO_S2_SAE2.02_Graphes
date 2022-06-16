package representation;

/**
 * Classe representant un arc partant d un noeud.
 * Un objet de type Arc est decrit par le nom du noeud destination de l arc
 *  et le cout correspondant au poids(cout) de l arc
 */
public class Arc
{
    /**
     * nom du noeud destination de l arc
     */
    private String dest;

    /**
     * cout correspondant au poids de l arc
     */
    private double cout;


    /**
     * Constructeur prenant un Noeud n et un double c et créant un Arc qui prend c comme cout
     * et n comme noeud de destination
     * @param n noeud de destination
     * @param c cout de l'arc
     */
    public Arc(Noeud n, double c) {
        this.dest=n.getNom();
        // le cout doit etre strictement positif
        if (c>0) {
            this.cout=c;
        // si le cout n est pas strictement positif, l arc n existe pas
        } else {
            this.cout=0;
        }
    }

    //Getters
    /**
     * Getter de destination
     * @return une destination de type String
     */
    public String getDest() {
        return this.dest;
    }

    /**
     * Getter de cout
     * @return un double cout
     */
    public double getCout() {
        return this.cout;
    }
}
