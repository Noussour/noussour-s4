import java.awt.*;

public class Case {
    private Graphics g;
    private int[][] m;

    public Case(Graphics g, int[][] m) {
        this.g = g;
        this.m = m;
    }

    public Graphics getG() {
        return g;
    }
    public void setG(Graphics g) {
        this.g = g;
    }

    public int[][] getM() {
        return m;
    }
    public void setM(int[][] m) {
        this.m = m;
    }
}
