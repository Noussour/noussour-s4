package EXO1;

import java.util.Scanner;

public class MainExp {
    public static void main(String[] args) throws GererException {
        Scanner scanner = new Scanner(System.in); int numerator , denominator;
        try {
            System.out.println("Entrez le numérateur : ");
            numerator = scanner.nextInt();
        }
        catch (Exception e) {
            System.out.println("Erreur de saisie");
            return;
        }
        try {
            System.out.println("Entrez le dénominateur : ");
            denominator = scanner.nextInt();
        }
        catch (Exception e) {
            System.out.println("Erreur de saisie");
            return;
        }
        if(numerator < denominator) throw  new GererException("Logiciel non valable");
        Division division = new Division(numerator, denominator);
        try {
            division.divide();
        } catch (ArithmeticException e) {
            System.out.println("Division par zéro impossible");
        }



    }
}
