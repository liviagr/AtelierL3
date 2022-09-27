import java.time.LocalDate;
import java.util.GregorianCalendar;

public class TestPersonne {
    public static void main(String[] args) {
        Personne p1 = new Personne("P1", "N1", 1,4,2000, 4, "ghgfh", "23456", "Bastia");
        Secretaire s1 = new Secretaire("NomSecrétaire1", "PrénomSecrétaire1", 2,4,2000, 4, "gfh", "23456", "Bastia",
                1000, new GregorianCalendar(2022, 9,2));

        Manager m1 = new Manager("NomManager1", "PrénomManager1", 3,1,2003, 4, "ghgfh", "23456", "Bastia", 1000,
                new GregorianCalendar(2022,
                9,2));
        Employe e1 = new Employe("NomEmploye1", "PrénomEmploye1", 3,1,2003, 4, "ghgfh", "23456", "Bastia", 1000,
                new GregorianCalendar(2022,
                9,2));

        m1.changerSecretaire(s1);

        Employe[] tabEmploye = {e1, m1, s1};
        for (Employe i : tabEmploye){
            i.augmenterLeSalaire(10);
            System.out.println("\n" + i.getNom() + " " + i.getPrenom() + " "+i.getSalaire());
        }





    }
}