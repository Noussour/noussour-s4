
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
            System.out.println("\n\t----- MAIN MENU -----\n");

            System.out.println("1- Rechercher un article par numéro");
            System.out.println("2- Ajouter un article au stock");
            System.out.println("3- Supprimer un article");
            System.out.println("4- Afficher le contenu du stock");
            System.out.println("5- QUITTER");

            System.out.print("\nEntrez votre choix : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n\t----- RECHERCHE ------");
                    System.out.print("Entrez le numero de l'article : ");
                    num = input.nextInt();
                    for (Article a : stock) {
                        if (a.getNum() == num) {
                            System.out.println(a + "\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n\t----- INSERTION ------");
                    System.out.println("Entrez les informations de l'element a ajouter :");
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
                    System.out.println("\n\t----- SUPPRIMER ------");
                    System.out.print("Entrez le numero de l'article a supprimer : ");
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
                    System.out.println("\n\t----- AFFICHAGE ------");
                    if (stock.size() == 0) {
                        System.out.println("Le stock est vide !\n");
                        break;
                    }
                    System.out.println("Le contenue du stock est le suivant : \n");
                    for (Article art : stock) {
                        System.out.println(art);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n\tAU REVOIR !!");
                    input.close();
                    stop = true; // Quitter l'application
                default:
                    System.err.println("\nChoix incorrect, veuillez entrer une option\n");
            }
        } while (!stop);

        


        input.close();
    }
}
