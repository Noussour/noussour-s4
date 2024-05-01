import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    Controller(Model model) {
        this.model = model;
    }
    public void setView(View view) {
        this.view = view;
view.addResoudreListener(new resoudre());
    }

    public void processUserInput() {
        double a;
        double b;
        double c;
        try {
            a = Double.parseDouble(view.getA());
            b = Double.parseDouble(view.getB());
            c = Double.parseDouble(view.getC());
        } catch (NumberFormatException e) {
           view.error("Please enter a valid number for A, B, and C.");
            return;
        }
        model.setA(a);
        model.setB(b);
        model.setC(c);
        double delta;
        try {
            delta = model.Deltat();
        } catch (DeltaInvalid e) {
            view.error(e.getMessage());
            return;
        }

    }

    public class resoudre implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            processUserInput();
            double root1 = model.calculateRoot1();
            double root2 = model.calculateRoot2();
            String result = "Root 1: " + root1 + "  Root 2: " + root2;
            view.displayResult(result);
        }
    }

    public static class DeltaInvalid extends RuntimeException {
        public DeltaInvalid(String message) {
            super(message);
        }
    }
}
