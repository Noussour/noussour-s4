public class Employe extends Personne {
    private int salaire;

    public Employe(String nom, String prenom, int dateNaissance, int salaire) {
        super(nom, prenom, dateNaissance);
        this.salaire = salaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    //redefinition de Afficher
    public void afficher() {
        System.out.println("===== EMPLOYE ===== ");
        super.afficher();
        System.out.println("salaire : " + this.salaire);
        System.out.println();
    }
}
