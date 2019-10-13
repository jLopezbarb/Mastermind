package mastermind.views.console.menu.start;

import mastermind.controllers.StartController;
import mastermind.utils.IO;
import mastermind.views.console.menu.Command;

public class GameSelectCommand extends Command {

    protected GameSelectCommand(String title, StartController startController) {
        super(title, startController);
    }

    @Override
    protected void execute() {
        IO.writeln(this.title);
        this.startController.start(this.title);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
