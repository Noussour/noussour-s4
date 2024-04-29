import java.awt.*;
import javax.swing.*;

public class Piece {
  private final Graphics g;
  public int x, y, player;

  public Piece(Graphics g, int x, int y, int player) {
    this.g = g;
    this.x = x;
    this.y = y;
    this.player = player;
    this.draw();
  }

  public void draw() {
    if (player == 1) {
      g.setColor(Color.RED);
    } else {
      g.setColor(Color.WHITE);
    }
    g.fillOval(x * 50 + 10, y * 50 + 10, 30, 30);
  }
}
