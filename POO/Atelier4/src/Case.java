public class Case {

    // nombre de points à ajouter ou retrancher (s'il y a déjà un personnage sur la case)
    private int gain;

    // représente le personnage présent sur la case - null s'il n'y en a pas
    private Personnage perso = null;

    // représente l'obstacle sur la case - null s'il n'y a pas d'obstacle
    private Obstacle obs = null;


    // Constructeur avec obstacle
    public Case(int gain, Obstacle obs) {
        this.gain = gain;
        this.obs = obs;
    }

    // Constructeur sans obstacle
    public Case(int gain) {
        this.gain = gain;
    }

    // Getter

    public int getGain() {
        return gain;
    }

    public Obstacle getObs() {
        return obs;
    }

    // Méthodes

    // récupère la valeur de la pénalité de l'obstacle | 0 s'il n'y a pas d'obstacle
    public int getPenalite(){
        // initialisation variable
        int penalite = 0;
        // s'il y a un obstacle
        if (this.obs != null){
            // récupère valeur de la pénalité
            penalite = this.obs.getPenalite();
        }
        return penalite;

    }

    // Méthodes Placement

    // placement personnage
    public void placerPersonnage(Personnage p){
        this.perso = p;
    }

    // placement obstacle
    public void placerObstacle(Obstacle o){
        this.obs = o;
    }

    // enlève personnage
    public void enleverPersonnage(Personnage p){
        this.perso = null;
    }

    // vérifie si la case est libre : ni obstacle, ni personnage
    public boolean estLibre(){
        return (this.sansPersonnage() && this.sansObstacle());
    }

    // Vérification absence d'obstacle
    public boolean sansObstacle(){
        return this.obs == null;
    }

    // Vérification absence personnage
    public boolean sansPersonnage(){
        return this.perso == null;
    }

    // redéfinition toString
    public String toString(){
        String resultat = "";
        // si case libre
        if (this.estLibre()){
            resultat = "Libre (gain = " + this.gain + ")";

        // S'il y a un obstacle
        } else if (!this.sansObstacle()) {
            resultat = "Obstacle (penalite = -" + this.obs.getPenalite() + ")";

        // S'il y a un personnage
        }else{
            // ajout de la chaine du personnage (type + nom) puis pénalité (négatif du gain de la case)
            resultat = this.perso.toString() + " (penalité = -" + this.gain + ")";
        }

        return resultat;

    }
}
