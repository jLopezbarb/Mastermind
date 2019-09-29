package mastermind;

import mastermind.utils.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SecretCombination extends Combination{

    public SecretCombination(){
        this.code = prepareCombination();
    }

    private String prepareCombination(){
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.values()));
        Random random = new Random();
        StringBuilder combination = new StringBuilder();
        for (int i= 0; i < Mastermind.COMBINATION_LENGTH; i++){
            int randomIndex = random.nextInt(colors.size());
            combination.append(colors.get(randomIndex));
            colors.remove(randomIndex);
        }
        return combination.toString();
    }

    public Result calculateResult(Combination combination){
        int black = calculateBlacks(combination);
        int white = calculateWhites(combination);
        return new Result(black, white);
    }

    private int calculateBlacks(Combination combination){
        int black = 0;
        for (int i = 0; i < this.code.length(); i++) {
            if (this.code.charAt(i) == (combination.code.charAt(i))){
                black += 1;
            }
        }
        return black;
    }

    private int calculateWhites(Combination combination){
        int white = 0;
        for (int i = 0; i < this.code.length(); i++) {
            String possibleWhites = combination.code.replace(combination.code.charAt(i), Character.MIN_VALUE);
            char color = this.code.charAt(i);
            if (possibleWhites.contains(String.valueOf(color))){
                white += 1;
            }
        }
        return white;
    }

    @Override
    public String toString(){
        return "****";
    }
}
