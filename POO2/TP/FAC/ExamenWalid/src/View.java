import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    private Model model;
    private JButton resoudre;
    private JTextField Atext;
    private JTextField Btext;
    private JTextField Ctext;
    JFrame resultFrame = new JFrame();

    View(Model model, Controller controller) {
        this.controller = controller;
        this.model = model;
        getContentPane().setBackground(Color.GRAY);
        setTitle("Quadratic Equation Solver");
        setSize(300, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JTextField field = new JTextField();
        setLocationRelativeTo(null);
        field.setSize(200, 50);
        JLabel text = new JLabel("A");
        text.setBounds(10, 50, 50, 50);
        add(text);
        field.setBounds(50, 50, 200, 50);
        add(field);
        JTextField field2 = new JTextField();

        field2.setSize(200, 50);
        JLabel text2 = new JLabel("B");
        text2.setBounds(10, 100, 50, 50);
        add(text2);
        field2.setBounds(50, 100, 200, 50);
        add(field2);
        JTextField field3 = new JTextField();
        field3.setSize(200, 50);

        JLabel text3 = new JLabel("C");
        text3.setBounds(10, 150, 50, 50);
        add(text3);
        field3.setBounds(50, 150, 200, 50);
        add(field3);
        Atext = field;
        Btext = field2;
        Ctext = field3;
        resoudre = new JButton("Resoudre");

        resoudre.setSize(100, 50);
        resoudre.setBounds(100, 200, 100, 50);
        add(resoudre);
        setVisible(true);

    }

    public String getA() {
        return Atext.getText();
    }

    public String getB() {
        return Btext.getText();
    }

    public String getC() {
        return Ctext.getText();
    }

    public void addResoudreListener(Controller.resoudre resoudre) {
        this.resoudre.addActionListener(resoudre);
    }

    public void error(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayResult(String result) {
        resultFrame.setLayout(new GridLayout(2, 1));
        resultFrame.setBackground(Color.BLACK);
        resultFrame.setForeground(Color.BLACK);
        resultFrame.getContentPane().setBackground(Color.pink);
        resultFrame.setSize(700, 500);
        resultFrame.setResizable(false);
        resultFrame.setLayout(null);
        JLabel resultLabel = new JLabel("le résultat est : ");
        resultLabel.setBounds(10, 10, 700, 50);
        resultFrame.add(resultLabel);
        JTextField resultField = new JTextField(result);
        resultField.setBounds(10, 50, 700, 50);
        resultField.setEditable(false);
        resultFrame.add(resultField);

        resultField.setFocusable(false);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setVisible(true);
    }
}
