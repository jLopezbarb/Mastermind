package mastermind.views.console.menu.start;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.views.console.menu.Command;

public class SavedGameCommand  extends Command {

    public SavedGameCommand(StartController startController) {
        super(MessageView.SAVED_GAME.getMessage(), startController);
    }

    @Override
    protected void execute() {
        new StartMenuView(this.startController).execute();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
