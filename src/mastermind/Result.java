package mastermind;

public class Result {

    private int black;
    private int white;

    public Result(int black, int white){
        this.black = black;
        this.white = white;
    }

    public boolean isWinner(){
        return (this.black == Mastermind.COMBINATION_LENGTH);
    }

    @Override
    public String toString() {
        return this.black + " blacks and " + this.white + " whites";
    }
}
