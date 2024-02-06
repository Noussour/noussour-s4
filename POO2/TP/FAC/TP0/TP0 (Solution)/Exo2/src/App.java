import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //TEST
        // Citoyen adel = new Citoyen("mo7", "adel", 32, 3218, "omar nahnah", "belcourt");
        // adel.afficher();

        //Question 3 :
        Citoyen[] C = new Citoyen[10];
        for (int i=0;i<C.length;i++) {
            String nom = "NOM_" + i ;
            int num = 32 + i;
            int codePostale = 1975 + i;
            String prenom = "PRENOM_" + i ;
            String rue = "rue" + i;    
            String ville = "ville" + i;
            C[i] = new Citoyen(nom, prenom, num, codePostale, rue, ville);
        }

        //TEST    
        // for (Citoyen citoyen : C) {
        //     citoyen.afficher();
        // }

        //TEST
        // C[3].getAdresse().setVille("ville5");
        // C[7].getAdresse().setVille("ville5");

        Scanner input = new Scanner(System.in);
        
        System.out.print("Entrez la ville à recherche : ");
        String V = input.nextLine();

        System.out.println("\nCitoyens  de " + V + ":\n");
        for (Citoyen citoyen : C) {
            if (citoyen.hasVille(V)) {
                citoyen.afficher();
            }
        }
        
        input.close();
    }
}
