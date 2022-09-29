import java.util.ArrayList;

public class Jeu {

    private final String titre;

    // constantes : joueur max et nombre de cases
    private static final int NB_JOUEUR_MAX = 6;
    private static final int NB_CASE = 50;

    // liste des joueurs inscrits au jeu
    private ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>();

    // liste des cases du jeu - initialise pour une longueur = 50 (index 0-49)
    private Case[] cases = new Case[NB_CASE];

    // nombre de déplacements à réaliser par chaque personnage
    private final int nbEtapes;

    // maximum d'obstacle présent dans le tableau (il peut y en avoir moins)
    private final int nbObstacles;

    // score maximal sur l'ensemble des lancements du jeu
    private int scoreMax;

    // constructeur
    public Jeu(String titre, int nbEtapes, int nbObstacles) {
        this.titre = titre;
        this.nbEtapes = nbEtapes;
        this.nbObstacles = nbObstacles;
    }


    // Méthodes
    // ajoute le joueur à la liste
    public void ajouterJoueur(Joueur j){
        // ajout d'un joueur seulement s'il y a la place et s'il peut jouer (possède personnages)
        if (this.listJoueurs.size() < NB_JOUEUR_MAX && j.peutJouer()){
            this.listJoueurs.add(j);
        }else{
            System.err.println("Erreur!");
        }
    }

    // renvoie tous les personnages de tous les joueurs
    public ArrayList<Personnage> tousLesPerso(){
        ArrayList<Personnage> listePerso = new ArrayList<Personnage>();
        // parcourt la liste des joueurs
        for (Joueur j : this.listJoueurs){
            // permet d'ajouter toute la liste des personnages du joueur sélectionné
            listePerso.addAll(j.getListePersos());
        }
        return listePerso;

    }

    // initialise toutes les cases du jeu
    public void initialiserCases(){
        int nbObstacleCree = 0;
        //initialisation du tableau des cases
        for (int i = 0; i < NB_CASE; i++){
            // compter nombre d'obstacles créés
            // génération nb aléatoire entre 1 et NB_CASE
            int gain = (int) (Math.random() * NB_CASE) +1;
            // si c'est un multiple de 5 : création d'obstacle
            if (i%5 == 0){
                // vérification qu'on peut encore créer des obstacles
                if (nbObstacleCree < this.nbObstacles){
                    // création d'un objet obstacle
                    Obstacle obstacle = new Obstacle(2*gain);
                    // création d'une case à l'index i contenant un obstacle
                    this.cases[i] = new Case(gain, obstacle);
                    // incrémentation du nombre d'obstacles créés
                    nbObstacleCree++;

                    // Si impossibilité de créer nouvel obstacle : on crée une case normale
                }else{
                    cases[i] = new Case(gain);
                }

            // si i pas un multiple de 5 : Création case avec seulement le gain
            }else{
                cases[i] = new Case(gain);
            }
        }
    }

