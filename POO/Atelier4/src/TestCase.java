public class TestCase {
    public static void main(String[] args) {

        // création obstacles
        Obstacle obs1 = new Obstacle(20);
        Obstacle obs2 = new Obstacle(10);

        // création humain
        Humain humain1 = new Humain("Hector", 12);

        // Création cases
        Case case1 = new Case(10, obs1 );
        Case case2 = new Case(10);
        Case case3 = new Case(20, obs2);

        // Test pénalité avec et sans obstacle
        System.out.println(case1.getPenalite());
        System.out.println(case2.getPenalite());

        // test placer et enlever personnage
        case2.placerPersonnage(humain1);
        System.out.println(case2);
        case2.enleverPersonnage(humain1);
        System.out.println(case2);

        // test case avec obstacle
        System.out.println(case3);



    }
}
