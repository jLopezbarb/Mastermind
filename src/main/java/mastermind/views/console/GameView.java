package mastermind.views.console;

import mastermind.controllers.ProposeController;
import mastermind.utils.IO;

class GameView {

    private final ProposeController controller;

    GameView(ProposeController controller) {
        this.controller = controller;
    }

    void writeln() {
        IO.writeln();
        IO.writeln(Message.GAME_TITLE);
        SecretCombinationView secretView = new SecretCombinationView(this.controller);
        secretView.writeln();
        boolean isWinner, isLooser;
        do {
            ProposedCombinationView proposedView = new ProposedCombinationView(this.controller);
            proposedView.propose();
            proposedView.writeAttemps();
            secretView.writeln();
            proposedView.writeGameInfo();
            isWinner = this.controller.isWinner();
            isLooser = this.controller.isLooser();
            writeIfLooser(isLooser);
            writeIfWinner(isWinner);
        } while (!isWinner & !isLooser);

    }

    private void writeIfLooser(boolean isLooser){
        if (isLooser) {
            IO.writeln(Message.LOOSER);
        }
    }

    private void writeIfWinner(boolean isWinner){
        if (isWinner) {
            IO.writeln(Message.WINNER);
        }
    }
}
