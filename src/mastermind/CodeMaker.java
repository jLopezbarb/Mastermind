package mastermind;

public class CodeMaker {

    private SecretCombination combination;
    private CodeBreaker codeBreaker;


    public CodeMaker(CodeBreaker codeBreaker){
        this.combination = new SecretCombination();
        this.codeBreaker = codeBreaker;
    }

    public void printCombination(){
        System.out.println(this.combination);
    }

    public void answer(){
        ProposedCombination proposedCombination = this.codeBreaker.getLastCombination();
        Result result = this.combination.calculateResult(proposedCombination);
        proposedCombination.setResult(result);
    }
}
