import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class Dessin extends JPanel {
  int[][] m;
  Piece selectedPiece = null;

  public Dessin() {
    this.m = M();
    setPreferredSize(new Dimension(800, 800));

    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int x = e.getX() / 100;
        int y = e.getY() / 100;
        if (m[y][x] > 0) {
          selectedPiece = new Piece(getGraphics(), m, x, y);
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (selectedPiece != null) {
          int x = e.getX() / 100;
          int y = e.getY() / 100;
          m[selectedPiece.y][selectedPiece.x] = -1;
          m[y][x] = selectedPiece.id;
          selectedPiece = null;
          repaint();
        }
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        if (selectedPiece != null) {
          selectedPiece.x = e.getX() - 50;
          selectedPiece.y = e.getY() - 50;
          repaint();
        }
      }
    });
  }

  public void paint(Graphics g) {
    new Case(g);
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        if (m[i][j] > 0) {
          new Piece(g, m, j, i);
        }
      }
    }
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