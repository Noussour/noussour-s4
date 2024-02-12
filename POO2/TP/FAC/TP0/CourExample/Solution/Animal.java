abstract public class Animal {
    int poids ;
    String coleur ;

    void manger(){
        System.out.println("Je mange de la viande");
    }
    void boire(){
        System.out.println("Je bois de l'eau");
    }
    abstract void deplacement();
    abstract void crier();

    @Override
    public String toString() {
        return "Animal{" +
                "poids=" + poids +
                ", coleur='" + coleur + '\'' +
                '}';
    }
}
