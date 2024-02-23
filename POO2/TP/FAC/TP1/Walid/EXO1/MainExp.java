package EXO1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainExp {
    public static void main(String[] args) throws GererException {
        Scanner scanner = new Scanner(System.in);
        try {
            Division division = new Division(scanner.nextInt(), scanner.nextInt());
            System.out.println(division.divide());
        }catch (GererException e) {


        }
        // or :
        /*
        try {
            Division division = new Division(scanner.nextInt(), scanner.nextInt());
            System.out.println(division.divide());
        }catch (GererException e){
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Division sur 0 ");
        }catch (InputMismatchException e){
            System.out.println("Veuillez saisir un entier");
        }
         */

        scanner.close();



    }
}
