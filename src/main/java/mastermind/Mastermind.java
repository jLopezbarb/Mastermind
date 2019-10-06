package mastermind;

import mastermind.controllers.Controller;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public class Mastermind {

    private Logic logic;
    private View view;

    private Mastermind() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    private void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
