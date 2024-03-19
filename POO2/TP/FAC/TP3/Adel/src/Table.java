import javax.swing.*;
import java.awt.*;

public class Table {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setTitle("Jeu de dame");
        jf.setSize(490,517);
        jf.setLocationRelativeTo(null);
        Dessin p = new Dessin();
        jf.getContentPane().add(p);
        jf.setVisible(true) ;
    }
}
