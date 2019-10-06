package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;


public class Logic {

    private final State state;

    private Game game;

    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new ProposeController(this.game, this.state));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }
}
