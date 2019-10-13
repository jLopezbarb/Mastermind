package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.controllers.StartController;

public abstract class Command extends mastermind.utils.Command {

    protected PlayController playController;

    protected StartController  startController;

    protected Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }

    protected Command(String title, StartController startController) {
        super(title);
        this.startController = startController;
    }

}
