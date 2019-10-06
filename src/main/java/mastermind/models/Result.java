package mastermind.models;

import mastermind.views.console.Message;

public class Result {
    private int blacks;

    private int whites;

    Result(int blacks, int whites) {
        assert blacks >= 0;
        assert whites >= 0;
        this.blacks = blacks;
        this.whites = whites;
    }

    public boolean isWinner() {
        return this.blacks == Combination.getWidth();
    }

    public String toString() {
        return Message.RESULT.replaceFirst("#blacks", "" + blacks)
                .replaceFirst("#whites", "" + whites);
    }

}
