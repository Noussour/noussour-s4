import java.awt.*;
import javax.swing.*;

public class Table {
  public static void main(String[] args) {
    JFrame jf = new JFrame();
    jf.setTitle("Jeu de dame");
    Dessin p = new Dessin();
    jf.getContentPane().add(p);
    jf.pack();
    jf.setLocationRelativeTo(null);
    jf.setVisible(true);
    jf.setResizable(false);
  }
}