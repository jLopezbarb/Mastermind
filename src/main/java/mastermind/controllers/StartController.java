package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class StartController extends Controller {

    StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.state.next();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
