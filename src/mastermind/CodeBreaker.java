package mastermind;

import java.util.ArrayList;

public class CodeBreaker {

    private int attemps;
    private ArrayList<ProposedCombination> combinations;


    public CodeBreaker(){
        this.combinations = new ArrayList<>();
    }

    public void guess(){
        ProposedCombination newGuess = new ProposedCombination();
        this.combinations.add(newGuess);
        this.attemps += 1;
    }

    public ProposedCombination getLastCombination(){
        return this.combinations.get(this.combinations.size() - 1);
    }

    public void printAttemps(){
        System.out.println(this.attemps + " Attemp(s):");
    }

    public void printCombinations(){
        for (ProposedCombination combination: this.combinations) {
            System.out.println(combination);
        }
    }

    public boolean isLooser(){
        if (this.attemps == Mastermind.MAX_ATTEMPS){
            System.out.println("You've lost!!! :-(");
            return true;
        }else{
            return false;
        }
    }

    public boolean isWinner(){
        if (this.getLastCombination().isWinner()){
            System.out.println("You've won!!! ;-)");
            return true;
        }else{
            return false;
        }
    }

}
