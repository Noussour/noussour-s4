public class PPInterface {
    public static void main(String[] args) {
        // à compléter … créer un tableau de Modifiable contenant de 2 objets AA et 2 objets BB.
        Modifiable[] tab = new Modifiable[4];
        tab[0] = new AA();
        tab[1] = new BB();
        tab[2] = new AA();
        tab[3] = new BB();


        // à compléter … afficher le tableau.
        for (Modifiable modifiable : tab) {
            System.out.println(modifiable);
        }


        // à compléter … déclencher la méthode zoomer() pour les éléments du tableau.
        // les AA sont divisés par 2.
        // les BB sont divisés par 4.
        for (Modifiable modifiable : tab) {
            if (modifiable.getClass() == AA.class) {
                modifiable.zoomer(2);
            } else {
                modifiable.zoomer(1);
            }
        }


        // à compléter … afficher le tableau.
        System.out.println("\nAprès zoom, le tableau est :");
        for (Modifiable modifiable : tab) {
            System.out.println(modifiable);
        }


    }
}
