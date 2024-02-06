public class Etudiant extends Personne {
    private String Diplome;
    private static int nbEtudiants = 0;


    public Etudiant(String nom, String prenom, String rue, String ville, String diplome) {
        super(nom, prenom, rue, ville);
        Diplome = diplome;
        nbEtudiants++;
        nbPersonnes++;
    }


    public String getDiplome() {
        return Diplome;
    }
    public void setDiplome(String diplome) {
        Diplome = diplome;
    }


    @Override
    public String toString() {
        return super.toString() + "\nNumero de bureau : " + this.Diplome;
    }    
    
    @Override
    public void ecrirePersonne() {
        System.out.println(this);
        System.out.println();
    }


    public static int nbEtudiants() {
        return nbEtudiants;
    }
}
