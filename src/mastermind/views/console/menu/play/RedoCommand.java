package mastermind.views.console.menu.play;

import mastermind.controllers.PlayController;
import mastermind.views.console.GameView;
import mastermind.views.console.menu.Command;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(CommandTitle.REDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        this.playController.redo();
        new GameView(playController);
    }

    @Override
    public boolean isActive() {
        return this.playController.redoable();
    }
}
