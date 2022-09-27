package exercice2;

public class Entier {

    private int valeur = 0;
    private int borneInferieur = 0;
    private int borneSuperieur = 100;



    // CONSTRUCTEURS


    // constructeur : valeur + bornes
    public Entier(int valeur, int borneInferieur, int borneSuperieur) {
        this.valeur = valeur;
        // vérification des bornes
        if (borneInferieur <= borneSuperieur) {
            this.borneInferieur = borneInferieur;
            this.borneSuperieur = borneSuperieur;
        }else{
            this.borneInferieur = borneSuperieur;
            this.borneSuperieur = borneInferieur;
        }
    }

    // constructeurs avec les bornes
    public Entier(int borneInferieur, int borneSuperieur) {
        //vérification des bornes - inversion si pas dans le bon ordre
        if (borneInferieur < borneSuperieur) {
            this.borneInferieur = borneInferieur;
            this.borneSuperieur = borneSuperieur;
        } else {
            this.borneInferieur = borneSuperieur;
            this.borneSuperieur = borneInferieur;
        }
    }

    // constructeur par défaut
    public Entier(){

    }


    //GETTER ET SETTER

    // getter borne inférieure
    public int getBorneInferieur() {
        return borneInferieur;
    }

    // getter borne superieure
    public int getBorneSuperieur() {
        return borneSuperieur;
    }

    // getter valeur
    public int getValeur() {
        return valeur;
    }

    // setter valeur : vérifie si valeur entre les bornes
    public void setValeur(int valeur) {
        if (valeur >= this.borneInferieur && valeur <= borneSuperieur){
            this.valeur = valeur;
        }else{
            System.err.println("Erreur! la valeur n'est pas comprise entre les deux bornes");
        }
    }


    // REDEFINITION DES METHODES D'OBJECT

    //redéfinition toString
    public String toString(){
        return "L'entier a pour valeur "+this.valeur + "située entre les bornes " + this.borneInferieur + ", " + this.borneSuperieur;
    }

    //redéfinition equals (2 entiers sont égaux s'ils ont la même valeur)
    public boolean equals(Entier e){
        return this.valeur == e.valeur;
    }

    // METHODES

    //incrémente de 1 la valeur
    public int incremente(){
        // incrémentation avant boucle car sinon elle se faisait dans les conditions
        this.valeur ++;
        if (this.valeur <= borneSuperieur){
            return this.valeur;
        }
        return this.valeur-1;
    }

    // incrémente la valeur de n
    public int incremente(int n){
        // vérification borne inférieure si jamais n <0
        if (this.valeur+n <= borneSuperieur && this.valeur+n >= borneInferieur){
            this.valeur += n;
        }
        return this.valeur;
    }



}
