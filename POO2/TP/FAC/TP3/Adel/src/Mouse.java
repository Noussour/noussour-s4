import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
    JFrame frame;

    Mouse(JFrame frame) {
        this.frame = frame;
    }

    static Piece piece = null;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("pressed");
        System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
        piece = (Piece.getPiece(mouseEvent.getX(), mouseEvent.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (piece != null) {
            piece.move(Piece.getRowFromX(mouseEvent.getX()), Piece.getColFromY(mouseEvent.getY()));
            frame.repaint();
        }

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (piece != null) {
            piece.xp = mouseEvent.getX() - 50;
            piece.yp = mouseEvent.getY() - 50;
            frame.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
