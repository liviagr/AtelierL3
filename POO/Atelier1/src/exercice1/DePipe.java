package exercice1;

class DePipe extends De{
    private int borneMinimale = 0;

    public DePipe(String nom, int nbFaces, int borneMinimale) {
        super(nom, nbFaces);
        if (borneMinimale < nbFaces){
            this.borneMinimale = borneMinimale;
        }else{
            System.err.println("Erreur! borne minimale invalide");
        }
    }

    public int lancer(){
        // int aléatoire entre la différence nbFace et minimale (éviter chiffre trop grand)
        // Ajoute borne minimale et 1 pour que le résultat soit tjs > borne minimale
        return r.nextInt(this.getNbFaces() - borneMinimale)+borneMinimale+1;

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




