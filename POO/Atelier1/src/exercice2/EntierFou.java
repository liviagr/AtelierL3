package exercice2;


public class EntierFou extends Entier{

    // attribut niveau de folie
    private int niveauDeFolie = 0;


    // CONSTRUCTEURS

    //constructeur défaut : le même que pour Entier
    public EntierFou() {
        super();
    }

    // constructeur : bornes : le même que pour Entier
    public EntierFou(int borneInferieur, int borneSuperieur, int niveauDeFolie) {
        super(borneInferieur, borneSuperieur);
        this.niveauDeFolie = niveauDeFolie;
    }

    //constructeur : valeur + borne : le même que pour Entier
    public EntierFou(int valeur, int borneInferieur, int borneSuperieur, int niveauDeFolie) {
        super(valeur, borneInferieur, borneSuperieur);
        this.niveauDeFolie = niveauDeFolie;

    }

    //Getter niveau de folie
    public int getNiveauDeFolie() {
        return niveauDeFolie;
    }

    public int incremente(){
        // génère nombre aléatoire entre 0 et niveau de folie
        double nbAleatoire = Math.random()*this.niveauDeFolie;
        // conversion en int
        nbAleatoire = (int) nbAleatoire;
        // récupère la valeur de l'objet
        int value = this.getValeur();
        // Renvoie la valeur finale
        return value += nbAleatoire;

    }
}
