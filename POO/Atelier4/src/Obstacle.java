public class Obstacle {

    // nombre de points qu'il faudra enlever au joueur, ne peut pas être négative
    private int penalite;


    // Constructeur
    public Obstacle(int penalite) {
        this.penalite = penalite;
    }

    // getter pénalité
    public int getPenalite() {
        return penalite;
    }
}
