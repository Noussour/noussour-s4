abstract public class Personne {
    protected String nom, prenom, rue, ville;
    protected static int nbPersonnes = 0;
    
    
    public Personne(String nom, String prenom, String rue, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.ville = ville;
        nbPersonnes++;
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

    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }


    @Override
    public String toString() {
        return "Nom : " + nom  + "\nPrenom : " + prenom + "\nAdresse : {rue : " + rue + " , ville : " + ville + "}";
    }

    abstract public void ecrirePersonne();

    public static void nbPersonnes() {
        System.out.println("Le nombre de personne est :  " + Personne.nbPersonnes);
        System.out.println("Le nombre de secretaires est : " + Secretaire.nbSecretaires());
        System.out.println("Le nombre d'enseignants est : " + Enseignant.nbEnseignants());
        System.out.println("Le nombre d'etudiants est : " + Etudiant.nbEtudiants());
        System.out.println();
    }

    public void modifierPersonne(String rue, String ville) {
        this.rue = rue;
        this.ville = ville;
        System.out.println("la personne apres modifacation :");
        this.ecrirePersonne();
    }

    
}