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
    setPreferredSize(new Dimension(400, 400));

    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int x = e.getX() / 50;
        int y = e.getY() / 50;
        if (m[y][x] > 0) {
          selectedPiece = new Piece(getGraphics(), x, y, m[y][x]);
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (selectedPiece != null) {
          int x = e.getX() / 50;
          int y = e.getY() / 50;
          Case c = new Case(getGraphics());
          Color color = c.getColor(x, y);
          if (color == Color.BLACK && m[y][x] != selectedPiece.player) {
            m[selectedPiece.y][selectedPiece.x] = -1;
            m[y][x] = selectedPiece.player;
            selectedPiece = null;
          }
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
            Piece p = new Piece(g, j, i, m[i][j]);
        }
      }
    }
    if (selectedPiece != null) {
      selectedPiece.draw();
    }
  }

  public static int[][] M() {
    return new int[][] {
      {-1, 1, -1, 1, -1, 1, -1, 1},
      {1, -1, 1, -1, 1, -1, 1, -1},
      {-1, 1, -1, 1, -1, 1, -1, 1},
      {-1, -1, -1, -1, -1, -1, -1, -1},
      {-1, -1, -1, -1, -1, -1, -1, -1},
      {2, -1, 2, -1, 2, -1, 2, -1},
      {-1, 2, -1, 2, -1, 2, -1, 2},
      {2, -1, 2, -1, 2, -1, 2, -1}
    };
  }
}