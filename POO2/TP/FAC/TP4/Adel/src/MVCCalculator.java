import java.awt.*;
import javax.swing.*;

public class MVCCalculator {
  public static void main(String[] args) {
    Model model = new Model();
    Vue vue = new Vue();
    Controller controller = new Controller(vue, model);

    vue.setVisible(true);
  }
}
