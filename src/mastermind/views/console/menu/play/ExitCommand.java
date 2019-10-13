package mastermind.views.console.menu.play;

import mastermind.controllers.PlayController;
import mastermind.views.console.menu.Command;

public class ExitCommand extends Command {

    protected ExitCommand(PlayController playController) {
        super(CommandTitle.EXIT_COMMAND.getTitle(), playController);
    }
    @Override
    protected void execute() {
        this.playController.next();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
