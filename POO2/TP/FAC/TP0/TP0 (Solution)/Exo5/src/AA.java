public class AA extends A implements Modifiable {
    private String nom;

    public AA() {
        this.nom = "AA";
        this.taille = 200;
    }

    @Override
    public String toString() {
        return "===== AA =====\n" + super.toString() + "\nNom : " + this.nom;
    }

    public void incrementer() {
        this.taille++;
    }

    public void zoomer(int n) {
        if(n < MIN)
            n = MIN;
        if(n > MAX)
            n = MAX;

        if (n >= 2) {
            this.taille *= 2;
        }
    }
}
