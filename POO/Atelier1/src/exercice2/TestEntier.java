package exercice2;

public class TestEntier {
    public static void main(String[] args) {

        Entier ent1 = new Entier(2,12);
        ent1.setValeur(12);
        EntierFou entFou = new EntierFou(12, 1, 20, 5);

        System.out.println(ent1.incremente(2));
        System.out.println(entFou.incremente());
    }
}
