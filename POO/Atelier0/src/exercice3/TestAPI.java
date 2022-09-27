package exercice3;

public class TestAPI {
    public static void main(String[] args) {
        //affiche pi
        System.out.println("Pi = " + Math.PI);
        // affiche un réel aléatoire entre 0 et 1 (exclu)
        System.out.println("Nombre aléatoire de 0 à 1 = " + Math.random());
        // affiche entier aléatoire entre 1 et 3 (inclus)
        System.out.println((int) (Math.random() * 3) + 1);

        int x1 = 2;
        int x2 = 4;
        System.out.println("Max entre 2 et 4 = " + Math.max(x1, x2));

        String n1 = "bonjour";
        String n2 = "Hello";

        //Affiche la première chaine dans l'ordre alphabétique
        // > 0 : n1 est avant dans l'alphabet
        if (n1.compareTo(n2) > 0) {
            System.out.println(n1);

        // < 0 : n2 est avant dans l'alphabet
        } else if (n1.compareTo(n2) < 0) {
            System.out.println(n2);
        } else {
            System.out.println("Les deux chaines sont égales");
        }
    }
}
