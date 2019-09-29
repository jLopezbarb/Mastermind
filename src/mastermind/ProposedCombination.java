package mastermind;

import mastermind.utils.Color;

import java.util.Scanner;

public class ProposedCombination extends Combination {

    private Result result;

    public ProposedCombination(){
        this.code = proposeCombination();
    }

    public boolean isWinner(){
        return this.result.isWinner();
    }

    public void setResult(Result result){
        this.result = result;
    }

    private String proposeCombination(){
        Scanner scanner = new Scanner(System.in);
        String combination;
        do {
            System.out.print("Propose a combination: ");
            combination = scanner.nextLine();
        }while (!checkIfIsValidCombination(combination));
        return combination;
    }

    private boolean checkIfIsValidCombination(String combination){
        if (combination.length() != Mastermind.COMBINATION_LENGTH){
            System.out.println("Wrong proposed combination length");
            return false;
        }
        if (!areColorsUnique(combination)){
            System.out.println("Repeated colors");
            return false;
        }
        if (!areCorrectColors(combination)){
            System.out.println("Wrong colors, they must be: rbygop");
            return false;
        }
        return true;
    }

    private boolean areCorrectColors(String colorCombination) {
        int correctColor = 0;
        for (Color color : Color.values()) {
            if (colorCombination.contains(color.name())){
                correctColor += 1;
            }
        }
        return (correctColor == Mastermind.COMBINATION_LENGTH);
    }

    private boolean areColorsUnique(String colorCombination) {
        int checker = 0; // An integer to store presence/absence of 26 characters using its 32 bits.
        for (int i = 0; i < colorCombination.length(); ++i){
            int val = (colorCombination.charAt(i)-'a');
            if ((checker & (1 << val)) > 0) // If bit corresponding to current character is already set
                return false;
            checker |= (1 << val); // set bit in checker
        }
         return true;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + this.result.toString();
    }
}
