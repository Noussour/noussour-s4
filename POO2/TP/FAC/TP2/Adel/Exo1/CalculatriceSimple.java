import javax.swing.*;
import java.awt.*;

public class CalculatriceSimple {
    public static void main(String[] args) {
    // Crée la fenetre
    JFrame fenetre= new JFrame("Ma première calculatrice");
    // Créer un panneau
    JPanel contenuFenetre = new JPanel();
    // Affecter un gestionnaire de disposition à ce panneau
    GridLayout disposition = new GridLayout(5, 3);
    contenuFenetre.setLayout(disposition);
    // Créer les contrôles en mémoire
    JLabel label1 = new JLabel("Number 1 :");
    JTextField entree1 = new JTextField(10);
    JLabel label2 = new JLabel("Number 2 :");
    JTextField entree2 = new JTextField(10);
    JLabel label3 = new JLabel("Somme :");
    JTextField resultat = new JTextField(10);
    JButton lancer = new JButton("Ajouter");
    // Ajoute les contrôles au panneau
    contenuFenetre.add(label1);
    contenuFenetre.add(entree1);
    contenuFenetre.add(label2);
    contenuFenetre.add(entree2);
    contenuFenetre.add(label3);
    contenuFenetre.add(resultat);
    contenuFenetre.add(lancer);
    // ajouter le panneau dans la fenetre
    fenetre.setContentPane(contenuFenetre);
    // Positionner les dimensions et rend la fenêtre visible
    fenetre.setSize(400,100);
    fenetre.setVisible(true);}
}