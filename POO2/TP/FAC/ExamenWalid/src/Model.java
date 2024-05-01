public class Model {
    private double a ;
    private double b ;
    private double c ;
    Model () {

    }

    double Deltat() {
       double delta;
        delta = b * b - 4 * a * c;
        if (delta < 0) {
            throw new Controller.DeltaInvalid("Pas de Solution dans R.");
        }
        return delta;
    }

    public double calculateRoot1() {
        return (-b + Math.sqrt(Deltat())) / (2 * a);
    }

    public double calculateRoot2() {
        return (-b - Math.sqrt(Deltat())) / (2 * a);
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }


    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
}
