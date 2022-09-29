public class TestJoueur {
    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("joueur1");

        joueur1.modifierPoints(10);
        System.out.println(joueur1.getNbPoint());
        joueur1.modifierPoints(-11);
        System.out.println(joueur1.getNbPoint());

        System.out.println(joueur1);



    }
}
