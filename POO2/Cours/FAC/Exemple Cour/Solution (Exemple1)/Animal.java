abstract public class Animal {
    int poids;
    String coleur;

    void manger(){
        System.out.println("Je suis un animal, et je mange de la viande");
    }
    void boire(){
        System.out.println("Je suis un animal, et je bois de l'eau");
    }

    //Abstract
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
