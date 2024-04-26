import java.awt.*;
import javax.swing.*;

public class CalculatriceComplexe {
  public static void main(String[] args) {
    Model model = new Model();
    Vue vue = new Vue();
    Controller controller = new Controller(vue, model);
    vue.setController(controller);

    vue.setVisible(true);
  }
}
