public class PPPersonne1 {
    public static void main(String[] args) {
        //Question 2 :
        Secretaire Sec=new Secretaire("Seba","Zohra","rue des rosiers", "Alger", "A326");

        Enseignant Ens=new Enseignant ("Fridi","Boualem","rue des mimosas", "Alger", "Mathematique");
        
        Etudiant Etu=new Etudiant ("Smati","Ryad","rue des lilas", "Alger", "Informatique");

        // à compléter … affichez le nombre de personnes.
        Personne.nbPersonnes();

        System.out.println("\nAprès modification:\n");

        //à compléter … modifiez l’adresse de « Seba Zohra » par : "rue des orangers, ville de Blida.
        Sec.modifierPersonne("rue des orangers", "Blida");


        //à compléter … modifiez l’adresse de « Fridi Boualem » par : "rue des marguerites", "Kouba".
        Ens.modifierPersonne("rue des marguerites", "Kouba");


        // à compléter … affichez les informations de toutes les personnes.
        Sec.ecrirePersonne();
        Ens.ecrirePersonne();
        Etu.ecrirePersonne();
    }
}
