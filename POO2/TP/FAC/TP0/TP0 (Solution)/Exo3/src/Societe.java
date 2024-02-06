public class Societe {
    private String nomSoc;
    private int nbreEmploye;
    
    
    public Societe(String nom, int nbreEmploye) {
        this.nomSoc = nom;
        this.nbreEmploye = nbreEmploye;
    }


    public String getNom() {
        return nomSoc;
    }
    public int getNbreEmploye() {
        return nbreEmploye;
    }
    
}
