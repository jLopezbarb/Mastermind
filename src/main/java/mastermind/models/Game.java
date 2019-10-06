package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int MAX_LONG = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public SecretCombination getSecretCombination(){
        return this.secretCombination;
    }

    public void addProposedCombination(ProposedCombination proposedCombination){
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
    }

    public int getAttemps(){
        return this.proposedCombinations.size();
    }
    public List<ProposedCombination> getProposedCombinations(){
        return this.proposedCombinations;
    }

    public List<Result> getResults(){
        return this.results;
    }
}
