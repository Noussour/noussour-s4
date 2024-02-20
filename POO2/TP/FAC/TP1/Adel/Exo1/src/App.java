import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws GererException {
        //Question 1 :
        Scanner input = new Scanner(System.in);
        int num, deno;
        // System.out.print("Enter 1st number : ");
        // int num = input.nextInt();
        // System.out.print("Enter 2nd number : ");
        // int deno = input.nextInt();
        // Division div = new Division(num, deno);

        // div.Division();

        //Question 2 :
        //Exception de division par 0 : ArithmeticException
        //Exception de mauvais type pendant l'input  : InputMismatchException

        //Question 3 :
        try {
            System.out.print("Enter 1st number : ");
            num = input.nextInt();
            System.out.print("Enter 2nd number : ");
            deno = input.nextInt();
            Division div = new Division(num, deno);
            div.Div();
        } catch (ArithmeticException e) {
            System.out.println(e + " : Impossible de diviser par zéro.");
        } catch (InputMismatchException e) {
            System.out.println(e + " : Les entrées ne sont pas des nombres entiers.");
        }

        try {
            if (input.hasNextLine()) {  // Vider le buffer
                input.nextLine();
            }
            System.out.print("Enter 1st number : ");
            num = input.nextInt();
            System.out.print("Enter 2nd number : ");
            deno = input.nextInt();
            Division div = new Division(num, deno);
            Test(num, deno);
            div.Div();
        } catch (GererException e) {
            System.out.println(e.getMessage());
        }
        input.close();
    }

    public static void Test(int x, int y) throws GererException{
        if(x < y){
            throw new GererException("Logiciel non valable");
        }
    }
}
