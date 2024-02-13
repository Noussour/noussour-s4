public class Enseignant extends Personne {
    private String specialite;
    private static int nbEnseignants = 0;
    
    
    public Enseignant(String nom, String prenom, String rue, String ville, String specialite) {
        super(nom, prenom, rue, ville);
        this.specialite = specialite;
        nbEnseignants++;
    }


    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialité : " + this.specialite;
    }


    @Override
    public void ecrirePersonne() {
        System.out.println(this);
        System.out.println();
    }


    public static int nbEnseignants() {
        return nbEnseignants;
    }

    
}
