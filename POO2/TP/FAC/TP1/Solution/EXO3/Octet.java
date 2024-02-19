package EXO3;

import java.util.Arrays;

public class Octet {
    private Bit[] bits ;

    public Octet(Bit[] bits){
        for (Bit bit : bits) {
            if(!bit.toString().equals("0") && !bit.toString().equals("1")){
                throw new IllegalArgumentException("Les bits doivent être des 0 ou des 1");
            }
        }

        if(bits.length != 8){
            throw new IllegalArgumentException("Un octet doit être composé de 8 bits");
        }

        this.bits = bits;

    }

    @Override
    public String toString() {
        return Arrays.toString(this.bits);
    }

    public static Octet OrLogic(Octet octet1 , Octet octet2){
        Bit[] bits = octet1.bits;
        for(int i = 0 ; i < bits.length ; i++){
            if(octet2.bits[i].toString().equals("1") && bits[i].toString().equals("0")){
                bits[i].invert();
            }
        }
        return new Octet(bits);
    }

}
