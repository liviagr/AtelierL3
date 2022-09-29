public class Humain extends Personnage{

    private int nbDeplacements = 0;
    // compris entre 1 et 3 - 2 à 4 déplacements, 3 à 6 déplacements
    private int niveau = 1;

    private static final int PASSAGE_NIVEAU_2 = 4;
    private static final int PASSAGE_NIVEAU_3 = 6;

    // Constructeur
    public Humain(String nom, int age) {
        super(nom, age);
    }



    // méthodes

    public void deplacer(int destination, int gain){
        super.deplacer(destination, gain);
        this.nbDeplacements++;
        // augmentation niveau en fonction du nombre de déplacements
        if (nbDeplacements == PASSAGE_NIVEAU_2){
            this.niveau = 2;
        } else if (nbDeplacements == PASSAGE_NIVEAU_3) {
            this.niveau = 3;

        }
    }

    public int positionSouhaitee(){
       return this.getPosition() + this.niveau*this.nbDeplacements;

    }


    // redéfinition toString
    public String toString(){
        return "Humain "+ super.toString();
    }



}
