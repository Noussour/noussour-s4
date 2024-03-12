import javax.swing.*;
import java.awt.*;


public class CalculatriceComplexe {
    public static void main(String[] args) {
        // Crée la fenetre
        JFrame fenetre= new JFrame("Ma première calculatrice");
        // Créer un panneau
        JPanel contenuFenetre = new JPanel();
        // Affecter un gestionnaire de disposition à ce panneau
        GridLayout disposition = new GridLayout(5, 3);
        contenuFenetre.setLayout(disposition);
        JTextField textField = new JTextField(10);
        JPanel panel1 = new JPanel();
        GridLayout p1 = new GridLayout(10, 5);
        JButton button0 = new JButton("0");
        JButton button1 = new JButton("0");
        JButton button2 = new JButton("0");
        JButton button3 = new JButton("0");
        JButton button4 = new JButton("0");
        JButton button5 = new JButton("0");
        JButton button6 = new JButton("0");
        JButton button7 = new JButton("0");
        JButton button8 = new JButton("0");
        JButton button9 = new JButton("0");


        contenuFenetre.add("North", textField);
        // ajouter le panneau dans la fenetre
        fenetre.setContentPane(contenuFenetre);
        // Positionner les dimensions et rend la fenêtre visible
        fenetre.setSize(400,100);
        fenetre.setVisible(true);
    }
}
