package exercice1;

import java.util.*;


public class DeMemoire extends De {

    private int dernierNbTire = 0;


    public DeMemoire(String nom, int nbFaces) {
        super(nom, nbFaces);
    }

    public int lancer(){
        int nbGenere = r.nextInt(this.getNbFaces()) + 1;
        // tant que le nombre généré est égal au dernier nombre tiré
        while(this.dernierNbTire == nbGenere) {
            nbGenere = r.nextInt(this.getNbFaces()) + 1;
        }
        this.dernierNbTire = nbGenere;
        return nbGenere;
    }

    public int lancer(int nbLance){
        int meilleurLance = 0;
        // lance le nombre de fois voulue
        for (int i = 0; i < nbLance;i++){
            int lanceActuel = lancer();
            // compare le lancé avec le meilleur
            if (lanceActuel > meilleurLance){
                meilleurLance = lanceActuel;
            }
        }
        return meilleurLance;
    }
}
