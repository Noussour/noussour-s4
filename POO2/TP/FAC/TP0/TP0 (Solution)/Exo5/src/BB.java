public class BB extends B implements Modifiable{
    private String chaine;

    public BB() {
        this.chaine = "BB";
        this.numero = 200;
    }

    @Override
    public String toString() {
        return "===== BB =====\n" + super.toString() + "\nChaine : " + this.chaine;
    }

    public void zoomer(int n) {
        if(n < MIN)
            n = MIN;
        if(n > MAX)
            n = MAX;

        if (n < 2)
            this.numero /= 2;
            
    }
}
