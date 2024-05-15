// Convert Vector to ArrayList in Java

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Object> array = new ArrayList<>(List.of("Adel", 1, 2.9));
        System.out.println(array);

        HashMap<String, String> map = new HashMap<>();
        map.put("moh", "hamid");
        System.out.println(map.get("moh").equals("hamid"));
        JFrame frame = new JFrame("JFrame Example");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);

        JWindow window = new JWindow();
        window.add(frame);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
    }
}
