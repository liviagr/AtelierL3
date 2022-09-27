package exercice1;

public class ManipRobot {
    public static void main(String[] args) {
        Robot Toto = new Robot("Toto", 10, 20, 3);
        Robot Titi = new Robot("Titi");

        // déplacement des 2 robots
        Toto.deplacer();
        Titi.deplacer();

        // affichage de Toto
        System.out.println(Toto);
        // changement de direction + déplacement
        Toto.changerOrientation(2);
        Toto.deplacer();

        System.out.println(Toto);
    }
}