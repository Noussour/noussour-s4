package EXO2;

import EXO2.Article;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public void commands() {
        System.out.println("1. Add an article");
        System.out.println("2. Remove an article");
        System.out.println("3. Search for an article");
        System.out.println("4. Quit");
    }

    public Article search(ArrayList<Article> stock, int number) {
        for (Article article : stock) {
            if (article.number == number) {
                return article;
            }
        }
        return null;
    }

    public boolean add(ArrayList<Article> stock, Article article) {
        if (search(stock, article.number) == null) {
            stock.add(article);
            return true;
        }
        return false;
    }

    public boolean remove(ArrayList<Article> stock, int number) {
        Article article = search(stock, number);
        if (article != null) {
            stock.remove(article);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Article> stock = new ArrayList<>();
        Main mainObj = new Main();

        while (true) {
            mainObj.commands();
            System.out.print("Enter your choice : ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
                continue;
            }

            switch (choice) {
                case 1:
                    int number;
                    String name;
                    float price;

                    System.out.print("Enter the article number : ");
                    while (true) {
                        try {
                            number = scanner.nextInt();
                            break; // Exit the loop if input is valid
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Enter the article name : ");
                    name = scanner.next();

                    System.out.print("Enter the article price : ");
                    while (true) {
                        try {
                            price = scanner.nextFloat();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid price.");
                            scanner.nextLine();
                        }
                    }

                    Article article = new Article(number, name, price);
                    if (mainObj.add(stock, article)) {
                        System.out.println("Article added successfully");
                    } else {
                        System.out.println("Article already exists");
                    }
                    break;

                case 2:
                    System.out.print("Enter the article number to remove : ");
                    while (true) {
                        try {
                            int numberToRemove = scanner.nextInt();
                            if (mainObj.remove(stock, numberToRemove)) {
                                System.out.println("Article removed successfully");
                            } else {
                                System.out.println("Article not found");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the article number to search : ");
                    while (true) {
                        try {
                            int numberToSearch = scanner.nextInt();
                            Article searchedArticle = mainObj.search(stock, numberToSearch);
                            if (searchedArticle != null) {
                                searchedArticle.display();
                            } else {
                                System.out.println("Article not found");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}
