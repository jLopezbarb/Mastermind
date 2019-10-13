package mastermind.views.console;

import mastermind.controllers.PlayController;

public class GameView {


    public GameView(PlayController playController) {
        new AttemptsView(playController).writeln();
        new SecretCombinationView(playController).writeln();
        for (int i = 0; i < playController.getAttempts(); i++) {
            new ProposedCombinationView(playController).write(i);
            new ResultView(playController).writeln(i);
        }
    }

}
