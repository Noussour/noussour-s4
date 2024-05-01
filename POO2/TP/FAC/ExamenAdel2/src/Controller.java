public class Controller {
  private Model model;
  private View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;

    view.chiffreButton.addActionListener(
        e -> {
          if (view.ValidateChiffre()) {
            view.mounthTextField.setText(model.getMounth(view.getChiffre()));
          } else {
            view.showError();
          }
        });
  }
}
