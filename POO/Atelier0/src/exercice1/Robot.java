package exercice1;

public class Robot {

    String reference;
    String nom;

    //coordonnées
    int x, y;

    //orientation du robot : 1 : Nord, 2: est, 3: sud, 4: ouest
    int orientation;

    static int nb_robot = 0;

    public Robot(String nom, int x, int y, int orientation) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        nb_robot++;
        this.reference = "ROB" + nb_robot;
    }

    public Robot(String nom) {
        this.nom = nom;
        this.x = 0;
        this.y = 0;
        this.orientation = 1;
        nb_robot++;
        this.reference = "ROB" + nb_robot;
    }


    public void changerOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void deplacer(){
        switch (this.orientation) {
            case 1:
                y += 1;
                break;
            case 2:
                x += 1;
                break;
            case 3:
                //modification y seulement si coordonnées >= 0
                if (y-1 >= 0) {
                    y -= 1;
                }
                break;
            case 4:
                //modification x seulement si coordonnées >= 0
                if (x-1 >= 0) {
                    x -= 1;
                }
                break;
        }
    }

    public void afficheToi(){
        String description = "Le robot s'appelle " + this.nom + " avec comme référence " +this.reference + ". Il se " +
                "trouve" + " aux " + "coordonnées (" +this.x +',' +this.y +") et regarde vers " + this.orientation;
        System.out.println(description);

    }

    public String toString(){
        return "Le robot s'appelle " + this.nom + " avec comme référence " +this.reference + ". Il se " + "trouve aux " + "coordonnées (" +this.x +',' +this.y +") et regarde vers " + this.orientation;
    }
}
