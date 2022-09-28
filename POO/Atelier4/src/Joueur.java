import java.util.ArrayList;

public class Joueur {

    private String nom;
    // permet de former le code J + numéro du Joueur : ex J1
    private String code = "J";
    private static int nbJoueurs = 0;

    // doit être positif
    private int nbPoint = 0;

    // permet de stocker les personnages du joueur
    private ArrayList<Personnage> listePersos = new ArrayList<Personnage>();

    // Constructeur
    public Joueur(String nom) {
        nbJoueurs++;
        this.nom = nom;
        this.code += nbJoueurs;
    }

    // getter nom
    public String getNom() {
        return nom;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public ArrayList<Personnage> getListePersos() {
        return listePersos;
    }

    // méthodes

    // ajout d'un personnage à la liste du joueur
    public void ajouterPersonnage(Personnage p){
        // ajout à la liste
        this.listePersos.add(p);
        // modification attribut propriétaire du personnage
        p.setProprietaire(this);

    }

    // modification de points - marche si nb positif ou négatif
    public void modifierPoints(int nb){
        // si la modification est supérieure à 0 : on l'applique
        if (this.nbPoint + nb >= 0){
            this.nbPoint += nb;
        }else{
            // Sinon le nombre de point est ramené à 0
            this.nbPoint = 0;
        }
    }

    // détermine si le joueur a le droit de jouer ou non
    public boolean peutJouer(){
        boolean jouer = false;
        // S'il y a au moins un personnage, le joueur peut jouer
        if (this.listePersos.size() > 0){
            jouer = true;
        }
        return jouer;
    }

    // rédéfinition toString
    public String toString(){
        // partie chaine commune (non dépendante du nombre de personnages
        String resultat = String.format("%s %s (%d points)", this.code, this.nom, this.nbPoint);
        // si le joueur a au moins 1 personnage
        if(this.listePersos.size()>0){
            resultat += String.format(" avec %d personnages", listePersos.size());

        // si le joueur n'a pas de personnage
        } else{
            resultat += " aucun personnage";
        }

        return resultat;
    }

}
