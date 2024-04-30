import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table {
  public static void main(String[] args) {
    JFrame jf = new JFrame();
    jf.setTitle("Jeu de dame");

    // Menu Bar :
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edition = new JMenu("Edition");
    JMenu nomEtPrenom = new JMenu("Nom et Prenom");
    JMenu sectionEtGroupe = new JMenu("Section et Groupe");

    // Create an ActionListener
    ActionListener menuListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
          JOptionPane.showMessageDialog(null, "You clicked " + actionEvent.getActionCommand());
      }
    };

    // Create JMenuItem and add ActionListener to it
    JMenuItem fileItem = new JMenuItem("File Item");
    fileItem.addActionListener(menuListener);
    file.add(fileItem);

    JMenuItem editionItem = new JMenuItem("Edition Item");
    editionItem.addActionListener(menuListener);
    edition.add(editionItem);

    JMenuItem nomEtPrenomItem = new JMenuItem("Nom et Prenom Item");
    nomEtPrenomItem.addActionListener(menuListener);
    nomEtPrenom.add(nomEtPrenomItem);

    JMenuItem sectionEtGroupeItem = new JMenuItem("Section et Groupe Item");
    sectionEtGroupeItem.addActionListener(menuListener);
    sectionEtGroupe.add(sectionEtGroupeItem);

    menuBar.add(file);
    menuBar.add(edition);
    menuBar.add(nomEtPrenom);
    menuBar.add(sectionEtGroupe);
    jf.setJMenuBar(menuBar);

    Dessin p = new Dessin();
    jf.getContentPane().add(p);
    jf.pack();
    jf.setLocationRelativeTo(null);
    jf.setVisible(true);
    jf.setResizable(false);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}