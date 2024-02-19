package EXO3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Octet> octets = new ArrayList<Octet>();

        int n= 10 ;
        for(int i = 0 ; i < n ; i++){
            Bit[] bits = new Bit[8];
            for(int j = 0 ; j < 8 ; j++){
                bits[j] = new Bit((char) (Math.random() < 0.5 ? '0' : '1'));
            }

            if(i == 5){
                bits[0] = new Bit('2');
            }
            try {
                octets.add(new Octet(bits));
            } catch (IllegalArgumentException e) {
                for(int j = 0 ; j < 8 ; j++){
                    bits[j] = new Bit('0');
                }
                octets.add(new Octet(bits));
            }
        }

        for (Octet octet : octets) {
            System.out.println(octet);
        }

        Octet octet = octets.getFirst();

        for (int i = 1; i < octets.size(); i++) {
            octet = Octet.OrLogic(octet, octets.get(i));
        }

        System.out.println( "Le OR Logique entre les touts cest : "+ octet);





    }
}