    public void lancerJeu(){
        // POSITIONNER LES PERSONNAGES

        // récupère la liste de tous les personnages
        ArrayList<Personnage> listePersonnage = tousLesPerso();

        // pour chaque personnage :
        for (Personnage p : listePersonnage){
            // initialisation i
            int i = 0;
            // Analyse chaque case - s'arrête quand le personnage actuel est placé ou à la fin du tableau cases
            while(p.getPosition() == 0 && i < this.cases.length){
                // si la case est libre
                if (cases[i].estLibre()){
                    // on place le personnage
                    cases[i].placerPersonnage(p);
                    p.deplacer(i,cases[i].getGain());
                    // on met à jour sa position
                    p.setPosition(i);

                }
                // incrémentation i/numéro de la case
                i++;
            }
        }

        // GESTION DES DEPLACEMENTS
        for (int i = 0; i < nbEtapes; i++){
            // chaque joueur jour l'un après l'autre
            for (Joueur j: this.listJoueurs){
                // chaque personnage du joueur joue l'un après l'autre
                for (Personnage p: j.getListePersos()){

                    // récupère nouvelle position souhaitée par le personnage
                    int nouvellePosition = p.positionSouhaitee();

                    // si le personnage sort du tableau de case : on le met à la dernière
                    if (nouvellePosition > NB_CASE-1){
                        nouvellePosition = NB_CASE-1;
                    }

                    // si la case en question est vide
                    if(cases[nouvellePosition].estLibre()){
                        // enlève le personnage de sa case actuelle
                        cases[p.getPosition()].enleverPersonnage(p);
                        // le déplace : changement de position + gain de points pour le joueur
                        p.deplacer(nouvellePosition,cases[nouvellePosition].getGain());
                        // ajoute le personnage à la case avec sa nouvelle position (=sa position après le déplacement)
                        cases[p.getPosition()].placerPersonnage(p);

                    // si la case en question a un obstacle
                    } else if (!cases[nouvellePosition].sansObstacle()) {
                        System.out.println(p + " case obstacle");
                        // modifie les points du joueur en fonction de la pénalité de l'obstacle
                        p.penaliser(cases[nouvellePosition].getObs().getPenalite());
                        // permet d'augmenter le nombre de déplacements si c'est un humain : évite de retomber en
                        // boucle sur la même case.
                        p.deplacer(p.getPosition(),0);

                    // si la case en question est déjà occupée par un personnage
                    } else if (!cases[nouvellePosition].sansPersonnage()){
                        // modifie les points du joueur en retranchant à ses point la valeur gain
                        p.penaliser(cases[nouvellePosition].getGain());
                    }
                }
            }

        }
        finJeu();

    }

    // gestion affichage des résultats
    public void finJeu(){
        afficherCases();
        afficherResultats();
    }

    // permet d'afficher l'état de toutes les cases à la fin de la partie.
    public void afficherCases(){
        int i = 0;
        // Pour chaque case, affiche son numéro et son contenu
        for (Case c : this.cases){
            System.out.print("case n° " + i+" : " + c + "\n");
            i++;
        }
    }


    // permet d'afficher les participants
    public void afficherParticipants(){
        System.out.println("LISTE DES JOUEURS");
        for (Joueur j : this.listJoueurs){
            System.out.println("------------------");
            System.out.println(j);
        }
    }

    // permet d'afficher les participants ainsi que le gagnant
    public void afficherResultats(){
        afficherParticipants();
        System.out.println("JEU " + this.titre);
        System.out.println("*********************************");
        System.out.println("RESULTATS");

        // gère l'affichage du nom et des points du joueur gagnant
        Joueur joueurGagnant = calculGagnant();
        if (joueurGagnant!= null){
            System.out.println(String.format("Le gagnant est %s avec %d points", joueurGagnant.getNom(), joueurGagnant.getNbPoint()));
            // affichage supplémentaire si le score max a été battu pendant la partie
            if (joueurGagnant.getNbPoint() > this.scoreMax){
                System.out.println("Record battu : Ancien score maximum : " + this.scoreMax);
                this.scoreMax = joueurGagnant.getNbPoint();

            }
        }else{
            System.out.println("Il n'y a pas de gagnant pour cette partie");
        }
        System.out.println("Le score maximum est " + this.scoreMax);




    }

    // permet de trouver le gagnant de la partie
    public Joueur calculGagnant(){
        // pour trouver le score max de la partie
        int scoreMaxPartie = 0;
        Joueur joueurGagnant = null;
        // parcourt la liste des joueurs
        for (Joueur j : this.listJoueurs){
            // regarde si le score du joueur actuel est le plus élevé de la partie
            if (j.getNbPoint() > scoreMaxPartie){
                scoreMaxPartie = j.getNbPoint();
                joueurGagnant = j;
            }
        }
        return joueurGagnant;
    }


}

