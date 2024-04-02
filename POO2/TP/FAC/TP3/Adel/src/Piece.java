import java.awt.*;
import javax.swing.*;

public class Piece {
  private final Graphics g;
  private final int[][] m;

  public Piece(Graphics g, int[][] m) {
    this.g = g;
    this.m = m;
    this.draw();
  }

  public void draw() {
    int count = 1;
    int color = 0;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        if (m[i][j] == count) {
          if (color % 2 == 0) g.setColor(Color.RED);
          else g.setColor(Color.WHITE);
          g.fillOval(j * 100 + 20, i * 100 + 20, 60, 60);
          count++;
        }
      }
      color++;
    }
  }
}
