package Controller;

import Model.Contador;
import View.ContadorView;

public class ContadorController {
    private Contador model;
    private ContadorView  view;

    public ContadorController(Contador model, ContadorView view) {
        this.model = model;
        this.view = view;

        this.view.addIncrementListener(e -> {
            model.increment();
            view.setValor(model.getValor());
        });

        view.setValor(model.getValor());
    }

    public void run() {
        this.view.setVisible(true);
    }




}
