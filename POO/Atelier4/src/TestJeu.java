public class TestJeu {
    public static void main(String[] args) {

        // Création du jeu
        Jeu jeu1 = new Jeu("AtelierPOO", 4, 10);

        // création des joueurs
        Joueur joueur1 = new Joueur("Paul");
        Joueur joueur2 = new Joueur("Lucien");

        // création personnages
        Tauren tauren1 = new Tauren("Hector", 15, 10);
        Humain humain1 = new Humain("Jean", 10);

        Humain humain2 = new Humain("Marie", 10);
        Tauren tauren2 = new Tauren("Hercule", 20, 5);

        // ajout des personnages à leur joueur
        joueur1.ajouterPersonnage(tauren1);
        joueur1.ajouterPersonnage(humain1);
        joueur2.ajouterPersonnage(humain2);
        joueur2.ajouterPersonnage(tauren2);

        // inscription des joueurs au jeu
        jeu1.ajouterJoueur(joueur1);
        jeu1.ajouterJoueur(joueur2);

        System.out.println(jeu1.tousLesPerso());
        // initialisation des cases
        jeu1.initialiserCases();

        int nbParties = 5;
        //lancement du jeu
        for (int i = 0; i <nbParties; i++) {
            jeu1.lancerJeu();
        }






    }
}
