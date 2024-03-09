
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Article> stock = new ArrayList<>();  //Declaration of an arraylist for the stock of articles
        Scanner input = new Scanner(System.in);
        boolean stop = false;
        boolean exist;
        String nom;
        int num, quantite;
        double prix;
        int i = 0;

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
                        try {
                            ExistTest(a, num);
                            System.out.println(a + "\n");
                        } catch (NotExistException e) {
                            e.getMessage();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n\t----- INSERTION ------");
                    System.out.println("Entrez les informations de l'element a ajouter :");
                    try {
                        System.out.print("Numero : ");
                        num = input.nextInt();
                        if (num < 0) {
                            throw new NegativeException("Le numero de cette Article doit etre Positive");
                        }
                    } catch (NegativeException e) {
                        System.out.println(e.getMessage() + "\n Nous avons initialiser le numero automatiquement a : " + 0);
                        i++;
                        num = i;
                    }
                    System.out.print("Nom : ");
                    nom = input.next();
                    try {
                        System.out.print("Quantité : ");
                        quantite = input.nextInt();
                        if (quantite < 0) {
                            throw new NegativeException("Le numero de cette Article doit etre Positive");
                        }
                    } catch (NegativeException e) {
                        System.out.println(e.getMessage() + "\n Nous avons initialiser le numero automatiquement a : " + 0);
                        quantite = 0;
                    }
                    try {
                        System.out.print("Prix : ");
                        prix = input.nextDouble();
                        if (prix < 0) {
                            throw new NegativeException("Le numero de cette Article doit etre Positive");
                        }
                    } catch (NegativeException e) {
                        System.out.println(e.getMessage() + "\n Nous avons initialiser le numero automatiquement a : " + (i+1));
                        prix = 0;
                    }

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
                    if (stock.isEmpty()) {
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

    public static void ExistTest(Article articles, int X) {
        if (articles.getNum() != X) {
            throw new NotExistException("Cette Article n'existe pas");
        }
    }
}
