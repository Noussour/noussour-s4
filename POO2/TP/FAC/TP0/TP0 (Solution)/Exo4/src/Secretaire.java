public class Secretaire extends Personne{
    private String numBureau;
    private static int nbSecretaires = 0;
    
    public Secretaire(String nom, String prenom, String rue, String ville, String numBureau) {
        super(nom, prenom, rue, ville);
        this.numBureau = numBureau;
        nbSecretaires++;
    }
    
    
    public String getNumBureau() {
        return numBureau;
    }
    public void setNumBureau(String numBureau) {
        this.numBureau = numBureau;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nNumero de bureau : " + this.numBureau;
    }    
    
    @Override
    public void ecrirePersonne() {
        System.out.println(this);
        System.out.println();
    }
    

    public static int nbSecretaires() {
        return nbSecretaires;
    }
}
