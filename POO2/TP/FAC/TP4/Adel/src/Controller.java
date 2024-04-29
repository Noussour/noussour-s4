import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
  public Vue vue;
  public Model model;

  public Controller(Vue vue, Model model) {
    this.vue = vue;
    this.model = model;

    this.vue.addCalculationListener(new CalculationListener());
  }





  public class CalculationListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Button clicked ");
      if (e.getSource() == vue.button1) {
        vue.ajouteSaisie("1");
      } else if (e.getSource() == vue.button2) {
        vue.ajouteSaisie("2");
      } else if (e.getSource() == vue.button3) {
        vue.ajouteSaisie("3");
      } else if (e.getSource() == vue.button4) {
        vue.ajouteSaisie("4");
      } else if (e.getSource() == vue.button5) {
        vue.ajouteSaisie("5");
      } else if (e.getSource() == vue.button6) {
        vue.ajouteSaisie("6");
      } else if (e.getSource() == vue.button7) {
        vue.ajouteSaisie("7");
      } else if (e.getSource() == vue.button8) {
        vue.ajouteSaisie("8");
      } else if (e.getSource() == vue.button9) {
        vue.ajouteSaisie("9");
      } else if (e.getSource() == vue.button0) {
        vue.ajouteSaisie("0");
      } else if (e.getSource() == vue.addButton) {
        model.setOperation(1, vue.getEntree());
        vue.textField.setText("");
      } else if (e.getSource() == vue.subButton) {
        model.setOperation(2, vue.getEntree());
        vue.textField.setText("");
      } else if (e.getSource() == vue.mulButton) {
        model.setOperation(3, vue.getEntree());
        vue.textField.setText("");
      } else if (e.getSource() == vue.divButton) {
        model.setOperation(4, vue.getEntree());
        vue.textField.setText("");
      } else if (e.getSource() == vue.eqButton) {
        vue.afficheTotal(model.getTotal());
      } else if (e.getSource() == vue.resetButton) {
        model.resetTotal();
        vue.textField.setText("");
      }
    }
  }
}
