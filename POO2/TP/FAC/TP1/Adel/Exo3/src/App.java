import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Octet> Octets = new ArrayList<Octet>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nombre d'octets que vous voulez utiliser : ");
        int nb = sc.nextInt();

        for (int i = 0; i < nb; i++) {
            ArrayList<Bit> octet = new  ArrayList<Bit>();
            for (int j = 0; j < 8; j++) {
                if (Math.random()  > 0.7) {
                    octet.add(new Bit(1));
                } else {
                    octet.add(new Bit(0));
                }
            }
            Octets.add(new Octet(octet));
        }

        ArrayList<Bit> octet1 = new  ArrayList<Bit>();
        for (int j = 0; j < 8; j++) {
            System.out.print("Bit" + (j+1) + ": ");
            int bit = sc.nextInt();
            octet1.add(new Bit(bit));
        }
        
        //*Question 4 :
        try {
            Octets.add(new Octet(octet1));
        } catch (IllegalArgumentException e) {
            for (int j = 0; j < 8; j++) {
                octet1.set(j, new Bit(0));
            }
            Octets.add(new Octet(octet1));
        }
        

        Octet result = Octets.get(0);
        for (int i = 1; i < nb; i++) {
            result  = Octet.OrLogique(result, Octets.get(i));
        }
        
        System.out.println("\nLes elements du tableau est : \n");
        for (Octet octet : Octets) {
            System.out.println(octet);
        }

        //*Question 3 :
        System.out.println("\nLe résultat est : \n" + result);
        



        sc.close();
    }
}
