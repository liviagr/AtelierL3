package exercice1;

import java.util.*;

public class De {

    // constantes gestion nombre de face minimum et maximum
    static final int NB_FACE_MINIMUM = 3;
    static final int NB_FACE_MAXIMUM = 120;


    //permet de gérer l'aléatoire
    protected static Random r = new Random();

    //nom et faces du dé
    private String nom;
    private int nbFaces;

    // gestion nombre de dés créés
    private static int nbDe = 0;

    // constructeur nom et nombre de faces
    public De(String nom, int nbFaces) {
        nbDe++;
        // si nom n'est pas vide ou un espace
        if (!nom.equals(" ")&& !nom.equals("")) {
            this.nom = nom;
        } else {
            this.nom = "Dé n° " + nbDe;
        }
        setNbFaces(nbFaces);
    }

    // constructeur seulement nom
    public De(String nom) {
        this(nom,6);

    }

    // constructeur seulement nombre de faces
    public De(int nbFaces) {
        this("", nbFaces);
    }


    //constructeurs
    public De() {
        this("", 6);
    }


    //getter et setter nb Faces
    public int getNbFaces() {
        return nbFaces;
    }

    public void setNbFaces(int nbFaces) {
        //Vérification nombre de faces
        if (nbFaces >= NB_FACE_MINIMUM && nbFaces <= NB_FACE_MAXIMUM) {
            this.nbFaces = nbFaces;
        } else {
            // gestion de l'erreur
            System.err.println("Erreur! nombre de faces invalide");
        }
    }


    //getter nom
    public String getNom() {
        return nom;
    }



    // Getter nombre de dés créés
    public static int getNbDe() {
        return nbDe;
    }



    // redéfinition de toString
    public String toString(){
        return "Le Dé : "+this.nom + " possède " + this.nbFaces + " faces.";
    }

    //redéfinition de equals : dés égaux si même nom et même nombre de faces
    public boolean equals(De deTest){
        // Vérifie égalité des strings - renvoie le bool correspondant
        return this.toString().equals(deTest.toString());
    }

    //méthode lancer le dé 1 fois
    public int lancer() {
        // Génère nombre aléatoire entre 1 et nb faces
        return r.nextInt(this.nbFaces) + 1;
    }

    // Méthode lance le dé un certain nombre de fois - garde le meilleur lancé
    public int lancer(int nbLance) {
        // initialise le meilleur lancé
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

