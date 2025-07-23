import Controller.ContadorController;
import Model.Contador;
import View.ContadorView;

public class Main {
    public static void main(String[] args) {

        // Controller (Model, View)
        ContadorController controller = new ContadorController(new Contador(), new ContadorView());

        controller.run();
    }
}
