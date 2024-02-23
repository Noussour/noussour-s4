package EXO1;

public class Division {
    private int numerator;
    private int denominator;


    public Division(int numerator, int denominator) throws GererException {
        if (denominator == 0) {
            throw new GererException("Logiciel non valable");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int divide() {
        return this.numerator/this.denominator ;
    }

}
