import java.awt.*;
import javax.swing.*;

public class CalculatriceComplexe {
  public static void main(String[] args) {
    Model model = new Model();
    Controler controler = new Controler();
    Vue vue = new Vue(model, controler);
  }
}
