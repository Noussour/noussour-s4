import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class ChessGame {
    public static void main(String[] args) throws IOException {
        LinkedList<Piece> ps = new LinkedList<>();
        Piece.ps = ps ;
        ps.add(new Rook(0, 0, false, "./images/w-rook.png"));
        ps.add(new Knight(1, 0, false, "./images/w-knight.png"));
        ps.add(new Bishop(2, 0, false, "./images/w-bishop.png"));
        ps.add(new Queen(3, 0, false, "./images/w-queen.png"));
        ps.add(new King(4, 0, false, "./images/w-king.png"));
        ps.add(new Bishop(5, 0, false, "./images/w-bishop.png"));
        ps.add(new Knight(6, 0, false, "./images/w-knight.png"));
        ps.add(new Rook(7, 0, false, "./images/w-rook.png"));
        for (int i = 0; i < 8; i++) {
            ps.add(new Pawn(i, 1, false, "./images/w-pawn.png"));
        }

// Black pieces
        ps.add(new Rook(0, 7, true, "./images/b-rook.png"));
        ps.add(new Knight(1, 7, true, "./images/b-knight.png"));
        ps.add(new Bishop(2, 7, true, "./images/b-bishop.png"));
        ps.add(new Queen(3, 7, true, "./images/b-queen.png"));
        ps.add(new King(4, 7, true, "./images/b-king.png"));
        ps.add(new Bishop(5, 7, true, "./images/b-bishop.png"));
        ps.add(new Knight(6, 7, true, "./images/b-knight.png"));
        ps.add(new Rook(7, 7, true, "./images/b-rook.png"));
        for (int i = 0; i < 8; i++) {
            ps.add(new Pawn(i, 6, true, "./images/b-pawn.png"));
        }

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(10 , 10, Consts.WIDTH, Consts.HEIGHT);
        frame.setUndecorated(true);
        JPanel panel = new JPanel(){
                @Override
                public void paint(Graphics g) {
                    boolean isWhite = true ;
                    for(int y = 0 ; y < 8 ; y ++){
                        for(int x = 0 ; x < 8 ; x++){
                            if(isWhite) {
                                g.setColor(Color.WHITE.darker());
                            }else {
                                g.setColor(Color.BLACK);
                            }
                            g.fillRect(x*Consts.SQUARE_SIZE, y*Consts.SQUARE_SIZE, Consts.SQUARE_SIZE,Consts.SQUARE_SIZE);
                            isWhite = !isWhite;
                        }
                        isWhite = !isWhite;
                    }
                  for (Piece piece : ps){
                      g.drawImage(piece.getImage() , piece.getXp() , piece.getYp() , this);
                  }
                }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Mouse mouse = new Mouse(frame);
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
        frame.setVisible(true);
    }
}
