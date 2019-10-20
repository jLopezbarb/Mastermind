package mastermind.models;

import java.util.List;

public class Session {

    private Game game;

    private State state;

    public Session(){
        this.state = new State();
        this.game = new Game();
    }

    public StateValue getStateValue() {
        return this.state.getStateValue();
    }

    public void next() {
        this.state.next();
    }

    public int getWidth() {
        return Combination.getWidth();
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
    }

    public List<Color> getCombination(int attempt){
        return this.game.getColors(attempt);
    }

    public Result getResult(int attempt){
        return this.game.getResult(attempt);
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public void reset() {
        this.game.clear();
        this.state.reset();
    }
}
