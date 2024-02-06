public class App {
    public static void main(String[] args) throws Exception {
        //Question 4 :
        CompteBancaire compte = new CompteBancaire();

        compte.setId("Mohamed Kamel");
        compte.deposer(100);
        compte.deposer(50);
        //pour acheter des livres
        compte.retirer(20);
        //etat courant du compte
        compte.afficher();

        CompteBancaire compteEpargne = new CompteBancaire();
        //transferer les 100 unites  de compte vers compteEpargne
        compte.transferer(100, compteEpargne);
    }
}
