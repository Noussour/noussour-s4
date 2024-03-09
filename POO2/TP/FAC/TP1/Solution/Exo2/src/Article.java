public class Article {
    private int num, qte;
    private double prix;
    private String nom;

    public Article(int num, double prix, int qte, String nom) {
        this.num = num;
        this.prix = prix;
        this.qte = qte;
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public double getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Article [num=" + num + ", prix=" + prix + ", qte=" + qte + ", nom=" + nom + "]";
    }
    
}
