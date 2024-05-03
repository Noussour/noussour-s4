import java.awt.image.BufferedImage;
import java.util.LinkedList;

public abstract class ChessPiece {
    int xp ;
    int yp ;
    boolean isWhite ;
    LinkedList<ChessPiece> ps ;
    String name ;
    public BufferedImage image ;

    public ChessPiece(int xp, int yp, boolean isWhite , LinkedList<ChessPiece> ps , BufferedImage image) {
        this.xp = xp;
        this.yp = yp;
        this.isWhite = isWhite;
        this.ps = ps ;
        this.image = image ;
    }

    public void move (int xp , int yp) {
        for(ChessPiece piece : ps){
            if(piece.xp == this.xp && piece.yp == this.yp){
                piece.kill();
                return ;
            }
        }
        this.xp = xp ;
        this.yp = yp ;
    }

    public void kill () {
        ps.remove(this);
    }
}
