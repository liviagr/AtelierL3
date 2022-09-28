public class TestHumain {
    public static void main(String[] args) {

        Humain humain1 = new Humain("Hector", 12);

        // plusieurs déplacements
        humain1.deplacer(2,10);
        System.out.println(humain1.positionSouhaitee());
        humain1.deplacer(5,10);
        humain1.deplacer(3,10);
        humain1.deplacer(1,10);

        System.out.println(humain1.getPosition());
        System.out.println(humain1);

    }
}

