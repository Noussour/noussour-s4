import java.awt.*;

public class Case {
  private Graphics g;

  public Case(Graphics g) {
    this.g = g;
    this.draw();
  }

  public void draw() {
    // draw a checker table of 8x8
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i + j) % 2 == 0) {
          g.setColor(Color.WHITE);
        } else {
          g.setColor(Color.BLACK);
        }
        g.fillRect(i * 50, j * 50, 50, 50);
      }
    }
  }

  public Color getColor(int x, int y) {
    return (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
  }
}
