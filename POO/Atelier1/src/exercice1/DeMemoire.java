package exercice1;

import java.util.*;


public class DeMemoire extends De {

    // Génération liste pour gérer les nombres déjà tirés
     ArrayList<Integer> nbrTires = new ArrayList<Integer>();


    public DeMemoire(String nom, int nbFaces) {
        super(nom, nbFaces);
    }

    public int lancer(){
        int nbGenere = getR().nextInt(this.getNbFaces()) + 1;
        while(nbrTires.contains(nbGenere)) {
            nbGenere = getR().nextInt(this.getNbFaces()) + 1;
        }
        nbrTires.add(nbGenere);
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
