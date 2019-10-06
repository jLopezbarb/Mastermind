package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class ResumeController extends Controller{

    ResumeController(Game game, State state) {
        super(game, state);
    }

    public void resume(boolean newGame) {
        if (newGame) {
            this.game.clear();
            this.state.reset();
        } else {
            this.state.next();
        }
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
