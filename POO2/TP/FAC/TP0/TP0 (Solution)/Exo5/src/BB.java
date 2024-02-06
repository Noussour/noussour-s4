public class BB extends B implements Modifiable{
    private String chaine;

    public BB() {
        this.chaine = "BB";
        this.numero = MAX;
    }

    @Override
    public String toString() {
        return "===== BB =====\n" + super.toString() + "\nChaine : " + this.chaine;
    }

    public void zoomer(int n) {
        if (this.numero >= MIN) {
            this.numero /= n;
        }
    }
}
