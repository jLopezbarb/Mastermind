package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int MAX_LONG = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    Game() {
        this.clear();
    }

    void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public SecretCombination getSecretCombination(){
        return this.secretCombination;
    }

    void addProposedCombination(ProposedCombination proposedCombination){
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
    }

    int getAttempts(){
        return this.proposedCombinations.size();
    }

    public List<ProposedCombination> getProposedCombinations(){
        return this.proposedCombinations;
    }

    List<Result> getResults(){
        return this.results;
    }

    Result getResult(int attempt){
        return this.getResults().get(attempt);
    }

    boolean isWinner(){
        return this.getResults().get(this.getAttempts() - 1).isWinner();
    }

    boolean isLooser(){
        return this.getAttempts() == Game.MAX_LONG;
    }

    List<Color> getColors(int attempt){
        return this.proposedCombinations.get(attempt).colors;
    }
}
