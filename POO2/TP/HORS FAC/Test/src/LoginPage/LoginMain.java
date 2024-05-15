package LoginPage;
import javax.swing.*;
import java.awt.*;

public class LoginMain {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}