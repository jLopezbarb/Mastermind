package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {


    private int attempts;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;


    Memento(int attempts) {
        this.attempts = attempts;
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    int getAttempts(){
        return this.attempts;
    }

    List<ProposedCombination> getProposedCombinations(){
        return this.proposedCombinations;
    }

    List<Result> getResults(){
        return this.results;
    }

    void add(ProposedCombination proposedCombination, Result result){
        this.proposedCombinations.add(proposedCombination);
        this.results.add(result);
    }

}
