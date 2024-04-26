import java.awt.*;
import javax.swing.*;

public class Vue extends JFrame {
  JTextField textField =
      new JTextField(20); // Create a Dimension object with the desired width and height
  Dimension dim = new Dimension(600, 50);
  // Affichage de la fenetreJPanel panel1 = new JPanel();

  JButton button0 = new JButton("1");
  JButton button1 = new JButton("2");
  JButton button2 = new JButton("3");
  JButton button12 = new JButton("+");
  JButton button3 = new JButton("4");
  JButton button4 = new JButton("5");
  JButton button5 = new JButton("6");
  JButton button13 = new JButton("-");
  JButton button6 = new JButton("7");
  JButton button7 = new JButton("8");
  JButton button8 = new JButton("9");
  JButton button11 = new JButton("=");
  JButton button9 = new JButton("0");
  JButton button10 = new JButton("*");
  JButton button14 = new JButton("/");
  JButton button15 = new JButton("");

  Controller controller;

  Vue() {
    // Créer un panneau
    JPanel contenuFenetre = new JPanel();
    // Affecter un gestionnaire de disposition à ce panneau
    BorderLayout disposition = new BorderLayout(5, 3);
    contenuFenetre.setLayout(disposition);

    // Créer un champ de texte

    JPanel panel = new JPanel();
    // Set the preferred size of the text field
    panel.setPreferredSize(dim);
    panel.setLayout(null);
    textField.setBounds(0, 0, 600, 50);
    panel.add(textField);
    contenuFenetre.add("North", panel);

    // add action listener to buttons
    button0.addActionListener(controller);
    button1.addActionListener(controller);
    button2.addActionListener(controller);
    button12.addActionListener(controller);
    button3.addActionListener(controller);
    button4.addActionListener(controller);
    button5.addActionListener(controller);
    button13.addActionListener(controller);
    button6.addActionListener(controller);
    button7.addActionListener(controller);
    button8.addActionListener(controller);
    button11.addActionListener(controller);
    button9.addActionListener(controller);
    button10.addActionListener(controller);
    button14.addActionListener(controller);
    button15.addActionListener(controller);

    // Créer un panneau pour les boutons

    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(4, 4));
    panel1.add(button0);
    panel1.add(button1);
    panel1.add(button2);
    panel1.add(button12);
    panel1.add(button3);
    panel1.add(button4);
    panel1.add(button5);
    panel1.add(button13);
    panel1.add(button6);
    panel1.add(button7);
    panel1.add(button8);
    panel1.add(button11);
    panel1.add(button9);
    panel1.add(button10);
    panel1.add(button14);
    panel1.add(button15);
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
    this.setContentPane(contenuFenetre);
    // Positionner les dimensions et rend la fenêtre visible
    this.setSize(600, 300);
    this.setResizable(false);
  }

  // important functions :
  public void ajouteSaisie(String s) {
    textField.setText(textField.getText() + s);
  }

  public void afficheTotal(int total) {
    textField.setText(String.valueOf(total));
  }

  public boolean entreeValid() {
    try {
      Integer.parseInt(textField.getText());
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public void erreur(String s) {
    JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
  }

  public int getEntree() {
    return Integer.parseInt(textField.getText());
  }

public void setController(Controller controller) {
    this.controller = controller;
  }
}
