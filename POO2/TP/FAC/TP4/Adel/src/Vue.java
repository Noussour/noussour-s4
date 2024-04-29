import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Vue extends JFrame {
  JTextField textField =
      new JTextField(20); // Create a Dimension object with the desired width and height
  Dimension dim = new Dimension(600, 50);
  // Affichage de la fenetre

  JButton addButton = new JButton("+");
  JButton subButton = new JButton("-");
  JButton mulButton = new JButton("*");
  JButton divButton = new JButton("/");
  JButton eqButton = new JButton("=");
  JButton resetButton = new JButton("C");

  JButton button0 = new JButton("0");
  JButton button1 = new JButton("1");
  JButton button2 = new JButton("2");
  JButton button3 = new JButton("3");
  JButton button4 = new JButton("4");
  JButton button5 = new JButton("5");
  JButton button6 = new JButton("6");
  JButton button7 = new JButton("7");
  JButton button8 = new JButton("8");
  JButton button9 = new JButton("9");

  Vue() {
    // Créer un panneau
    JPanel contenuFenetre = new JPanel();
    textField.setEditable(false);
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

    // Créer un panneau pour les boutons

    JPanel panel1 = new JPanel();

    panel1.setLayout(new GridLayout(4, 4));
    panel1.add(button1);
    panel1.add(button2);
    panel1.add(button3);
    panel1.add(addButton);
    panel1.add(button4);
    panel1.add(button5);
    panel1.add(button6);
    panel1.add(subButton);
    panel1.add(button7);
    panel1.add(button8);
    panel1.add(button9);
    panel1.add(mulButton);
    panel1.add(button0);
    panel1.add(resetButton);
    panel1.add(divButton);
    panel1.add(eqButton);
    contenuFenetre.add("Center", panel1);

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

  public void addCalculationListener(ActionListener calcListener) {
    button0.addActionListener(calcListener);
    button1.addActionListener(calcListener);
    button2.addActionListener(calcListener);
    button3.addActionListener(calcListener);
    button4.addActionListener(calcListener);
    button5.addActionListener(calcListener);
    button6.addActionListener(calcListener);
    button7.addActionListener(calcListener);
    button8.addActionListener(calcListener);
    button9.addActionListener(calcListener);
    addButton.addActionListener(calcListener);
    subButton.addActionListener(calcListener);
    mulButton.addActionListener(calcListener);
    divButton.addActionListener(calcListener);
    eqButton.addActionListener(calcListener);
    resetButton.addActionListener(calcListener);
  }
}
