package exercice2;

public class Vecteur3D {
    float x, y, z;

    public Vecteur3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vecteur3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // Affiche les coordonnées
    public void affichageCoordonnees(){
        String affichage = "<"+this.x + ", " + this.y +", " + this.z + ">";
        System.out.println(affichage);
    }

    // calcule la norme d'un vecteur
    public double norme(){
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    // calcule produit scalaire de 2 vecteurs - instance
    public float produitScalaire(Vecteur3D v){
        return (this.x * v.x + this.y * v.y + this.z * v.z);
    }

    // calcule produit scalaire de 2 vecteurs - static
    public static float produitScalaire(Vecteur3D v, Vecteur3D u){
        return v.produitScalaire(u);
    }

    // calcule la somme de 2 vecteurs - instance
    public Vecteur3D somme(Vecteur3D v){
        return new Vecteur3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    // calcule la somme de 2 vecteurs - static
    public static Vecteur3D somme(Vecteur3D v, Vecteur3D u){
        return v.somme(u);
    }

    //permet d'afficher le vecteur
    public String toString(){
        return "<"+this.x + ", " + this.y +", " + this.z + ">";
    }


}
