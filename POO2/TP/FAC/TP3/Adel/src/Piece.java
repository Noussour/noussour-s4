import java.awt.*;
import javax.swing.*;

public class Piece {
  private final Graphics g;
  private final int[][] m;
  public int x, y, id;

  public Piece(Graphics g, int[][] m, int x, int y) {
    this.g = g;
    this.m = m;
    this.x = x;
    this.y = y;
    this.id = m[y][x];
    this.draw();
  }

  public void draw() {
    int count = 1;
    int color = 0;
    int x;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        if (m[i][j] == count) {
          if (color % 2 == 0) g.setColor(Color.RED);
          else g.setColor(Color.WHITE);
          g.fillOval(j * 100 + 20, i * 100 + 20, 60, 60);
          g.setColor(Color.BLACK);
          g.setFont(new Font("Arial", Font.BOLD, 24));
          x = (count >= 10) ? j * 100 + 34 : j * 100 + 42;
          g.drawString(Integer.toString(count), x, i * 100 + 60);
          count++;
        }
      }
      color++;
    }
  }
}
