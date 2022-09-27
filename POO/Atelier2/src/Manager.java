import java.util.GregorianCalendar;

public class Manager extends Employe{

     Secretaire secretaireActuelle = null;

    /**Constructeur */

    public Manager(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville, int salaire, GregorianCalendar dateEmbauche) {
        super(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, dateEmbauche);
    }


    /** Surchage toString*/

    public String toString(){
        String result = super.toString();
        result += "\nPoste : Manager \nSecrétaire Actuelle : "+secretaireActuelle;
        return result;
    }

    /** Méthodes*/

    public void augmenterLeSalaire(float percentage) {
        int anciennete = super.calculAnnuite();
        // appel de la fonction précédente - applique la modification du pourcentage - transforme en float
        super.augmenterLeSalaire((float) (percentage + 0.5*anciennete));
    }

    // changement de secrétaire
    public void changerSecretaire(Secretaire secretaireChange){
        // Si la manager a déjà une secrétaire, on le supprime de la liste
        if(this.secretaireActuelle != null)
        {
            // manager supprimé de la liste de la secrétaire actuelle
            this.secretaireActuelle.supprimerManager(this);

        }
        // secrétaire actuelle devient la secrétaire à changer
        this.secretaireActuelle = secretaireChange;
        // ajout du manager à la liste de la nouvelle secrétaire
        this.secretaireActuelle.ajouterManager(this);

    }
}
