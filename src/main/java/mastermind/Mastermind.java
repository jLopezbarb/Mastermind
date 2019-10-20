package mastermind;

import mastermind.controllers.Controller;
import mastermind.controllers.Logic;
import mastermind.views.View;

public class Mastermind {

    private Logic logic;

    private Mastermind() {
        this.logic = new Logic();
    }

    private void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
