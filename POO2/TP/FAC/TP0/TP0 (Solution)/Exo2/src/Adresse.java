public class Adresse {
    //Question 1 :
    private int num, codePostale;
    private String rue, ville;

    public Adresse(int num, int codePostale, String rue, String ville) {
        this.num = num;
        this.codePostale = codePostale;
        this.rue = rue;
        this.ville = ville;
    }

    

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public int getCodePostale() {
        return codePostale;
    }
    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    public void Afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  "{" + "num=" + num + ", codePostale=" + codePostale + ", rue='" + rue + '\'' + ", ville='" + ville + '\'' + '}';
    }

   
}
