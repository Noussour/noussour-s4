public class AA extends A implements Modifiable {
    private String nom;

    public AA() {
        this.nom = "AA";
        this.taille = MAX;
    }

    @Override
    public String toString() {
        return "===== AA =====\n" + super.toString() + "\nNom : " + this.nom;
    }

    public void incrementer() {
        this.taille++;
    }

    public void zoomer(int n) {
        if (this.taille >= MIN) {
            this.taille /= n;
        }
    }
}
