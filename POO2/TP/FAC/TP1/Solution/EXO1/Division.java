package EXO1;

public class Division {
    private int numerator;
    private int denominator;


    public Division(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void divide() {
        System.out.println(this.numerator + "/" + this.denominator + " = " + (this.numerator / this.denominator) );
    }

}
