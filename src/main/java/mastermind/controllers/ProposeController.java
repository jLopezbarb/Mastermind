package mastermind.controllers;

import mastermind.models.*;
import mastermind.models.Error;


import java.util.ArrayList;
import java.util.List;

public class ProposeController extends Controller {


    ProposeController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public SecretCombination getSecretCombination(){
        return this.game.getSecretCombination();
    }

    public mastermind.models.Error isCorrectCombination(String characters){
        Error error = null;
        ArrayList<Color> colors = new ArrayList<>();
        if (characters.length() != getSecretCombination().getWidth()) {
            error = mastermind.models.Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Color color = Color.getInstance(characters.charAt(i));
                if (color == null) {
                    error = mastermind.models.Error.WRONG_CHARACTERS;
                } else {
                    for (Color value : colors) {
                        if (color == value) {
                            error = Error.DUPLICATED;
                        }
                    }
                    colors.add(color);
                }
            }
        }
        return error;
    }

    public void addCombination(String colors){
        ArrayList<Color> combination = new ArrayList<>();
        for (int i = 0; i < colors.length(); i++) {
            Color color = Color.getInstance(colors.charAt(i));
            combination.add(color);
        }
        ProposedCombination proposedCombination = new ProposedCombination(combination);
        this.game.addProposedCombination(proposedCombination);
    }

    public int getAttemps(){
        return this.game.getAttemps();
    }

    public List<ProposedCombination> getProposedCombinations() {
        return this.game.getProposedCombinations();
    }

    public List<Result> getResults() {
        return this.game.getResults();
    }

    public boolean isWinner(){
        return this.getResults().get(this.getAttemps() - 1).isWinner();
    }

    public boolean isLooser(){
        return this.getAttemps() == Game.MAX_LONG;
    }
    public void finish(){
        this.state.next();
    }



}
