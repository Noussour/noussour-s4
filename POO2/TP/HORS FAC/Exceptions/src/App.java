
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CustomException {
        
        int[] arr = {1, 2, 3, 4, 5};
        Scanner scanner = new Scanner(System.in);

        System.out.println(arr[3]);
        // System.out.println(arr[5]);   it will throw ArrayIndexOutOfBoundsException

        //TRY-CATCH-FINALLY BLOCKS :
        try {   //instructions you want to test
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {    //to handle the exception
            System.out.println("An ArrayIndexOutOfBoundsException has occured !");
        } finally {     //this block will be executed in both cases
            System.out.println("This is the end of the program.");
        }

        System.out.println("\n\n");

        //MULTIPLE EXEPTIONS CASE :
        //1st Method :
        try {
            System.out.print("Age : ");
            int Age1 = scanner.nextInt();    //if we enter  a string instead of number it will throw InputMismatchException
            System.out.println(Age1);
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException has occured !");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException has occured !");
        } finally {
            System.out.println("End of the program!");
        }

        //2nd Method :
        try {
            System.out.print("Age : ");
            int Age2;
            if (scanner.hasNextInt()) { //verify if the input buffer contains an int or a string
                Age2 = scanner.nextInt();    //if we enter  a string instead of number it will throw InputMismatchException
            } else {
                scanner.next();
                Age2 = scanner.nextInt();
            }
            
            System.out.println(Age2);
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("ArrayIndexOutOfBoundsException or InputMismatchException has occured !");
        } finally {
            System.out.println("End of the program!");
        }

        System.out.println("\n\n");

        //USE A CUSTOM EXCEPTION :
        try {
            valideAge(-5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The message : " + e.getMessage());
            System.out.println("The cause : " + e.getCause());
        }
        
   

        scanner.close();
    }

    public static void valideAge(int Age) throws CustomException{
        if (Age < 0) {
            //throwing our own exception if the age had a negative value
            throw new CustomException("You entered an invalid age !", new IOException());
        }
    }
}
