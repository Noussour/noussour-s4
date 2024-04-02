import java.awt.*;
import javax.swing.*;

public class Dessin extends JPanel {
  int[][] m;

  public Dessin() {
    this.m = M();
  }

  public void paint(Graphics g) {
    new Case(g);
    new Piece(g, m);
  }

  public static int[][] M() {
    return new int[][] {
      {-1, 1, -1, 2, -1, 3, -1, 4},
      {5, -1, 6, -1, 7, -1, 8, -1},
      {-1, 9, -1, 10, -1, 11, -1, 12},
      {-3, -1, -3, -1, -3, -1, -3, -1},
      {-1, -3, -1, -3, -1, -3, -1, -3},
      {13, -1, 14, -1, 15, -1, 16, -1},
      {-1, 17, -1, 18, -1, 19, -1, 20},
      {21, -1, 22, -1, 23, -1, 24, -1}
    };
  }
}
