package LoginPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        model.AddUser("abdou", "abdou");
        model.AddUser("adel", "adel");
        model.AddUser("moh", "moh");
        model.AddUser("walid", "walid");

        view.loginButton.addActionListener(this);
        view.resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.loginButton) {
            String userName = view.userName.getText();
            String password = view.userPassword.getText();
            view.userName.setText("");
            view.userPassword.setText("");
            if (model.VerifyUser(userName)) {
                if (model.VerifyPassword(userName, password)){
                    view.DisplayMessage("Login Successful");
                }
                else {
                    view.DisplayMessage("Wrong Password");
                }
            }
            else {
                view.DisplayMessage("Wrong User");
            }
        }
        if (actionEvent.getSource() == view.resetButton) {
            view.userPassword.setText("");
            view.userName.setText("");
        }

    }
}