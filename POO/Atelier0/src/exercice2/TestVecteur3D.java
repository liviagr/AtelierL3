package exercice2;

import java.text.DecimalFormat;

public class TestVecteur3D {
    public static void main(String[] args) {

        // Format affichage
        DecimalFormat df=new DecimalFormat("#0.00");

        //création des 2 objets vecteurs
        Vecteur3D v = new Vecteur3D(3,2,5);
        Vecteur3D u = new Vecteur3D(1,2,3);

        // affichage coordonnées + calcule norme pour v
        //v.affichageCoordonnees();
        System.out.println("v = " +v);
        System.out.println("Norme v = "+df.format(v.norme()));

        // affichage coordonnées + calcule norme pour u
        //u.affichageCoordonnees();
        System.out.println("u = " +u);
        System.out.println("Norme u = "+df.format(u.norme()));

        // Affichage + calcule : Somme et produit scalaire
        System.out.println("v + u = "+Vecteur3D.somme(v,u));
        System.out.println("v.u = "+v.produitScalaire(u));


    }
}

