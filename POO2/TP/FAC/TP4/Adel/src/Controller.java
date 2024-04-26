import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
  public Vue vue;
  public Model model;

  public Controller(Vue vue, Model model) {
    this.vue = vue;
    this.model = model;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    System.out.println(command);

    if (vue.entreeValid()) {
      int number = vue.getEntree();

      switch (command) {
        case "+":
          model.setOperation(1, number);
          break;
        case "-":
          model.setOperation(2, number);
          break;
        case "*":
          model.setOperation(3, number);
          break;
        case "/":
          model.setOperation(4, number);
          break;
        case "=":
          model.doOperation(number);
          vue.afficheTotal(model.getTotal());
          break;
        default:
          vue.ajouteSaisie(command);
          break;
      }
    } else {
      vue.erreur("Invalid entry");
    }
  }
}
