package mastermind.models;

import mastermind.types.Color;
import mastermind.utils.Registry;

import java.util.List;

public class SessionImplementation implements  Session{
    private State state;

    private Game game;

    private Registry registry;

    private String name;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
        this.registry.registry();
    }

    public boolean isLooser() {
        return this.game.getAttempts() == Game.MAX_LONG;
    }

    public boolean isWinner() {
        return this.game.getResults().get(this.game.getAttempts()-1).isWinner();
    }

    public List<Color> getColors(int position) {
        return this.game.getProposedCombinations().get(position).colors;
    }

    public int getBlacks(int position) {
        return this.game.getResults().get(position).getBlacks();
    }

    public int getWhites(int position) {
        return this.game.getResults().get(position).getWhites();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public void next() {
        this.state.next();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    @Override
    public int getWidth() {
        return Combination.getWidth();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }

    public Game getGame(){
        return this.game;
    }

    public void setName(String name){
        this.name = name;
    }

    public void resetRegistry(){
        this.registry.reset();
    }

    public void setStateValue(StateValue stateValue) {
        this.state.setStateValue(stateValue);
    }
}
