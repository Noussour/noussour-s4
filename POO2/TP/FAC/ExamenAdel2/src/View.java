import java.awt.*;
import javax.swing.*;

public class View extends JFrame {
  JLabel chiffreLabel = new JLabel("Enter a number: ");
  JTextField chiffreTextField = new JTextField(10);
  JButton chiffreButton = new JButton("Convert");
  JLabel mounthLabel = new JLabel("The mounth is: ");
  JTextField mounthTextField = new JTextField(10);

  View() {
    JPanel mainPanel = new JPanel();
    JPanel mounthPanel = new JPanel();
    mainPanel.setBackground(Color.PINK);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600, 400);
    this.setResizable(false);
    mounthPanel.setBackground(Color.BLUE);
    mounthPanel.add(mounthLabel);
    mounthPanel.add(mounthTextField);
    mainPanel.add(chiffreLabel);
    mainPanel.add(chiffreTextField);
    mainPanel.add(chiffreButton);
    mainPanel.add(mounthPanel, BorderLayout.CENTER);
    this.add(mainPanel);
  }

  public String getChiffre() {
    return chiffreTextField.getText();
  }

  public boolean ValidateChiffre() {
    try {
      if (Integer.parseInt(chiffreTextField.getText()) < 1
          || Integer.parseInt(chiffreTextField.getText()) > 12
          || chiffreTextField.getText().isEmpty()) {
        throw new InvalidMounthException("Invalid mounth");
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  public void showError() {
    JOptionPane.showMessageDialog(
        this,
        "Invalid mounth, it should be a number between 1 and 12",
        "Error",
        JOptionPane.ERROR_MESSAGE);
  }
}
