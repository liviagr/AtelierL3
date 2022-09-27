import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Secretaire extends Employe{

    // Liste pour gérer les managers
    private ArrayList<Manager> listeManager = new ArrayList<>();
    private final int NB_MAXIMAL_MANAGER = 5;

    /**Constructeur */

    public Secretaire(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville, int salaire, GregorianCalendar dateEmbauche) {
        super(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire, dateEmbauche);
    }

    /** Surchage toString*/

    public String toString(){
        String result = super.toString();
        result += "\nPoste : Secrétaire\nGère " + listeManager.size() + " manager(s)";
        return result;
    }

    /** Méthodes */

    //gérer l'augmentation du salaire
    public void augmenterLeSalaire(float pourcentage){
        // appel la méthode de la classe - modifie pourcentage en fonction du nombre de managers à charge
         super.augmenterLeSalaire((float) (pourcentage + 0.1*listeManager.size()));
    }

    /** gestion des managers */

    public void ajouterManager(Manager nouveauManager){
        int nbManager = listeManager.size();

        // Ajout du manager si la secrétaire n'en a pas 5
        if (nbManager < NB_MAXIMAL_MANAGER){
            listeManager.add(nouveauManager);
        }
        else{
            System.err.println("Erreur! Cette secrétaire ne peut pas avoir plus de manager.");
        }
    }

    public void supprimerManager(Manager managerSupprime){

        // si le manager est dans la liste on le supprime
        if(this.listeManager.contains(managerSupprime))
        {
            this.listeManager.remove(managerSupprime);
        }else{
            System.err.println("Erreur! Ce manager n'est pas géré par cette secrétaire.");
        }
    }
}
