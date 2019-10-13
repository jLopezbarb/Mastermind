package mastermind.views.console.menu.start;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.views.console.menu.Command;

public class NewGameCommand extends Command {

    protected NewGameCommand(StartController startController) {
        super(MessageView.NEW_GAME.getMessage(), startController);
    }

    @Override
    protected void execute() {
        this.startController.start();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
