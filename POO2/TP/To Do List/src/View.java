import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class View {
    JFrame frame;
    JPanel fieldPanel;
    JButton addButton;
    JTextField field;
    JPanel dataPanel;
    ArrayList<JPanel> tasks;
    int hieghtPanel;

    HashMap<Integer, JLabel> labels = new HashMap<>();
    public View() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        fieldPanel = new JPanel();
        fieldPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        fieldPanel.setLayout(new FlowLayout());
        fieldPanel.setBackground(Color.BLACK);
        frame.add(fieldPanel, BorderLayout.NORTH);


        field = new JTextField();
        field.setPreferredSize(new Dimension(350, 35));

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 35));

        fieldPanel.add(field);
        fieldPanel.add(addButton);
        hieghtPanel = fieldPanel.getHeight() + 10;

        tasks = new ArrayList<>();
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        dataPanel.setSize(500, 0);
        frame.add(dataPanel);
//
        JScrollPane scrollPane = new JScrollPane(dataPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public String geTextFromField() {
        return field.getText();
    }

    public void setTextFromField(String task) {
        field.setText(task);
    }

    public void clearTextField() {
        this.setTextFromField("");
    }

    public Boolean isTextFieldEmpty() {
        return this.geTextFromField().isEmpty();
    }

    public void addLabel(String task) {
        tasks.add(new JPanel());
        tasks.getLast().setBounds(0,hieghtPanel, frame.getWidth(), 50);
        hieghtPanel += 50;
        tasks.getLast().setLayout(null);
        tasks.getLast().setSize(new Dimension(500, 50));
        JLabel label = new JLabel(task);
        label.setBounds(50, 0, 350, 35);
        tasks.getLast().add(label);
        JButton deleteButton = new JButton("Delete");
        tasks.getLast().add(deleteButton);
        deleteButton.setBounds(350, 0, 100, 35);
        dataPanel.add(tasks.getLast());
        frame.revalidate();
        frame.repaint();
    }

    public void AddActionsListner(ActionListener actionsListner) {
        addButton.addActionListener(actionsListner);
    }
}
