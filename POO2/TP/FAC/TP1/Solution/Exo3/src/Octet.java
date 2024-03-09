import java.util.ArrayList;

public class Octet {
    //* Question 2 :
    private final ArrayList<Bit> octet;

    public Octet(ArrayList<Bit> octet) {
        for (Bit bit : octet) {
            if (bit.getValue() != 0 && bit.getValue() != 1) {
                throw new IllegalArgumentException("Valeur de bit invalide");
            }
        }
        this.octet = octet;
    }

    public ArrayList<Bit> getOctet() {
        return octet;
    }

    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder("Octet : ");
        for (Bit b : this.octet) {
            resultat.append(b.getValue());
        }
        return resultat.toString();
    }

    public static Octet OrLogique(Octet o1, Octet o2){
        int i=0;
        Octet res = new Octet(new ArrayList<>());
        while (i < 8 ) {
            Bit b1 = o1.getOctet().get(i);
            Bit b2 = o2.getOctet().get(i);
            Bit bRes = new Bit((b1.getValue()) | (b2.getValue()));
            res.getOctet().add(bRes);
            i++;
        }
        return res;
    }
}
