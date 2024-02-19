
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Article> stock = new ArrayList<Article>();  //Declaration of an arraylist for the stock of articles
        Scanner input = new Scanner(System.in);
        boolean stop = false;
        boolean exist;
        String nom;
        int num, quantite;
        double prix;

        do {
            System.out.println("----- MAIN MENU -----\n");

            System.out.println("1- Rechercher un article par numéro");
            System.out.println("2- Ajouter un article au stock");
            System.out.println("3- Supprimer un article");
            System.out.println("4- QUITTER");

            System.out.print("\nEntrez votre choix : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEntrez le numero de l'article : ");
                    num = input.nextInt();
                    for (Article a : stock) {
                        if (a.getNum() == num) {
                            System.out.println(a + "\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nEntrez les informations de l'element a ajouter :");
                    System.out.print("Numero : ");
                    num = input.nextInt();
                    System.out.print("Nom : ");
                    nom = input.next();
                    System.out.print("Quantité : ");
                    quantite = input.nextInt();
                    System.out.print("Prix : ");
                    prix = input.nextDouble();
                    exist = false;
                    for (Article a : stock) {
                        if (a.getNum() == num) {
                            System.out.println("\nUn article avec ce numéro existe déja.\n");
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        stock.add(new Article(num, prix, quantite, nom));
                        System.out.println("\nL'ajout est réussi !\n");
                    }
                    break;
                case 3:
                    System.out.print("\nEntrez le numero de l'article a supprimer : ");
                    num = input.nextInt();
                    for (int index = 0; index < stock.size(); index++) {
                        if (stock.get(index).getNum() == num) {
                            stock.remove(index);
                            System.out.println("\nArticle suprimmée avec succées\n");
                            break;
                        }
                    }
                    break;
                case 4:
                    input.close();
                    stop = true; // Quitter l'application
                default:
                    System.err.println("\nChoix incorrect, veuillez entrer une option\n");
            }
        } while (!stop);

        


        input.close();
    }
}
