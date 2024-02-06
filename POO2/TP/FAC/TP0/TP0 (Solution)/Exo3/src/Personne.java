public class Personne {
    private String nom, prenom;
    private int anneeNaissance;


    public Personne(String nom, String prenom, int anneeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
    }


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }
    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public void afficher() {
        System.out.println("nom : " + this.nom);
        System.out.println("prénom : " + this.prenom);
        System.out.println("année de naissance : " + this.anneeNaissance);
    }
    
   
}
