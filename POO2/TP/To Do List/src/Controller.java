import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.AddActionsListner(new ActionsListener());
    }

    public class ActionsListener implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button == view.addButton && !view.isTextFieldEmpty()) {
                model.addData(view.geTextFromField());
                view.addLabel(view.geTextFromField());

            }

//       if (button.getText == "Delete" ) {
//            model.removeData(view.getSelectedLabel());
//            view.removeLabel(view.getSelectedLabel());
//        }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
