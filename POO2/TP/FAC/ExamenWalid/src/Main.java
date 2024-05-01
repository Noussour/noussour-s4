import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model , controller);

        controller.setView(view);

    }
}