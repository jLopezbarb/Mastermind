package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.IO;
import mastermind.views.MessageView;

public class WinnerView {

    public WinnerView(PlayController playController){
        if (playController.isWinner()) {
            IO.writeln(MessageView.WINNER.getMessage());
        } else if (playController.isLooser()) {
            IO.writeln(MessageView.LOOSER.getMessage());
        }
    }
}
