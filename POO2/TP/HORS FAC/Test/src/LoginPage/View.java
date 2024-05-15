package LoginPage;
import javax.swing.*;
import java.awt.*;


public class View extends JFrame{
    JLabel userLabel = new JLabel("username");
    JLabel passwordLabel = new JLabel("password");
    JTextField userName = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    public View() {
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel.setBounds(100, 90, 100, 50);
        passwordLabel.setBounds(100, 190, 100, 50);
        userName.setBounds(200, 100, 200, 30);
        userPassword.setBounds(200, 200, 200, 30);
        loginButton.setBounds(100, 300, 100, 50);
        resetButton.setBounds(300, 300, 100, 50);

        this.add(userLabel);
        this.add(passwordLabel);
        this.add(userName);
        this.add(userPassword);
        this.add(loginButton);
        this.add(resetButton);
    }

    public void DisplayMessage (String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}