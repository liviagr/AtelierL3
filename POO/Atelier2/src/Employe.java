import java.util.*;
import java.time.LocalDate;
public class Employe extends Personne{

    private float salaire;
    private GregorianCalendar dateEmbauche;

    // date du jour au format aaaa-mm-jj
    static final LocalDate DATE_ACTUELLE = LocalDate.now();


    static final int AGE_MINIMUM = 16;
    static final int AGE_MAXIMUM = 65;

    /** Constructeur**/

    protected Employe(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal,
              String ville, int salaire, GregorianCalendar dateEmbauche) {
        super(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville);
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;

    }

    /** createEmploye : permet de vérifier employé valide**/

    public static Employe createEmploye(String leNom, String lePrenom, int j, int m, int a, int numero, String rue,
                                  String code_postal, String ville, int salaire, GregorianCalendar dateEmbauche){
        // initialise variable
        Employe employeValide = null;
        // vérifier âge
        if (ageValide(new GregorianCalendar(a,m,j))){
            // si âge valide, appel du constructeur
            employeValide = new Employe(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville, salaire,
                    dateEmbauche);
        }
        return employeValide;

    }

    /** getter */

    public float getSalaire() {
        return salaire;
    }


    /** surchage toString*/
    public String toString(){
       String result = super.toString();
       result += "Employé(e) \nSalaire : " + this.getSalaire() + "\nDate d'embauche : " + +dateEmbauche.get(Calendar.DAY_OF_MONTH)+
               "-"+dateEmbauche.get(Calendar.MONTH)+
               "-"+dateEmbauche.get(Calendar.YEAR);
       return result;
    }

    /** vérifie si l'employé a l'âge de travailler**/

    public static boolean ageValide(GregorianCalendar dateNaissance){
        // Vérifie les années pour lesquelles l'employé peut travailler - les compare à l'année actuelle
        return (dateNaissance.get(Calendar.YEAR) + AGE_MINIMUM <= DATE_ACTUELLE.getYear() && dateNaissance.get(Calendar.YEAR) + AGE_MAXIMUM >= (DATE_ACTUELLE.getYear()));
    }

    /** Augmente le salaire**/
    public void augmenterLeSalaire(float pourcentage){
        if (pourcentage > 0){
            this.salaire *= (1+pourcentage/100);
        }}

    // calcul ancienneté - une année commencée = 1 an d'ancienneté
    public int calculAnnuite() {
        // récupère l'année actuelle
        int anneActuelle = DATE_ACTUELLE.getYear();
        // initialisation nombre année
        int nbAnnee = 0;
        // Si l'employé a commencé l'année actuelle
        if( anneActuelle == this.dateEmbauche.get(Calendar.YEAR)){
            nbAnnee = 1;
        }else {
            nbAnnee = anneActuelle - this.dateEmbauche.get(Calendar.YEAR);
        }
        // renvoie différence année actuelle et année d'embauche
        return nbAnnee;
    }

}
