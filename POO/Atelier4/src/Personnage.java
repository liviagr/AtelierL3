abstract class Personnage {

    private String nom;
    private int age;
    // représente le numéro de la case sur laquelle est positionné le personnage
    private int position = 0;

    // représente le joueur auquel appartient le personnage
    private Joueur proprietaire;



    // constructeur
    public Personnage(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }


    // getter position
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    // setter position
    // setter propriétaire
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }



    // méthodes

    // déplacement + gain de points du joueur
    public void deplacer(int destination, int gain){
        this.position = destination;
        this.proprietaire.modifierPoints(gain);
    }

    // diminue nombre de point du joueur
    public void penaliser(int penalite){
        this.proprietaire.modifierPoints(-penalite);
    }

    public abstract int positionSouhaitee();

    // redéfinition toString - renvoie que le nom du personnage
    public String toString(){
        return this.nom;
    }
}
