public class Citoyen {
    //Question 2 :
    private String nom, prenom;
    private Adresse adresse;
    
    public Citoyen(String nom, String prenom, int num, int codePostale, String rue, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = new Adresse(num, codePostale, rue, ville);
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

    public Adresse getAdresse() {
        return adresse;
    }
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void afficher() {
        System.out.println(this + "\n");
    }

    public boolean hasVille(String ville) {
        return this.adresse.getVille().equals(ville);
    }

    @Override
    public String toString() {
        return  "Nom  : " + nom + "\nPrenom : " + prenom + "\nAdresse : " + adresse ;
    }
}
