public class Tauren extends Personnage {

    // représente la taille en mètres
    private int taille;



    // constructeur
    public Tauren(String nom, int age, int taille) {
        super(nom, age);
        this.taille = taille;
    }


    // Méthodes

    // position que souhaite atteindre le personnage
    public int positionSouhaitee(){
        // nombre aléatoire entre 1 et la taille
        return this.getPosition() + (int)(Math.random() * this.taille) + 1;
    }

    // redéfinition toString
    public String toString(){
        return "Tauren "+super.toString();
    }
}
