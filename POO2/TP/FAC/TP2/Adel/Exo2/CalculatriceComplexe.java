import javax.swing.*;
import java.awt.*;


public class CalculatriceComplexe {
    public static void main(String[] args) {
        // Crée la fenetre
        JFrame fenetre= new JFrame("Calculatrice");
        // Créer un panneau
        JPanel contenuFenetre = new JPanel();
        // Affecter un gestionnaire de disposition à ce panneau
        BorderLayout disposition = new BorderLayout(5, 3);
        contenuFenetre.setLayout(disposition);

        // Créer un champ de texte
        JTextField textField = new JTextField("Hello", 20);// Create a Dimension object with the desired width and height
        Dimension dim = new Dimension(600, 50);
        JPanel panel = new JPanel();
        // Set the preferred size of the text field
        panel.setPreferredSize(dim);
        panel.setLayout(null);
        textField.setBounds(0, 0, 600, 50);
        panel.add(textField);
        contenuFenetre.add("North", panel);

        // Créer un panneau pour les boutons
        JPanel panel1 = new JPanel();
        GridLayout layout1 = new GridLayout(4, 3);
        panel1.setLayout(layout1);
        JButton button0 = new JButton("1");
        JButton button1 = new JButton("2");
        JButton button2 = new JButton("3");
        JButton button3 = new JButton("4");
        JButton button4 = new JButton("5");
        JButton button5 = new JButton("6");
        JButton button6 = new JButton("7");
        JButton button7 = new JButton("8");
        JButton button8 = new JButton("9");
        JButton button9 = new JButton("0");
        JButton button10 = new JButton(",");
        JButton button11 = new JButton("=");
        panel1.add(button0);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(button10);
        panel1.add(button11);
        contenuFenetre.add("Center", panel1);

//        JPanel panel2 = new JPanel();
//        GridLayout layout2 = new GridLayout(2, 3);
//        panel2.setLayout(layout2);
//        JButton buttonPlus = new JButton("+");
//        JButton buttonMoins = new JButton("-");
//        JButton buttonFois = new JButton("*");
//        JButton buttonDiv = new JButton("/");
//        JButton buttonEgal = new JButton("=");
//        panel2.add(buttonPlus);
//        panel2.add(buttonMoins);
//        panel2.add(buttonFois);
//        panel2.add(buttonDiv);
//        panel2.add(buttonEgal);
//        contenuFenetre.add("West", panel2);


        // ajouter le panneau dans la fenetre
        fenetre.setContentPane(contenuFenetre);
        // Positionner les dimensions et rend la fenêtre visible
        fenetre.setSize(600,300);
        fenetre.setVisible(true);
    }
}
