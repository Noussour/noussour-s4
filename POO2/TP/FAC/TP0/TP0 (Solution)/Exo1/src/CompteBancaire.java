public class CompteBancaire {
    //Question 1 :
    private double solde;
    private String id;
    
    public CompteBancaire() {
        this(0, "anonyme");
    }    
    
    public CompteBancaire(double solde, String id) {
        this.solde = solde;
        this.id = id;
    }

    //Question 2 :    
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //Question 3 :
    public void retirer(double montant) {
        if (this.solde >= montant && montant > 0)
            this.solde -= montant;
    }

    public void deposer(double montant) {
        if (montant > 0)
            this.solde += montant;
    }

    public void transferer(double montant, CompteBancaire compteDepot) {
        this.retirer(montant);
        compteDepot.deposer(montant);
    }

    public void afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ID : " + this.getId() + "\nSolde : " + this.getSolde();
    }
}
