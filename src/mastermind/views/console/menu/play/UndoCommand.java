package mastermind.views.console.menu.play;

import mastermind.controllers.PlayController;
import mastermind.views.console.GameView;
import mastermind.views.console.menu.Command;

public class UndoCommand extends Command {

    public UndoCommand(PlayController playController) {
        super(CommandTitle.UNDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        this.playController.undo();
        new GameView(playController);
    }

    @Override
    public boolean isActive() {
        return this.playController.undoable();
    }
}
