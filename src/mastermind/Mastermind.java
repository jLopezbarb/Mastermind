package mastermind;

import java.util.Scanner;

public class Mastermind {

    public static final int COMBINATION_LENGTH = 4;
    public static final int  MAX_ATTEMPS = 10;
    private CodeMaker codeMaker;
    private CodeBreaker codeBreaker;


    public void play(){
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("----- MASTERMIND -----");
            startNewGame();
            System.out.print("Do you want to continue? [Y/n]: ");
            option = scanner.nextLine();
        }while(wantsToContinue(option));
    }

    private void startNewGame(){
        this.codeBreaker = new CodeBreaker();
        this.codeMaker = new CodeMaker(this.codeBreaker);
        this.codeMaker.printCombination();
        do {
            this.codeBreaker.guess();
            this.codeMaker.answer();
            this.printGameStatus();
        }while (!(this.codeBreaker.isWinner() || this.codeBreaker.isLooser()));
    }

    private boolean wantsToContinue(String option){
        return (!option.toLowerCase().equals("n"));
    }

    private void printGameStatus(){
        this.codeBreaker.printAttemps();
        this.codeMaker.printCombination();
        this.codeBreaker.printCombinations();
    }

}
