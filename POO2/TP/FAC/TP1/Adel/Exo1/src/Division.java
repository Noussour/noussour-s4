public class Division {
    private int num;
    private int denom;

    public Division(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public void Div() {
        System.out.println(num + " / " + denom + " = " + (num / denom));
    }
}
