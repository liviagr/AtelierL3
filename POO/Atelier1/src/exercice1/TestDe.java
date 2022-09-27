package exercice1;

public class TestDe {
    public static void main(String[] args) {

        // test constructeurs dé classique
        De DeFace = new De(5);
        De testDe = new De();
        De testDeTout = new De("nom", 6);
        De testDeNom = new De(" ");
        De testDeTout2 = new De("nom");

        // test dé pipé et mémoire
        DePipe testDePipe = new DePipe("DéPipe", 3, 1);
        DeMemoire testDeMemoire = new DeMemoire("DéMemoire", 10);

        // Test des getter et setter
        System.out.println(DeFace);
        System.out.println(testDeNom.getNom());
        testDeNom.setNbFaces(12);
        System.out.println(testDeTout.getNbFaces()+ " " +testDeTout.getNom());

        // Test lancé de dé
        System.out.println("Lancé de Dé " + testDeTout.lancer());
        // test dé memoire
        for (int i = 0; i < 10;i++) {
            System.out.println("Lancé de Dé " + testDeMemoire.lancer());
        }

        // Test affichage
        System.out.println(DeFace);
        System.out.println(testDe);
        System.out.println(testDeTout);
        System.out.println(testDeNom);
        System.out.println(testDeTout2);

        // test equals
        System.out.println(testDeTout2.equals(testDeTout));







    }
}