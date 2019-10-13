package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;
import mastermind.utils.Originator;

public class Game implements Originator {


    static final int MAX_LONG = 10;

    private SecretCombination secretCombination;

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attempts;

    Game() {
        this.clear();
    }

    void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList();
        this.results = new ArrayList();
        this.attempts = 0;
    }

    void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }

    public int getAttempts() {
        return this.attempts;
    }

    List<Result> getResults() {
        return this.results;
    }

    List<ProposedCombination> getProposedCombinations() {
        return this.proposedCombinations;
    }

    @Override
    public void restore(Memento memento) {
        this.attempts = memento.getAttempts();
        this.proposedCombinations = memento.getProposedCombinations();
        this.results = memento.getResults();
    }

    @Override
    public Memento createMemento() {
        Memento memento = new Memento(this.attempts);
        for (int i = 0; i < this.proposedCombinations.size(); i++) {
            memento.add(this.proposedCombinations.get(i).copy(), this.results.get(i).copy());
        }
        return memento;
    }

    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }

    public ProposedCombination getProposedCombination(int attempt){
        return this.proposedCombinations.get(attempt);
    }

    public Result getResult(int attempt){
        return this.results.get(attempt);
    }

    public void setAttempts(int attempts){
        this.attempts = attempts;
    }

    public void addResult(Result result){
        this.results.add(result);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }
}
