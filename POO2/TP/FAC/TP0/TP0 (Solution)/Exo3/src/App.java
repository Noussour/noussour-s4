public class App {
    public static void main(String[] args) throws Exception {
        Personne[] personnes = new Personne[5];
        
        //le directeur
        personnes[0] = new Directeur("NOM_0", "PRENOM_0", 2000, "Societe1",4);

        for (int i=1;i<personnes.length;i++) {
            String nom = "NOM_" + i ;
            String prenom = "PRENOM_" + i ;
            int anneeNaissance = 1997 + i;
            int salaire = 800 + i*100;
            personnes[i] = new Employe(nom, prenom, anneeNaissance, salaire);
        }


        //affichage
        for (Personne personne : personnes) {
            personne.afficher();
        }
    }
}
