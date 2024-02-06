public class Directeur extends Personne {
    private Societe societe;
    
    public Directeur(String nom, String prenom, int anneeNaissance, String nomSoc, int nbreEmploye) {
        super(nom, prenom, anneeNaissance);
        this.societe = new Societe(nomSoc, nbreEmploye);
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public void afficher() {
        System.out.println("===== DIRECTEUR =====");
        super.afficher();
        System.out.println("nom de la sociéte : " + this.getSociete().getNom());
        System.out.println();
    }
}
